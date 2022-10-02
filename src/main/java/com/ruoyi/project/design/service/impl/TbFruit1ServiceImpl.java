package com.ruoyi.project.design.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.design.mapper.TbFruit1Mapper;
import com.ruoyi.project.design.domain.TbFruit1;
import com.ruoyi.project.design.service.ITbFruit1Service;

/**
 * 钢制菠萝Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
@Service
public class TbFruit1ServiceImpl implements ITbFruit1Service 
{
    @Autowired
    private TbFruit1Mapper tbFruit1Mapper;

    /**
     * 查询钢制菠萝
     * 
     * @param frid 钢制菠萝主键
     * @return 钢制菠萝
     */
    @Override
    public TbFruit1 selectTbFruit1ByFrid(Long frid)
    {
        return tbFruit1Mapper.selectTbFruit1ByFrid(frid);
    }

    /**
     * 查询钢制菠萝列表
     * 
     * @param tbFruit1 钢制菠萝
     * @return 钢制菠萝
     */
    @Override
    public List<TbFruit1> selectTbFruit1List(TbFruit1 tbFruit1)
    {
        return tbFruit1Mapper.selectTbFruit1List(tbFruit1);
    }

    /**
     * 新增钢制菠萝
     * 
     * @param tbFruit1 钢制菠萝
     * @return 结果
     */
    @Override
    public int insertTbFruit1(TbFruit1 tbFruit1)
    {
        return tbFruit1Mapper.insertTbFruit1(tbFruit1);
    }

    /**
     * 修改钢制菠萝
     * 
     * @param tbFruit1 钢制菠萝
     * @return 结果
     */
    @Override
    public int updateTbFruit1(TbFruit1 tbFruit1)
    {
        return tbFruit1Mapper.updateTbFruit1(tbFruit1);
    }

    /**
     * 批量删除钢制菠萝
     * 
     * @param frids 需要删除的钢制菠萝主键
     * @return 结果
     */
    @Override
    public int deleteTbFruit1ByFrids(Long[] frids)
    {
        return tbFruit1Mapper.deleteTbFruit1ByFrids(frids);
    }

    /**
     * 删除钢制菠萝信息
     * 
     * @param frid 钢制菠萝主键
     * @return 结果
     */
    @Override
    public int deleteTbFruit1ByFrid(Long frid)
    {
        return tbFruit1Mapper.deleteTbFruit1ByFrid(frid);
    }

    @Override
    public List<TbFruit1> selectTbFruit1ListQuery(Long[] ids1) {
        return tbFruit1Mapper.selectTbFruit1ListQuery(ids1);
    }
}
