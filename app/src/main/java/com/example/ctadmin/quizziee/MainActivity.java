package com.example.ctadmin.quizziee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button score=(Button)findViewById(R.id.score);
        Button retry=(Button)findViewById(R.id.retry);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scorecount=0;
                RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);
                RadioGroup rg2 = (RadioGroup) findViewById(R.id.rg2);
                RadioGroup rg3 = (RadioGroup) findViewById(R.id.rg3);
                int id1=rg1.getCheckedRadioButtonId();
                int id2=rg2.getCheckedRadioButtonId();
                int id3=rg3.getCheckedRadioButtonId();
                View rb1 = rg1.findViewById(id1);
                int s1 = rg1.indexOfChild(rb1);
                View rb2 = rg2.findViewById(id2);
                int s2 = rg2.indexOfChild(rb2);
                View rb3 = rg3.findViewById(id3);
                int s3 = rg3.indexOfChild(rb3);
                if(s1==1)
                    scorecount=scorecount+1;
                if(s2==2)
                    scorecount=scorecount+1;
                if(s3==3)
                    scorecount=scorecount+1;
                CheckBox cb1 = (CheckBox) findViewById(R.id.checkbox1);
                boolean isChecked1 = cb1.isChecked();
                CheckBox cb2 = (CheckBox) findViewById(R.id.checkbox2);
                boolean isChecked2 = cb2.isChecked();
                CheckBox cb3 = (CheckBox) findViewById(R.id.checkbox3);
                boolean isChecked3 = cb3.isChecked();
                CheckBox cb4 = (CheckBox) findViewById(R.id.checkbox4);
                boolean isChecked4 = cb4.isChecked();
                if (isChecked1 && isChecked3 && !isChecked2 && !isChecked4) {
                    scorecount = scorecount + 1;
                }
                EditText et=(EditText)findViewById(R.id.EditText);
                if(et.getText().toString().equals("Rapunzel"))
                {
                    scorecount=scorecount+1;
                }
                Toast.makeText(MainActivity.this, "Your score is " +scorecount,
                        Toast.LENGTH_SHORT).show();
            }
        });
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup vg = (ViewGroup) findViewById(R.id.activity_main);
                vg.invalidate();
                setContentView(R.layout.activity_main);
            }
        });
    }
}

