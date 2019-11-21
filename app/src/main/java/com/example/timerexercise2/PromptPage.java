package com.example.timerexercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PromptPage extends AppCompatActivity {

    private Button btStartTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt_page);
        btStartTimer = (Button) findViewById(R.id.btStartTimer);

    btStartTimer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(PromptPage.this, MainActivity.class);
            startActivity(intent);
        }
    });
    }

}
