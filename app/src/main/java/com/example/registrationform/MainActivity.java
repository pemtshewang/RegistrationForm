package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner programSpin,yearSpin;
    String[] programme= {"B Architecture","BE. Information Technology","BE. Civil","BE. Instrumentation", "BE. Electrical","BE. Geology","BE. ECE"};
    String[] year={"First Year","Second Year","Third Year","Fourth Year","Fifth Year"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //spinnerObjects
        programSpin = (Spinner) findViewById(R.id.spinner1);
        yearSpin = (Spinner) findViewById(R.id.year);

        //spinnerAdapter
        ArrayAdapter<String> programAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, programme);
        programAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        programSpin.setAdapter(programAdapter);

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, year);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpin.setAdapter(yearAdapter);

    }
}