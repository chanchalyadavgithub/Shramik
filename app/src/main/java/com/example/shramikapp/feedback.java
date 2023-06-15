package com.example.shramikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback extends AppCompatActivity {
EditText txtname, txtcontact, txtsubject, txtmsg;
Button btnsave;
Member member;
DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        txtname=(EditText) findViewById(R.id.editTextName);
        txtcontact=(EditText) findViewById(R.id.editTextEmail);
        txtsubject=(EditText) findViewById(R.id.editTextSubject);
        txtmsg=(EditText) findViewById(R.id.editTextMessage);
        btnsave=(Button) findViewById(R.id.buttonSubmit);
        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        btnsave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                member.setName(txtname.getText().toString().trim());
                member.setContact(txtcontact.getText().toString().trim());
                member.setSubject(txtsubject.getText().toString().trim());
                member.setMessage(txtmsg.getText().toString().trim());
                reff.push().setValue(member);
                Toast.makeText(feedback.this, "Thankyou for your feedback!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}