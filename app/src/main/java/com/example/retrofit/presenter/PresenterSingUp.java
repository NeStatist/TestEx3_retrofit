package com.example.retrofit.presenter;

import android.widget.ProgressBar;

import com.example.retrofit.core.App;
import com.example.retrofit.CallBack.CreateCallBack;
import com.example.retrofit.network.model.registration.UserCreateRequest;
import com.example.retrofit.network.model.registration.UserCreateResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterSingUp {

    private CreateCallBack callback;

    public PresenterSingUp(CreateCallBack callback) {
        this.callback = callback;
    }

    public void regUser(UserCreateRequest user, final ProgressBar progressBar){
        progressBar.setVisibility(ProgressBar.VISIBLE);
        App.getInstanse().getAPI().createUser(user).enqueue(new Callback<UserCreateResponse>() {
            @Override
            public void onResponse(Call<UserCreateResponse> call, Response<UserCreateResponse> response) {
                progressBar.setVisibility(ProgressBar.INVISIBLE);
                if (response.isSuccessful()) {
                    callback.successReq(response.body());

                }
            }

            @Override
            public void onFailure(Call<UserCreateResponse> call, Throwable t) {
                callback.fail(t);
            }
        });
    }
}
