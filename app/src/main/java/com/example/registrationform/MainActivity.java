package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner programSpin,yearSpin;
    String[] programme= {"B Architecture","BE. Information Technology","BE. Civil","BE. Instrumentation", "BE. Electrical","BE. Geology","BE. ECE"};
    String[] year={"First Year","Second Year","Third Year","Fourth Year","Fifth Year"};
    String programValue,yearValue,studentID,fName,mName,lName,semesterValue,academicYear,scholarship,modules;
    Button submit;
    TextView studentIDInput,fNameInput,mNameInput,lNameInput,modulesInput;
    RadioGroup seasonalSemester,numberSemester;
    RadioButton selectedSeasonSem,selectedNumberSem;
    CheckBox govt,self;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //spinnerObjects
        programSpin = (Spinner) findViewById(R.id.programSpin);
        yearSpin = (Spinner) findViewById(R.id.yearSpin);
        submit = (Button) findViewById(R.id.submit);
        studentIDInput = (TextView) findViewById(R.id.studentID);
        fNameInput = (TextView) findViewById(R.id.fname);
        mNameInput = (TextView) findViewById(R.id.mname);
        lNameInput = (TextView) findViewById(R.id.lname);
        modulesInput = (TextView) findViewById(R.id.modulesInput);
        seasonalSemester = (RadioGroup) findViewById(R.id.seasonalSemester);
        numberSemester = (RadioGroup) findViewById(R.id.numberSemester);


        //spinnerAdapter
        ArrayAdapter<String> programAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, programme);
        programAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        programSpin.setAdapter(programAdapter);
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, year);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpin.setAdapter(yearAdapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting the studentID
                studentID = studentIDInput.getText().toString();
                fName = fNameInput.getText().toString();
                mName = mNameInput.getText().toString();
                lName = lNameInput.getText().toString();

                //getting the program values

                programValue = programSpin.getSelectedItem().toString();

                // getting the selected year

                yearValue = yearSpin.getSelectedItem().toString();

                //checking the season semester value
                selectedSeasonSem = findViewById(seasonalSemester.getCheckedRadioButtonId());
                academicYear = selectedSeasonSem.getText().toString();

                //checking the season semester number
                selectedNumberSem = findViewById(numberSemester.getCheckedRadioButtonId());
                semesterValue = selectedNumberSem.getText().toString();

                self = (CheckBox) findViewById(R.id.selfFund);
                govt = (CheckBox) findViewById(R.id.govtScholarship);
                //checking the scholarships
                govt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Selected Govt Scholarship", Toast.LENGTH_SHORT).show();
                    }
                });

                self.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"Selected Self Funding",Toast.LENGTH_LONG).show();
                    }
                });

                if(self.isChecked() && govt.isChecked()){
                    scholarship = "Fee waiver Scholarship";
                }else if(self.isChecked()){
                    scholarship = "Self Funded";
                }else{
                    scholarship = "Government Funded";
                }
                //getting the modules here
                modules = modulesInput.getText().toString();

                Intent intent = new Intent(MainActivity.this,showData.class);

                intent.putExtra("studentid",studentID);
                intent.putExtra("fname",fName);
                intent.putExtra("mname",mName);
                intent.putExtra("lname",lName);
                intent.putExtra("program",programValue);
                intent.putExtra("studyyear",yearValue);
                intent.putExtra("academicyear",academicYear);
                intent.putExtra("semester",semesterValue);
                intent.putExtra("scholarship",scholarship);
                intent.putExtra("modules",modules);
                startActivity(intent);
            }
        });


    }
}

