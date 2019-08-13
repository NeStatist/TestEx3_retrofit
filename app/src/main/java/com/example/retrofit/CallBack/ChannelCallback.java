package com.example.retrofit.CallBack;

import com.example.retrofit.network.model.channel.ChannelResponse;

public interface ChannelCallback {

    void success(ChannelResponse response);
    void fail(Throwable throwable);
}
