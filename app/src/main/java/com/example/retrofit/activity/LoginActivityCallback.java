package com.example.retrofit.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofit.CallBack.LoginUserCallback;
import com.example.retrofit.R;
import com.example.retrofit.core.App;
import com.example.retrofit.network.model.Login.UserLoginRequest;
import com.example.retrofit.network.model.Login.UserLoginResponse;
import com.example.retrofit.presenter.PresenterLogIn;


public class LoginActivityCallback extends AppCompatActivity implements View.OnClickListener, LoginUserCallback {

    private EditText addPass, addEmail;
    private PresenterLogIn presenterLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);

        addPass = findViewById(R.id.loginPassword);
        addEmail = findViewById(R.id.loginEmail);

        findViewById(R.id.btnRegister).setOnClickListener(this);
        findViewById(R.id.buttonLogin).setOnClickListener(this);

        presenterLogIn = new PresenterLogIn(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:

                    correctLogin();
                    loginMeth();


                break;

            case R.id.btnRegister:
                startActivity(new Intent(this, SingUpActivity.class));
                break;
        }
    }

    public boolean loginMeth(){

        UserLoginRequest user = new UserLoginRequest();

        user.setEmail(addEmail.getText().toString());
        user.setPassword(addPass.getText().toString());
        user.setDeviceToken("HGWYUsnd83bdsjdfwoi4c");
        user.setOsType("ios");

        presenterLogIn.loginUser(user, (ProgressBar) findViewById(R.id.progressBar2));

      return true;
    }

    public boolean correctLogin(){

        String email = addEmail.getText().toString();
        String password = addPass.getText().toString();


        if (email.isEmpty()) {
            addEmail.setError("Email is required");
            addEmail.requestFocus();
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            addEmail.setError("Enter a valid email\nEmail must be like this: example@gmail.com");
            addEmail.requestFocus();
            return false;
        }
        if (password.isEmpty()) {
            addPass.setError("Password is required");
            addPass.requestFocus();
            return false;
        }

        return true;
    }

    @Override
    public void successReq(UserLoginResponse userLoginResponse) {
           intentInUserActivity(userLoginResponse);
    }

    @Override
    public void fail(Throwable throwable) {

    }

    public void intentInUserActivity(UserLoginResponse response) {

        SharedPreferences.Editor ed = App.getInstanse().getSharedPreferences().edit();
        ed.putInt("userId", response.getUser().getId());
        ed.apply();

        Intent intent = new Intent(this, UserActivityCallback.class);
        startActivity(intent);
    }
}
