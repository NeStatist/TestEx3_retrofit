package com.example.retrofit.presenter;

import android.widget.ProgressBar;

import com.example.retrofit.CallBack.LoginUserCallback;
import com.example.retrofit.core.App;
import com.example.retrofit.network.model.Login.UserLoginRequest;
import com.example.retrofit.network.model.Login.UserLoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterLogIn {

    private LoginUserCallback callback;

    public PresenterLogIn(LoginUserCallback callback) {
        this.callback = callback;
    }

    public void loginUser(UserLoginRequest user, final ProgressBar progressBar){
        progressBar.setVisibility(ProgressBar.VISIBLE);
        App.getInstanse().getAPI().loginUser(user).enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
                progressBar.setVisibility(ProgressBar.INVISIBLE);
                if (response.isSuccessful()) {
                    callback.successReq(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {
                callback.fail(t);
            }
        });
    }
}
