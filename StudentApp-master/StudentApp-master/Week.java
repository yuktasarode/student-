package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.example.student.R;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.example.student.Utils.LetterImageView;

public class Week extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences sharedPreferences;
    public static String SEL_DAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);
        setUpUIViews();
        //initToolbar();
        setUpListView();

    }

    private void setUpUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarWeek);
        listView = (ListView) findViewById(R.id.lV_week);
        sharedPreferences=getSharedPreferences("My_Day",MODE_PRIVATE);

    }

    /*private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("WEEK");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }*/

    private void setUpListView() {
        String[] week = getResources().getStringArray(R.array.Week);

        WeekAdapter adapter = new WeekAdapter(this,R.layout.week_activity_single_item, week);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        startActivity(new Intent(Week.this, DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Monday").apply();
                        break;
                    }
                    case 1: {
                        startActivity(new Intent(Week.this, DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Tuesday").apply();
                        break;
                    }
                    case 2: {
                        startActivity(new Intent(Week.this, DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Wednesday").apply();
                        break;
                    }
                    case 3: {
                        startActivity(new Intent(Week.this, DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Thursday").apply();
                        break;
                    }
                    case 4: {
                        startActivity(new Intent(Week.this, DayDetail.class));
                        sharedPreferences.edit().putString(SEL_DAY, "Friday").apply();
                        break;
                    }
                }
            }
        });

    }
    public class WeekAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] week = new String[]{};

        public WeekAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.week = objects;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivlogo = (LetterImageView) convertView.findViewById(R.id.ivLetter);
                holder.tvweek = (TextView) convertView.findViewById(R.id.tvweek);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.ivlogo.setOval(true);
            holder.ivlogo.setLetter(week[position].charAt(0));
            holder.tvweek.setText(week[position]);
            return convertView;
        }


        class ViewHolder {
            private LetterImageView ivlogo;
            private TextView tvweek;
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
