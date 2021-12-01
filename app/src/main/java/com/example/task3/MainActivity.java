package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_add;

    MyApplication myApplication = (MyApplication) this.getApplication();
    List<Student> studentList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList = myApplication.getStudentList();

        Log.d("TAG", "OnCreate: " + studentList.toString());
        Toast.makeText(this, "Students count = " + studentList.size(), Toast.LENGTH_SHORT).show();

        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddOne.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.rv_studentList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MyAdapter(studentList, this);
        recyclerView.setAdapter(myAdapter);
    }



}