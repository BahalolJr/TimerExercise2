package com.example.timerexercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DisplayTime extends AppCompatActivity {

    private TextView dispTime;
    private TextView dispCurrentDandT;
    private TextView dispEndDate;
    private TextView dispCurrentTime;
    private TextView dispEndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_time);
        dispTime = (TextView) findViewById(R.id.tvTime);
        dispCurrentDandT = (TextView) findViewById(R.id.tvStartDateAndTime);
        dispEndDate = (TextView) findViewById(R.id.dispEndDate);
        dispCurrentTime = (TextView) findViewById(R.id.tvCurrentTime);
        dispEndTime = (TextView) findViewById(R.id.tvEndTime);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        final String endDate = format.format(calendar.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        final String endTime = sdf.format(new Date());

        Intent incomingIntent = getIntent();
        final String timeReceived = incomingIntent.getStringExtra("timeTaken");
        final String currentDandT = incomingIntent.getStringExtra("currentDate");
        final String currentTime = incomingIntent.getStringExtra("currentTime");


        dispCurrentDandT.setText(currentDandT);
        dispTime.setText(timeReceived);
        dispEndDate.setText(endDate);
        dispCurrentTime.setText(currentTime);
        dispEndTime.setText(endTime);
    }
}
