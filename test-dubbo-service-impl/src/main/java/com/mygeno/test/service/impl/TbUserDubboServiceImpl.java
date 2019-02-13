package com.mygeno.test.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.mygeno.test.mapper.TbUserMapper;
import com.mygeno.test.pojo.TbUser;
import com.mygeno.test.pojo.TbUserExample;
import com.mygeno.test.service.TbUserDubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: yt
 * @Date: 2019/2/13
 * @Description: com.mygeno.test.service.impl
 * @version: 1.0
 */
@Service
public class TbUserDubboServiceImpl implements TbUserDubboService {

    @Autowired
    private TbUserMapper tbUserMapper;

    /**
     * 功能描述: 根据用户名(用户名或者电话或者邮箱)和密码查询用户
     *
     * @param
     * @return
     * @auther: yt
     * @date: 2019/2/13 11:15
     */
    public TbUser selByUser(String username, String password) {
        TbUserExample example = new TbUserExample();
        example.or().andUsernameEqualTo(username).andPasswordEqualTo(password);
        example.or().andPhoneEqualTo(username).andPasswordEqualTo(password);
        example.or().andEmailEqualTo(username).andPasswordEqualTo(password);
        List<TbUser> list = tbUserMapper.selectByExample(example);
        if(list != null && list.size() != 0){
            return list.get(0);
        }
        return null;
    }
}
