package com.mygeno.test.service;

import com.mygeno.test.pojo.TbUser;

/**
 * @Auther: yt
 * @Date: 2019/2/13
 * @Description: com.mygeno.test.service
 * @version: 1.0
 */
public interface TbUserDubboService {

    /**
      * 功能描述: 根据用户名(用户名或者电话或者邮箱)和密码查询用户
      * @param
      * @return
      * @auther: yt
      * @date: 2019/2/13 11:15
      */
    TbUser selByUser(String username, String password);
}
