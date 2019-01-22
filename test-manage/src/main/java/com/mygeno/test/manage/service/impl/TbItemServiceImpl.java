package com.mygeno.test.manage.service.impl;

import com.mygeno.test.manage.service.TbItemService;
import com.mygeno.test.pojo.EasyUIDatagrid;
import com.mygeno.test.service.TbItemDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: yt
 * @Date: 2019/1/22
 * @Description: com.mygeno.test.manage.service.impl
 * @version: 1.0
 */
@Service
public class TbItemServiceImpl implements TbItemService {

    @Autowired
    private TbItemDubboService tbItemDubboService;

    public EasyUIDatagrid showItem(int page, int rows) {
        return tbItemDubboService.selByPage(page, rows);
    }
}
