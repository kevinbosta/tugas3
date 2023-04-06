package com.learn.recycleview_baru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterData adapterData;
    List<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RVdata);
        listData = new ArrayList<>();

        for (int i=0; i<10; i++){
            listData.add("Data Ke : " + i);
        }

        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fopen();
            }
        });
        adapterData = new AdapterData(this,listData);
        recyclerView.setAdapter(adapterData);
        adapterData.notifyDataSetChanged();

    }
    public void fopen(){
        Intent intent = new Intent(this,dataActivity.class);
        startActivity(intent);
    }
}