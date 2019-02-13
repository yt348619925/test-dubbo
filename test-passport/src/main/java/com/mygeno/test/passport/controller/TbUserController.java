package com.mygeno.test.passport.controller;

import com.mygeno.test.passport.service.TbUserService;
import com.mygeno.test.pojo.MygenoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: yt
 * @Date: 2019/2/12
 * @Description: com.mygeno.test.passport.controller
 * @version: 1.0
 */
@Controller
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;
    /**
      * 功能描述: 显示登陆页面
      * @param
      * @return
      * @auther: yt
      * @date: 2019/2/13 10:03
      */
    @RequestMapping("user/showLogin")
    public String showLogin() {
        return "login";
    }

    /**
      * 功能描述: 用户登录
      * @param
      * @return
      * @auther: yt
      * @date: 2019/2/13 22:48
      */
    @RequestMapping("user/login")
    @ResponseBody
    public MygenoResult login(String username, String password){
        return tbUserService.login(username, password);
    }
}
