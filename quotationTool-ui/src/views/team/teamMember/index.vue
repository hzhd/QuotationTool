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
      <el-form-item label="团员性别" prop="memberSex">
        <el-select
          v-model="queryParams.memberSex"
          placeholder="请选择团员性别"
          clearable
        >
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="入团时间">
        <el-date-picker
          v-model="daterangeJoinTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="联系电话" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入联系电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电子邮箱" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入电子邮箱"
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
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['team:teamMember:add']"
          >新增</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['team:teamMember:edit']"
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
          v-hasPermi="['team:teamMember:remove']"
          >删除</el-button
        >
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['team:teamMember:export']"
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
      :data="teamMemberList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="团员姓名" align="center" prop="memberName" />
      <el-table-column label="团员性别" align="center" prop="memberSex">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.sys_user_sex"
            :value="scope.row.memberSex"
          />
        </template>
      </el-table-column>
      <el-table-column
        label="照片"
        align="center"
        prop="memberPicture"
        width="100"
      >
        <template slot-scope="scope">
          <image-preview
            :src="scope.row.memberPicture"
            :width="50"
            :height="50"
          />
        </template>
      </el-table-column>
      <el-table-column label="归属团队" align="center" prop="teamId" />
      <el-table-column
        label="入团时间"
        align="center"
        prop="joinTime"
        width="180"
      >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.joinTime, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="联系电话" align="center" prop="phone" />
      <el-table-column label="电子邮箱" align="center" prop="email" />
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
            v-hasPermi="['team:teamMember:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['team:teamMember:remove']"
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

    <!-- 添加或修改团队成员对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="团员性别,1=男 2=女" prop="memberSex">
          <el-select
            v-model="form.memberSex"
            placeholder="请选择团员性别,1=男 2=女"
          >
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="照片">
          <image-upload v-model="form.memberPicture" />
        </el-form-item>
        <el-form-item label="入团时间" prop="joinTime">
          <el-date-picker
            clearable
            v-model="form.joinTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入团时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="联系电话" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="电子邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入电子邮箱" />
        </el-form-item>
        <el-form-item label="新增记录的操作员ID" prop="creatorId">
          <el-input
            v-model="form.creatorId"
            placeholder="请输入新增记录的操作员ID"
          />
        </el-form-item>
        <el-form-item label="修改记录的操作员ID" prop="updatorId">
          <el-input
            v-model="form.updatorId"
            placeholder="请输入修改记录的操作员ID"
          />
        </el-form-item>
        <el-form-item label="逻辑删除标记,0:未删除 1:已删除" prop="delTag">
          <el-input
            v-model="form.delTag"
            placeholder="请输入逻辑删除标记,0:未删除 1:已删除"
          />
        </el-form-item>
        <el-form-item label="记录版本号" prop="recVersion">
          <el-input v-model="form.recVersion" placeholder="请输入记录版本号" />
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
  listTeamMember,
  getTeamMember,
  delTeamMember,
  addTeamMember,
  updateTeamMember,
} from "@/api/team/teamMember";

export default {
  name: "TeamMember",
  dicts: ["sys_user_sex"],
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
      // 团队成员表格数据
      teamMemberList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 记录版本号时间范围
      daterangeJoinTime: [],
      // 记录版本号时间范围
      daterangeCreateTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        memberName: null,
        memberSex: null,
        memberPicture: null,
        teamId: null,
        joinTime: null,
        phone: null,
        email: null,
        creatorId: null,
        updatorId: null,
        delTag: null,
        recVersion: null,
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
    /** 查询团队成员列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeJoinTime && "" != this.daterangeJoinTime) {
        this.queryParams.params["beginJoinTime"] = this.daterangeJoinTime[0];
        this.queryParams.params["endJoinTime"] = this.daterangeJoinTime[1];
      }
      if (null != this.daterangeCreateTime && "" != this.daterangeCreateTime) {
        this.queryParams.params["beginCreateTime"] =
          this.daterangeCreateTime[0];
        this.queryParams.params["endCreateTime"] = this.daterangeCreateTime[1];
      }
      listTeamMember(this.queryParams).then((response) => {
        this.teamMemberList = response.rows;
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
        memberName: null,
        memberSex: null,
        memberPicture: null,
        teamId: null,
        joinTime: null,
        phone: null,
        email: null,
        creatorId: null,
        createBy: null,
        createTime: null,
        updatorId: null,
        updateBy: null,
        updateTime: null,
        delTag: null,
        recVersion: null,
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
      this.daterangeJoinTime = [];
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
      this.title = "添加团队成员";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getTeamMember(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改团队成员";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updateTeamMember(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTeamMember(this.form).then((response) => {
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
        .confirm('是否确认删除团队成员编号为"' + ids + '"的数据项？')
        .then(function () {
          return delTeamMember(ids);
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
        "team/teamMember/export",
        {
          ...this.queryParams,
        },
        `teamMember_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
