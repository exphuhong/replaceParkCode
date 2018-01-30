package com.iFox.mapperDAO;

import com.iFox.entity.ParkUser;
import org.apache.ibatis.annotations.Param;

/**
 * Created by exphuhong on 17-9-13.
 * Start
 */
public interface ParkUserMapper {

    //注册用户
    void addUser(ParkUser parkUser);

    //登录
    ParkUser getUser(@Param("email") String email, @Param("password") String password);

    //判断邮箱是否已经注册
    String getEmail(@Param("email") String email);
}
