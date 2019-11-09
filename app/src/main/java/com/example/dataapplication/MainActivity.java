package com.example.dataapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private List<Student> studentList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper=new MyDatabaseHelper(this,"School.db",null,1);
        Button createDatabase=findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });

        Button add=findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("stuName","小西");
                values.put("stuNO","1720");
                values.put("stuPhotoId","12");
                db.insert("Student",null,values);
                values.clear();
                values.put("stuName","小东");
                values.put("stuNO","1725");
                values.put("stuPhotoId","15");
                db.insert("Student",null,values);
            }
        });

        Button show=findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                Cursor cursor=db.query("Student",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        int stuId=cursor.getInt(cursor.getColumnIndex("stuId"));
                        String stuName=cursor.getString(cursor.getColumnIndex("stuName"));
                        String stuNO=cursor.getString(cursor.getColumnIndex("stuNO"));
                        String stuPhotoId=cursor.getString(cursor.getColumnIndex("stuPhotoId"));
                        Student student=new Student(stuId,stuName,stuNO,stuPhotoId);
                        System.out.println(student);
                        studentList.add(student);
                    }while(cursor.moveToNext());
                }
                cursor.close();
                ListView listView = findViewById(R.id.list_item);
                StudentAdapter adapter = new StudentAdapter(MainActivity.this,studentList);
                listView.setAdapter(adapter);
            }
        });
    }
}
