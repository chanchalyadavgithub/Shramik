package com.example.shramikapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FAQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        TextView mainTextView = findViewById(R.id.mainTextView);
        final TextView extraTextView = findViewById(R.id.extraTextView);

        mainTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (extraTextView.getVisibility() == View.GONE) {
                    extraTextView.setVisibility(View.VISIBLE);
                } else {
                    extraTextView.setVisibility(View.GONE);
                }
            }
        });



        TextView mainTextView1 = findViewById(R.id.mainTextView1);
        final TextView extraTextView1 = findViewById(R.id.extraTextView1);

        mainTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (extraTextView1.getVisibility() == View.GONE) {
                    extraTextView1.setVisibility(View.VISIBLE);
                } else {
                    extraTextView1.setVisibility(View.GONE);
                }
            }
        });


        TextView mainTextView3 = findViewById(R.id.mainTextView3);
        final TextView extraTextView3 = findViewById(R.id.extraTextView3);

        mainTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (extraTextView3.getVisibility() == View.GONE) {
                    extraTextView3.setVisibility(View.VISIBLE);
                } else {
                    extraTextView3.setVisibility(View.GONE);
                }
            }
        });

        TextView mainTextView2 = findViewById(R.id.mainTextView2);
        final TextView extraTextView2 = findViewById(R.id.extraTextView2);

        mainTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (extraTextView2.getVisibility() == View.GONE) {
                    extraTextView2.setVisibility(View.VISIBLE);
                } else {
                    extraTextView2.setVisibility(View.GONE);
                }
            }
        });

        TextView mainTextView4 = findViewById(R.id.mainTextView4);
        final TextView extraTextView4 = findViewById(R.id.extraTextView4);

        mainTextView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (extraTextView4.getVisibility() == View.GONE) {
                    extraTextView4.setVisibility(View.VISIBLE);
                } else {
                    extraTextView4.setVisibility(View.GONE);
                }
            }
        });




    }
}