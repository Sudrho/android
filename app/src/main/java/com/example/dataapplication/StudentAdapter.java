package com.example.dataapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {
    private List<Student> studentList;
    private Context mContext;

    public StudentAdapter(Context context, List<Student> objects) {
        super(context, R.layout.item, objects);
        studentList = objects;
        mContext = context;
    }

    @Nullable
    @Override
    public Student getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        if(convertView != null)
////            view = convertView;
////        else {
////            view = View.inflate(mContext, R.layout.item,null);
////        }
            Student student = getItem(position);
            @SuppressLint("ViewHolder") View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent,false);
            TextView stuId = view.findViewById(R.id.stuId);
            TextView stuName = view.findViewById(R.id.stuName);
            TextView stuNO = view.findViewById(R.id.stuNO);
            TextView stuPhotoId = view.findViewById(R.id.stuPhotoId);

        assert student != null;
            stuId.setText(student.getStuId());
            stuName.setText(student.getStuName());
            stuNO.setText(student.getStuNO());
            stuPhotoId.setText(student.getStuPhotoId());
            return view;
        }
    }