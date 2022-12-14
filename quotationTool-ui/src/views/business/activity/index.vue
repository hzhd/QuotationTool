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
      <el-form-item label="活动名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入活动名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动类型" prop="activityType">
        <el-select
          v-model="queryParams.activityType"
          placeholder="请选择活动类型"
          clearable
        >
          <el-option
            v-for="dict in dict.type.activity_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="归属场馆" prop="attrSite">
        <el-input
          v-model="queryParams.attrSite"
          placeholder="请输入归属场馆"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动状态" prop="activityType">
        <el-input
          v-model="queryParams.activityType"
          placeholder="请输入活动状态"
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
          v-hasPermi="['business:activity:add']"
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
          v-hasPermi="['business:activity:edit']"
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
          v-hasPermi="['business:activity:remove']"
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
          v-hasPermi="['business:activity:export']"
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
      :data="activityList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="activityId" />
      <el-table-column label="活动名称" align="center" prop="name" />
      <el-table-column label="活动类型" align="center" prop="activityType">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.activity_type"
            :value="scope.row.activityType"
          />
        </template>
      </el-table-column>
      <el-table-column
        label="图片"
        align="center"
        prop="activityImg"
        width="100"
      >
        <template slot-scope="scope">
          <image-preview
            :src="scope.row.activityImg"
            :width="50"
            :height="50"
          />
        </template>
      </el-table-column>
      <el-table-column
        label="活动详情"
        align="center"
        show-overflow-tooltip="true"
        prop="activityDetails"
      />
      <el-table-column
        label="活动介绍视频"
        align="center"
        prop="activityVideo"
      />
      <el-table-column label="活动地址" align="center" prop="activityAddr" />
      <el-table-column
        label="活动承办方"
        align="center"
        prop="activityContractor"
      />
      <el-table-column
        label="活动周期"
        align="center"
        show-overflow-tooltip="true"
        prop="period"
      />
      <el-table-column label="温馨提示" align="center" prop="hint" />
      <el-table-column
        label="活动最大参与人数"
        align="center"
        prop="maxPeople"
      />
      <el-table-column label="活动状态" align="center" prop="activityType" />
      <el-table-column label="归属场馆" align="center" prop="attrSite" />
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
            v-hasPermi="['business:activity:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:activity:remove']"
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

    <!-- 添加或修改活动库数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="50%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="活动名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入活动名称" />
        </el-form-item>
        <el-form-item label="活动类型" prop="activityType">
          <el-select v-model="form.activityType" placeholder="请选择活动类型">
            <el-option
              v-for="dict in dict.type.activity_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="图片">
          <image-upload v-model="form.activityImg" />
        </el-form-item>

        <el-form-item label="活动详情">
          <editor v-model="form.activityDetails" :min-height="192" />
        </el-form-item>
        <el-form-item label="活动介绍视频">
          <file-upload v-model="form.activityVideo" />
        </el-form-item>
        <el-form-item label="活动地址" prop="activityAddr">
          <el-input v-model="form.activityAddr" placeholder="请输入活动地址" />
        </el-form-item>
        <el-form-item label="活动承办方" prop="activityContractor">
          <el-input
            v-model="form.activityContractor"
            placeholder="请输入活动承办方"
          />
        </el-form-item>
        <el-form-item label="活动周期" prop="period">
          <el-input v-model="form.period" placeholder="请输入活动周期" />
        </el-form-item>
        <el-form-item label="温馨提示" prop="hint">
          <el-input v-model="form.hint" placeholder="请输入温馨提示" />
        </el-form-item>
        <el-form-item label="活动最大参与人数" prop="maxPeople">
          <el-input
            v-model="form.maxPeople"
            placeholder="请输入活动最大参与人数"
          />
        </el-form-item>
        <el-form-item label="归属场馆" prop="attrSite">
          <el-input v-model="form.attrSite" placeholder="请输入归属场馆" />
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
  listActivity,
  getActivity,
  delActivity,
  addActivity,
  updateActivity,
} from "@/api/business/activity";

export default {
  name: "Activity",
  dicts: ["activity_type"],
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
      // 活动库数据表格数据
      activityList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 逻辑删除  0删除  1存在时间范围
      daterangeCreateTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        activityImg: null,
        activityDetails: null,
        activityVideo: null,
        activityAddr: null,
        activityContractor: null,
        period: null,
        hint: null,
        maxPeople: null,
        activityType: null,
        attrSite: null,
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
    /** 查询活动库数据列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeCreateTime && "" != this.daterangeCreateTime) {
        this.queryParams.params["beginCreateTime"] =
          this.daterangeCreateTime[0];
        this.queryParams.params["endCreateTime"] = this.daterangeCreateTime[1];
      }
      listActivity(this.queryParams).then((response) => {
        this.activityList = response.rows;
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
        activityId: null,
        name: null,
        activityImg: null,
        activityDetails: null,
        activityVideo: null,
        activityAddr: null,
        activityContractor: null,
        period: null,
        hint: null,
        maxPeople: null,
        activityType: null,
        attrSite: null,
        createTime: null,
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
      this.ids = selection.map((item) => item.activityId);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加活动库数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const activityId = row.activityId || this.ids;
      getActivity(activityId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改活动库数据";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.activityId != null) {
            updateActivity(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addActivity(this.form).then((response) => {
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
      const activityIds = row.activityId || this.ids;
      this.$modal
        .confirm('是否确认删除活动库数据编号为"' + activityIds + '"的数据项？')
        .then(function () {
          return delActivity(activityIds);
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
        "business/activity/export",
        {
          ...this.queryParams,
        },
        `activity_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
