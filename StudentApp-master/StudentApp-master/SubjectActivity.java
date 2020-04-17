package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.student.Utils.LetterImageView;

import javax.security.auth.Subject;

import static com.example.student.SubjectDetails.subjectpreferences;

public class SubjectActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences sharedPreferences;
    private String[] Subjects;
    public static String subjectpref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        setUpUIViews();
        setUpListView();


    }

    private void setUpUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarSubject);
        listView = (ListView) findViewById(R.id.lV_subject);
        sharedPreferences = getSharedPreferences("My_Day", MODE_PRIVATE);

    }

    /*private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("WEEK");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }*/

    private void setUpListView() {
        Subjects = getResources().getStringArray(R.array.Syllabus);

        SubjectAdapter subjectAdapter=new SubjectAdapter(this,R.layout.subject_single_item,Subjects);
        listView.setAdapter(subjectAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position)
                {
                    case 0: {
                        subjectpreferences.edit().putString(subjectpref,"OS").apply();
                        startActivity(new Intent(SubjectActivity.this,SubjectDetails.class));
                        break;
                    }
                    case 1: {
                        subjectpreferences.edit().putString(subjectpref,"DBMS").apply();
                        startActivity(new Intent(SubjectActivity.this,SubjectDetails.class));
                        break;
                    }
                    case 2: {
                        subjectpreferences.edit().putString(subjectpref,"DIA").apply();
                        startActivity(new Intent(SubjectActivity.this,SubjectDetails.class));
                        break;
                    }

                    case 3: {
                        subjectpreferences.edit().putString(subjectpref,"IGT").apply();
                        startActivity(new Intent(SubjectActivity.this,SubjectDetails.class));
                        break;
                    }


                    }
                }

        });

}

    public class SubjectAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] subjects = new String[]{};

        public SubjectAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.subjects = objects;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivlogo = (LetterImageView) convertView.findViewById(R.id.ivLettersubj);
                holder.tvsubj = (TextView) convertView.findViewById(R.id.tvsubj);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.ivlogo.setOval(true);
            holder.ivlogo.setLetter(subjects[position].charAt(0));
            holder.tvsubj.setText(subjects[position]);
            return convertView;
        }


        class ViewHolder {
            private LetterImageView ivlogo;
            private TextView tvsubj;
        }
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
