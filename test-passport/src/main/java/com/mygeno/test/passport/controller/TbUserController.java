package com.mygeno.test.passport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: yt
 * @Date: 2019/2/12
 * @Description: com.mygeno.test.passport.controller
 * @version: 1.0
 */
@Controller
public class TbUserController {

    @RequestMapping("user/showLogin")
    public String showLogin(){
        return "login";
    }
}
