package com.example.retrofit.presenter;

import com.example.retrofit.CallBack.UserIdCallback;
import com.example.retrofit.core.App;
import com.example.retrofit.network.model.getUserById.UserByIdResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterUser {

    private UserIdCallback callback;

    public PresenterUser(UserIdCallback callback) {
        this.callback = callback;
    }

   public void getUserId(int id) {
        App.getInstanse().getAPI().getUserByID(id).enqueue(new Callback<UserByIdResponse>() {
            @Override
            public void onResponse(Call<UserByIdResponse> call, Response<UserByIdResponse> response) {
                if (response.isSuccessful()) {
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserByIdResponse> call, Throwable t) {
                callback.fail(t);
            }
        });
    }
}
