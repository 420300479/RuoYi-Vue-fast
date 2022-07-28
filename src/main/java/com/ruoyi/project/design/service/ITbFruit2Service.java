package com.ruoyi.project.design.service;

import java.util.List;
import com.ruoyi.project.design.domain.TbFruit2;

/**
 * 铸铁西瓜Service接口
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
public interface ITbFruit2Service 
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
     * 批量删除铸铁西瓜
     * 
     * @param frids 需要删除的铸铁西瓜主键集合
     * @return 结果
     */
    public int deleteTbFruit2ByFrids(Long[] frids);

    /**
     * 删除铸铁西瓜信息
     * 
     * @param frid 铸铁西瓜主键
     * @return 结果
     */
    public int deleteTbFruit2ByFrid(Long frid);
}
