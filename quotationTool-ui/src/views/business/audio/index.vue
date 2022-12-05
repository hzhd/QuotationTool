<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="音频名称" prop="audioName">
        <el-input
          v-model="queryParams.audioName"
          placeholder="请输入音频名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
       <el-form-item label="发布状态" prop="issueState">
          <el-select v-model="queryParams.issueState" placeholder="请选择课程状态" clearable>
            <el-option
              v-for="dict in dict.type.issue_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
       </el-form-item>
       <el-form-item label="归属场馆" prop="stadiumId">
            <el-select v-model="queryParams.stadiumId" placeholder="请选择归属场馆">
              <el-option
                v-for="(item, index) of stadiumList"
                :label="item.stadiumName"
                :value="item.stadiumId"
                :key="index"
              ></el-option>
            </el-select>
       </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
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
          v-hasPermi="['business:audio:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['business:audio:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['business:audio:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['business:audio:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="audioList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="音视频id" align="center" prop="audioId"/>
      <el-table-column label="音视频名称" align="center" prop="audioName" />
      <el-table-column label="音视频介绍" align="center" prop="audioIntroduce" />
      <!--<el-table-column label="音视频内容" align="center" prop="voiceContent" />
      <el-table-column label="音视频内容" align="center" prop="movieContent" />  -->
      <el-table-column label="温馨提示" align="center" prop="reminder" />
       <el-table-column label="发布状态" align="center" prop="issueState" >
            <template slot-scope="scope">
                            <dict-tag :options="dict.type.issue_type" :value="scope.row.issueState"/>
                          </template>
                        </el-table-column>
      <el-table-column label="归属场馆" align="center" prop="stadiumId">
      </el-table-column>
      <el-table-column label="数据来源" align="center" prop="resource" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['business:audio:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:audio:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改音视频库对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="音频名称" prop="audioName">
          <el-input v-model="form.audioName" placeholder="请输入音频名称" />
        </el-form-item>
        <el-form-item label="音频介绍" prop="audioIntroduce">
          <el-input v-model="form.audioIntroduce" placeholder="请输入音频介绍" />
        </el-form-item>
        <el-form-item label="音频内容">
          <editor v-model="form.voiceContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="视频内容">
          <editor v-model="form.movieContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="温馨提示" prop="reminder">
          <el-input v-model="form.reminder" placeholder="请输入温馨提示" />
        </el-form-item>
        <el-form-item label="归属场馆" prop="stadiumId">
         <el-select v-model="form.stadiumId" placeholder="请选择归属场馆">
                    <el-option
                      v-for="(item, index) of stadiumList"
                        :label="item.stadiumName"
                      :value="item.stadiumId"
                      :key="index"
                    ></el-option>
                  </el-select>
        </el-form-item>
        <el-form-item label="数据来源" prop="resource">
          <el-input v-model="form.resource" placeholder="请输入数据来源" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listAudio, getAudio, delAudio, addAudio, updateAudio,queryStadium } from "@/api/business/audio";

export default {
  name: "Audio",
  dicts: ['sys_normal_disable','issue_type'],
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
      // 音视频库表格数据
      audioList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        audioName: null,
        audioIntroduce: null,
        voiceContent: null,
        movieContent: null,
        reminder: null,
        issueState: null,
        stadiumId: null,
        resource: null,
        status: null,
      },
      stadiumList: [],
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
    this.getStadiumList();
  },
  methods: {
    /** 查询音视频库列表 */
    getList() {
      this.loading = true;
      listAudio(this.queryParams).then(response => {
        this.audioList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
   getStadiumList() {
        queryStadium().then((response) => {
          this.stadiumList = response;
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
        audioId: null,
        audioName: null,
        audioIntroduce: null,
        voiceContent: null,
        movieContent: null,
        reminder: null,
        issueState: null,
        stadiumId: null,
        resource: null,
        status: "0",
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
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
      this.ids = selection.map(item => item.audioId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加音视频库";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const audioId = row.audioId || this.ids
      getAudio(audioId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改音视频库";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.audioId != null) {
            updateAudio(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAudio(this.form).then(response => {
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
      const audioIds = row.audioId || this.ids;
      this.$modal.confirm('是否确认删除音视频库编号为"' + audioIds + '"的数据项？').then(function() {
        return delAudio(audioIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('business/audio/export', {
        ...this.queryParams
      }, `audio_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
