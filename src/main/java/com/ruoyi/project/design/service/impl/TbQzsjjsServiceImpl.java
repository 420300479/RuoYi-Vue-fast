package com.ruoyi.project.design.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.design.mapper.TbQzsjjsMapper;
import com.ruoyi.project.design.domain.TbQzsjjs;
import com.ruoyi.project.design.service.ITbQzsjjsService;

/**
 * 计算Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-15
 */
@Service
public class TbQzsjjsServiceImpl implements ITbQzsjjsService 
{
    @Autowired
    private TbQzsjjsMapper tbQzsjjsMapper;

    /**
     * 查询计算
     * 
     * @param prId 计算主键
     * @return 计算
     */
    @Override
    public TbQzsjjs selectTbQzsjjsByPrId(Long prId)
    {
        return tbQzsjjsMapper.selectTbQzsjjsByPrId(prId);
    }

    /**
     * 查询计算列表
     * 
     * @param tbQzsjjs 计算
     * @return 计算
     */
    @Override
    public List<TbQzsjjs> selectTbQzsjjsList(TbQzsjjs tbQzsjjs)
    {
        return tbQzsjjsMapper.selectTbQzsjjsList(tbQzsjjs);
    }
}
