package com.example.retrofit.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.retrofit.CallBack.UserIdCallback;
import com.example.retrofit.R;
import com.example.retrofit.core.App;
import com.example.retrofit.network.model.getUserById.UserByIdResponse;
import com.example.retrofit.presenter.PresenterUser;

public class UserActivityCallback extends AppCompatActivity implements UserIdCallback, View.OnClickListener{

    private TextView viewUserNAme, viewEmail;
    private PresenterUser presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        viewUserNAme = findViewById(R.id.viewUserName);
        viewEmail = findViewById(R.id.viewEmail);

        findViewById(R.id.logOut).setOnClickListener(this);
        findViewById(R.id.categories).setOnClickListener(this);

        presenter = new PresenterUser(this);
        SharedPreferences sp = App.getInstanse().getSharedPreferences();
        presenter.getUserId(sp.getInt("userId", 0));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logOut:
                logoutMeth();
                break;

            case R.id.categories:
                Intent intent = new Intent(UserActivityCallback.this, ChannelActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void success(UserByIdResponse response) {
        setUserparams(response);
    }

    public void setUserparams(UserByIdResponse response) {
        viewUserNAme.setText(response.getData().getUser().getUsername());
        viewEmail.setText(response.getData().getUser().getEmail());
    }


    public void logoutMeth(){
        Intent intent = new Intent(UserActivityCallback.this, SplashScreenActivity.class);
        SharedPreferences.Editor ed = App.getInstanse().getSharedPreferences().edit();
        ed.clear();
        ed.apply();
        startActivity(intent);
    }
    
    @Override
    public void fail(Throwable throwable) {
        Log.e("Response", throwable.toString());
    }


}
