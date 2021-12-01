package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Details extends AppCompatActivity {

    Button btn_edit;

    List<Student> studentList;
    MyApplication myApplication = (MyApplication) this.getApplication();

    TextView tv_name_input_details, tv_id_input_details, tv_phone_input_details, tv_address_input_details;
    CheckBox cb_details;


    int placeInList;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        btn_edit = findViewById(R.id.btn_edit);

        studentList = MyApplication.getStudentList();

        tv_id_input_details = findViewById(R.id.tv_id_input_details);
        tv_phone_input_details = findViewById(R.id.tv_phone_input_details);
        tv_address_input_details = findViewById(R.id.tv_address_input_details);
        tv_name_input_details = findViewById(R.id.tv_name_input_details);
        cb_details= findViewById(R.id.cb_details);


        Intent intent = getIntent();
        placeInList = intent.getIntExtra("placeInList", -1);
        Student student = null;

        if(placeInList >= 0){
            for (Student s: studentList) {
                if(s.getPlaceInList() == placeInList){
                    student = s;
                    break;
                }
            }
            tv_name_input_details.setText(student.getName());
            tv_address_input_details.setText(student.getAddress());
            tv_phone_input_details.setText(student.getPhone_number());
            tv_id_input_details.setText(String.valueOf(student.getId()));
            //Glide.with(this).load(student.getImageURL()).into(iv_image_details);
            cb_details.setChecked(student.isFlag());

        }


        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Details.this, Edit.class);
                intent.putExtra("placeInList", placeInList);
                startActivity(intent);
            }
        });
    }
}