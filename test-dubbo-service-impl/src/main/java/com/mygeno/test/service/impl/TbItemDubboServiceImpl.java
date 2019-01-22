package com.mygeno.test.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mygeno.test.mapper.TbItemMapper;
import com.mygeno.test.pojo.EasyUIDatagrid;
import com.mygeno.test.pojo.TbItem;
import com.mygeno.test.pojo.TbItemExample;
import com.mygeno.test.service.TbItemDubboService;
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

    /**
     * 功能描述: 分页数据展示
     *
     * @param page
     * @return
     * @Param rows
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
}
