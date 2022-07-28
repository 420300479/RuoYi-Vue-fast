<template>
    <div class="app-container">
      <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
        <el-form-item label="编号" prop="dzh">
          <el-input
            v-model="queryParams.dzh"
            placeholder="请选择编号"
            clearable
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-button 
           type="primary" 
           plain
           icon="el-icon-search" 
           size="small" 
           @click="handleQuery()"
          >一键查选
        </el-button>
     
        <el-button
           type="info"
           plain
           icon="el-icon-close" 
           size="small" 
           @click="resetQuery()"
           >一键取消
        </el-button>
  
      </el-form>
  
       <el-row :gutter="10" class="mb8"> </el-row>  
       <el-row :gutter="10" class="mb8"> </el-row>  
  
      <el-table v-loading="loading" :data="qzsjjsList" border ref="qzsjjsList" width="100%" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" :reserve-selection="true" align="center"/>
        <el-table-column label=" 曲轴设计选型" align="center" prop="prId" />
        <el-table-column label=" 产品定制号" align="center" prop="dzh" />
        <el-table-column label=" A9 球头受力面直径(mm)db" align="center" prop="quzhouQtmDia" />
        <el-table-column label=" A10 滑动轴承摩擦系数 μ" align="center" prop="slideFricCoe" />
        <el-table-column label=" A11曲柄颈长度(mm)la " align="center" prop="la" />
        <el-table-column label=" A13曲柄臂厚度(mm)b " align="center" prop="b" />
        <el-table-column label=" A14曲柄臂高度(mm)h " align="center" prop="h" />
        <el-table-column label=" A15曲柄臂形心至支承颈形心的距离(mm)c " align="center" prop="r" />
        <el-table-column label=" A16曲柄颈及支承颈圆角半径(mm) r " align="center" prop="c" />
        <el-table-column label=" A18 曲轴材料 " align="center" prop="qzClmc" />
        <el-table-column label=" D2曲柄颈最大弯曲应力(MPa) " align="center" prop="qbjzdwqyl" />
        <el-table-column label=" D3支承颈最大剪应力(MPa " align="center" prop="zcjzdjqyl" />
        <el-table-column label=" D4挠度 " align="center" prop="nd" />
      </el-table>
  
  
      <el-row :gutter="10" class="mb8"> </el-row>  
      <el-row :gutter="10" class="mb8"> </el-row>  
  
      <div class="container-button">
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
             <el-button
             type="success"
             plain
             icon="el-icon-download"
             size="mini"
             @click="handleExportXlsx"
             v-hasPermi="['design:report:exportXlsx']"
            >导出Excel文件</el-button>
            <el-button
             type="success"
             plain
             icon="el-icon-download"
             size="mini"
             @click="handleExportPdf"
             v-hasPermi="['design:report:exportPortDocF']"
            >导出Pdf文件</el-button>          
          </el-col>
         <right-toolbar :showSearch.sync="showSearch" 
           @queryTable="getList">
        </right-toolbar>
        </el-row>
      </div>
    </div>
  </template>
  
  <script>
  import { listQzsjjs, getQzsjjs } from "@/api/design/report";
  import { getQueryObject } from "../../../utils";
  export default {
    name: "Qzsjjs",
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 计算表格数据
        qzsjjsList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          prId: null,
          dzh: null,
          quzhouQtmDia: null,
          slideFricCoe: null,
          la: null,
          b: null,
          h: null,
          r: null,
          c: null,
          qzClmc: null,
          nominalTorsion: null,
          qbjzdwqyl: null,
          zcjzdjqyl: null,
          nd: null
        },
  
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          prId: [
            { required: true, message: "设计计算表不能为空", trigger: "blur" }
          ],
          dzh: [
            { required: true, message: "定制号不能为空", trigger: "blur" }
          ],
        }
      };
    },
  
    created() {
      this.getList();
    },
    methods: {
      /** 查询列表 */
      getList() {
        this.loading = true;
        listQzsjjs(this.queryParams).then(response => {
          this.qzsjjsList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      }, 
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          prId: null,
          dzh: null,
          name: null,
          jcds: null,
          gcl: null,
          gclxc: null,
          hkxc: null,
          zdxccs: null,
          lianganLength: null,
          quzhouZcjDia: null,
          quzhouQbjDia: null,
          quzhouQtmDia: null,
          slideFricCoe: null,
          la: null,
          b: null,
          h: null,
          r: null,
          c: null,
          qzClmc: null,
          nominalTorsion: null,
          qbjzdwqyl: null,
          zcjzdjqyl: null,
          nd: null
        };
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1; 
        this.loading = true;
        listQzsjjs(this.queryParams).then(response => {
          this.qzsjjsList = response.rows;
          if(this.qzsjjsList!=null)
          {
             this.$refs.qzsjjsList.toggleAllSelection();
          }
          this.total = response.total;
          this.loading = false;
        });
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.loading = true;
        listQzsjjs(this.queryParams).then(response => {
          this.qzsjjsList = response.rows;
          this.$refs.qzsjjsList.clearSelection();
          this.total = response.total;
          this.loading = false;
        });
        this.resetForm("queryForm");
        this.cancel();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.prId)
        this.single = selection.length!==1
        this.multiple = !selection.length
      },
      /** 导出按钮 导出 excel文件 操作 */
      handleExportXlsx() 
      {
        this.download
        (
          'design/report/exportXlsx', 
          // "design/report/downloadTemplate",//导入模板
          {
            //...this.queryParams
          }, 
          `qzsjjs_${new Date().getTime()}.xlsx`
        )
      },
      /** 导出按钮 导出 Pdf文件 操作 */
      handleExportPdf() 
      {
        this.download
        (
          'design/report/exportPortDocF', 
          {
            //...this.queryParams
          }, 
          `qzsjjs_${new Date().getTime()}.pdf`
        )
      }
  
  
  
  
    }
  };
  </script>
  
  <style lang="scss" scoped>
    .container-button 
    {
      display: flex;
      padding-top: 20px;
      flex-direction: column;
      align-items: flex-end;
      > button 
      {
        margin-bottom: 16px;
        font-size: 16px;
      }
    }
  </style>