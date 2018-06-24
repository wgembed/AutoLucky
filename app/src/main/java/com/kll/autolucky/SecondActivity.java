package com.kll.autolucky;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.Timer;
import java.util.TimerTask;

public class SecondActivity extends AppCompatActivity {

    private final int DELAY_TIME = 3000;
    private  Timer delay_time;
    private  TimerTask delay_task;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode)
        {
            case KeyEvent.KEYCODE_BACK:
                delay_task.cancel();
                finish();
                break;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

            delay_time = new Timer();
            delay_task = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(SecondActivity.this, FirstActivity.class));
                finish();
            }
        };
        delay_time.schedule(delay_task, DELAY_TIME);
    }
}
