package com.mygeno.test.manage.service;

import com.mygeno.test.pojo.EasyUITree;
import com.mygeno.test.pojo.EasyUITree;

import java.util.List;

/**
 * @Auther: yt
 * @Date: 2019/2/12
 * @Description: com.mygeno.test.manage.service
 * @version: 1.0
 */
public interface TbItemCatService {

    /**
     * 功能描述: 查询商品类目
     * @return
     * @auther: yt
     * @dae: 2019/2/12 11:22
     */
    List<EasyUITree> showItemCat(long id);
}
