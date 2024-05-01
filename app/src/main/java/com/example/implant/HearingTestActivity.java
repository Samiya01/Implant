package com.example.implant;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class HearingTestActivity extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hearing_test);
        List<String> listItems = new ArrayList<String>();
        for(int i=1;i<=10;i++) {
            listItems.add("Audio " + i);
        }
        listView = (ListView)findViewById(R.id.listview);
        customAdapter = new CustomAdapter(getApplicationContext(),R.layout.ui_activity,listItems);
        listView.setAdapter((ListAdapter) customAdapter);
    }
}