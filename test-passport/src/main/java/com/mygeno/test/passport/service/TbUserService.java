package com.mygeno.test.passport.service;

import com.mygeno.test.pojo.MygenoResult;

/**
 * @Auther: yt
 * @Date: 2019/2/13
 * @Description: com.mygeno.test.passport.service
 * @version: 1.0
 */
public interface TbUserService {

    MygenoResult login(String username, String password);
}
