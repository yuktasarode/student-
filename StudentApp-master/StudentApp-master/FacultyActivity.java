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


public class FacultyActivity extends AppCompatActivity {
    private ListView listView;
    private Toolbar toolbar;
    public static SharedPreferences sharedPreferences;
    public static String SEL_FACULTY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        setUpUIViews();
        setUpListView();
    }

    private void setUpUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarFaculty);
        listView = (ListView) findViewById(R.id.lV_faculty);
        sharedPreferences=getSharedPreferences("My_Faculty",MODE_PRIVATE);


    }

    private void setUpListView() {
        final String[] faculty_names = getResources().getStringArray(R.array.FacultyName);

        FacultyAdapter adapter = new FacultyAdapter(this, R.layout.faculty_single_item, faculty_names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        startActivity(new Intent(FacultyActivity.this, FacultyDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY, 0).apply();
                        break;
                    }
                    case 1: {
                        startActivity(new Intent(FacultyActivity.this, FacultyDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY, 1).apply();
                        break;
                    }
                    case 2: {
                        startActivity(new Intent(FacultyActivity.this, FacultyDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY, 2).apply();
                        break;
                    }
                    case 3: {
                        startActivity(new Intent(FacultyActivity.this, FacultyDetails.class));
                        sharedPreferences.edit().putInt(SEL_FACULTY, 3).apply();
                        break;
                    }

                    }
                }

        });
    }

        public class FacultyAdapter extends ArrayAdapter {

            private int resource;
            private LayoutInflater layoutInflater;
            private String[] faculty = new String[]{};

            public FacultyAdapter(Context context, int resource, String[] objects) {
                super(context, resource, objects);
                this.resource = resource;
                this.faculty = objects;
                layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            }


            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder;
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = layoutInflater.inflate(resource, null);
                    holder.ivlogo = (LetterImageView) convertView.findViewById(R.id.ivFaculty);
                    holder.tvfacultyname = (TextView) convertView.findViewById(R.id.tvfacultyname);
                    convertView.setTag(holder);
                } else {
                    holder =(ViewHolder) convertView.getTag();
                }
                holder.ivlogo.setOval(true);
                holder.ivlogo.setLetter(faculty[position].charAt(0));
                holder.tvfacultyname.setText(faculty[position]);
                return convertView;
            }


            class ViewHolder {
                private LetterImageView ivlogo;
                private TextView tvfacultyname;
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
