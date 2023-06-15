package com.example.shramikapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private Button btnAllJob;
    private Button btnPostJob;


    //Toolbar
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



//        getSupportActionBar().setTitle("Shramik");
//        View.OnClickListener onClickListener1 = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent action;
//                startActivity(new Intent(HomeActivity.this,List_Labors.class));
//
//            }
//        };
        btnAllJob=findViewById(R.id.btn_allJob);
        btnPostJob=findViewById(R.id.btn_PostJob);

        TextView textView = findViewById(R.id.help);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, FAQ.class);
                startActivity(intent);
            }
        });

        TextView textView1 = findViewById(R.id.feedbk);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, feedback.class);
                startActivity(intent);
            }
        });



        btnAllJob.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(HomeActivity.this,userlist.class));
            }
        });




        btnPostJob.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(getApplicationContext(), PostJobActivity.class));
            }

        });



    }

}