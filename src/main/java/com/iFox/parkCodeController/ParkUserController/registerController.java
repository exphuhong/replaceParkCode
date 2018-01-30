package com.iFox.parkCodeController.ParkUserController;

import com.iFox.entity.ParkUser;
import com.iFox.parkCodeService.ParkUserService;
import com.google.gson.Gson;
import com.iFox.utils.EmailUtils;
import com.iFox.utils.vo.CheckCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by exphuhong
 * Date 18-1-29.
 * Start
 */
@Controller
public class registerController {

    private static final String REGEX = "\\w+@\\w+(\\.\\w+)+";
    private static boolean flag = false;
    private static CheckCode code;
    @Resource
    private ParkUserService parkUserService;

    @RequestMapping("register")
    public
    @ResponseBody
    String register(String parkUserJson, String checkCode) throws GeneralSecurityException, MessagingException {
        Gson gson = new Gson();
        ParkUser parkUser = gson.fromJson(parkUserJson, ParkUser.class);
        if (flag) {
            System.out.println(flag);
            if (code.getCode().equals(checkCode) && (code.getExpTime()-new Date().getTime()) > 0) {
                if (parkUserService.addUser(parkUser).equals("200")) { ;
                    return "200";
                } else {
                    System.out.println("服务器异常");
                    return "316";
                }
            } else {
                System.out.println("验证失败");
                return "317";
            }
        } else {
            System.out.println("邮箱没有验证");
            return "318";
        }

    }

    @RequestMapping("checkEmail")
    public
    @ResponseBody
    String checkEmail(String email) throws GeneralSecurityException, MessagingException {
        if (email.matches(REGEX)) {
            if (parkUserService.getEmail(email) .equals("200") ) {
                code = EmailUtils.getRandomCode();
                EmailUtils.sendEmail(email, code.getCode());
                flag = true;
                return "200";
            } else {
                return "316";
            }

        } else {
            return "邮箱格式不正确";
        }
    }
}
