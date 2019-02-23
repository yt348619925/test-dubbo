package com.mygeno.test.passport.controller;

import com.mygeno.test.passport.service.TbUserService;
import com.mygeno.test.pojo.Jwt;
import com.mygeno.test.pojo.MygenoResult;
import com.mygeno.test.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

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
    public String showLogin(@RequestHeader(value="Accept-Language") String referer, Model model) {
        System.out.println(referer);
//        if(referer != null && !"".equals(referer)){
//            model.addAttribute("redirect", referer);
//        }
        return "login";
    }

    /**
      * 功能描述: 用户登录,返回token
      * @param
      * @return
      * @auther: yt
      * @date: 2019/2/13 22:48
      */
    @RequestMapping("user/login")
    @ResponseBody
    public MygenoResult login(String username, String password){

        Jwt jwt = new Jwt();
        jwt.setTtlMillis(1000 * 60 * 60);//一个小时
        jwt.setIss("YearT");
        jwt.setSub("Mygeno");
        jwt.setIat(new Date(System.currentTimeMillis()));
        jwt.setAud("admin");

        String token = JwtUtils.createJwt(jwt);


        MygenoResult result = tbUserService.login(username, password);
        result.setMsg(token);
        return result;
    }
}
