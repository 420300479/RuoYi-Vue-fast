package com.ruoyi.project.design.service;

import java.util.List;
import com.ruoyi.project.design.domain.TbQzsjjs;

/**
 * 计算Service接口
 * 
 * @author ruoyi
 * @date 2022-09-15
 */
public interface ITbQzsjjsService 
{
    /**
     * 查询计算
     * 
     * @param prId 计算主键
     * @return 计算
     */
    public TbQzsjjs selectTbQzsjjsByPrId(Long prId);

    /**
     * 查询计算列表
     * 
     * @param tbQzsjjs 计算
     * @return 计算集合
     */
    public List<TbQzsjjs> selectTbQzsjjsList(TbQzsjjs tbQzsjjs);

    /**
     * 新增计算
     * 
     * @param tbQzsjjs 计算
     * @return 结果
     */
 }
