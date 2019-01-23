package com.mygeno.test.manage.service.impl;

import com.mygeno.test.manage.pojo.TbChild;
import com.mygeno.test.manage.service.TbItemService;
import com.mygeno.test.pojo.EasyUIDatagrid;
import com.mygeno.test.pojo.TbItem;
import com.mygeno.test.pojo.TbItemCat;
import com.mygeno.test.service.TbItemCatDubboService;
import com.mygeno.test.service.TbItemDubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private TbItemCatDubboService tbItemCatDubboService;

    public EasyUIDatagrid showItem(int page, int rows) {
        EasyUIDatagrid list = tbItemDubboService.selByPage(page, rows);
        List<TbItem> listRows = (List<TbItem>) list.getRows();
        List<TbChild> childList = new ArrayList<TbChild>();
        for (TbItem listFor:
             listRows) {
            TbChild child = new TbChild();
            BeanUtils.copyProperties(listFor, child);
            TbItemCat tbItemCat = tbItemCatDubboService.selById(listFor.getCid());
            child.setCname(tbItemCat.getName());
            childList.add(child);
        }
        list.setRows(childList);
        return list;
    }
}
