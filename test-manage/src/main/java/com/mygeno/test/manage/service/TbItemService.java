package com.mygeno.test.manage.service;

import com.mygeno.test.pojo.EasyUIDatagrid;
import com.mygeno.test.pojo.MygenoResult;
import com.mygeno.test.pojo.TbItem;

/**
 * @Auther: yt
 * @Date: 2019/1/22
 * @Description: com.mygeno.test.manage.service
 * @version: 1.0
 */
public interface TbItemService {

    /**
     * 功能描述: 分页数据展示
     *
     * @param page
     * @return EasyUIDatagrid
     * @Param rows
     * @auther: yt
     * @date: 2019/1/22 13:24
     */
    EasyUIDatagrid showItem(int page, int rows);

    /**
     * 功能描述:
     *
     * @param ids    需要修改的商品的Id;
     * @param status 需要修改的状态;
     * @return 0为失败;1为成功
     * @auther: yt
     * @date: 2019/1/23 15:31
     */
    MygenoResult updByIds(String ids, Byte status);

    /**
     * 功能描述: 新增商品,商品描述
     * @param
     * @return
     * @auther: yt
     * @date: 2019/2/23 17:02
     */
    MygenoResult insItem(TbItem tbItem, String desc);
}
