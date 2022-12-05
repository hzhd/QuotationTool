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
      <el-form-item label="团队名称" prop="teamName">
        <el-input
          v-model="queryParams.teamName"
          placeholder="请输入团队名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="团队类型" prop="teamType">
        <el-select
          v-model="queryParams.teamType"
          placeholder="请选择团队类型"
          clearable
          collapse-tags
        >
          <el-option
            v-for="dict in dict.type.team_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="团队名称" prop="teamName">
        <el-input
          v-model="queryParams.teamName"
          placeholder="请输入团队名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
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
          v-hasPermi="['team:team:add']"
          >新增</el-button
        >
      </el-col>

      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['team:team:export']"
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
      :data="teamList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="记录主键" align="center" prop="id" />
      <el-table-column label="团队名称" align="center" prop="teamName" />
      <!-- <el-table-column label="团队类型" align="center" prop="teamType">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.team_type"
            :value="scope.row.teamType.split(',')"
          />
        </template>
      </el-table-column> -->
      <el-table-column label="团队类型" align="center" prop="teamTypeLabel" />
      <!-- <el-table-column
        label="团队介绍"
        align="center"
        prop="teamIntro"
        :show-overflow-tooltip="true"
      >
        <template slot-scope="scope">
          <div v-html="scope.row.teamIntro" style="height: 200px"></div>
        </template>
      </el-table-column> -->
      <el-table-column
        label="团队图片"
        align="center"
        prop="teamPic"
        width="100"
      >
        <template slot-scope="scope">
          <image-preview :src="scope.row.teamPic" :width="50" :height="50" />
        </template>
      </el-table-column>
      <el-table-column label="团队视频" align="center" prop="teamVideo">
        <template slot-scope="scope">
          <img
            v-if="scope.row.teamVideo"
            src="../../../assets/images/video.png"
            @click="voicePlay(scope.row.teamVideo)"
            style="width: 45px; height: 35px"
          />
          <div v-if="!scope.row.teamVideo">暂无数据</div>
        </template>
      </el-table-column>
      <!-- <el-table-column
        label="团队风采介绍"
        align="center"
        prop="teamMine"
        :show-overflow-tooltip="true"
      >
        <template slot-scope="scope">
          <div v-html="scope.row.teamMine" style="height: 200px"></div>
        </template>
      </el-table-column> -->
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
            v-hasPermi="['team:team:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['team:team:remove']"
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

    <!-- 添加或修改团队管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="50%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="团队名称" prop="teamName">
          <el-input v-model="form.teamName" placeholder="请输入团队名称" />
        </el-form-item>
        <el-form-item label="团队类型" prop="teamType">
          <el-select
            v-model="form.teamType"
            placeholder="请选择团队类型"
            multiple
            @change="zhuanstr"
          >
            <el-option
              v-for="dict in dict.type.team_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="团队介绍">
          <editor v-model="form.teamIntro" :min-height="192" />
        </el-form-item>
        <el-form-item label="团队图片">
          <image-upload v-model="form.teamPic" />
        </el-form-item>
        <el-form-item label="团队视频">
          <file-upload v-model="form.teamVideo" />
        </el-form-item>
        <el-form-item label="团队风采介绍">
          <editor v-model="form.teamMine" :min-height="192" />
        </el-form-item>
        <el-form-item label="团队风采图片">
          <editor v-model="form.minePic" :min-height="192" />
        </el-form-item>
        <el-form-item label="团队风采视频">
          <editor v-model="form.mineVideo" :min-height="192" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <el-dialog title="项目介绍视频" :visible.sync="openVideo" append-to-body>
      <video
        width="100%"
        height="30%"
        v-if="openVideo"
        :src="httpSrc + openVideoSrc"
        controls
      ></video>
    </el-dialog>
  </div>
</template>

<script>
import {
  listTeam,
  getTeam,
  delTeam,
  addTeam,
  updateTeam,
} from "@/api/team/team";

export default {
  name: "Team",
  dicts: ["team_type"],
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
      // 团队管理表格数据
      teamList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 记录版本号时间范围
      daterangeCreateTime: [],
      // 视频弹出层
      openVideo: false,
      // 视频弹出层的视频地址
      openVideoSrc: "",
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        teamName: null,
        teamType: "",
        teamIntro: null,
        teamPic: null,
        teamVideo: null,
        teamMine: null,
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
    zhuanstr(e) {
      console.log(e.join());
    },
    /**播放视频**/
    voicePlay(data) {
      this.openVideo = true;
      this.openVideoSrc = data;
    },
    /** 查询团队管理列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeCreateTime && "" != this.daterangeCreateTime) {
        this.queryParams.params["beginCreateTime"] =
          this.daterangeCreateTime[0];
        this.queryParams.params["endCreateTime"] = this.daterangeCreateTime[1];
      }
      listTeam(this.queryParams).then((response) => {
        this.teamList = response.rows;
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
        teamName: null,
        teamType: null,
        teamIntro: null,
        teamPic: null,
        teamVideo: null,
        teamMine: null,
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
      this.title = "添加团队管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getTeam(id).then((response) => {
        this.form = response.data;
        this.form.teamType = response.data.teamType.split(",");
        this.open = true;
        this.title = "修改团队管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            this.form.teamType = this.form.teamType.join();
            updateTeam(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            this.form.teamType = this.form.teamType.join();
            addTeam(this.form).then((response) => {
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
        .confirm("确定要删除吗?")
        .then(function () {
          return delTeam(ids);
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
        "team/team/export",
        {
          ...this.queryParams,
        },
        `team_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
