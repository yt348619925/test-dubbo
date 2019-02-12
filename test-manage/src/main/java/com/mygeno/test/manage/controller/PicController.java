package com.mygeno.test.manage.controller;

import com.mygeno.test.manage.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: yt
 * @Date: 2019/2/12
 * @Description: com.mygeno.test.manage.controller
 * @version: 1.0
 */
@Controller
public class PicController {

    @Autowired
    private PicService picService;
    /**
      * 功能描述:图片上传
      * @param
      * @return
      * @auther: yt
      * @date: 2019/2/12 16:39
      */
    @RequestMapping("/pic/upload")
    @ResponseBody
    public Map<String, Object> upload(MultipartFile uploadFile){
        Map<String, Object> map = picService.upload(uploadFile);
        return map;
    }
}
