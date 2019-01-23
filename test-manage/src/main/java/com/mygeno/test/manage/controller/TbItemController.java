package com.mygeno.test.manage.controller;

import com.mygeno.test.manage.service.TbItemService;
import com.mygeno.test.pojo.EasyUIDatagrid;
import com.mygeno.test.pojo.MygenoResult;
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

    /**
     * 功能描述: 分页数据展示
     *
     * @param page
     * @return EasyUIDatagrid
     * @Param rows
     * @auther: yt
     * @date: 2019/1/22 13:24
     */
    @RequestMapping("item/list")
    @ResponseBody
    public EasyUIDatagrid showItem(int page, int rows){
        EasyUIDatagrid list = tbItemService.showItem(page, rows);
        return list;
    }

    /**
      * 功能描述: 删除
      * @param ids 用逗号分隔的id的字符串
      * @return 状态
      * @auther: yt
      * @date: 2019/1/23 16:50
      */
    @RequestMapping("rest/item/delete")
    @ResponseBody
    public MygenoResult delete(String ids){
        //商品状态，1-正常，2-下架，3-删除
        return tbItemService.updByIds(ids, (byte) 3);
    }

    /**
      * 功能描述: 下架
      * @param ids 用逗号分隔的id的字符串
      * @return 状态
      * @auther: yt
      * @date: 2019/1/23 17:19
      */
    @RequestMapping("rest/item/instock")
    @ResponseBody
    public MygenoResult instock(String ids){
        //商品状态，1-正常，2-下架，3-删除
        return tbItemService.updByIds(ids, (byte)2);
    }

    /**
      * 功能描述: 上架
      * @param ids 用逗号分隔的id的字符串
      * @return 状态
      * @auther: yt
      * @date: 2019/1/23 17:22
      */
    @RequestMapping("rest/item/reshelf")
    @ResponseBody
    public MygenoResult reshelf(String ids){
        //商品状态，1-正常，2-下架，3-删除
        return tbItemService.updByIds(ids, (byte)1);
    }
}
