package com.mygeno.test.manage.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Auther: yt
 * @Date: 2019/2/12
 * @Description: com.mygeno.test.manage.service
 * @version: 1.0
 */
public interface PicService {

    Map<String, Object> upload(MultipartFile uploadFile);
}
