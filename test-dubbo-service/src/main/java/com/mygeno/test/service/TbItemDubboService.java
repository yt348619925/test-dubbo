package com.mygeno.test.service;

import com.mygeno.test.pojo.EasyUIDatagrid;

/**
 * @Auther: yt
 * @Date: 2019/1/22
 * @Description: com.mygeno.test.service
 * @version: 1.0
 */
public interface TbItemDubboService {

    EasyUIDatagrid selByPage(int page, int rows);
}
