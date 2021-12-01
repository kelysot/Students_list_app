package com.example.task3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Student> studentList;
    Context context;

    public MyAdapter(List<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list_row, parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tv_name.setText(studentList.get(position).getName());
        holder.tv_id.setText(String.valueOf(studentList.get(position).getId()));
        holder.cb_lr.setChecked(studentList.get(position).isFlag());
        //Glide.with(this.context).load(studentList.get(position).getImageURL()).into(holder.iv_student_image);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sent the control to the editOneItem activity
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("placeInList", studentList.get(position).getPlaceInList());
                context.startActivity(intent);
            }
        });
        holder.cb_lr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList.get(position).setFlag(!(studentList.get(position).isFlag()));
                holder.cb_lr.setChecked(studentList.get(position).isFlag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_student_image;
        TextView tv_name;
        TextView tv_id;
        CheckBox cb_lr;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_student_image = itemView.findViewById(R.id.iv_student_image);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_name = itemView.findViewById(R.id.tv_name);
            cb_lr = itemView.findViewById(R.id.cb_lr);
            parentLayout= itemView.findViewById(R.id.oneRowStudentLayout);
        }
    }
}
