package com.example.timerexercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LongSummaryStatistics;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean running;
    private long pauseoffset;
    protected String duration;
    public Button bStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bStop = (Button) findViewById(R.id.stopButton);
        chronometer = findViewById(R.id.timer);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        final String currentDate = format.format(calendar.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        final String currentTime = sdf.format(new Date());


        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseoffset);
            chronometer.start();
            running = true;

            Chronometer chrono = (Chronometer) findViewById(R.id.timer);
            chrono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                @Override
                public void onChronometerTick(Chronometer chronometer) {
                    long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                    int h = (int) (time / 3600000);
                    int m = (int) (time - h * 3600000) / 60000;
                    int s = (int) (time - h * 3600000 - m * 60000) / 1000;
                    String t = (h < 10 ? "0" + h : h) + ":" + (m < 10 ? "0" + m : m) + ":" + (s < 10 ? "0" + s : s);
                    chronometer.setText(t);
                }
            });
            chrono.setBase(SystemClock.elapsedRealtime());
            chrono.setText("00hr 00min 00sec");
        }

        bStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (running) {
                    chronometer.stop();
                    pauseoffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                    running = false;


                    duration = chronometer.getText().toString();
                    Intent intent = new Intent(MainActivity.this, DisplayTime.class);
                    intent.putExtra("timeTaken", duration);
                    intent.putExtra("currentDate", currentDate);
                    intent.putExtra("currentTime", currentTime);
                    startActivity(intent);
                }
            }
        });
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }
}
