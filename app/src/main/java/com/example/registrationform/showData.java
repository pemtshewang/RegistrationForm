package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class showData extends AppCompatActivity {
TextView studentId,fName,mName,lName,program,yearofStudy,academicYear,semester,scholarship,modules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        studentId = (TextView) findViewById(R.id.studentID);
        fName = (TextView) findViewById(R.id.fname);
        mName = (TextView) findViewById(R.id.mname);
        lName = (TextView) findViewById(R.id.lname);
        program = (TextView) findViewById(R.id.program);
        yearofStudy = (TextView) findViewById(R.id.studyYear);
        academicYear = (TextView) findViewById(R.id.academicYear);
        semester = (TextView) findViewById(R.id.semester);
        scholarship = (TextView) findViewById(R.id.scholarshipType);
        modules = (TextView) findViewById(R.id.modules);
            studentId.setText(getIntent().getStringExtra("studentid"));
            fName.setText(getIntent().getStringExtra("fname"));
            mName.setText(getIntent().getStringExtra("mname"));
            lName.setText(getIntent().getStringExtra("lname"));
            program.setText(getIntent().getStringExtra("program"));
            yearofStudy.setText(getIntent().getStringExtra("studyyear"));
            semester.setText(getIntent().getStringExtra("semester"));
            scholarship.setText(getIntent().getStringExtra("scholarship"));
            modules.setText(getIntent().getStringExtra("modules"));
            academicYear.setText(getIntent().getStringExtra("academicyear"));
    }

}