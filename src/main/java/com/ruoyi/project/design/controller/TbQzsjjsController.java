package com.ruoyi.project.design.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.poi.PdfUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.design.domain.TbQzsjjs;
import com.ruoyi.project.design.service.ITbQzsjjsService;

/**
 * 计算Controller
 * 
 * @author ruoyi
 * @date 2022-09-15
 */
@RestController
@RequestMapping("/design/report")
public class TbQzsjjsController extends BaseController
{
    @Autowired
    private ITbQzsjjsService tbQzsjjsService;

    /**
     * 查询计算列表
     */
    @PreAuthorize("@ss.hasPermi('design:report:list')")
    @GetMapping("/list")
    public TableDataInfo list(TbQzsjjs tbQzsjjs)
    {
        startPage();
        List<TbQzsjjs> list = tbQzsjjsService.selectTbQzsjjsList(tbQzsjjs);
        return getDataTable(list);
    }

    /**
     * 导出计算列表的Excel文件
     */
    @PreAuthorize("@ss.hasPermi('design:report:exportXlsx')")
    @Log(title = "计算", businessType = BusinessType.EXPORT)
    @PostMapping("/exportXlsx")
    public void exportXlsx(HttpServletResponse response, TbQzsjjs tbQzsjjs)
    {
        List<TbQzsjjs> list = tbQzsjjsService.selectTbQzsjjsList(tbQzsjjs);
        ExcelUtil<TbQzsjjs> util = new ExcelUtil<TbQzsjjs>(TbQzsjjs.class);
        util.exportExcel(response, list, "计算数据");
    }

    /**
     * 导出计算列表的Pdf文件
     * @return 
     * @throws Exception 
     */
    @PreAuthorize("@ss.hasPermi('design:report:exportPortDocF')")
    @Log(title = "计算", businessType = BusinessType.EXPORT)
    @PostMapping("/exportPortDocF")    
    public void exportPortDocF(HttpServletResponse response, TbQzsjjs tbQzsjjs) 
    {
        List<TbQzsjjs> list = tbQzsjjsService.selectTbQzsjjsList(tbQzsjjs);
        PdfUtil<TbQzsjjs> util = new PdfUtil<TbQzsjjs>(TbQzsjjs.class);
        util.exportPdf(response, list, "计算数据");        
    }


    
    /**
     * 获取计算详细信息
     */
    @PreAuthorize("@ss.hasPermi('design:report:query')")
    @GetMapping(value = "/{prId}")
    public AjaxResult getInfo(@PathVariable("prId") Long prId)
    {
        return AjaxResult.success(tbQzsjjsService.selectTbQzsjjsByPrId(prId));
    }
  }
