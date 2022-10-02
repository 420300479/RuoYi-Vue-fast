package com.ruoyi.project.design.mapper;

import java.util.List;
import com.ruoyi.project.design.domain.TbFruit2;

/**
 * 铸铁西瓜Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
public interface TbFruit2Mapper 
{
    /**
     * 查询铸铁西瓜
     * 
     * @param frid 铸铁西瓜主键
     * @return 铸铁西瓜
     */
    public TbFruit2 selectTbFruit2ByFrid(Long frid);

    /**
     * 查询铸铁西瓜列表
     * 
     * @param tbFruit2 铸铁西瓜
     * @return 铸铁西瓜集合
     */
    public List<TbFruit2> selectTbFruit2List(TbFruit2 tbFruit2);

    /**
     * 新增铸铁西瓜
     * 
     * @param tbFruit2 铸铁西瓜
     * @return 结果
     */
    public int insertTbFruit2(TbFruit2 tbFruit2);

    /**
     * 修改铸铁西瓜
     * 
     * @param tbFruit2 铸铁西瓜
     * @return 结果
     */
    public int updateTbFruit2(TbFruit2 tbFruit2);

    /**
     * 删除铸铁西瓜
     * 
     * @param frid 铸铁西瓜主键
     * @return 结果
     */
    public int deleteTbFruit2ByFrid(Long frid);

    /**
     * 批量删除铸铁西瓜
     * 
     * @param frids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbFruit2ByFrids(Long[] frids);

    List<TbFruit2> selectTbFruit2ListQuery(Long[] ids2);
}
