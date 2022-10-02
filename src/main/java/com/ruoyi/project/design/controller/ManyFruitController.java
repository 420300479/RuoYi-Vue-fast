package com.ruoyi.project.design.controller;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.poi.PdfUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.design.domain.TbFruit1;
import com.ruoyi.project.design.domain.TbFruit2;
import com.ruoyi.project.design.service.ITbFruit1Service;
import com.ruoyi.project.design.service.ITbFruit2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 钢制菠萝Controller
 *
 * @author ruoyi
 * @date 2022-09-30
 */
@RestController
@RequestMapping("/design/manyFruit")
public class ManyFruitController extends BaseController {
    @Autowired
    private ITbFruit1Service tbFruit1Service;
    @Autowired
    private ITbFruit2Service tbFruit2Service;

    /**
     * 查询钢制菠萝列表
     */
    @PreAuthorize("@ss.hasPermi('design:manyFruit:list')")
    @GetMapping("/list")
    public AjaxResult list(TbFruit1 tbFruit1) {
        List<TbFruit1> list1 = tbFruit1Service.selectTbFruit1List(tbFruit1);
        TbFruit2 tbFruit2 = new TbFruit2();
        if (StringUtils.isNotBlank(tbFruit1.getDzh())) {
            tbFruit2.setDzh(tbFruit1.getDzh());
        }
        List<TbFruit2> list2 = tbFruit2Service.selectTbFruit2List(tbFruit2);
        //返回数据为data1 data2
        return new AjaxResult(200, "操作成功", list1, list2);
    }

    /**
     * 导出计算列表的Pdf文件（多文件）
     *
     * @return
     * @throws Exception
     */
    @PreAuthorize("@ss.hasPermi('design:report:handleExportPdfMany')")
    @Log(title = "计算", businessType = BusinessType.EXPORT)
    @PostMapping("/handleExportPdfMany")
    public void handleExportPdfMany(HttpServletResponse response, @RequestParam HashMap<String, Object> param) throws IOException {
        Long[] long1 = Convert.toLongArray(StringUtils.strip(Convert.toStr(param.get("ids1")), "[]"));/*paramTem.get(0);*/
        List<TbFruit1> list1 = tbFruit1Service.selectTbFruit1ListQuery(long1);
        TbFruit2 tbFruit2 = new TbFruit2();
        Long[] long2 = Convert.toLongArray(StringUtils.strip(Convert.toStr(param.get("ids2")), "[]"));
        List<TbFruit2> list2 = tbFruit2Service.selectTbFruit2ListQuery(long2);
        List<String> sourceFilePaths = new ArrayList<String>();
        PdfUtil<TbFruit1> util = new PdfUtil<TbFruit1>(TbFruit1.class);
        String output = util.exportPdfMany(response, list1, "表1 菠萝");
        sourceFilePaths.add(output);
        PdfUtil<TbFruit2> uti2 = new PdfUtil<TbFruit2>(TbFruit2.class);
        output = uti2.exportPdfMany(response, list2, "表2 西瓜");
        sourceFilePaths.add(output);
        //合并PDF文件
        output = util.mergePdfFile(sourceFilePaths, "test_merged.pdf");
        // 输出pdf文件的二进制文件流
        FileInputStream input = new FileInputStream(output);
        byte[] data = null;
        data = new byte[input.available()];
        input.read(data);
        response.getOutputStream().write(data);
    }

    /**
     * 导出钢制菠萝列表
     */
    @PreAuthorize("@ss.hasPermi('design:manyFruit:export')")
    @Log(title = "钢制菠萝", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbFruit1 tbFruit1) {
        List<TbFruit1> list = tbFruit1Service.selectTbFruit1List(tbFruit1);
        ExcelUtil<TbFruit1> util = new ExcelUtil<TbFruit1>(TbFruit1.class);
        util.exportExcel(response, list, "钢制菠萝数据");
    }

    /**
     * 获取钢制菠萝详细信息
     */
    @PreAuthorize("@ss.hasPermi('design:manyFruit:query')")
    @GetMapping(value = "/{frid}")
    public AjaxResult getInfo(@PathVariable("frid") Long frid) {
        return AjaxResult.success(tbFruit1Service.selectTbFruit1ByFrid(frid));
    }

    /**
     * 新增钢制菠萝
     */
    @PreAuthorize("@ss.hasPermi('design:manyFruit:add')")
    @Log(title = "钢制菠萝", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbFruit1 tbFruit1) {
        return toAjax(tbFruit1Service.insertTbFruit1(tbFruit1));
    }

    /**
     * 修改钢制菠萝
     */
    @PreAuthorize("@ss.hasPermi('design:manyFruit:edit')")
    @Log(title = "钢制菠萝", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbFruit1 tbFruit1) {
        return toAjax(tbFruit1Service.updateTbFruit1(tbFruit1));
    }

    /**
     * 删除钢制菠萝
     */
    @PreAuthorize("@ss.hasPermi('design:manyFruit:remove')")
    @Log(title = "钢制菠萝", businessType = BusinessType.DELETE)
    @DeleteMapping("/{frids}")
    public AjaxResult remove(@PathVariable Long[] frids) {
        return toAjax(tbFruit1Service.deleteTbFruit1ByFrids(frids));
    }

}
