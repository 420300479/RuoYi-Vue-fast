package com.ruoyi.project.design.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.design.mapper.TbFruit2Mapper;
import com.ruoyi.project.design.domain.TbFruit2;
import com.ruoyi.project.design.service.ITbFruit2Service;

/**
 * 铸铁西瓜Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
@Service
public class TbFruit2ServiceImpl implements ITbFruit2Service 
{
    @Autowired
    private TbFruit2Mapper tbFruit2Mapper;

    /**
     * 查询铸铁西瓜
     * 
     * @param frid 铸铁西瓜主键
     * @return 铸铁西瓜
     */
    @Override
    public TbFruit2 selectTbFruit2ByFrid(Long frid)
    {
        return tbFruit2Mapper.selectTbFruit2ByFrid(frid);
    }

    /**
     * 查询铸铁西瓜列表
     * 
     * @param tbFruit2 铸铁西瓜
     * @return 铸铁西瓜
     */
    @Override
    public List<TbFruit2> selectTbFruit2List(TbFruit2 tbFruit2)
    {
        return tbFruit2Mapper.selectTbFruit2List(tbFruit2);
    }

    /**
     * 新增铸铁西瓜
     * 
     * @param tbFruit2 铸铁西瓜
     * @return 结果
     */
    @Override
    public int insertTbFruit2(TbFruit2 tbFruit2)
    {
        return tbFruit2Mapper.insertTbFruit2(tbFruit2);
    }

    /**
     * 修改铸铁西瓜
     * 
     * @param tbFruit2 铸铁西瓜
     * @return 结果
     */
    @Override
    public int updateTbFruit2(TbFruit2 tbFruit2)
    {
        return tbFruit2Mapper.updateTbFruit2(tbFruit2);
    }

    /**
     * 批量删除铸铁西瓜
     * 
     * @param frids 需要删除的铸铁西瓜主键
     * @return 结果
     */
    @Override
    public int deleteTbFruit2ByFrids(Long[] frids)
    {
        return tbFruit2Mapper.deleteTbFruit2ByFrids(frids);
    }

    /**
     * 删除铸铁西瓜信息
     * 
     * @param frid 铸铁西瓜主键
     * @return 结果
     */
    @Override
    public int deleteTbFruit2ByFrid(Long frid)
    {
        return tbFruit2Mapper.deleteTbFruit2ByFrid(frid);
    }
}
