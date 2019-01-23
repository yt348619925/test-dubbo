package com.mygeno.test.manage.service.impl;

import com.mygeno.test.manage.pojo.TbChild;
import com.mygeno.test.manage.service.TbItemService;
import com.mygeno.test.pojo.EasyUIDatagrid;
import com.mygeno.test.pojo.MygenoResult;
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

    /**
     * 功能描述: 分页数据展示
     *
     * @param page
     * @return EasyUIDatagrid
     * @Param rows
     * @auther: yt
     * @date: 2019/1/22 13:24
     */
    public EasyUIDatagrid showItem(int page, int rows) {
        EasyUIDatagrid list = tbItemDubboService.selByPage(page, rows);
        List<TbItem> listRows = (List<TbItem>) list.getRows();
        List<TbChild> childList = new ArrayList<TbChild>();
        for (TbItem listFor :
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

    /**
     * 功能描述: 修改商品状态
     *
     * @param ids    需要修改的商品的Id;
     * @param status 需要修改的状态;
     * @return 0为失败;1为成功
     * @auther: yt
     * @date: 2019/1/23 15:31
     */
    public MygenoResult updByIds(String ids, Byte status) {
        String[] idSplit = ids.split(",");
        long[] idLong = new long[idSplit.length];
        for (int i = 0; i < idSplit.length; i++) {
            idLong[i] = Long.parseLong(idSplit[i]);
        }
        int index = tbItemDubboService.updByIds(idLong, status);
        MygenoResult result = new MygenoResult();
        if (index == 0) {
            result.setMsg("修改失败");
        } else {
            result.setStatus(200);
        }
        return result;
    }
}
