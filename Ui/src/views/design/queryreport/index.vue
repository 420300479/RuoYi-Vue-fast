<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
          <el-select 
            v-model="queryParams.dzh" 
            filterable 
            placeholder="请选择编号" 
            clearable size="small" 
            @change="changeDzh">
          <el-option
            v-for="item in options"
            :key="item.dzh"
            :label="item.dzh"
            :value="item.dzh"
          />
          </el-select>
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
        <span>表1 菠萝</span>
        <el-table
            :data="tableDataFruit1"
            :border="true"
            stripe
            style="width: 100%"
            @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column label="表编号" align="center" prop="frid" />
            <el-table-column label="果子名称" align="center" prop="fname" />
            <el-table-column label="个数" align="center" prop="num" />
            <el-table-column label="力" align="center" prop="forc1" />
            <el-table-column label="位移" align="center" prop="disp1" />
            <el-table-column label="变形" align="center" prop="disp2" />
            <el-table-column label="次数" align="center" prop="rounds" />
            <el-table-column label="长度1" align="center" prop="length1" />
            <el-table-column label="直径1" align="center" prop="dia1" />
            <el-table-column label="直径2" align="center" prop="dia2" />
            <el-table-column label="直径3" align="center" prop="dia3" />
            <el-table-column label="系数" align="center" prop="coe3" />
            <el-table-column label="长度2" align="center" prop="length2" />
            <el-table-column label="长度3" align="center" prop="length3" />
            <el-table-column label="高度1" align="center" prop="height1" />
            <el-table-column label="长度4" align="center" prop="length4" />
            <el-table-column label="半径1" align="center" prop="radius1" />
            <el-table-column label="材料1" align="center" prop="mat1" />
            <el-table-column label="扭矩1" align="center" prop="torsion1" />
            <el-table-column label="应力1" align="center" prop="stress1" />
            <el-table-column label="应力2" align="center" prop="stress2" />
            <el-table-column label="应力3" align="center" prop="stress3" />
        </el-table>
        <el-row :gutter="10" class="mb8"> </el-row>
        <el-row :gutter="10" class="mb8"> </el-row>
        <pagination
          v-show="total>0"
          :total="total"
          :page.sync="queryParams.pageNum"
          :limit.sync="queryParams.pageSize"
          @pagination="getListFruit1"
        />

        <span>表2 西瓜</span>
        <el-table
            :data="tableDataFruit2"
            :border="true"
            stripe
            style="width: 100%"
            @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column label="表编号" align="center" prop="frid" />
            <el-table-column label="果子名称" align="center" prop="fname" />
            <el-table-column label="变形" align="center" prop="disp1" />
            <el-table-column label="次数" align="center" prop="rounds" />
            <el-table-column label="长度1" align="center" prop="length1" />
            <el-table-column label="直径1" align="center" prop="dia1" />
            <el-table-column label="直径2" align="center" prop="dia2" />
            <el-table-column label="直径3" align="center" prop="dia3" />
            <el-table-column label="系数" align="center" prop="coe3" />
            <el-table-column label="长度2" align="center" prop="length2" />
            <el-table-column label="长度3" align="center" prop="length3" />
            <el-table-column label="高度1" align="center" prop="height1" />
            <el-table-column label="长度4" align="center" prop="length4" />
            <el-table-column label="半径1" align="center" prop="radius1" />
            <el-table-column label="材料1" align="center" prop="mat1" />
            <el-table-column label="扭矩1" align="center" prop="torsion1" />
            <el-table-column label="应力1" align="center" prop="stress1" />
            <el-table-column label="应力2" align="center" prop="stress2" />
            <el-table-column label="挠度" align="center" prop="deform" />
        </el-table>
        <el-row :gutter="10" class="mb8"> </el-row>
        <el-row :gutter="10" class="mb8"> </el-row>
        <pagination
          v-show="total>0"
          :total="total"
          :page.sync="queryParamsFruit2.pageNum"
          :limit.sync="queryParamsFruit2.pageSize"
          @pagination="getListFruit2"
        />

        <div class="container-button">
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
             <el-button
              type="success"
              plain
              icon="el-icon-download"
              size="mini"
              @click="handleExportXlsx"
              v-hasPermi="['design:queryreport:exportXlsx']"
             >导出Excel文件</el-button>
             <el-button
              type="success"
              plain
              icon="el-icon-download"
              size="mini"
              @click="handleExportPdf"
              v-hasPermi="['design:queryreport:exportPortDocF']"
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
  import { getListFruit1 } from "@/api/design/fruit1";
  import { getListFruit2 } from "@/api/design/fruit2";   
  export default {
  name: "QueryReport",
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
      // 果表格数据
      QueryReportList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // dzh查询项
      options: [],
      // 表1 菠萝
      tableDataFruit1: [{}],
      // 表2 西瓜
      tableDataFruit2: [{}],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        dzh: null,
      },
      queryParamsFruit2: {
        pageNum: 1,
        pageSize: 10,
        dzh: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },

  mounted() {
      //查询数据表
      this.getlistFruit1()
      this.getlistFruit2()
      console.log("页面更新标志2")
    },
  method: {
    /** 查询定制号 */
    getlistFruit1() {
          getListFruit1().then((res) => {
          this.options = res.rows
        })
    },
    /** 查询定制号 */
    getlistFruit2() {
          getListFruit2().then((res) => {
          this.clOptions = res.rows
        })
      },

    changeDzh(val) {
        this.queryParams.dzh = val
        for (const v of this.options) {
          if (v.dzh == val) {
            this.tableDataFruit1.splice(0, 1, v)
            console.log(v, this.tableDataFruit1)
            this.tableDataFruit2.splice(0, 1, v)
            console.log(v, this.tableDataFruit2)
            return;
          }
        }
      },

    /** 查询列表 */
    getList() {
        this.loading = true;
        listFruit1(this.queryParams).then(response => {
          this.fruit1List = response.rows;
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
        frid: null,
        dzh: null,
        fname: null,
        num: null,
        forc1: null,
        disp1: null,
        disp2: null,
        rounds: null,
        length1: null,
        dia1: null,
        dia2: null,
        dia3: null,
        coe3: null,
        length2: null,
        length3: null,
        height1: null,
        length4: null,
        radius1: null,
        mat1: null,
        torsion1: null,
        stress1: null,
        stress2: null,
        stress3: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1; 
      this.loading = true;
      listfruit1(this.queryParams).then(response => {
        this.fruit1List = response.rows;
        if(this.fruit1List!=null)
        {
           this.$refs.fruit1List.toggleAllSelection();
        }
        this.total = response.total;
        this.loading = false;
      });
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.loading = true;
      listfruit1(this.queryParams).then(response => {
        this.fruit1List = response.rows;
        this.$refs.fruit1List.clearSelection();
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
        'design/queryreport/exportXlsx', 
        {
          //...this.queryParams
        }, 
        `fruits_${new Date().getTime()}.xlsx`
      )
    },
    /** 导出按钮 导出 Pdf文件 操作 */
    handleExportPdf() 
    {
      this.download
      (
        'design/queryreport/exportPortDocF', 
        {
          //...this.queryParams
        }, 
        `fruits_${new Date().getTime()}.pdf`
      )
    }
}
};
</script>

<style lang="scss" scoped>

    h1 
    {
        margin: 20;
        padding: 0;
        color: rgba($color: #F4930B, $alpha: 1.0);
    }

    span
    {
        margin-right: 16px;
        color: rgba($color: #2C3747, $alpha: 1.0);
        font-size: 16px;
        font-weight: 500;
    }

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