package com.example.retrofit.network;


import com.example.retrofit.network.model.Login.UserLoginRequest;
import com.example.retrofit.network.model.Login.UserLoginResponse;
import com.example.retrofit.network.model.channel.ChannelResponse;
import com.example.retrofit.network.model.registration.UserCreateRequest;
import com.example.retrofit.network.model.getUserById.UserByIdResponse;
import com.example.retrofit.network.model.registration.UserCreateResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserAPI {

    @POST("api-mobile/user/create")
    Call<UserCreateResponse> createUser(@Body UserCreateRequest user);

    @POST("api-mobile/user/login")
    Call<UserLoginResponse> loginUser(@Body UserLoginRequest user);

    @GET("api-mobile/user/get-by-id")
    Call<UserByIdResponse> getUserByID(@Query("id") int id);

    @GET("api/get-channels")
    Call<ChannelResponse> getChannel();
}
