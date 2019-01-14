package com.example.elcoo.blijdorpapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class RoutesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

        Date currentTime = Calendar.getInstance().getTime();

        TextView timeNow = (TextView) findViewById(R.id.textView);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
        String strDate = "Current Time : " + mdformat.format(calendar.getTime());

        timeNow.setText(strDate);

//        if (mdformat.format(calendar.getTime()) < mdformat.format()) {
//
//        }
    }
}