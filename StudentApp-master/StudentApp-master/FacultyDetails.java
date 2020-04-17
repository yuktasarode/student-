package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;


import de.hdodenhof.circleimageview.CircleImageView;

public class FacultyDetails extends AppCompatActivity {
    private CircleImageView facultyImage;
    private Toolbar toolbar;
    private TextView facultyName;
    private TextView phoneNo;
    private TextView email;
    private TextView dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_details);

        setUpUIViews();
    }

    private void setUpUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarFacultyDetails);
        facultyName=(TextView)findViewById(R.id.tvfacultySelName);
        facultyImage=(CircleImageView)findViewById(R.id.ivFaculty);
        phoneNo=(TextView)findViewById(R.id.tvphoneno);
        email=(TextView)findViewById(R.id.tvemail);
        dept=(TextView)findViewById(R.id.tvdept);

    }

    private void setupDetails(){
        int faculty_pos=FacultyActivity.sharedPreferences.getInt(FacultyActivity.SEL_FACULTY,0);
        String[] facultyNames=getResources().getStringArray(R.array.FacultyName);
        int[] facultyImages=new int[]{
                R.drawable.faculty,R.drawable.faculty,R.drawable.faculty,R.drawable.faculty
        };
        int[] facultyArray=new int[]{
                R.array.faculty1,R.array.faculty2,R.array.faculty3,R.array.faculty4
        };
        String[] facultyDetails=getResources().getStringArray(facultyArray[faculty_pos]);
        phoneNo.setText(facultyDetails[0]);
        email.setText(facultyDetails[1]);
        dept.setText(facultyDetails[2]);
        facultyImage.setImageResource(facultyImages[faculty_pos]);
        facultyName.setText(facultyNames[faculty_pos]);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
            {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
