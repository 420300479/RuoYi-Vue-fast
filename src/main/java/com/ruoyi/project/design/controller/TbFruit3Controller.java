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
import com.ruoyi.project.design.domain.TbFruit3;
import com.ruoyi.project.design.domain.TbFruit3;
import com.ruoyi.project.design.service.ITbFruit3Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.poi.PdfUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 铝合金芒果Controller
 * 
 * @author ruoyi
 * @date 2022-09-18
 */
@RestController
@RequestMapping("/design/fruit3")
public class TbFruit3Controller extends BaseController
{
    @Autowired
    private ITbFruit3Service tbFruit3Service;

    /**
     * 查询铝合金芒果列表
     */
    @PreAuthorize("@ss.hasPermi('design:fruit3:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbFruit3 tbFruit3)
    {
        startPage();
        List<TbFruit3> list = tbFruit3Service.selectTbFruit3List(tbFruit3);
        return getDataTable(list);
    }

    /**
     * 导出铝合金芒果列表
     */
    @PreAuthorize("@ss.hasPermi('design:fruit3:export')")
    @Log(title = "铝合金芒果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbFruit3 tbFruit3)
    {
        List<TbFruit3> list = tbFruit3Service.selectTbFruit3List(tbFruit3);
        ExcelUtil<TbFruit3> util = new ExcelUtil<TbFruit3>(TbFruit3.class);
        util.exportExcel(response, list, "铝合金芒果数据");
    }
    
    /**
     * 导出铸铁西瓜列表的Pdf文件
     * @return 
     * @throws Exception 
     */
    @PreAuthorize("@ss.hasPermi('design:fruit3:exportPortDocF')")
    @Log(title = "铝合金芒果", businessType = BusinessType.EXPORT)
    @PostMapping("/exportPortDocF")    
    public void exportPortDocF(HttpServletResponse response, TbFruit3 TbFruit3) 
    {
        List<TbFruit3> list = tbFruit3Service.selectTbFruit3List(TbFruit3);
        PdfUtil<TbFruit3> util = new PdfUtil<TbFruit3>(TbFruit3.class);
        util.exportPdf(response, list, "铸铁西瓜数据");        
    }

    /**
     * 获取铝合金芒果详细信息
     */
    @PreAuthorize("@ss.hasPermi('design:fruit3:query')")
    @GetMapping(value = "/{frid}")
    public AjaxResult getInfo(@PathVariable("frid") Long frid)
    {
        return AjaxResult.success(tbFruit3Service.selectTbFruit3ByFrid(frid));
    }

    /**
     * 新增铝合金芒果
     */
    @PreAuthorize("@ss.hasPermi('design:fruit3:add')")
    @Log(title = "铝合金芒果", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbFruit3 tbFruit3)
    {
        return toAjax(tbFruit3Service.insertTbFruit3(tbFruit3));
    }

    /**
     * 修改铝合金芒果
     */
    @PreAuthorize("@ss.hasPermi('design:fruit3:edit')")
    @Log(title = "铝合金芒果", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbFruit3 tbFruit3)
    {
        return toAjax(tbFruit3Service.updateTbFruit3(tbFruit3));
    }

    /**
     * 删除铝合金芒果
     */
    @PreAuthorize("@ss.hasPermi('design:fruit3:remove')")
    @Log(title = "铝合金芒果", businessType = BusinessType.DELETE)
	@DeleteMapping("/{frids}")
    public AjaxResult remove(@PathVariable Long[] frids)
    {
        return toAjax(tbFruit3Service.deleteTbFruit3ByFrids(frids));
    }
}
