package com.example.calcmain;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button one,two,three,four,five,six,seven,eight,nine,zero,op_brace,co_brace,plus,minus,divide,multiply,modulo,equal,ac,decimal,clear;
    TextView question,answer;
    String process;
    Double prevAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        plus = (Button) findViewById(R.id.add);
        minus = (Button) findViewById(R.id.minus);
        divide = (Button) findViewById(R.id.divide);
        multiply = (Button) findViewById(R.id.multiply);
        modulo = (Button) findViewById(R.id.modulo);
        equal = (Button) findViewById(R.id.equal);
        op_brace = (Button) findViewById(R.id.openbrace);
        co_brace = (Button) findViewById(R.id.closebrace);
        question = (TextView) findViewById(R.id.input);
        answer = (TextView) findViewById(R.id.answer);
        ac = (Button) findViewById(R.id.autoreset);
        clear = (Button) findViewById(R.id.clear);
        decimal = (Button) findViewById(R.id.decimal);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.append("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.append("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.append("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.append("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.append("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.append("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.append("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.append("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.append("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.append("0");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkEmpty(question))
                {
                    String stmt = prevAnswer.toString() + "+";
                    question.setText(stmt);
                }else{
                    question.append("+");
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkEmpty(question))
                {
                    String stmt = prevAnswer.toString() + "-";
                    question.setText(stmt);
                }else{
                    question.append("-");
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkEmpty(question))
                {
                    String stmt = prevAnswer.toString() + "/";
                    question.setText(stmt);
                }else{
                    question.append("/");
                }
            }
        });
        modulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkEmpty(question))
                {
                    String stmt = prevAnswer.toString() + "%";
                    question.setText(stmt);
                }else{
                    question.append("%");
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkEmpty(question))
                {
                    String stmt = prevAnswer.toString() + "x";
                    question.setText(stmt);
                }else{
                    question.append("x");
                }
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.setText("");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question.getText().toString().length()<1){
                    Toast.makeText(getApplicationContext(),"Buffer is empty",Toast.LENGTH_LONG).show();
                }else if(question.getText().toString().length()==1){
                    question.setText("");
                }else{
                    String current = question.getText().toString();
                    question.setText(current.substring(0,current.length()-1));
                }
            }
        });
        op_brace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               question.append("(");
            }
        });
        co_brace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.append(")");
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.append(".");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                process = question.getText().toString();
                process = process.replaceAll("x","*");
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";
                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                    prevAnswer = Double.valueOf(finalResult);
                    answer.setText("="+finalResult);
                    question.setText("");
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"An ERROR occurred, please take care of the statement",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public static boolean checkEmpty(TextView question)
    {
        return question.getText().toString().equals("");
    }
}