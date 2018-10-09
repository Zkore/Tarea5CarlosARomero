package com.iteso.pdm18_scrollabletabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                User user = loadPreferences();
                Intent intent;
                if(!user.isLogged )
                    intent = new Intent(ActivitySplashScreen.this, ActivityLogin.class);
                    else
                    intent = new Intent(ActivitySplashScreen.this, ActivityMain.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1500);
    }

    public User loadPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences("com.iteso.USER_PREFERENCES",MODE_PRIVATE);
        User user = new User();
        user.setName(sharedPreferences.getString("USER", null));
        user.setPassword(sharedPreferences.getString("PASSWORD", null));
        user.setLogged(sharedPreferences.getBoolean("LOGIN", false));
        return user;
    }
}

