package com.iFox.parkCodeController.ParkUserController;

import com.iFox.entity.ParkUser;
import com.iFox.parkCodeService.ParkUserService;
import com.google.gson.Gson;
import com.iFox.utils.EmailUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

/**
 * Created by exphuhong
 * Date 18-1-29.
 * Start
 */
@Controller
public class registerController {


    private static final String REGEX = "\\w+@\\w+(\\.\\w+)+";
    private static boolean flag = false;
    private static String code = null;
    @Resource
    private ParkUserService parkUserService;

    @RequestMapping("register")
    public
    @ResponseBody
    String register(String parkUserJson, String checkCode) throws GeneralSecurityException, MessagingException {
        Gson gson = new Gson();
        ParkUser parkUser = gson.fromJson(parkUserJson, ParkUser.class);
        if (flag) {
            if (checkCode.equals(code)) {
                if (parkUserService.addUser(parkUser).equals("200")) {
                    return "注册成功";
                } else {
                    return "服务器异常注册失败";
                }
            } else {
                return "验证码不正确";
            }
        } else {
            return "邮箱没有验证";
        }

    }

    @RequestMapping("checkEmail")
    public
    @ResponseBody
    String checkEmail(String email) throws GeneralSecurityException, MessagingException {
        if (email.matches(REGEX)) {
            code = EmailUtils.getRandomCode();
            EmailUtils.sendEmail(email, code);
            flag = true;
            return "验证码已发送";
        } else {
            return "邮箱格式不正确";
        }
    }
}
