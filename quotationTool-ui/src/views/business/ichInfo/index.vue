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
      <el-form-item label="项目名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入项目名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="项目标签" prop="projectLabel">
        <el-input
          v-model="queryParams.projectLabel"
          placeholder="请输入项目标签"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="归属场馆" prop="attrSite">
        <el-input
          v-model="queryParams.attrSite"
          placeholder="请输入归属场馆"
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
          v-hasPermi="['business:ichInfo:add']"
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
          v-hasPermi="['business:ichInfo:edit']"
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
          v-hasPermi="['business:ichInfo:remove']"
          >删除</el-button
        >
      </el-col>
      <!-- <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['business:ichInfo:export']"
          >导出</el-button
        >
      </el-col> -->
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="ichInfoList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
       <el-table-column type="index" width="55" label="序号" align="center" />
      <el-table-column label="名称" align="center" prop="projectName" />
      <!-- <el-table-column
        label="产品内容"
        align="center"
        show-overflow-tooltip="true"
        prop="projectContent"
      /> -->
      <!-- <el-table-column
        label="项目介绍语音"
        align="center"
        prop="projectVoice">

        <template slot-scope="scope">
          <img
            v-if="scope.row.projectVoice"
            src="../../../assets/images/yuyin.png"
            @click="voicePlay(scope.row)"
            style="width: 45px; height: 35px;"
          />
          <div v-if="!scope.row.projectVoice">暂无数据</div>
        </template>
      </el-table-column> -->
      <el-table-column
        label="项目图片"
        align="center"
        prop="projectMsg"
        width="100"
      >
        <template slot-scope="scope">
          <image-preview
            :src="scope.row.projectMsg"
            :width="100"
            :height="100"
          />
        </template>
      </el-table-column>
      <el-table-column label="项目介绍视频" align="center" prop="projectVodeo">
        <template slot-scope="scope">
          <img
            v-if="scope.row.projectVodeo"
            src="../../../assets/images/video.png"
            @click="voicePlay(scope.row.projectVodeo)"
            style="width: 45px; height: 35px"
          />
          <div v-if="!scope.row.projectVodeo">暂无数据</div>
        </template>
      </el-table-column>
      <el-table-column label="项目标签" align="center" prop="projectLabel" />
      <el-table-column label="归属场馆" align="center" prop="attrSite" />
      <!-- <el-table-column
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
            v-hasPermi="['business:ichInfo:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:ichInfo:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column> -->
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改非遗库数据维护对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="50%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入项目名称" />
        </el-form-item>
        <el-form-item label="项目内容">
          <editor v-model="form.projectContent" :min-height="192" />
        </el-form-item>
        <el-form-item label="项目介绍语音">
          <file-upload v-model="form.projectVoice" />
        </el-form-item>
        <el-form-item label="项目图片">
          <image-upload v-model="form.projectMsg" />
        </el-form-item>
        <el-form-item label="项目介绍视频">
          <file-upload v-model="form.projectVodeo" />
        </el-form-item>
        <el-form-item label="项目标签" prop="projectLabel">
          <el-input v-model="form.projectLabel" placeholder="请输入项目标签" />
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
  listIchInfo,
  getIchInfo,
  delIchInfo,
  addIchInfo,
  updateIchInfo,
} from "@/api/business/ichInfo";

export default {
  name: "IchInfo",
  data() {
    return {
      // 文件地址前缀
      httpSrc: process.env.VUE_APP_BASE_API,
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
      // 非遗库数据维护表格数据
      ichInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 语音弹出层
      openAudio: false,
      // 语音弹出层的视频地址
      openAudioSrc: "",
      // 视频弹出层
      openVideo: false,
      // 视频弹出层的视频地址
      openVideoSrc: "",
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectName: null,
        projectContent: null,
        projectVoice: null,
        projectMsg: null,
        projectVodeo: null,
        projectLabel: null,
        attrSite: null,
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
    voicePlay(data) {
      this.openVideo = true;
      this.openVideoSrc = data;
    },
    /** 查询非遗库数据维护列表 */
    getList() {
      this.loading = true;
      listIchInfo(this.queryParams).then((response) => {
        this.ichInfoList = response.rows;
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
        ichId: null,
        projectName: null,
        projectContent: null,
        projectVoice: null,
        projectMsg: null,
        projectVodeo: null,
        projectLabel: null,
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
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map((item) => item.ichId);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加非遗库数据维护";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const ichId = row.ichId || this.ids;
      getIchInfo(ichId).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改非遗库数据维护";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.ichId != null) {
            updateIchInfo(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addIchInfo(this.form).then((response) => {
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
      const ichIds = row.ichId || this.ids;
      this.$modal
        .confirm('是否确认删除非遗库数据维护编号为"' + ichIds + '"的数据项？')
        .then(function () {
          return delIchInfo(ichIds);
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
        "business/ichInfo/export",
        {
          ...this.queryParams,
        },
        `ichInfo_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
