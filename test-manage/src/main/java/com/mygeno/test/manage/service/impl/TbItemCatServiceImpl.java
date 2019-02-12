package com.mygeno.test.manage.service.impl;

import com.mygeno.test.manage.service.TbItemCatService;
import com.mygeno.test.pojo.EasyUITree;
import com.mygeno.test.pojo.TbItemCat;
import com.mygeno.test.service.TbItemCatDubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yt
 * @Date: 2019/2/12
 * @Description: com.mygeno.test.manage.service.impl
 * @version: 1.0
 */
@Service
public class TbItemCatServiceImpl implements TbItemCatService {

    @Autowired
    private TbItemCatDubboService tbItemCatDubboService;

    /**
     * 功能描述: 查询商品类目
     *
     * @return
     * @auther: yt
     * @date: 2019/2/12 11:22
     */
    public List<EasyUITree> showItemCat(long id) {
        //调用dubbo方法
        List<TbItemCat> list = tbItemCatDubboService.selByPidAndStatus(id, 1);

        //拼装返回值
        List<EasyUITree> treeList = new ArrayList<EasyUITree>();
        for (TbItemCat tbItemCat : list) {
            EasyUITree tree = new EasyUITree();
            tree.setId(tbItemCat.getId());
            tree.setState(tbItemCat.getIsParent()?"closed":"open");
            tree.setText(tbItemCat.getName());
            treeList.add(tree);
        }
        return treeList;
    }
}
