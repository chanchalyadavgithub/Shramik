package com.example.shramikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostJobActivity extends AppCompatActivity {

    EditText txttitle, txtdes, txtskills, txtsal;
    Button btnpost;
    DatabaseReference reff;
    JobData jobdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job);
        txttitle=(EditText) findViewById(R.id.et);
        txtdes=(EditText) findViewById(R.id.etd);
        txtskills=(EditText) findViewById(R.id.etsk);
        txtsal=(EditText) findViewById(R.id.etsa);
        btnpost=(Button) findViewById(R.id.btn);
        jobdata=new JobData();
        reff= FirebaseDatabase.getInstance().getReference().child("JobData");
        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               jobdata.setTitle(txttitle.getText().toString().trim());
                jobdata.setDescription(txtdes.getText().toString().trim());
                jobdata.setSkills(txtskills.getText().toString().trim());
                jobdata.setSalary(txtsal.getText().toString().trim());
                reff.push().setValue(jobdata);
                Toast.makeText(PostJobActivity.this,"Job posted Successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}