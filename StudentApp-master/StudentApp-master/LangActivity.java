package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LangActivity extends AppCompatActivity {

    private Button eng;
    private Button hin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang);

        eng=(Button)findViewById(R.id.btnEng);
        hin=(Button)findViewById(R.id.btnHin);

        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LangActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        hin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LangActivity.this,TranslateStudent.class);
                startActivity(intent);
            }
        });
    }
}
