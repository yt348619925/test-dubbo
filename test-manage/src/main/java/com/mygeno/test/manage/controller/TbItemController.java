package com.mygeno.test.manage.controller;

import com.mygeno.test.manage.service.TbItemService;
import com.mygeno.test.pojo.EasyUIDatagrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: yt
 * @Date: 2019/1/22
 * @Description: com.mygeno.test.manage.controller
 * @version: 1.0
 */
@Controller
public class TbItemController {

    @Autowired
    private TbItemService tbItemService;

    @RequestMapping("item/list")
    @ResponseBody
    public EasyUIDatagrid showItem(int page, int rows){
        EasyUIDatagrid list = tbItemService.showItem(page, rows);
        return list;
    }
}
