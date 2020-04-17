package com.example.student;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.student.Utils.LetterImageView;

public class DayDetail extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    public static String[] Monday;
    public static String[] Tuesday;
    public static String[] Wednesday;
    public static String[] Thursday;
    public static String[] Friday;
    public static String[] timeMon;
    public static String[] timeTues;
    public static String[] timeWed;
    public static String[] timeThurs;
    public static String[] timeFri;
    private String[] PrefferedDay;
    private String[] PreferredTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);

        setupUIViews();
        setUpListView();
    }

    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarDay);
        listView = (ListView) findViewById(R.id.lV_day);
    }
    /*private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Week.sharedPreferences.getString(Week.SEL_DAY,null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }*/

    public void setUpListView(){

        Monday=getResources().getStringArray(R.array.Monday);
        Tuesday=getResources().getStringArray(R.array.Tuesday);
        Wednesday=getResources().getStringArray(R.array.Wednesday);
        Thursday=getResources().getStringArray(R.array.Thursday);
        Friday=getResources().getStringArray(R.array.Friday);

        timeMon=getResources().getStringArray(R.array.timeMon);
        timeTues=getResources().getStringArray(R.array.timeTue);
        timeWed=getResources().getStringArray(R.array.timeWed);
        timeThurs=getResources().getStringArray(R.array.timeThurs);
        timeFri=getResources().getStringArray(R.array.timeFri);

        String selected_day=Week.sharedPreferences.getString(Week.SEL_DAY,null);

        if(selected_day.equalsIgnoreCase("Monday")){
            PrefferedDay=Monday;
            PreferredTime=timeMon;
        }

        else  if(selected_day.equalsIgnoreCase("Tuesday")){
            PrefferedDay=Tuesday;
            PreferredTime=timeTues;
        }
        else  if(selected_day.equalsIgnoreCase("Wednesday")){
            PrefferedDay=Wednesday;
            PreferredTime=timeWed;
        }
        else  if(selected_day.equalsIgnoreCase("Thursday")){
            PrefferedDay=Thursday;
            PreferredTime=timeThurs;
        }
        else {
            PrefferedDay = Friday;
            PreferredTime = timeFri;
        }

        SimpleAdapter simpleAdapter=new SimpleAdapter(DayDetail.this,PrefferedDay,PreferredTime);
        listView.setAdapter(simpleAdapter);

    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView subject,time;
        private String[] subjectarray;
        private String[] timearray;
        private LetterImageView letterImageView;

        public SimpleAdapter(Context context,String[] subject,String[] time){
            mcontext=context;
            timearray=time;
            subjectarray=subject;
            layoutInflater=LayoutInflater.from(context);
        }

        @Override

        public int getCount() {
            return subjectarray.length;
        }

        @Override
        public Object getItem(int position) {
            return subjectarray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView=layoutInflater.inflate(R.layout.day_detail_single_item,null);
            }

            subject=(TextView)convertView.findViewById(R.id.tvdaydetail);
            time=(TextView)convertView.findViewById(R.id.tvtime);
            letterImageView=(LetterImageView)convertView.findViewById(R.id.ivdaydetail);



            letterImageView.setOval(true);
            letterImageView.setLetter(subjectarray[position].charAt(0));

            subject.setText(subjectarray[position]);
            time.setText(timearray[position]);




            return convertView;
        }
    }

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




