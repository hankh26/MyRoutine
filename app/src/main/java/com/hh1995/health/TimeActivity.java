package com.hh1995.health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class TimeActivity extends AppCompatActivity {

    TextView timeOut;
    TextView tvSet;

    Button btnStart;
    Button btnCancel;

    EditText etM;
    EditText etS;

    CountDownTimer timer;

    final static int Init=0;
    final static int Run=1;
    final static int Pause=2;

    int cur_Status=Init;
    long BaseTime;
    long PauseTime;

    String timel="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        btnStart = findViewById(R.id.btn_tstart);
        btnCancel = findViewById(R.id.btn_cancel);
        timeOut = findViewById(R.id.time_out);
        tvSet = findViewById(R.id.tv_set);
        etM=findViewById(R.id.etm);
        etS=findViewById(R.id.ets);

        //timel=etM.getText().toString()+etS.getText().toString();
        countDown("0010");

    }


    public void countDown(final String time) {
        long conversionTime = 0;

        String getMin = time.substring(0, 2);
        String getSecond = time.substring(2, 4);

        if (getMin.substring(0, 1) == "0") {
            getMin = getMin.substring(1, 2);
        }

        if (getSecond.substring(0, 1) == "0") {
            getSecond = getSecond.substring(1, 2);
        }

        conversionTime = Long.valueOf(getMin) * 60 * 1000 + Long.valueOf(getSecond) * 1000;

        timer = new CountDownTimer(conversionTime, 1000) {
            public void onTick(long millisUntilFinished) {

                long getMin = millisUntilFinished - (millisUntilFinished / (60 * 60 * 1000));
                String min = String.valueOf(getMin / (60 * 1000));

                String second = String.valueOf((getMin % (60 * 1000)) / 1000);

                String millis = String.valueOf((getMin % (60 * 1000)) % 1000);


                if (min.length() == 1) {
                    min = "0" + min;
                }

                if (second.length() == 1) {
                    second = "0" + second;
                }

                timeOut.setText(min + ":" + second);
            }

            public void onFinish() {

                timeOut.setText("00:10");
            }
        };

    }
        public void myOnClick (View view) throws InterruptedException {
            switch (view.getId()) {
                case R.id.btn_tstart:
                    switch (cur_Status){
                        case Init:
                        timer.start();
                        btnStart.setText("일시정지");
                        cur_Status=Run;
                        break;
                        case Run:
                            btnStart.setText("시작");
                            timer.cancel();
                            cur_Status=Pause;
                            Toast.makeText(this, timeOut.getText().toString(), Toast.LENGTH_SHORT).show();
                            break;
                        case Pause:
                            String now=timeOut.getText().toString();
                            now=now.replace(":","");
                            countDown(now);
                            timer.start();
                            cur_Status=Run;
                            break;
                    }

                    break;
                case R.id.btn_cancel:
                    Toast.makeText(this, "n"+etM.getText().toString()+etS.getText().toString()+"n", Toast.LENGTH_SHORT).show();
            }

        }

    public void clickStop(View view) {
        Intent intent=new Intent(TimeActivity.this,TimerActivity.class);
        startActivity(intent);
        finish();
    }
}

