package com.iFox.parkCodeService;

import com.iFox.entity.ParkUser;

/**
 * Created by exphuhong
 * Date 18-1-29.
 * Start
 */
public interface ParkUserService {

    String addUser(ParkUser parkUser);

    ParkUser getUser(String email, String password);
}
