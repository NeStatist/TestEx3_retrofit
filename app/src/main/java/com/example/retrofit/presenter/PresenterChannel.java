package com.example.retrofit.presenter;

import com.example.retrofit.CallBack.ChannelCallback;
import com.example.retrofit.core.App;
import com.example.retrofit.network.model.channel.ChannelResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterChannel {

    private ChannelCallback callback;

    public PresenterChannel(ChannelCallback callback) {
        this.callback = callback;
    }

    public void getChannel(){
        App.getInstanse().getAPI().getChannel().enqueue(new Callback<ChannelResponse>() {
            @Override
            public void onResponse(Call<ChannelResponse> call, Response<ChannelResponse> response) {
                if (response.isSuccessful()) {
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<ChannelResponse> call, Throwable t) {
                callback.fail(t);
            }
        });
    }

}
