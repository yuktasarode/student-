package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.os.Bundle;

public class MainLog extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button loginStud,loginteacher;
    private FirebaseAuth mAuth;
    private TextView register;
    private TextView attempts;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_log);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        loginStud=findViewById(R.id.loginsStudent);
        loginteacher=findViewById(R.id.loginTeacher);
        register=findViewById(R.id.register);
        attempts=findViewById(R.id.attempts);

        //Login for student
        loginStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth=FirebaseAuth.getInstance();
                String semail=email.getText().toString();
                String spassword=password.getText().toString();

                mAuth.signInWithEmailAndPassword(semail,spassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful())
                        {

                            Toast.makeText(MainLog.this,"Login failed.Please check Email and password",Toast.LENGTH_SHORT).show();
                            counter--;
                            if(counter==0)
                                loginStud.setEnabled(false);
                            attempts.setText("Number of attempts:"+counter);

                        }
                        else
                        {
                            Toast.makeText(MainLog.this,"login successful",Toast.LENGTH_SHORT).show();

                            Intent intent= new Intent(MainLog.this,LangActivity.class);
                            finish();
                            startActivity(intent);
                        }
                    }
                });
            }
        });
        //Login for teacher
        loginteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth=FirebaseAuth.getInstance();
                String semail=email.getText().toString();
                String spassword=password.getText().toString();

                mAuth.signInWithEmailAndPassword(semail,spassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful())
                        {

                            Toast.makeText(MainLog.this,"Login failed.Please check Email and password",Toast.LENGTH_SHORT).show();
                            counter--;
                            if(counter==0)
                                loginStud.setEnabled(false);
                            attempts.setText("Number of attempts:"+counter);

                        }
                        else
                        {
                            Toast.makeText(MainLog.this,"login successful",Toast.LENGTH_SHORT).show();

                            Intent intent= new Intent(MainLog.this,TeacherHome.class);
                            finish();
                            startActivity(intent);
                        }
                    }
                });
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainLog.this,register.class);
                finish();
                startActivity(intent);
            }
        });
    }

}
