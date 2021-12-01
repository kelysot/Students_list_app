package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Edit extends AppCompatActivity {

    Button btn_cancel_edit,btn_delete_edit, btn_save_edit;

    List<Student> studentList;
    MyApplication myApplication = (MyApplication) this.getApplication();

    EditText et_name_edit, et_phone_edit, et_id_edit, et_address_edit;
    CheckBox cb_edit;


    int placeInList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        studentList = MyApplication.getStudentList();

        btn_cancel_edit = findViewById(R.id.btn_cancel_edit);
        btn_delete_edit = findViewById(R.id.btn_delete_edit);
        btn_save_edit = findViewById(R.id.btn_save_edit);

        et_id_edit = findViewById(R.id.et_id_edit);
        et_phone_edit = findViewById(R.id.et_phone_edit);
        et_address_edit = findViewById(R.id.et_address_edit);
        et_name_edit = findViewById(R.id.et_name_edit);
        cb_edit= findViewById(R.id.cb_edit);


        Intent intent = getIntent();
        placeInList = intent.getIntExtra("placeInList", -1);
        Student student = null;

        for (Student s: studentList) {
            if(s.getPlaceInList() == placeInList){
                student = s;
                break;
            }
        }
        et_name_edit.setText(student.getName());
        et_id_edit.setText(String.valueOf(student.getId()));
        et_phone_edit.setText(student.getPhone_number());
        et_address_edit.setText(student.getAddress());
       // Glide.with(this).load(student.getImageURL()).into(iv_image_edit);
        cb_edit.setChecked(student.isFlag());

        btn_save_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //update the student
                Student updatedStudent = new Student(placeInList,Integer.parseInt(et_id_edit.getText().toString()), et_name_edit.getText().toString(), et_phone_edit.getText().toString(), et_address_edit.getText().toString(),cb_edit.isChecked());
                studentList.set(placeInList, updatedStudent);

                //go back to main activity
                Intent intent = new Intent(Edit.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_cancel_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Edit.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_delete_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList.remove(placeInList);
                for (Student s:studentList) { //match placeInList to the place the student is in the list
                    int place = s.getPlaceInList();
                    if(place > placeInList){
                        s.setPlaceInList(place-1);
                    }
                }
                MyApplication.setNextPlaceInList(MyApplication.getNextPlaceInList()-1);
                Intent intent = new Intent(Edit.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}