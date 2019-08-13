package com.example.retrofit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.retrofit.CallBack.CreateCallBack;
import com.example.retrofit.R;
import com.example.retrofit.core.App;
import com.example.retrofit.network.model.registration.UserCreateRequest;
import com.example.retrofit.network.model.registration.UserCreateResponse;
import com.example.retrofit.presenter.PresenterSingUp;


public class SingUpActivity extends AppCompatActivity implements View.OnClickListener, CreateCallBack {

    private EditText editPass, editNickname, editEmail;
    private PresenterSingUp presenterSingUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);



        presenterSingUp = new PresenterSingUp(this);

        editPass = findViewById(R.id.signPassword);
        editNickname = findViewById(R.id.userName);
        editEmail = findViewById(R.id.signEmail);

        findViewById(R.id.btnLogIn).setOnClickListener(this);
        findViewById(R.id.btnSignIn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignIn:

                registerUser();
                correctData();
                break;

            case R.id.btnLogIn:

                startActivity(new Intent(this, LoginActivityCallback.class));
                break;
        }
    }

    public boolean correctData(){

        String nickname = editNickname.getText().toString();
        String email = editEmail.getText().toString();
        String password = editPass.getText().toString();

        if (nickname.isEmpty()) {
            editNickname.setError("Enter User Name");
            editNickname.requestFocus();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("Enter email");
            editEmail.requestFocus();
            return false;
        }

        if (email.isEmpty()) {
            editEmail.setError("Email");
            editEmail.requestFocus();
            return false;
        }
        if (password.isEmpty()) {
            editPass.setError("Passwordz");
            editPass.requestFocus();
            return false;
        }

        return true;
    }


    public void registerUser(){

        UserCreateRequest user = new UserCreateRequest();

        user.setUsername(editNickname.getText().toString());
        user.setEmail(editEmail.getText().toString());
        user.setPassword(editPass.getText().toString());
        user.setDeviceToken("HGWYUsnd83bdsjdfwoi4c");
        user.setOsType("ios");

        presenterSingUp.regUser(user, (ProgressBar) findViewById(R.id.progressBar));
    }


    @Override
    public void successReq(UserCreateResponse userCreateResponse) {
        intentInUserActivity(userCreateResponse);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Account create!", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void fail(Throwable throwable) {
        Log.i("SuccessFail", throwable.toString());
    }



    public void intentInUserActivity(UserCreateResponse userCreateResponse) {

        SharedPreferences.Editor ed = App.getInstanse().getSharedPreferences().edit();
        ed.putInt("userId", userCreateResponse.getData().getId());
        ed.apply();

        Intent intent = new Intent(this, UserActivityCallback.class);
        startActivity(intent);
    }

}

