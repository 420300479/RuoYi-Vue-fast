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
import com.ruoyi.project.design.domain.TbFruit4;
import com.ruoyi.project.design.domain.TbFruit4;
import com.ruoyi.project.design.service.ITbFruit4Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.poi.PdfUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 混合金白果Controller
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
@RestController
@RequestMapping("/design/fruit4")
public class TbFruit4Controller extends BaseController
{
    @Autowired
    private ITbFruit4Service tbFruit4Service;

    /**
     * 查询混合金白果列表
     */
    @PreAuthorize("@ss.hasPermi('design:fruit4:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbFruit4 tbFruit4)
    {
        startPage();
        List<TbFruit4> list = tbFruit4Service.selectTbFruit4List(tbFruit4);
        return getDataTable(list);
    }

    /**
     * 导出混合金白果列表
     */
    @PreAuthorize("@ss.hasPermi('design:fruit4:export')")
    @Log(title = "混合金白果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbFruit4 tbFruit4)
    {
        List<TbFruit4> list = tbFruit4Service.selectTbFruit4List(tbFruit4);
        ExcelUtil<TbFruit4> util = new ExcelUtil<TbFruit4>(TbFruit4.class);
        util.exportExcel(response, list, "混合金白果数据");
    }
    
    /**
     * 导出铸铁西瓜列表的Pdf文件
     * @return 
     * @throws Exception 
     */
    @PreAuthorize("@ss.hasPermi('design:Fruit4:exportPortDocF')")
    @Log(title = "混合金白果", businessType = BusinessType.EXPORT)
    @PostMapping("/exportPortDocF")    
    public void exportPortDocF(HttpServletResponse response, TbFruit4 TbFruit4) 
    {
        List<TbFruit4> list = tbFruit4Service.selectTbFruit4List(TbFruit4);
        PdfUtil<TbFruit4> util = new PdfUtil<TbFruit4>(TbFruit4.class);
        util.exportPdf(response, list, "铸铁西瓜数据");        
    }

    /**
     * 获取混合金白果详细信息
     */
    @PreAuthorize("@ss.hasPermi('design:fruit4:query')")
    @GetMapping(value = "/{frid}")
    public AjaxResult getInfo(@PathVariable("frid") Long frid)
    {
        return AjaxResult.success(tbFruit4Service.selectTbFruit4ByFrid(frid));
    }

    /**
     * 新增混合金白果
     */
    @PreAuthorize("@ss.hasPermi('design:fruit4:add')")
    @Log(title = "混合金白果", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbFruit4 tbFruit4)
    {
        return toAjax(tbFruit4Service.insertTbFruit4(tbFruit4));
    }

    /**
     * 修改混合金白果
     */
    @PreAuthorize("@ss.hasPermi('design:fruit4:edit')")
    @Log(title = "混合金白果", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbFruit4 tbFruit4)
    {
        return toAjax(tbFruit4Service.updateTbFruit4(tbFruit4));
    }

    /**
     * 删除混合金白果
     */
    @PreAuthorize("@ss.hasPermi('design:fruit4:remove')")
    @Log(title = "混合金白果", businessType = BusinessType.DELETE)
	@DeleteMapping("/{frids}")
    public AjaxResult remove(@PathVariable Long[] frids)
    {
        return toAjax(tbFruit4Service.deleteTbFruit4ByFrids(frids));
    }
}
