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
      <el-form-item label="图片名称" prop="picName">
        <el-input
          v-model="queryParams.picName"
          placeholder="请输入图片名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- 关联场馆记录 -->
      <el-form-item label="归属场馆" prop="stadiumId">
        <el-select v-model="queryParams.stadiumId" placeholder="请选择活动区域">
          <el-option
            v-for="(item, index) of stadiumList"
            :label="item.stadium_name"
            :value="item.id"
            :key="index"
          ></el-option>
        </el-select>
        <!-- <el-input v-model="form.stadiumLabel" placeholder="请输入归属场馆" /> -->
      </el-form-item>
      <el-form-item label="图片标签" prop="picTag">
        <el-input
          v-model="queryParams.picTag"
          placeholder="请输入图片标签"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间">
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
          v-hasPermi="['media:picture:add']"
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
          v-hasPermi="['media:picture:export']"
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
      :data="pictureList"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="图片名称" align="center" prop="picName" />
      <el-table-column label="图片类型" align="center" prop="picTypeLabel" />
      <el-table-column label="图片标签" align="center" prop="picTag" />
      <el-table-column label="归属场馆" align="center" prop="stadiumLabel" />
      <el-table-column label="图片介绍" align="center" prop="picIntro" />
      <el-table-column
        label="图片路径"
        align="center"
        prop="picPath"
        width="100"
      >
        <template slot-scope="scope">
          <image-preview :src="scope.row.picPath" :width="50" :height="50" />
        </template>
      </el-table-column>
      <el-table-column label="温馨提示" align="center" prop="picTip" />
      <el-table-column label="入库时间" align="center" prop="createTime" />
      <!-- 0=待审核、1=审核中、2=审核未通过、3=待发布、4=已发布 -->
      <el-table-column label="状态" align="center" prop="picStatusLabel" />
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
            v-hasPermi="['media:picture:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['media:picture:remove']"
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

    <!-- 添加或修改图片基本信息库对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="50%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="图片名称" prop="picName">
          <el-input v-model="form.picName" placeholder="请输入图片名称" />
        </el-form-item>
        <el-form-item label="归属场馆" prop="stadiumId">
          <el-select v-model="form.stadiumId" placeholder="请选择归属场馆">
            <el-option
              v-for="(item, index) of stadiumList"
              :label="item.stadium_name"
              :value="item.id"
              :key="index"
            ></el-option>
          </el-select>
          <!-- <el-input v-model="form.stadiumLabel" placeholder="请输入归属场馆" /> -->
        </el-form-item>
        <el-form-item label="图片类型" prop="picType">
          <el-select v-model="form.picType" placeholder="请选择图片类型">
            <el-option
              v-for="(item, index) of picTypeList"
              :label="item.dictLabel"
              :value="item.dictValue"
              :key="index"
            ></el-option>
          </el-select>
          <!-- <el-input v-model="form.stadiumLabel" placeholder="请输入归属场馆" /> -->
        </el-form-item>

        <el-form-item label="图片标签" prop="picTag">
          <el-input v-model="form.picTag" placeholder="请输入图片标签" />
        </el-form-item>
        <el-form-item label="图片介绍" prop="picIntro">
          <el-input
            v-model="form.picIntro"
            type="textarea"
            placeholder="请输入内容"
          />
        </el-form-item>
        <el-form-item label="图片路径">
          <image-upload v-model="form.picPath" />
        </el-form-item>
        <el-form-item label="温馨提示" prop="picTip">
          <el-input
            v-model="form.picTip"
            type="textarea"
            placeholder="请输入内容"
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
  listPicture,
  getPicture,
  delPicture,
  addPicture,
  updatePicture,
  queryStadium,
  queryPicType,
} from "@/api/media/picture";

export default {
  name: "Picture",
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
      // 图片基本信息库表格数据
      pictureList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 记录版本号时间范围
      daterangeCreateTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        picName: null,
        picType: null,
        stadiumId: null,
        picTag: null,
        picIntro: null,
        picPath: null,
        picTip: null,
        picStatus: null,
        creatorId: null,
        createTime: null,
        updatorId: null,
        delTag: null,
        recVersion: null,
      },
      stadiumList: [],
      picTypeList: [],
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        picName: [
          { required: true, message: "图片名称不能为空", trigger: "blur" },
        ],
        picType: [
          { required: true, message: "图片类型不能为空", trigger: "change" },
        ],
        stadiumId: [
          {
            required: true,
            message: "归属场馆，关联场馆记录不能为空",
            trigger: "blur",
          },
        ],
        picPath: [
          { required: true, message: "图片路径不能为空", trigger: "blur" },
        ],
        picStatus: [
          {
            required: true,
            message:
              "图片状态，0=待审核、1=审核中、2=审核未通过、3=待发布、4=已发布不能为空",
            trigger: "blur",
          },
        ],
        creatorId: [
          {
            required: true,
            message: "新增记录的操作员ID不能为空",
            trigger: "blur",
          },
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" },
        ],
        updatorId: [
          {
            required: true,
            message: "修改记录的操作员ID不能为空",
            trigger: "blur",
          },
        ],
        updateTime: [
          { required: true, message: "修改时间不能为空", trigger: "blur" },
        ],
        recVersion: [
          { required: true, message: "记录版本号不能为空", trigger: "blur" },
        ],
      },
    };
  },
  created() {
    this.getStadiumList();
    this.getList();
    this.getQueryPicType();
  },
  methods: {
    /** 查询图片基本信息库列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeCreateTime && "" != this.daterangeCreateTime) {
        this.queryParams.params["beginCreateTime"] =
          this.daterangeCreateTime[0];
        this.queryParams.params["endCreateTime"] = this.daterangeCreateTime[1];
      }
      listPicture(this.queryParams).then((response) => {
        this.pictureList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getStadiumList() {
      queryStadium({}).then((response) => {
        this.stadiumList = response.data;
      });
    },
    getQueryPicType() {
      queryPicType({}).then((response) => {
        this.picTypeList = response.data;
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
        picName: null,
        picType: null,
        stadiumId: null,
        picTag: null,
        picIntro: null,
        picPath: null,
        picTip: null,
        picStatus: 0,
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
      this.title = "添加图片基本信息库";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getPicture(id).then((response) => {
        this.form = response.data;
        this.open = true;
        this.title = "修改图片基本信息库";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.id != null) {
            updatePicture(this.form).then((response) => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPicture(this.form).then((response) => {
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
        .confirm('是否确认删除图片基本信息库编号为"' + ids + '"的数据项？')
        .then(function () {
          return delPicture(ids);
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
        "media/picture/export",
        {
          ...this.queryParams,
        },
        `picture_${new Date().getTime()}.xlsx`
      );
    },
  },
};
</script>
