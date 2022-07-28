package com.ruoyi.project.design.service;

import java.util.List;
import com.ruoyi.project.design.domain.TbFruit3;

/**
 * 铝合金芒果Service接口
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
public interface ITbFruit3Service 
{
    /**
     * 查询铝合金芒果
     * 
     * @param frid 铝合金芒果主键
     * @return 铝合金芒果
     */
    public TbFruit3 selectTbFruit3ByFrid(Long frid);

    /**
     * 查询铝合金芒果列表
     * 
     * @param tbFruit3 铝合金芒果
     * @return 铝合金芒果集合
     */
    public List<TbFruit3> selectTbFruit3List(TbFruit3 tbFruit3);

    /**
     * 新增铝合金芒果
     * 
     * @param tbFruit3 铝合金芒果
     * @return 结果
     */
    public int insertTbFruit3(TbFruit3 tbFruit3);

    /**
     * 修改铝合金芒果
     * 
     * @param tbFruit3 铝合金芒果
     * @return 结果
     */
    public int updateTbFruit3(TbFruit3 tbFruit3);

    /**
     * 批量删除铝合金芒果
     * 
     * @param frids 需要删除的铝合金芒果主键集合
     * @return 结果
     */
    public int deleteTbFruit3ByFrids(Long[] frids);

    /**
     * 删除铝合金芒果信息
     * 
     * @param frid 铝合金芒果主键
     * @return 结果
     */
    public int deleteTbFruit3ByFrid(Long frid);
}
