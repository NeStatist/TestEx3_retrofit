package com.example.retrofit.CallBack;

import com.example.retrofit.network.model.Login.UserLoginResponse;

public interface LoginUserCallback {

    void successReq(UserLoginResponse userLoginResponse);
    void fail(Throwable throwable);
}
