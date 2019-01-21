package com.mygeno.test.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: yt
 * @Date: 2019/1/21
 * @Description: com.mygeno.test.manage.controller
 * @version: 1.0
 */
@Controller
public class PageController {

    /**
      * 功能描述: 登陆展示欢迎页
      * @param: void
      * @return: index.jsp
      * @auther: yt
      * @date:  2019.01.21
      */
    @RequestMapping("/")
    public String welcome(){
        return "index";
    }

    /**
      * 功能描述: 页面跳转,因为页面名字和功能名字相同,所以用restfor风格
      * @param: {page}
      * @return: page
      * @auther: yt
      * @date:  2019.01.21
      */
    @RequestMapping("{page}")
    public String showPage(@PathVariable String page ){
        return page;
    }

}
