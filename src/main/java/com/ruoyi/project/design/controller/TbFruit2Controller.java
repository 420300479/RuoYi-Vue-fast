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
import com.ruoyi.project.design.domain.TbFruit2;
import com.ruoyi.project.design.service.ITbFruit2Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.poi.PdfUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 铸铁西瓜Controller
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
@RestController
@RequestMapping("/design/fruit2")
public class TbFruit2Controller extends BaseController
{
    @Autowired
    private ITbFruit2Service tbFruit2Service;

    /**
     * 查询铸铁西瓜列表
     */
    @PreAuthorize("@ss.hasPermi('design:fruit2:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbFruit2 tbFruit2)
    {
        startPage();
        List<TbFruit2> list = tbFruit2Service.selectTbFruit2List(tbFruit2);
        return getDataTable(list);
    }

    /**
     * 导出铸铁西瓜列表
     */
    @PreAuthorize("@ss.hasPermi('design:fruit2:export')")
    @Log(title = "铸铁西瓜", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbFruit2 tbFruit2)
    {
        List<TbFruit2> list = tbFruit2Service.selectTbFruit2List(tbFruit2);
        ExcelUtil<TbFruit2> util = new ExcelUtil<TbFruit2>(TbFruit2.class);
        util.exportExcel(response, list, "铸铁西瓜数据");
    }
    
    /**
     * 导出铸铁西瓜列表的Pdf文件
     * @return 
     * @throws Exception 
     */
    @PreAuthorize("@ss.hasPermi('design:fruit2:exportPortDocF')")
    @Log(title = "铸铁西瓜", businessType = BusinessType.EXPORT)
    @PostMapping("/exportPortDocF")    
    public void exportPortDocF(HttpServletResponse response, TbFruit2 TbFruit2) 
    {
        List<TbFruit2> list = tbFruit2Service.selectTbFruit2List(TbFruit2);
        PdfUtil<TbFruit2> util = new PdfUtil<TbFruit2>(TbFruit2.class);
        util.exportPdf(response, list, "铸铁西瓜数据");        
    }

    /**
     * 获取铸铁西瓜详细信息
     */
    @PreAuthorize("@ss.hasPermi('design:fruit2:query')")
    @GetMapping(value = "/{frid}")
    public AjaxResult getInfo(@PathVariable("frid") Long frid)
    {
        return AjaxResult.success(tbFruit2Service.selectTbFruit2ByFrid(frid));
    }

    /**
     * 新增铸铁西瓜
     */
    @PreAuthorize("@ss.hasPermi('design:fruit2:add')")
    @Log(title = "铸铁西瓜", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbFruit2 tbFruit2)
    {
        return toAjax(tbFruit2Service.insertTbFruit2(tbFruit2));
    }

    /**
     * 修改铸铁西瓜
     */
    @PreAuthorize("@ss.hasPermi('design:fruit2:edit')")
    @Log(title = "铸铁西瓜", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbFruit2 tbFruit2)
    {
        return toAjax(tbFruit2Service.updateTbFruit2(tbFruit2));
    }

    /**
     * 删除铸铁西瓜
     */
    @PreAuthorize("@ss.hasPermi('design:fruit2:remove')")
    @Log(title = "铸铁西瓜", businessType = BusinessType.DELETE)
	@DeleteMapping("/{frids}")
    public AjaxResult remove(@PathVariable Long[] frids)
    {
        return toAjax(tbFruit2Service.deleteTbFruit2ByFrids(frids));
    }
}
