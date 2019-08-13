package com.example.retrofit.CallBack;

import com.example.retrofit.network.model.getUserById.UserByIdResponse;

public interface UserIdCallback {

    void success(UserByIdResponse response);
    void fail(Throwable throwable);
}
