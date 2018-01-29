package com.iFox.utils.vo;

/**
 * Created by exphuhong
 * Date 18-1-29.
 * Start
 */
public class LoginJson {
    private String email;
    private String password;
    private TokenModel tokenModel;

    public LoginJson(String email, String password, TokenModel tokenModel) {
        this.email = email;
        this.password = password;
        this.tokenModel = tokenModel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TokenModel getTokenModel() {
        return tokenModel;
    }

    public void setTokenModel(TokenModel tokenModel) {
        this.tokenModel = tokenModel;
    }
}
