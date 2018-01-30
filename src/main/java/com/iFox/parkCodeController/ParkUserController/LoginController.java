package com.iFox.parkCodeController.ParkUserController;

import com.iFox.entity.ParkUser;
import com.iFox.parkCodeService.ParkUserService;
import com.iFox.utils.RedisUtils;
import com.iFox.utils.vo.LoginJson;
import com.iFox.utils.vo.TokenModel;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Created by exphuhong
 * Date 18-1-29.
 * Start
 */
@Controller
public class LoginController {

    private static final long EXP_DATE = 60 * 60 * 24 * 30 ;
    private static Gson gson = new Gson();
    @Resource
    private ParkUserService parkUserService;

    @RequestMapping("login")
    public
    @ResponseBody
    String getUser(String email, String password) {
        ParkUser parkUser = parkUserService.getUser(email, password);
        if (parkUser != null) {
            UUID uuid = UUID.randomUUID();
            Long createTime = new Date().getTime();
            Long expTime = createTime + EXP_DATE;
            TokenModel tokenModel = new TokenModel(email, createTime, expTime, uuid);
            RedisUtils.addToken(tokenModel);

            //添加token后将登录对象以及token返回给客户端

            LoginJson loginJson = new LoginJson(parkUser, tokenModel);
            return gson.toJson(loginJson);
        }
        return "316";
    }

    @RequestMapping("logout")
    public
    @ResponseBody
    String logout(String tokenModel) {
        TokenModel deleteTokenModel = gson.fromJson(tokenModel, TokenModel.class);
        RedisUtils.deleteToken(deleteTokenModel);
        return "200";
    }

}
