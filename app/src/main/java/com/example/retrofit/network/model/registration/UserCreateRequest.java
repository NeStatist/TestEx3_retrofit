package com.example.retrofit.network.model.registration;

import com.google.gson.annotations.SerializedName;

public class UserCreateRequest {

    private String email;
    private String username;
    private String password;

    @SerializedName("device_token")
    private String deviceToken;

    @SerializedName("os_type")
    private String osType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }
}

