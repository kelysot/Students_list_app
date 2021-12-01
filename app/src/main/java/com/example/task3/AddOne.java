package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.List;

public class AddOne extends AppCompatActivity {

    Button btn_save, btn_cancel;

    List<Student> studentList;
    MyApplication myApplication = (MyApplication) this.getApplication();

    EditText et_student_name, et_student_address, et_id, et_phone;
    CheckBox cb_add;

    int placeInList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_one);

        studentList = myApplication.getStudentList();

        btn_cancel = findViewById(R.id.btn_cancel);
        btn_save = findViewById(R.id.btn_save);

        et_id = findViewById(R.id.et_id);
        et_phone = findViewById(R.id.et_phone);
        et_student_address = findViewById(R.id.et_student_address);
        et_student_name = findViewById(R.id.et_student_name);
        cb_add= findViewById(R.id.cb_add);

        Intent intent = getIntent();
        placeInList = intent.getIntExtra("placeInList", -1);
        Student student = null;

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add new student
                //create student object.
                int nextPlaceInList = myApplication.getNextPlaceInList();
                Student newStudent = new Student(nextPlaceInList,Integer.parseInt(et_id.getText().toString()), et_student_name.getText().toString(), et_phone.getText().toString(), et_student_address.getText().toString(),cb_add.isChecked());

                //add the student object to the global list of students.
                studentList.add(newStudent);
                nextPlaceInList++;


                //go back to main activity
                Intent intent = new Intent(AddOne.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddOne.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}