package com.ruoyi.project.design.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.design.domain.TbFruit1;
import com.ruoyi.project.design.service.ITbFruit1Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.poi.PdfUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 钢制菠萝Controller
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
@RestController
@RequestMapping("/design/fruit1")
public class TbFruit1Controller extends BaseController
{
    @Autowired
    private ITbFruit1Service tbFruit1Service;

    /**
     * 查询钢制菠萝列表
     */
    @PreAuthorize("@ss.hasPermi('design:fruit1:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbFruit1 tbFruit1)
    {
        startPage();
        List<TbFruit1> list = tbFruit1Service.selectTbFruit1List(tbFruit1);
        return getDataTable(list);
    }

    /**
     * 导出钢制菠萝列表
     */
    @PreAuthorize("@ss.hasPermi('design:fruit1:export')")
    @Log(title = "钢制菠萝", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbFruit1 tbFruit1)
    {
        List<TbFruit1> list = tbFruit1Service.selectTbFruit1List(tbFruit1);
        ExcelUtil<TbFruit1> util = new ExcelUtil<TbFruit1>(TbFruit1.class);
        util.exportExcel(response, list, "钢制菠萝数据");
    }
    
    
    /**
     * 导出计算列表的Pdf文件
     * @return 
     * @throws Exception 
     */
    @PreAuthorize("@ss.hasPermi('design:fruit1:exportPortDocF')")
    @Log(title = "计算", businessType = BusinessType.EXPORT)
    @PostMapping("/exportPortDocF")    
    public void exportPortDocF(HttpServletResponse response, TbFruit1 TbFruit1) 
    {
        List<TbFruit1> list = tbFruit1Service.selectTbFruit1List(TbFruit1);
        PdfUtil<TbFruit1> util = new PdfUtil<TbFruit1>(TbFruit1.class);
        util.exportPdf(response, list, "钢制菠萝数据");        
    }



    /**
     * 获取钢制菠萝详细信息
     */
    @PreAuthorize("@ss.hasPermi('design:fruit1:query')")
    @GetMapping(value = "/{frid}")
    public AjaxResult getInfo(@PathVariable("frid") Long frid)
    {
        return AjaxResult.success(tbFruit1Service.selectTbFruit1ByFrid(frid));
    }

    /**
     * 新增钢制菠萝
     */
    @PreAuthorize("@ss.hasPermi('design:fruit1:add')")
    @Log(title = "钢制菠萝", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbFruit1 tbFruit1)
    {
        return toAjax(tbFruit1Service.insertTbFruit1(tbFruit1));
    }

    /**
     * 修改钢制菠萝
     */
    @PreAuthorize("@ss.hasPermi('design:fruit1:edit')")
    @Log(title = "钢制菠萝", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbFruit1 tbFruit1)
    {
        return toAjax(tbFruit1Service.updateTbFruit1(tbFruit1));
    }

    /**
     * 删除钢制菠萝
     */
    @PreAuthorize("@ss.hasPermi('design:fruit1:remove')")
    @Log(title = "钢制菠萝", businessType = BusinessType.DELETE)
	@DeleteMapping("/{frids}")
    public AjaxResult remove(@PathVariable Long[] frids)
    {
        return toAjax(tbFruit1Service.deleteTbFruit1ByFrids(frids));
    }
}
