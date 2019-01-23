package com.mygeno.test.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.mygeno.test.mapper.TbItemCatMapper;
import com.mygeno.test.pojo.TbItemCat;
import com.mygeno.test.service.TbItemCatDubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: yt
 * @Date: 2019/1/22
 * @Description: com.mygeno.test.service.impl
 * @version: 1.0
 */
@Service
public class TbItemCatDubboServiceImpl implements TbItemCatDubboService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    /**
      * 功能描述: 根据cid查询类目信息
      * @param cid
      * @return TbItemCat
      * @auther: yt
      * @date: 2019/1/23 13:43
      */
    public TbItemCat selById(long id) {
        return tbItemCatMapper.selectByPrimaryKey(id);
    }
}
