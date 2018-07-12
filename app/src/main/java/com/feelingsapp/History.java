package com.feelingsapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static com.feelingsapp.R.id.history_view;

public class History extends AppCompatActivity {

    private FeelingViewModel feelingModel;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        feelingModel = ViewModelProviders.of(this).get(FeelingViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.history_view);
        final FeelingListAdapter adapter = new FeelingListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        feelingModel.getAllFeelings().observe(this, new Observer<List<Feeling>>() {
            @Override
            public void onChanged(@Nullable final List<Feeling> feelings) {
                // Update the cached copy of the words in the adapter.
                adapter.setFeelings(feelings);
            }
        });
    }

}
