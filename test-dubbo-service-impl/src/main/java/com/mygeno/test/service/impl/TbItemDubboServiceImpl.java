package com.mygeno.test.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mygeno.test.mapper.TbItemDescMapper;
import com.mygeno.test.mapper.TbItemMapper;
import com.mygeno.test.pojo.EasyUIDatagrid;
import com.mygeno.test.pojo.TbItem;
import com.mygeno.test.pojo.TbItemDesc;
import com.mygeno.test.pojo.TbItemExample;
import com.mygeno.test.service.TbItemDubboService;
import com.mygeno.test.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: yt
 * @Date: 2019/1/22
 * @Description: com.mygeno.test.service.impl
 * @version: 1.0
 */
@Service
public class TbItemDubboServiceImpl implements TbItemDubboService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    /**
     * 功能描述: 分页数据展示
     * @param page
     * @Param rows
     * @return EasyUIDatagrid
     * @auther: yt
     * @date: 2019/1/22 13:24
     */
    public EasyUIDatagrid selByPage(int page, int rows) {
        //selectByExample 方法参数为new Example时,则where语句后面什么都不跟,即查询所有
        List<TbItem> list = tbItemMapper.selectByExample(new TbItemExample());

        //分页工具,将page和rows传进去,就可以得到所有的需要的数据
        PageHelper.startPage(page, rows);

        //分页工具将sql语句后面加上limit
        PageInfo<TbItem> info = new PageInfo<TbItem>(list);

        //创建返回参数对象
        EasyUIDatagrid grid = new EasyUIDatagrid();

        //注入数据
        grid.setRows(info.getList());
        grid.setTotal(info.getTotal());
        return grid;
    }

    /**
     * 功能描述:
     * @param ids 需要修改的商品的Id;
     * @param status 需要修改的状态;
     * @return 0为失败;1为成功
     * @auther: yt
     * @date: 2019/1/23 15:31
     */
    public int updByIds(long[] ids, Byte status) {
        int index = 0;
        for (int i = 0;i<ids.length;i++) {
            TbItem tbItem = new TbItem();
            tbItem.setId(ids[i]);
            tbItem.setStatus(status);

            //根据id修改状态值
            index += tbItemMapper.updateByPrimaryKeySelective(tbItem);
        }
        if(index == ids.length){
            return 1;
        }
        return 0;
    }

    /**
     * 功能描述: 新增商品,商品描述
     * @param
     * @return
     * @auther: yt
     * @date: 2019/2/23 17:02
     */
    public int insItem(TbItem tbItem, TbItemDesc desc) {
        //自己创建ID,可减少高并发下的id取值错误问题
        long id = IDUtils.genItemId();
        tbItem.setId(id);
        int index = tbItemMapper.insert(tbItem);
        desc.setItemId(id);
        index += tbItemDescMapper.insert(desc);
        if(index == 2){
            return 1;
        }
        return 0;
    }
}
