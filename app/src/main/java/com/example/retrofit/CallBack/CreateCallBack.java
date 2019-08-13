package com.example.retrofit.CallBack;

import com.example.retrofit.network.model.registration.UserCreateResponse;

public interface CreateCallBack {

    void successReq(UserCreateResponse userCreateResponse);
    void fail(Throwable throwable);

}
