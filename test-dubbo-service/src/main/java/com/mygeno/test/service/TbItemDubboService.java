package com.mygeno.test.service;

import com.mygeno.test.pojo.EasyUIDatagrid;
import com.mygeno.test.pojo.TbItem;
import com.mygeno.test.pojo.TbItemDesc;

/**
 * @Auther: yt
 * @Date: 2019/1/22
 * @Description: com.mygeno.test.service
 * @version: 1.0
 */
public interface TbItemDubboService {

    /**
     * 功能描述: 分页数据展示
     * @param page
     * @Param rows
     * @return EasyUIDatagrid
     * @auther: yt
     * @date: 2019/1/22 13:24
     */
    EasyUIDatagrid selByPage(int page, int rows);

    /**
      * 功能描述:
      * @param ids 需要修改的商品的Id;
      * @param status 需要修改的状态;
      * @return 0为失败;1为成功
      * @auther: yt
      * @date: 2019/1/23 15:31
      */
    int updByIds(long[] ids, Byte status);

    /**
      * 功能描述: 新增商品,商品描述
      * @param
      * @return
      * @auther: yt
      * @date: 2019/2/23 17:02
      */
    int insItem(TbItem tbItem, TbItemDesc desc);
}
