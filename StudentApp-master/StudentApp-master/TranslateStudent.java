package com.example.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class TranslateStudent extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_student);



        setupUIViews();
        //initToolbar();
        setUpListView();
    }



    private void setupUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarTrans);
        listView = (ListView) findViewById(R.id.lV_trans);
    }

    /*private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Student++");
    }*/

    private  void setUpListView(){
        String[] title=getResources().getStringArray(R.array.MainTrans);

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,title);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:break;
                }
            }
        });
    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView title;
        private String[] titlearray;
        private ImageView imageView;

        public SimpleAdapter(Context context,String[] title){
            mcontext=context;
            titlearray=title;
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
                convertView=layoutInflater.inflate(R.layout.translate_single_item,null);
            }

            title=convertView.findViewById(R.id.tvmaintrans);
            imageView=convertView.findViewById(R.id.icontrans);

            title.setText(titlearray[position]);

            if(titlearray[position].equalsIgnoreCase(
                    "विषय")){
                imageView.setImageResource(R.drawable.timetableicon);
            }
            else if(titlearray[position].equalsIgnoreCase("कार्य")){
                imageView.setImageResource(R.drawable.subjecticon);
            }
            else if(titlearray[position].equalsIgnoreCase(
                    "अध्यापक")){
                imageView.setImageResource(R.drawable.faculty);
            }
            else{
                imageView.setImageResource(R.drawable.resourcesicon);
            }
            return convertView;
        }
    }
}

