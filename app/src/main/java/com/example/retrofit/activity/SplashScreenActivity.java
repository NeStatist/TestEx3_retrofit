package com.example.retrofit.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofit.R;
import com.example.retrofit.core.App;

public class SplashScreenActivity extends AppCompatActivity {

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SharedPreferences sp = App.getInstanse().getSharedPreferences();

        id = sp.getInt("userId", 0);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                splashLogin();
            }
        }, 1*1000);
    }

    public void splashLogin(){

       if(id != 0){

            Intent intent = new Intent(SplashScreenActivity.this, UserActivityCallback.class);
            SharedPreferences.Editor ed = App.getInstanse().getSharedPreferences().edit();
            ed.putInt("userId", id);
            startActivity(intent);

        } else {

            Intent intent = new Intent(SplashScreenActivity.this, SingUpActivity.class);
            startActivity(intent);
            finish();
       }
    }
}
