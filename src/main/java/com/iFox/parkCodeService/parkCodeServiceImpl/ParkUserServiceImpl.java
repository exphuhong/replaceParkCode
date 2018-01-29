package com.iFox.parkCodeService.parkCodeServiceImpl;

import com.iFox.entity.ParkUser;
import com.iFox.mapperDAO.ParkUserMapper;
import com.iFox.parkCodeService.ParkUserService;
import com.iFox.utils.EmailUtils;
import com.iFox.utils.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by exphuhong
 * Date 18-1-29.
 * Start
 */
@Service
public class ParkUserServiceImpl implements ParkUserService {

    @Resource
    private ParkUserMapper parkUserMapper;

    @Override
    public String addUser(ParkUser parkUser) {
        long pwdLength = parkUser.getPassword().length();
        if (pwdLength > 6 && pwdLength < 16) {
            String password = parkUser.getPassword();
            parkUser.setPassword(MD5Utils.md5Message(password));
            String userCode = EmailUtils.getRandomCode();
            parkUser.setUserName("用户" + userCode);
            parkUser.setSchool("学校" + userCode);
            parkUserMapper.addUser(parkUser);
            if (parkUser.getUserId() != null) {
                return "200";
            }
        }
        return "316";
    }

    @Override
    public ParkUser getUser(String email, String password) {
        password = MD5Utils.md5Message(password);
        return parkUserMapper.getUser(email, password);
    }
}
