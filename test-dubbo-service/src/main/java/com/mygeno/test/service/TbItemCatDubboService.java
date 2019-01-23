package com.mygeno.test.service;

import com.mygeno.test.pojo.TbItemCat;

/**
 * @Auther: yt
 * @Date: 2019/1/22
 * @Description: com.mygeno.test.service
 * @version: 1.0
 */
public interface TbItemCatDubboService {

    /**
     * 功能描述: 根据cid查询类目信息
     * @param cid
     * @return TbItemCat
     * @auther: yt
     * @date: 2019/1/23 13:43
     */
    TbItemCat selById(long id);
}
