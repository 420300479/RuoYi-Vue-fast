<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="果子编号" prop="dzh">
        <el-input
          v-model="queryParams.dzh"
          placeholder="请输入果子编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExportPdfMany"
          v-hasPermi="['design:manyFruit:handleExportPdfMany']"
        >导出pdf
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <span>表1 菠萝</span>
    <el-table v-loading="loading" max-height="250" :data="manyFruitList1" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="表编号" align="center" prop="frid"/>
      <el-table-column label="果子编号" align="center" prop="dzh"/>
      <el-table-column label="果子名称" align="center" prop="fname"/>
      <el-table-column label="个数" align="center" prop="num"/>
      <el-table-column label="力" align="center" prop="forc1"/>
      <el-table-column label="位移" align="center" prop="disp1"/>
      <el-table-column label="变形" align="center" prop="disp2"/>
      <el-table-column label="次数" align="center" prop="rounds"/>
      <el-table-column label="长度1" align="center" prop="length1"/>
      <el-table-column label="直径1" align="center" prop="dia1"/>
      <el-table-column label="直径2" align="center" prop="dia2"/>
      <el-table-column label="直径3" align="center" prop="dia3"/>
      <el-table-column label="系数" align="center" prop="coe3"/>
      <el-table-column label="长度2" align="center" prop="length2"/>
      <el-table-column label="长度3" align="center" prop="length3"/>
      <el-table-column label="高度1" align="center" prop="height1"/>
      <el-table-column label="长度4" align="center" prop="length4"/>
      <el-table-column label="半径1" align="center" prop="radius1"/>
      <el-table-column label="材料1" align="center" prop="mat1"/>
      <el-table-column label="扭矩1" align="center" prop="torsion1"/>
      <el-table-column label="应力1" align="center" prop="stress1"/>
      <el-table-column label="应力2" align="center" prop="stress2"/>
      <el-table-column label="应力3" align="center" prop="stress3"/>
    </el-table>

    <span>表2 西瓜</span>

    <el-table v-loading="loading" max-height="250" :data="manyFruitList2" @selection-change="handleSelectionChange2">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="表编号" align="center" prop="frid"/>
      <el-table-column label="果子编号" align="center" prop="dzh"/>
      <el-table-column label="果子名称" align="center" prop="fname"/>
      <el-table-column label="变形" align="center" prop="disp1"/>
      <el-table-column label="次数" align="center" prop="rounds"/>
      <el-table-column label="长度1" align="center" prop="length1"/>
      <el-table-column label="直径1" align="center" prop="dia1"/>
      <el-table-column label="直径2" align="center" prop="dia2"/>
      <el-table-column label="直径3" align="center" prop="dia3"/>
      <el-table-column label="系数" align="center" prop="coe3"/>
      <el-table-column label="长度2" align="center" prop="length2"/>
      <el-table-column label="长度3" align="center" prop="length3"/>
      <el-table-column label="高度1" align="center" prop="height1"/>
      <el-table-column label="长度4" align="center" prop="length4"/>
      <el-table-column label="半径1" align="center" prop="radius1"/>
      <el-table-column label="材料1" align="center" prop="mat1"/>
      <el-table-column label="扭矩1" align="center" prop="torsion1"/>
      <el-table-column label="应力1" align="center" prop="stress1"/>
      <el-table-column label="应力2" align="center" prop="stress2"/>
      <el-table-column label="挠度" align="center" prop="deform"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:fruit2:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:fruit2:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加或修改钢制菠萝对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="果子编号" prop="dzh">
          <el-input v-model="form.dzh" placeholder="请输入果子编号"/>
        </el-form-item>
        <el-form-item label="果子名称" prop="fname">
          <el-input v-model="form.fname" placeholder="请输入果子名称"/>
        </el-form-item>
        <el-form-item label="个数" prop="num">
          <el-input v-model="form.num" placeholder="请输入个数"/>
        </el-form-item>
        <el-form-item label="力" prop="forc1">
          <el-input v-model="form.forc1" placeholder="请输入力"/>
        </el-form-item>
        <el-form-item label="位移" prop="disp1">
          <el-input v-model="form.disp1" placeholder="请输入位移"/>
        </el-form-item>
        <el-form-item label="变形" prop="disp2">
          <el-input v-model="form.disp2" placeholder="请输入变形"/>
        </el-form-item>
        <el-form-item label="次数" prop="rounds">
          <el-input v-model="form.rounds" placeholder="请输入次数"/>
        </el-form-item>
        <el-form-item label="长度1" prop="length1">
          <el-input v-model="form.length1" placeholder="请输入长度1"/>
        </el-form-item>
        <el-form-item label="直径1" prop="dia1">
          <el-input v-model="form.dia1" placeholder="请输入直径1"/>
        </el-form-item>
        <el-form-item label="直径2" prop="dia2">
          <el-input v-model="form.dia2" placeholder="请输入直径2"/>
        </el-form-item>
        <el-form-item label="直径3" prop="dia3">
          <el-input v-model="form.dia3" placeholder="请输入直径3"/>
        </el-form-item>
        <el-form-item label="系数" prop="coe3">
          <el-input v-model="form.coe3" placeholder="请输入系数"/>
        </el-form-item>
        <el-form-item label="长度2" prop="length2">
          <el-input v-model="form.length2" placeholder="请输入长度2"/>
        </el-form-item>
        <el-form-item label="长度3" prop="length3">
          <el-input v-model="form.length3" placeholder="请输入长度3"/>
        </el-form-item>
        <el-form-item label="高度1" prop="height1">
          <el-input v-model="form.height1" placeholder="请输入高度1"/>
        </el-form-item>
        <el-form-item label="长度4" prop="length4">
          <el-input v-model="form.length4" placeholder="请输入长度4"/>
        </el-form-item>
        <el-form-item label="半径1" prop="radius1">
          <el-input v-model="form.radius1" placeholder="请输入半径1"/>
        </el-form-item>
        <el-form-item label="材料1" prop="mat1">
          <el-input v-model="form.mat1" placeholder="请输入材料1"/>
        </el-form-item>
        <el-form-item label="扭矩1" prop="torsion1">
          <el-input v-model="form.torsion1" placeholder="请输入扭矩1"/>
        </el-form-item>
        <el-form-item label="应力1" prop="stress1">
          <el-input v-model="form.stress1" placeholder="请输入应力1"/>
        </el-form-item>
        <el-form-item label="应力2" prop="stress2">
          <el-input v-model="form.stress2" placeholder="请输入应力2"/>
        </el-form-item>
        <el-form-item label="应力3" prop="stress3">
          <el-input v-model="form.stress3" placeholder="请输入应力3"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listManyFruit, getManyFruit, delManyFruit, addManyFruit, updateManyFruit} from "@/api/design/manyFruit";

