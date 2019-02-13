package com.mygeno.test.passport.service.impl;

import com.mygeno.test.passport.service.TbUserService;
import com.mygeno.test.pojo.MygenoResult;
import com.mygeno.test.pojo.TbUser;
import com.mygeno.test.service.TbUserDubboService;
import com.mygeno.test.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: yt
 * @Date: 2019/2/13
 * @Description: com.mygeno.test.passport.service.impl
 * @version: 1.0
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDubboService tbUserDubboService;

    public MygenoResult login(String username, String password) {
        password = Md5Utils.md5(password);
        TbUser tbUser = tbUserDubboService.selByUser(username, password);

        MygenoResult result = new MygenoResult();
        if(tbUser != null){
            result.setStatus(200);
            return result;
        }else{
            result.setMsg("用户名或密码错误");
            return result;
        }
    }
}
