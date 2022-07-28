package com.ruoyi.project.design.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.design.mapper.TbFruit4Mapper;
import com.ruoyi.project.design.domain.TbFruit4;
import com.ruoyi.project.design.service.ITbFruit4Service;

/**
 * 混合金白果Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
@Service
public class TbFruit4ServiceImpl implements ITbFruit4Service 
{
    @Autowired
    private TbFruit4Mapper tbFruit4Mapper;

    /**
     * 查询混合金白果
     * 
     * @param frid 混合金白果主键
     * @return 混合金白果
     */
    @Override
    public TbFruit4 selectTbFruit4ByFrid(Long frid)
    {
        return tbFruit4Mapper.selectTbFruit4ByFrid(frid);
    }

    /**
     * 查询混合金白果列表
     * 
     * @param tbFruit4 混合金白果
     * @return 混合金白果
     */
    @Override
    public List<TbFruit4> selectTbFruit4List(TbFruit4 tbFruit4)
    {
        return tbFruit4Mapper.selectTbFruit4List(tbFruit4);
    }

    /**
     * 新增混合金白果
     * 
     * @param tbFruit4 混合金白果
     * @return 结果
     */
    @Override
    public int insertTbFruit4(TbFruit4 tbFruit4)
    {
        return tbFruit4Mapper.insertTbFruit4(tbFruit4);
    }

    /**
     * 修改混合金白果
     * 
     * @param tbFruit4 混合金白果
     * @return 结果
     */
    @Override
    public int updateTbFruit4(TbFruit4 tbFruit4)
    {
        return tbFruit4Mapper.updateTbFruit4(tbFruit4);
    }

    /**
     * 批量删除混合金白果
     * 
     * @param frids 需要删除的混合金白果主键
     * @return 结果
     */
    @Override
    public int deleteTbFruit4ByFrids(Long[] frids)
    {
        return tbFruit4Mapper.deleteTbFruit4ByFrids(frids);
    }

    /**
     * 删除混合金白果信息
     * 
     * @param frid 混合金白果主键
     * @return 结果
     */
    @Override
    public int deleteTbFruit4ByFrid(Long frid)
    {
        return tbFruit4Mapper.deleteTbFruit4ByFrid(frid);
    }
}
