package com.iFox.utils.vo;

import com.iFox.entity.ParkUser;

/**
 * Created by exphuhong
 * Date 18-1-29.
 * Start
 */
public class LoginJson {
    private ParkUser parkUser;
    private TokenModel tokenModel;

    public LoginJson() {
    }

    public LoginJson(ParkUser parkUser, TokenModel tokenModel) {
        this.parkUser = parkUser;
        this.tokenModel = tokenModel;
    }

    public ParkUser getParkUser() {
        return parkUser;
    }

    public void setParkUser(ParkUser parkUser) {
        this.parkUser = parkUser;
    }

    public TokenModel getTokenModel() {
        return tokenModel;
    }

    public void setTokenModel(TokenModel tokenModel) {
        this.tokenModel = tokenModel;
    }
}
