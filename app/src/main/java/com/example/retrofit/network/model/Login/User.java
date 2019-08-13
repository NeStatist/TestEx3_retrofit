package com.example.retrofit.network.model.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("auth_key")
    @Expose
    private String authKey;
    @SerializedName("auth_hash")
    @Expose
    private String authHash;
    @SerializedName("password_hash")
    @Expose
    private String passwordHash;
    @SerializedName("password_reset_token_mobile")
    @Expose
    private Object passwordResetTokenMobile;
    @SerializedName("reset_token_mobile_attempts")
    @Expose
    private Integer resetTokenMobileAttempts;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("new_email")
    @Expose
    private Object newEmail;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("resolution")
    @Expose
    private Integer resolution;
    @SerializedName("resolution_mobile")
    @Expose
    private Integer resolutionMobile;
    @SerializedName("theme")
    @Expose
    private String theme;
    @SerializedName("confirmed_email")
    @Expose
    private Integer confirmedEmail;
    @SerializedName("from_social")
    @Expose
    private Integer fromSocial;
    @SerializedName("social_type")
    @Expose
    private Object socialType;
    @SerializedName("social_id")
    @Expose
    private Object socialId;
    @SerializedName("language")
    @Expose
    private Integer language;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("last_login")
    @Expose
    private Integer lastLogin;
    @SerializedName("partnerId")
    @Expose
    private Object partnerId;
    @SerializedName("currency_id")
    @Expose
    private Object currencyId;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("isReceiveAgree")
    @Expose
    private Integer isReceiveAgree;
    @SerializedName("isUserEU")
    @Expose
    private Integer isUserEU;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getAuthHash() {
        return authHash;
    }

    public void setAuthHash(String authHash) {
        this.authHash = authHash;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Object getPasswordResetTokenMobile() {
        return passwordResetTokenMobile;
    }

    public void setPasswordResetTokenMobile(Object passwordResetTokenMobile) {
        this.passwordResetTokenMobile = passwordResetTokenMobile;
    }

    public Integer getResetTokenMobileAttempts() {
        return resetTokenMobileAttempts;
    }

    public void setResetTokenMobileAttempts(Integer resetTokenMobileAttempts) {
        this.resetTokenMobileAttempts = resetTokenMobileAttempts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(Object newEmail) {
        this.newEmail = newEmail;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public Integer getResolution() {
        return resolution;
    }

    public void setResolution(Integer resolution) {
        this.resolution = resolution;
    }

    public Integer getResolutionMobile() {
        return resolutionMobile;
    }

    public void setResolutionMobile(Integer resolutionMobile) {
        this.resolutionMobile = resolutionMobile;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getConfirmedEmail() {
        return confirmedEmail;
    }

    public void setConfirmedEmail(Integer confirmedEmail) {
        this.confirmedEmail = confirmedEmail;
    }

    public Integer getFromSocial() {
        return fromSocial;
    }

    public void setFromSocial(Integer fromSocial) {
        this.fromSocial = fromSocial;
    }

    public Object getSocialType() {
        return socialType;
    }

    public void setSocialType(Object socialType) {
        this.socialType = socialType;
    }

    public Object getSocialId() {
        return socialId;
    }

    public void setSocialId(Object socialId) {
        this.socialId = socialId;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Integer lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Object getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Object partnerId) {
        this.partnerId = partnerId;
    }

    public Object getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Object currencyId) {
        this.currencyId = currencyId;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Integer getIsReceiveAgree() {
        return isReceiveAgree;
    }

    public void setIsReceiveAgree(Integer isReceiveAgree) {
        this.isReceiveAgree = isReceiveAgree;
    }

    public Integer getIsUserEU() {
        return isUserEU;
    }

    public void setIsUserEU(Integer isUserEU) {
        this.isUserEU = isUserEU;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
