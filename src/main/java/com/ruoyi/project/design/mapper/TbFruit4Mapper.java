package com.ruoyi.project.design.mapper;

import java.util.List;
import com.ruoyi.project.design.domain.TbFruit4;

/**
 * 混合金白果Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
public interface TbFruit4Mapper 
{
    /**
     * 查询混合金白果
     * 
     * @param frid 混合金白果主键
     * @return 混合金白果
     */
    public TbFruit4 selectTbFruit4ByFrid(Long frid);

    /**
     * 查询混合金白果列表
     * 
     * @param tbFruit4 混合金白果
     * @return 混合金白果集合
     */
    public List<TbFruit4> selectTbFruit4List(TbFruit4 tbFruit4);

    /**
     * 新增混合金白果
     * 
     * @param tbFruit4 混合金白果
     * @return 结果
     */
    public int insertTbFruit4(TbFruit4 tbFruit4);

    /**
     * 修改混合金白果
     * 
     * @param tbFruit4 混合金白果
     * @return 结果
     */
    public int updateTbFruit4(TbFruit4 tbFruit4);

    /**
     * 删除混合金白果
     * 
     * @param frid 混合金白果主键
     * @return 结果
     */
    public int deleteTbFruit4ByFrid(Long frid);

    /**
     * 批量删除混合金白果
     * 
     * @param frids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbFruit4ByFrids(Long[] frids);
}
