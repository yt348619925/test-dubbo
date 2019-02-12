package com.mygeno.test.manage.service.impl;

import com.mygeno.test.manage.service.PicService;
import com.mygeno.test.utils.FtpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: yt
 * @Date: 2019/2/12
 * @Description: com.mygeno.test.manage.service.impl
 * @version: 1.0
 */
@Service
public class PicServiceImpl implements PicService {

    private String host = "192.168.33.13";

    private int port = 21;

    private String username = "ftpuser";

    private String password = "123456";

    private String basePath = "/home/ftpuser";

    private String filePath = "/";

    public Map<String, Object> upload(MultipartFile uploadFile) {
        Map<String, Object> map = new HashMap<String, Object>();
        String oldName = uploadFile.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        boolean result = false;
        try {
            result = FtpUtil.uploadFile(host, port, username, password, basePath, filePath, fileName, uploadFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if( result){
                map.put("error", 0);
                map.put("url", "http://" + host + ":80/" + filePath + fileName);
            }else{
                map.put("error", 1);
                map.put("msg", "上传失败");
            }
        }
        return map;
    }
}
