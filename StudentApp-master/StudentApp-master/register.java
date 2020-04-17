package com.example.student;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    private EditText studName,teacherName,studEmail,teacherEmail,studPassword,teacherPassword,studID,teacherDept, studSem;
    private Button studRegister,teacherRegister;
    private RadioButton teacher,student;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        studName=findViewById(R.id.studName);
        studEmail=findViewById(R.id.studEmail);
        studPassword=findViewById(R.id.studPassword);
        studRegister=findViewById(R.id.studRegister);
        studID=findViewById(R.id.studId);
        studSem=findViewById(R.id.studSem);


        teacherName=findViewById(R.id.teacherName);
        teacherEmail=findViewById(R.id.teacherEmail);
        teacherPassword=findViewById(R.id.teacherPassword);
        teacherRegister=findViewById(R.id.teacherRegister);
        teacherDept=findViewById(R.id.teacherDept);

        student=findViewById(R.id.radioStud);
        teacher=findViewById(R.id.TeacherRadio);

        student.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                teacherName.setVisibility(teacherName.INVISIBLE);
                teacherEmail.setVisibility(teacherEmail.INVISIBLE);
                teacherPassword.setVisibility(teacherPassword.INVISIBLE);
                teacherRegister.setVisibility(teacherRegister.INVISIBLE);
                teacherDept.setVisibility(teacherDept.INVISIBLE);

                studName.setVisibility(studName.VISIBLE);
                studEmail.setVisibility(studEmail.VISIBLE);
                studPassword.setVisibility(studPassword.VISIBLE);
                studRegister.setVisibility(studRegister.VISIBLE);
                studID.setVisibility(studID.VISIBLE);
                studSem.setVisibility(studSem.VISIBLE);

            }
        });

        teacher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



                studName.setVisibility(studName.INVISIBLE);
                studEmail.setVisibility(studEmail.INVISIBLE);
                studPassword.setVisibility(studPassword.INVISIBLE);
                studRegister.setVisibility(studRegister.INVISIBLE);
                studID.setVisibility(studID.INVISIBLE);
                studSem.setVisibility(studSem.INVISIBLE);

                teacherName.setVisibility(teacherName.VISIBLE);
                teacherEmail.setVisibility(teacherEmail.VISIBLE);
                teacherPassword.setVisibility(teacherPassword.VISIBLE);
                teacherRegister.setVisibility(teacherRegister.VISIBLE);
                teacherDept.setVisibility(teacherDept.VISIBLE);
            }
        });

        teacherRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=teacherName.getText().toString();
                String email=teacherEmail.getText().toString();
                String password=teacherPassword.getText().toString();
                String dept=teacherDept.getText().toString();

                firebaseAuth=FirebaseAuth.getInstance();
                if(!email.isEmpty() && !password.isEmpty() && password.length()>=6) {


                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(register.this, MainLog.class));
                            } else
                                Toast.makeText(register.this, "Registration failed", Toast.LENGTH_SHORT).show();

                        }
                    });
                }

                else if(email.isEmpty())
                    Toast.makeText(register.this, "Please enter Email id", Toast.LENGTH_SHORT).show();
                else if(password.isEmpty() || password.length()<6)
                    Toast.makeText(register.this, "Please enter password", Toast.LENGTH_SHORT).show();

            }
        });

        studRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=studName.getText().toString();
                String email=studEmail.getText().toString();
                String password=studPassword.getText().toString();
                int id=Integer.parseInt(studID.getText().toString());

                firebaseAuth=FirebaseAuth.getInstance();
                if(!email.isEmpty() && !password.isEmpty() && password.length()>=6) {

                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(register.this, MainLog.class));
                            } else
                                Toast.makeText(register.this, "Registration failed", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
                else if(email.isEmpty())
                    Toast.makeText(register.this, "Please enter Email id", Toast.LENGTH_SHORT).show();
                else if(password.isEmpty() || password.length()<6)
                    Toast.makeText(register.this, "Please enter password", Toast.LENGTH_SHORT).show();


            }
        });


    }
}
