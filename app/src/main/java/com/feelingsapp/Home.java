package com.feelingsapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    ImageButton buttonSad;
    ImageButton buttonHappy;
    ImageButton buttonAngry;
    FloatingActionButton buttonHistory;

    FeelingRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addListenerOnButton();
        repository = new FeelingRepository(this.getApplication());
    }

    public void addListenerOnButton() {

        buttonSad = findViewById(R.id.imageButtonSad);
        buttonHappy = findViewById(R.id.imageButtonHappy);
        buttonAngry = findViewById(R.id.imageButtonAngry);
        buttonHistory = findViewById(R.id.histoyButton);

        buttonSad.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Feeling feeling = new Feeling("sad", "");
                repository.insert(feeling);
                Toast.makeText(Home.this,
                        "Are you sad?", Toast.LENGTH_SHORT).show();

            }
        });

        buttonHappy.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Feeling feeling = new Feeling("happy", "");
                repository.insert(feeling);
                Toast.makeText(Home.this,
                        "Are you happy?", Toast.LENGTH_SHORT).show();
            }
        });

        buttonAngry.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Feeling feeling = new Feeling("angry", "");
                repository.insert(feeling);
                Toast.makeText(Home.this,
                        "Are you angry?", Toast.LENGTH_SHORT).show();
            }
        });

        buttonHistory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                startActivity(new Intent(Home.this, History.class));
            }
        });

    }
}
