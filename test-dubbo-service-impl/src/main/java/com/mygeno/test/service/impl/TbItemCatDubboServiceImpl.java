package com.mygeno.test.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.mygeno.test.mapper.TbItemCatMapper;
import com.mygeno.test.pojo.TbItemCat;
import com.mygeno.test.pojo.TbItemCatExample;
import com.mygeno.test.pojo.TbItemExample;
import com.mygeno.test.service.TbItemCatDubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: yt
 * @Date: 2019/1/22
 * @Description: com.mygeno.test.service.impl
 * @version: 1.0
 */
@Service
public class TbItemCatDubboServiceImpl implements TbItemCatDubboService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    /**
      * 功能描述: 根据cid查询类目信息
      * @param id
      * @return TbItemCat
      * @auther: yt
      * @date: 2019/1/23 13:43
      */
    public TbItemCat selById(long id) {
        return tbItemCatMapper.selectByPrimaryKey(id);
    }

    /**
     * 功能描述: 根据pid和status查询类目
     * @param pid, status
     * @return
     * @auther: yt
     * @date: 2019/2/12 11:22
     */
    public List<TbItemCat> selByPidAndStatus(long pid, int status) {
        TbItemCatExample example = new TbItemCatExample();
        //排序,用列名不是属性名
        example.setOrderByClause("sort_order asc");
        example.createCriteria().andParentIdEqualTo(pid).andStatusEqualTo(status);
        return tbItemCatMapper.selectByExample(example);
    }
}
