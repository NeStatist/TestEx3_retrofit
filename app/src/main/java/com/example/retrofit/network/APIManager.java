package com.example.retrofit.network;


import com.example.retrofit.network.model.Login.UserLoginRequest;
import com.example.retrofit.network.model.Login.UserLoginResponse;
import com.example.retrofit.network.model.channel.ChannelResponse;
import com.example.retrofit.network.model.registration.UserCreateRequest;
import com.example.retrofit.network.model.getUserById.UserByIdResponse;
import com.example.retrofit.network.model.registration.UserCreateResponse;

import retrofit2.Call;

public class APIManager implements UserAPI{

    private UserAPI apiUser;

    public APIManager() {
        apiUser = NetManager.getInstance().getRestApi();
    }

    @Override
    public Call<UserCreateResponse> createUser(UserCreateRequest user) {
        return apiUser.createUser(user);
    }

    @Override
    public Call<UserLoginResponse> loginUser(UserLoginRequest user) {
        return apiUser.loginUser(user);
    }

    @Override
    public Call<UserByIdResponse> getUserByID(int id) {
        return apiUser.getUserByID(id);
    }

    @Override
    public Call<ChannelResponse> getChannel() {
        return apiUser.getChannel();
    }
}
