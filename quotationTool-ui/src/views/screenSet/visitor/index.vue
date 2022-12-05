<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="直播标题" prop="zbTitle">
        <el-input v-model="queryParams.zbTitle" placeholder="请输入直播标题" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <!-- <el-form-item label="直播时间" prop="zbTime">
        <el-date-picker clearable
          v-model="queryParams.zbTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择直播时间">
        </el-date-picker>
      </el-form-item> -->
      <!-- <el-form-item label="直播人数" prop="zbCount">
        <el-input
          v-model="queryParams.zbCount"
          placeholder="请输入直播人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="资讯标题" prop="zxTitle">
        <el-input v-model="queryParams.zxTitle" placeholder="请输入资讯标题" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <!-- <el-form-item label="资讯时间" prop="zxTime">
        <el-date-picker clearable
          v-model="queryParams.zxTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择资讯时间">
        </el-date-picker>
      </el-form-item> -->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
          v-hasPermi="['screenSet:visitor:add']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['screenSet:visitor:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['screenSet:visitor:remove']">删除</el-button>
      </el-col>
      <!-- <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['screenSet:visitor:export']"
        >导出</el-button>
      </el-col> -->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="visitorList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column type="index" width="55" label="序号" align="center" />
      <!-- <el-table-column label="主键id" align="center" prop="id" /> -->
      <el-table-column label="视频" align="center" prop="video" show-overflow-tooltip >
          <template slot-scope="scope">
          <img
            v-if="scope.row.video"
            src="../../../assets/images/video.png"
            @click="voicePlay(scope.row.video)"
            style="width: 45px; height: 35px;"
          />
          <div v-if="!scope.row.video">暂无数据</div>
        </template>
      </el-table-column>
      <el-table-column label="直播照片" align="center" prop="zbImage" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.zbImage" :width="50" :height="50" />
        </template>
      </el-table-column>
      <el-table-column label="直播标题" align="center" prop="zbTitle" show-overflow-tooltip />
      <!-- <el-table-column label="直播时间" align="center" prop="zbTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.zbTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column> -->
      <el-table-column label="直播时间" align="center" prop="zbTime" width="180" />
      <el-table-column label="直播人数" align="center" prop="zbCount" />
      <!-- <el-table-column label="资讯图片" align="center" prop="zxImage" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.zxImage" :width="50" :height="50" />
        </template>
      </el-table-column>
      <el-table-column label="资讯标题" align="center" prop="zxTitle" show-overflow-tooltip />
      <el-table-column label="资讯时间" align="center" prop="zxTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.zxTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column> -->
      <!-- <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['screenSet:visitor:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['screenSet:visitor:remove']"
          >删除</el-button>
        </template>
      </el-table-column> -->
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改游客大屏配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="50%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="视频">
          <file-upload v-model="form.video" />
        </el-form-item>
        <el-form-item label="直播照片">
          <image-upload v-model="form.zbImage" />
        </el-form-item>
        <el-form-item label="直播标题" prop="zbTitle">
          <el-input v-model="form.zbTitle" placeholder="请输入直播标题" />
        </el-form-item>
        <!-- <el-form-item label="直播时间" prop="zbTime">
          <el-date-picker clearable v-model="form.zbTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="请选择直播时间">
          </el-date-picker>
        </el-form-item> -->
        <el-form-item label="直播时间" prop="zbTime">
          <el-input v-model="form.zbTime" placeholder="请输入直播时间" />
        </el-form-item>
        <el-form-item label="直播人数" prop="zbCount">
          <el-input v-model="form.zbCount" placeholder="请输入直播人数" />
        </el-form-item>
        <!-- <el-form-item label="资讯图片">
          <image-upload v-model="form.zxImage" />
        </el-form-item>
        <el-form-item label="资讯标题" prop="zxTitle">
          <el-input v-model="form.zxTitle" placeholder="请输入资讯标题" />
        </el-form-item>
        <el-form-item label="资讯时间" prop="zxTime">
          <el-date-picker clearable v-model="form.zxTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="请选择资讯时间">
          </el-date-picker>
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <el-dialog title="视频" :visible.sync="openVideo" append-to-body>
      <video width="100%" height="30%" v-if="openVideo" :src="httpSrc + openVideoSrc" controls></video>
    </el-dialog>
  </div>
</template>

<script>
import { listVisitor, getVisitor, delVisitor, addVisitor, updateVisitor } from "@/api/screenSet/visitor";

export default {
  name: "Visitor",
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
      // 游客大屏配置表格数据
      visitorList: [],
      // 弹出层标题
      title: "",
      // 视频弹出层
      openVideo: false,
      // 视频弹出层的视频地址
      openVideoSrc: '',
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        video: null,
        zbImage: null,
        zbTitle: null,
        zbTime: null,
        zbCount: null,
        zxImage: null,
        zxTitle: null,
        zxTime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        // video: [
        //   { required: true, message: "视频不能为空", trigger: "blur" }
        // ],
        // zbImage: [
        //   { required: true, message: "直播照片不能为空", trigger: "blur" }
        // ],
        zbTitle: [
          { required: true, message: "直播标题不能为空", trigger: "blur" }
        ],
        // zbTime: [
        //   { required: true, message: "直播时间不能为空", trigger: "blur" }
        // ],
        // zbCount: [
        //   { required: true, message: "直播人数不能为空", trigger: "blur" }
        // ],
        // zxImage: [
        //   { required: true, message: "资讯图片不能为空", trigger: "blur" }
        // ],
        zxTitle: [
          { required: true, message: "资讯标题不能为空", trigger: "blur" }
        ],
        zxTime: [
          { required: true, message: "资讯时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    voicePlay(data) {
      this.openVideo = true
      this.openVideoSrc = data
    },
    /** 查询游客大屏配置列表 */
    getList() {
      this.loading = true;
      listVisitor(this.queryParams).then(response => {
        this.visitorList = response.rows;
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
        video: null,
        zbImage: null,
        zbTitle: null,
        zbTime: null,
        zbCount: null,
        zxImage: null,
        zxTitle: null,
        zxTime: null
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加游客大屏配置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getVisitor(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改游客大屏配置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateVisitor(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addVisitor(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除游客大屏配置编号为"' + ids + '"的数据项？').then(function () {
        return delVisitor(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('screenSet/visitor/export', {
        ...this.queryParams
      }, `visitor_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
