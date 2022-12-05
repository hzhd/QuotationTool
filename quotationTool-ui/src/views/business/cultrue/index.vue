<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      size="small"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <!-- <el-form-item label="文化咨询标题" prop="culTitle">
        <el-input
          v-model="queryParams.culTitle"
          placeholder="请输入文化咨询标题"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="资讯名称" prop="culName">
        <el-input
          v-model="queryParams.culName"
          placeholder="请输入资讯名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资讯内容" prop="culMsg">
        <el-input
          v-model="queryParams.culMsg"
          placeholder="请输入资讯内容"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入库时间">
        <el-date-picker
          v-model="daterangeCreateTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['business:cultrue:add']"
          >新增</el-button
        >
      </el-col>
      <!-- <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['business:cultrue:edit']"
          >修改</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['business:cultrue:remove']"
          >删除</el-button
        >
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['business:cultrue:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="cultrueList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="主键" align="center" prop="id" /> -->
      <!-- <el-table-column label="文化咨询标题" align="center" prop="culTitle" /> -->
      <!-- <el-table-column label="文化咨询时间" align="center" prop="culTime" /> -->
      <el-table-column label="图文化资讯名称" align="center" prop="culName" />
      <el-table-column label="文化资讯内容" align="center" prop="culMsg" />
      <el-table-column label="文化资讯链接" align="center" prop="culUrl" />
      <el-table-column label="归属场馆" align="center" prop="culAddr" />
      <el-table-column label="入库时间" align="center" prop="createTime" />
      <!-- <el-table-column label="状态" align="center" prop="delStatus" /> -->
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['business:cultrue:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:cultrue:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改文化咨询库对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="50%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!-- <el-form-item label="文化咨询标题" prop="culTitle">
          <el-input v-model="form.culTitle" placeholder="请输入文化咨询标题" />
        </el-form-item>
        <el-form-item label="文化咨询时间" prop="culTime">
          <el-input v-model="form.culTime" placeholder="请输入文化咨询时间" />
        </el-form-item> -->
        <el-form-item label="图文化资讯名称" prop="culName">
          <el-input v-model="form.culName" placeholder="请输入图文化资讯名称" />
        </el-form-item>
        <el-form-item label="文化资讯内容" prop="culMsg">
          <el-input v-model="form.culMsg" placeholder="请输入文化资讯内容" />
        </el-form-item>
        <el-form-item label="文化资讯链接" prop="culUrl">
          <el-input v-model="form.culUrl" placeholder="请输入文化资讯链接" />
        </el-form-item>
        <el-form-item label="归属场馆" prop="culAddr">
          <el-input v-model="form.culAddr" placeholder="请输入归属场馆" />
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
import {
  listCultrue,
  getCultrue,
  delCultrue,
  addCultrue,
  updateCultrue,
} from "@/api/business/cultrue";

export default {
  name: "Cultrue",
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
      // 文化咨询库表格数据
      cultrueList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 状态时间范围
      daterangeCreateTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        culTitle: null,
        culTime: null,
        culName: null,
        culMsg: null,
        culUrl: null,
        culAddr: null,
        createTime: null,
        delStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询文化咨询库列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeCreateTime && "" != this.daterangeCreateTime) {
        this.queryParams.params["beginCreateTime"] =
          this.daterangeCreateTime[0];
        this.queryParams.params["endCreateTime"] = this.daterangeCreateTime[1];
      }
      listCultrue(this.queryParams).then((response) => {
        this.cultrueList = response.rows;
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
        id: null,
        culTitle: null,
        culTime: null,
        culName: null,
        culMsg: null,
        culUrl: null,
        culAddr: null,
        createTime: null,
        updateTime: null,
        delStatus: "0",
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.daterangeCreateTime = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加文化咨询库";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getCultrue(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改文化咨询库";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updateCultrue(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCultrue(this.form).then((response) => {
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
      const ids = row.id || this.ids;
      this.$modal
        .confirm('是否确认删除文化咨询库编号为"' + ids + '"的数据项？')
        .then(function () {
          return delCultrue(ids);
        })
        .then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        })
        .catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download(
        "business/cultrue/export",
        {
          ...this.queryParams,
        },
        `cultrue_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