export default {
  name: "ManyFruit",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组 表一
      ids: [],
      // 选中数组 表二
      ids2: [],

      idsAll: '',
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 钢制菠萝表格数据
      manyFruitList1: [],
      // 西瓜表格数据
      manyFruitList2: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        /* pageNum: 1,
         pageSize: 10,*/
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
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        dzh: [
          {required: true, message: "果子编号不能为空", trigger: "blur"}
        ],
        fname: [
          {required: true, message: "果子名称不能为空", trigger: "blur"}
        ],
        num: [
          {required: true, message: "个数不能为空", trigger: "blur"}
        ],
        forc1: [
          {required: true, message: "力不能为空", trigger: "blur"}
        ],
        disp1: [
          {required: true, message: "位移不能为空", trigger: "blur"}
        ],
        disp2: [
          {required: true, message: "变形不能为空", trigger: "blur"}
        ],
        rounds: [
          {required: true, message: "次数不能为空", trigger: "blur"}
        ],
        length1: [
          {required: true, message: "长度1不能为空", trigger: "blur"}
        ],
        dia1: [
          {required: true, message: "直径1不能为空", trigger: "blur"}
        ],
        dia2: [
          {required: true, message: "直径2不能为空", trigger: "blur"}
        ],
        dia3: [
          {required: true, message: "直径3不能为空", trigger: "blur"}
        ],
        coe3: [
          {required: true, message: "系数不能为空", trigger: "blur"}
        ],
        torsion1: [
          {required: true, message: "扭矩1不能为空", trigger: "blur"}
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询钢制菠萝列表 */
    getList() {
      this.loading = true;
      listManyFruit(this.queryParams).then(response => {
        debugger
        this.manyFruitList1 = response.data1;
        this.manyFruitList2 = response.data2;
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
      /*this.queryParams.pageNum = 1;*/
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据  表一
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.frid)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    // 多选框选中数据  表二
    handleSelectionChange2(selection) {
      this.ids2 = selection.map(item => item.frid)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加钢制菠萝";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const frid = row.frid || this.ids
      getManyFruit(frid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改钢制菠萝";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.frid != null) {
            updateManyFruit(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addManyFruit(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const frids = row.frid || this.ids;
      this.$modal.confirm('是否确认删除钢制菠萝编号为"' + frids + '"的数据项？').then(function () {
        return delManyFruit(frids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('design/manyFruit/export', {
        ...this.queryParams
      }, `manyFruit_${new Date().getTime()}.xlsx`)
    },
    /** 导出pdf操作 */
    handleExportPdfMany() {
      debugger
      const idsAll = {ids1: JSON.stringify(this.ids), ids2: JSON.stringify(this.ids2)};
      this.download('design/manyFruit/handleExportPdfMany', idsAll, `manyFruit_${new Date().getTime()}.pdf`)
    }
  }
};
</script>
