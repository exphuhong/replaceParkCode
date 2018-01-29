package com.iFox.parkCodeController.ParkUserController;

import com.iFox.entity.ParkUser;
import com.iFox.parkCodeService.ParkUserService;
import com.iFox.utils.vo.LoginJson;
import com.iFox.utils.vo.TokenModel;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
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

    private static final long EXP_DATE = 60 * 60 * 24 * 30;

    @Resource
    private ParkUserService parkUserService;
    @RequestMapping("login")
    public
    @ResponseBody
    String getUser(String email,String password) {
        ParkUser parkUser = parkUserService.getUser(email, password);
        if (parkUser != null) {
            Gson gson = new Gson();
            String tokenName = email;
            UUID uuid = UUID.randomUUID();
            Long createTime = new Date().getTime();
            Long expTime = createTime + EXP_DATE;
            TokenModel tokenModel = new TokenModel(tokenName, createTime, expTime, uuid);
            LoginJson loginJson = new LoginJson(email, password,tokenModel);
            return gson.toJson(loginJson);
        }
        return null;
    }
}
