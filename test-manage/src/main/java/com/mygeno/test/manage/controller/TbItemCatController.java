package com.mygeno.test.manage.controller;

import com.mygeno.test.manage.service.TbItemCatService;
import com.mygeno.test.pojo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: yt
 * @Date: 2019/2/12
 * @Description: com.mygeno.test.manage.controller
 * @version: 1.0
 */
@Controller
public class TbItemCatController {

    @Autowired
    private TbItemCatService tbItemCatService;

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITree> showItemCat(@RequestParam(defaultValue = "0") long id){
        return tbItemCatService.showItemCat(id);
    }
}
