package com.example.shramikapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class userlist extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    private MyAdapter myAdapter;
    ArrayList<User> list;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        searchView=findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }

            private void filterList(String text) {
                ArrayList<User> filteredList =new ArrayList<>();
                for(User item:list){

                    if(item.getTitle().toLowerCase().contains(text.toLowerCase())){
                        filteredList.add(item);
                    }

                }
                if(filteredList.isEmpty()){
                    Toast.makeText(userlist.this, "No data found", Toast.LENGTH_SHORT).show();
                }
                else{
                   myAdapter.setFilteredList(filteredList);
                }
            }
        });

        recyclerView= findViewById(R.id.userList);
        database = FirebaseDatabase.getInstance().getReference("JobData");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list= new ArrayList<>();
        myAdapter = new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    User user= dataSnapshot.getValue(User.class);
                    list.add(user);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}