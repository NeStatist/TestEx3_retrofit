package com.example.retrofit.core;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.retrofit.network.UserAPI;
import com.example.retrofit.network.APIManager;


public class App extends Application {

    private UserAPI mAPI;
    private static App instance;
    private SharedPreferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mAPI = new APIManager();
        preferences = getSharedPreferences("all", MODE_PRIVATE);
    }

    public UserAPI getAPI() {
        return mAPI;
    }

    public static App getInstanse() {
        return instance;
    }

    public SharedPreferences getSharedPreferences() {
        return preferences;
    }

}
