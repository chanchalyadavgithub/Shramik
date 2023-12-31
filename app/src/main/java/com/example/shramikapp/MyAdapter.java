package com.example.shramikapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;
    ArrayList<User> list;
    public void setFilteredList(ArrayList<User> filteredList){
        this.list=filteredList;
        notifyDataSetChanged();
    }


    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = list.get(position);
        holder.title.setText(user.getTitle());
        holder.description.setText(user.getDescription());
        holder.skills.setText(user.getSkills());
        holder.salary.setText(user.getSalary());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, description, skills, salary;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.tvtitle);
            description=itemView.findViewById(R.id.tvdescription);
            skills=itemView.findViewById(R.id.tvskills);
            salary=itemView.findViewById(R.id.tvsalary);

        }
    }



}
