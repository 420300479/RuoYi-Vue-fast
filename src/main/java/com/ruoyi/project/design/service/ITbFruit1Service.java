package com.ruoyi.project.design.service;

import java.util.List;
import com.ruoyi.project.design.domain.TbFruit1;

/**
 * 钢制菠萝Service接口
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
public interface ITbFruit1Service 
{
    /**
     * 查询钢制菠萝
     * 
     * @param frid 钢制菠萝主键
     * @return 钢制菠萝
     */
    public TbFruit1 selectTbFruit1ByFrid(Long frid);

    /**
     * 查询钢制菠萝列表
     * 
     * @param tbFruit1 钢制菠萝
     * @return 钢制菠萝集合
     */
    public List<TbFruit1> selectTbFruit1List(TbFruit1 tbFruit1);

    /**
     * 新增钢制菠萝
     * 
     * @param tbFruit1 钢制菠萝
     * @return 结果
     */
    public int insertTbFruit1(TbFruit1 tbFruit1);

    /**
     * 修改钢制菠萝
     * 
     * @param tbFruit1 钢制菠萝
     * @return 结果
     */
    public int updateTbFruit1(TbFruit1 tbFruit1);

    /**
     * 批量删除钢制菠萝
     * 
     * @param frids 需要删除的钢制菠萝主键集合
     * @return 结果
     */
    public int deleteTbFruit1ByFrids(Long[] frids);

    /**
     * 删除钢制菠萝信息
     * 
     * @param frid 钢制菠萝主键
     * @return 结果
     */
    public int deleteTbFruit1ByFrid(Long frid);

    List<TbFruit1> selectTbFruit1ListQuery(Long[] ids1);
}
