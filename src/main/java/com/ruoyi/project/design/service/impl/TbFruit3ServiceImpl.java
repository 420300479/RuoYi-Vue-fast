package com.ruoyi.project.design.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.design.mapper.TbFruit3Mapper;
import com.ruoyi.project.design.domain.TbFruit3;
import com.ruoyi.project.design.service.ITbFruit3Service;

/**
 * 铝合金芒果Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
@Service
public class TbFruit3ServiceImpl implements ITbFruit3Service 
{
    @Autowired
    private TbFruit3Mapper tbFruit3Mapper;

    /**
     * 查询铝合金芒果
     * 
     * @param frid 铝合金芒果主键
     * @return 铝合金芒果
     */
    @Override
    public TbFruit3 selectTbFruit3ByFrid(Long frid)
    {
        return tbFruit3Mapper.selectTbFruit3ByFrid(frid);
    }

    /**
     * 查询铝合金芒果列表
     * 
     * @param tbFruit3 铝合金芒果
     * @return 铝合金芒果
     */
    @Override
    public List<TbFruit3> selectTbFruit3List(TbFruit3 tbFruit3)
    {
        return tbFruit3Mapper.selectTbFruit3List(tbFruit3);
    }

    /**
     * 新增铝合金芒果
     * 
     * @param tbFruit3 铝合金芒果
     * @return 结果
     */
    @Override
    public int insertTbFruit3(TbFruit3 tbFruit3)
    {
        return tbFruit3Mapper.insertTbFruit3(tbFruit3);
    }

    /**
     * 修改铝合金芒果
     * 
     * @param tbFruit3 铝合金芒果
     * @return 结果
     */
    @Override
    public int updateTbFruit3(TbFruit3 tbFruit3)
    {
        return tbFruit3Mapper.updateTbFruit3(tbFruit3);
    }

    /**
     * 批量删除铝合金芒果
     * 
     * @param frids 需要删除的铝合金芒果主键
     * @return 结果
     */
    @Override
    public int deleteTbFruit3ByFrids(Long[] frids)
    {
        return tbFruit3Mapper.deleteTbFruit3ByFrids(frids);
    }

    /**
     * 删除铝合金芒果信息
     * 
     * @param frid 铝合金芒果主键
     * @return 结果
     */
    @Override
    public int deleteTbFruit3ByFrid(Long frid)
    {
        return tbFruit3Mapper.deleteTbFruit3ByFrid(frid);
    }
}
