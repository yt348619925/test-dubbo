package com.mygeno.test.service;

import com.mygeno.test.pojo.TbItemCat;

import java.util.List;

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

    /**
      * 功能描述: 根据pid和status查询类目
      * @param long pid, int status
      * @return
      * @auther: yt
      * @date: 2019/2/12 11:22
      */
    List<TbItemCat> selByPidAndStatus(long pid, int status);
}
