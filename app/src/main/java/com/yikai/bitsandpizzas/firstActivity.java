package com.yikai.bitsandpizzas;

import android.app.Activity;
import android.os.Bundle;
import java.util.TimerTask;
import java.util.Timer;
import android.content.Intent;
import android.app.ActionBar;

public class firstActivity extends Activity {

    private ActionBar mActionBar;
    long t = 2000;

    protected void forintent(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mActionBar=getActionBar();
        mActionBar.hide();

        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);




        setContentView(R.layout.activity_first);


        TimerTask task = new TimerTask() {
            public void run() {
                forintent();

            }
        };
        Timer timer = new Timer();
        timer.schedule(task, t);





    }
}