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
      <el-form-item label="场地名称" prop="siteName">
        <el-input
          v-model="queryParams.siteName"
          placeholder="请输入场地名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="peopleList"
      @selection-change="handleSelectionChange"
    >
      <!-- <el-table-column type="selection" width="55" align="center" /> -->
      <!-- <el-table-column label="主键" align="center" prop="id" /> -->
      <el-table-column type="index" width="55" label="序号" align="center" />
      <el-table-column label="场地名称" align="center" prop="siteName" />
      <el-table-column label="进入人数(日)" align="center" prop="inPeopleDay" />
      <el-table-column
        label="出入人数(日)"
        align="center"
        prop="outPeopleDay"
      />
      <el-table-column
        label="进入人数(周)"
        align="center"
        prop="inPeopleWeek"
      />
      <el-table-column
        label="出入人数(周)"
        align="center"
        prop="outPeopleWeek"
      />
      <el-table-column
        label="进入人数(月)"
        align="center"
        prop="inPeopleMonth"
      />
      <el-table-column
        label="出入人数(月)"
        align="center"
        prop="outPeopleMonth"
      />
      <el-table-column
        label="进入人数(年)"
        align="center"
        prop="inPeopleYear"
      />
      <el-table-column
        label="出入人数(年)"
        align="center"
        prop="outPeopleYear"
      />
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
            v-hasPermi="['business:people:edit']"
            >修改</el-button
          >
          <!-- <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:people:remove']"
            >删除</el-button
          > -->
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

    <!-- 添加或修改进出人数统计对话框 -->
    <el-dialog
      :title="title"
      :visible.sync="open"
      width="1000px"
      append-to-body
    >
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="场地名称" prop="siteName">
          <el-input v-model="form.siteName" placeholder="请输入场地名称" />
        </el-form-item>
        <el-form-item label="日进入人数" prop="inPeopleDay">
          <el-input v-model="form.inPeopleDay" placeholder="请输入日进入人数" />
        </el-form-item>
        <el-form-item label="日出入人数" prop="outPeopleDay">
          <el-input
            v-model="form.outPeopleDay"
            placeholder="请输入日出入人数"
          />
        </el-form-item>
        <el-form-item label="周进入人数" prop="inPeopleWeek">
          <el-input
            v-model="form.inPeopleWeek"
            placeholder="请输入周进入人数"
          />
        </el-form-item>
        <el-form-item label="周出入人数" prop="outPeopleWeek">
          <el-input
            v-model="form.outPeopleWeek"
            placeholder="请输入周出入人数"
          />
        </el-form-item>
        <el-form-item label="月进入人数" prop="inPeopleMonth">
          <el-input
            v-model="form.inPeopleMonth"
            placeholder="请输入月进入人数"
          />
        </el-form-item>
        <el-form-item label="月出入人数" prop="outPeopleMonth">
          <el-input
            v-model="form.outPeopleMonth"
            placeholder="请输入月出入人数"
          />
        </el-form-item>
        <el-form-item label="年进入人数" prop="inPeopleYear">
          <el-input
            v-model="form.inPeopleYear"
            placeholder="请输入年进入人数"
          />
        </el-form-item>
        <el-form-item label="年出入人数" prop="outPeopleYear">
          <el-input
            v-model="form.outPeopleYear"
            placeholder="请输入年出入人数"
          />
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
  listPeople,
  getPeople,
  delPeople,
  addPeople,
  updatePeople,
} from "@/api/business/people";

export default {
  name: "People",
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
      // 进出人数统计表格数据
      peopleList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        siteName: null,
        inPeopleDay: null,
        outPeopleDay: null,
        inPeopleWeek: null,
        outPeopleWeek: null,
        inPeopleMonth: null,
        outPeopleMonth: null,
        inPeopleYear: null,
        outPeopleYear: null,
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
    /** 查询进出人数统计列表 */
    getList() {
      this.loading = true;
      listPeople(this.queryParams).then((response) => {
        this.peopleList = response.rows;
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
        siteName: null,
        inPeopleDay: null,
        outPeopleDay: null,
        inPeopleWeek: null,
        outPeopleWeek: null,
        inPeopleMonth: null,
        outPeopleMonth: null,
        inPeopleYear: null,
        outPeopleYear: null,
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
      this.title = "添加进出人数统计";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getPeople(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改进出人数统计";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updatePeople(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPeople(this.form).then((response) => {
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
        .confirm('是否确认删除进出人数统计编号为"' + ids + '"的数据项？')
        .then(function () {
          return delPeople(ids);
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
        "business/people/export",
        {
          ...this.queryParams,
        },
        `people_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
