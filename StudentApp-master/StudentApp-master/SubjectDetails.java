package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SubjectDetails extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences subjectpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);

        setUpUIViews();
        setUpListView();
    }

    private void setUpUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarSubjDet);
        listView = (ListView) findViewById(R.id.lV_subjdet);
        subjectpreferences=getSharedPreferences("subjects",MODE_PRIVATE);

    }

    private void setUpListView() {
        String subject_selected=SubjectActivity.sharedPreferences.getString(SubjectActivity.subjectpref,null);
        String[] syllabus = new String[]{};

        String[] titles=getResources().getStringArray(R.array.TITLE);

        if(subject_selected.equalsIgnoreCase("OS")){
            syllabus=getResources().getStringArray(R.array.OS);
        }
        else if(subject_selected.equalsIgnoreCase("DBMS")){
            syllabus=getResources().getStringArray(R.array.DBMS);
        }
        else if(subject_selected.equalsIgnoreCase("DIA")){
            syllabus=getResources().getStringArray(R.array.DIA);
        }
        else if(subject_selected.equalsIgnoreCase("IGT")){
            syllabus=getResources().getStringArray(R.array.IGT);
        }
        SubjectDetailsAdapter subjectDetailsAdapter = new SubjectDetailsAdapter(this, titles,syllabus);
        listView.setAdapter(subjectDetailsAdapter);

    }
    public class SubjectDetailsAdapter extends BaseAdapter {

        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView title,syllabus;
        private String[] titlearray;
        private String[] syllabusarray;


        public SubjectDetailsAdapter(Context context,String[] title,String[] syllabus){
            mcontext=context;
            titlearray=title;
            syllabusarray=syllabus;
            layoutInflater=LayoutInflater.from(context);
        }

        @Override

        public int getCount() {
            return titlearray.length;
        }

        @Override
        public Object getItem(int position) {
            return titlearray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView=layoutInflater.inflate(R.layout.subj_det_single_item,null);
            }

            title=convertView.findViewById(R.id.tvsubjtitle);
            syllabus=convertView.findViewById(R.id.tvsyllabus);

            title.setText(titlearray[position]);
            syllabus.setText(syllabusarray[position]);


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
