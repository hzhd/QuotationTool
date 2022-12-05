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
      <el-form-item label="电影名称" prop="movieName">
        <el-input
          v-model="queryParams.movieName"
          placeholder="请输入电影名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="电影类型" prop="movieType">
        <el-select
          v-model="queryParams.movieType"
          placeholder="请选择电影类型"
          clearable
        >
          <el-option
            v-for="dict in dict.type.movie_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="归属场馆" prop="guishuAddr">
        <el-input
          v-model="queryParams.guishuAddr"
          placeholder="请输入电影归属场馆"
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
          v-hasPermi="['business:viewing:add']"
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
          v-hasPermi="['business:viewing:edit']"
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
          v-hasPermi="['business:viewing:remove']"
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
          v-hasPermi="['business:viewing:export']"
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
      :data="viewingList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="主键" align="center" prop="id" /> -->
      <el-table-column label="电影名称" align="center" prop="movieName" />
      <el-table-column label="电影类型" align="center" prop="movieType">
        <template slot-scope="scope">
          <dict-tag
            :options="dict.type.movie_type"
            :value="scope.row.movieType"
          />
        </template>
      </el-table-column>
      <!-- <el-table-column label="电影介绍" align="center" prop="movieJieshao" /> -->
      <el-table-column
        label="电影图片"
        align="center"
        prop="movieMsg"
        width="100"
      >
        <template slot-scope="scope">
          <image-preview :src="scope.row.movieMsg" :width="50" :height="50" />
        </template>
      </el-table-column>
      <!-- <el-table-column label="观影人数" align="center" prop="viewingNo" />
      <el-table-column label="观影热度" align="center" prop="viewingHot" /> -->
      <el-table-column label="放映时间" align="center" prop="time" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.time, "{y}-{m}-{d}") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="放映地点" align="center" prop="site" />

      <el-table-column label="电影片段" align="center" prop="moviePianduan">
        <template slot-scope="scope">
          <img
            v-if="scope.row.moviePianduan"
            src="../../../assets/images/video.png"
            @click="voicePlay(scope.row.moviePianduan)"
            style="width: 45px; height: 35px"
          />
          <div v-if="!scope.row.moviePianduan">暂无数据</div>
        </template>
      </el-table-column>

      <el-table-column
        label="温馨提示"
        align="center"
        prop="tishi"
        :show-overflow-tooltip="true"
      />
      <el-table-column label="最大观影人数" align="center" prop="maxPeople" />
      <el-table-column label="归属场馆" align="center" prop="guishuAddr" />
      <el-table-column label="入库时间" align="center" prop="createTime" />
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
            v-hasPermi="['business:viewing:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:viewing:remove']"
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

    <!-- 添加或修改电影统计对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="50%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="电影名称" prop="movieName">
          <el-input v-model="form.movieName" placeholder="请输入电影名称" />
        </el-form-item>
        <el-form-item label="电影介绍">
          <editor v-model="form.movieJieshao" :min-height="192" />
        </el-form-item>
        <el-form-item label="电影类型" prop="movieType">
          <el-select v-model="form.movieType" placeholder="请选择电影类型">
            <el-option
              v-for="dict in dict.type.movie_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="电影图片">
          <image-upload v-model="form.movieMsg" />
        </el-form-item>
        <el-form-item label="观影人数" prop="viewingNo">
          <el-input v-model="form.viewingNo" placeholder="请输入观影人数" />
        </el-form-item>
        <el-form-item label="观影热度" prop="viewingHot">
          <el-input v-model="form.viewingHot" placeholder="请输入观影热度" />
        </el-form-item>
        <el-form-item label="放映时间" prop="time">
          <el-date-picker
            clearable
            v-model="form.time"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择放映时间"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="放映地点" prop="site">
          <el-input v-model="form.site" placeholder="请输入放映地点" />
        </el-form-item>
        <el-form-item label="电影片段">
          <file-upload v-model="form.moviePianduan" />
        </el-form-item>
        <el-form-item label="温馨提示" prop="tishi">
          <el-input v-model="form.tishi" placeholder="请输入温馨提示" />
        </el-form-item>
        <el-form-item label="最大观影人数" prop="maxPeople">
          <el-input v-model="form.maxPeople" placeholder="请输入最大观影人数" />
        </el-form-item>
        <el-form-item label="电影归属场馆" prop="guishuAddr">
          <el-input
            v-model="form.guishuAddr"
            placeholder="请输入电影归属场馆"
          />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <el-dialog title="电影片段" :visible.sync="openVideo" append-to-body>
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
  listViewing,
  getViewing,
  delViewing,
  addViewing,
  updateViewing,
} from "@/api/business/viewing";

export default {
  name: "Viewing",
  dicts: ["movie_type"],
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
      // 电影统计表格数据
      viewingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 电影类型时间范围
      daterangeTime: [],
      // 电影类型时间范围
      daterangeCreateTime: [],
      // 视频弹出层
      openVideo: false,
      // 视频弹出层的视频地址
      openVideoSrc: "",
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        movieName: null,
        movieJieshao: null,
        movieMsg: null,
        viewingNo: null,
        viewingHot: null,
        time: null,
        site: null,
        delStatus: null,
        moviePianduan: null,
        tishi: null,
        maxPeople: null,
        guishuAddr: null,
        movieType: null,
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
    /** 查询电影统计列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeTime && "" != this.daterangeTime) {
        this.queryParams.params["beginTime"] = this.daterangeTime[0];
        this.queryParams.params["endTime"] = this.daterangeTime[1];
      }
      if (null != this.daterangeCreateTime && "" != this.daterangeCreateTime) {
        this.queryParams.params["beginCreateTime"] =
          this.daterangeCreateTime[0];
        this.queryParams.params["endCreateTime"] = this.daterangeCreateTime[1];
      }
      listViewing(this.queryParams).then((response) => {
        this.viewingList = response.rows;
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
        movieName: null,
        movieJieshao: null,
        movieMsg: null,
        viewingNo: null,
        viewingHot: null,
        time: null,
        site: null,
        delStatus: "0",
        moviePianduan: null,
        tishi: null,
        maxPeople: null,
        guishuAddr: null,
        movieType: null,
        createTime: null,
        updateTime: null,
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
      this.daterangeTime = [];
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
      this.title = "添加电影统计";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getViewing(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改电影统计";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updateViewing(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addViewing(this.form).then((response) => {
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
        .confirm('是否确认删除电影统计编号为"' + ids + '"的数据项？')
        .then(function () {
          return delViewing(ids);
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
        "business/viewing/export",
        {
          ...this.queryParams,
        },
        `viewing_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
