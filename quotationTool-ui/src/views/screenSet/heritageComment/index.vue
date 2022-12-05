<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="评论用户" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入评论用户"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="星级" prop="starLevel">
        <el-input
          v-model="queryParams.starLevel"
          placeholder="请输入星级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="模块类型" prop="moduleType">
        <el-input
          v-model="queryParams.moduleType"
          placeholder="请输入模块类型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
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
          v-hasPermi="['screenSet:heritageComment:add']"
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
          v-hasPermi="['screenSet:heritageComment:edit']"
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
          v-hasPermi="['screenSet:heritageComment:remove']"
        >删除</el-button>
      </el-col>
      <!-- <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['screenSet:heritageComment:export']"
        >导出</el-button>
      </el-col> -->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="heritageCommentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />      
      <el-table-column type="index" width="55" label="序号" align="center"/>
      <!-- <el-table-column label="主键id" align="center" prop="id" /> -->
      <el-table-column label="评论用户" align="center" prop="userName" />
      <el-table-column label="评论内容" align="center" prop="content" show-overflow-tooltip/>
      <!-- <el-table-column label="头像" align="center" prop="photo" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.photo" :width="50" :height="50"/>
        </template>
      </el-table-column> -->
      <el-table-column label="星级" align="center" prop="starLevel" />
      <el-table-column label="模块类型" align="center" >
        <template slot-scope="scope">
          <!-- {{scope.row.moduleType}} -->
            <!-- {{scope.row.moduleType == 'hd' }} -->
            <!-- <div v-for="(item,index) in dict.type.comment_module" :key="index">
              <span v-if="item.value == scope.row.moduleType">{{item.lable}}</span>
            </div> -->
            <span>{{scope.row.moduleType == 'fy'?'非遗':'活动'}}</span>
            <!-- {{findLabel(scope.row.moduleType)}} -->
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column label="备注" align="center" prop="remark" /> -->
      <!-- <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['screenSet:heritageComment:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['screenSet:heritageComment:remove']"
          >删除</el-button>
        </template>
      </el-table-column> -->
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改非遗评论对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="70%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="评论用户" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入评论用户" />
        </el-form-item>
        <el-form-item label="评论内容">
          <!-- <editor v-model="form.content" :min-height="192"/> -->
          <el-input v-model="form.content" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <!-- <el-form-item label="头像">
          <image-upload v-model="form.photo"/>
        </el-form-item> -->
        <el-form-item label="星级" prop="starLevel">
          <el-input v-model="form.starLevel" placeholder="请输入星级" />
        </el-form-item>
        <el-form-item label="模块类型" prop="moduleType">
          <!-- <el-input v-model="form.moduleType" placeholder="请输入模块类型" /> -->
          <el-radio-group v-model="form.moduleType">
            <el-radio
              v-for="dict in dict.type.comment_module"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <!-- <el-form-item label="所属项目">
              <el-select v-model="form.projectId" placeholder="请选择项目">
                <el-option
                  v-for="item in projects"
                  :key="item.ichId"
                  :label="item.projectName"
                  :value="item.ichId"
                ></el-option>
              </el-select>
            </el-form-item> -->
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
import {getProject, listHeritageComment, getHeritageComment, delHeritageComment, addHeritageComment, updateHeritageComment } from "@/api/screenSet/heritageComment";
import { value } from "micromatch/lib/utils";

export default {
  name: "HeritageComment",
  dicts: ['comment_module'],
  data() {
    return {
      
      // 岗位选项
      projects: [],
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
      // 非遗评论表格数据
      heritageCommentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        content: null,
        photo: null,
        starLevel: null,
        moduleType: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        // id: [
        //   { required: true, message: "主键id不能为空", trigger: "blur" }
        // ],
        userName: [
          { required: true, message: "评论用户不能为空", trigger: "blur" }
        ],
        content: [
          { required: true, message: "评论内容不能为空", trigger: "blur" }
        ],
        // photo: [
        //   { required: true, message: "头像不能为空", trigger: "blur" }
        // ],
        // starLevel: [
        //   { required: true, message: "星级不能为空", trigger: "blur" }
        // ],
        // moduleType: [
        //   { required: true, message: "模块类型不能为空", trigger: "blur" }
        // ],
        // delFlag: [
        //   { required: true, message: "删除标志不能为空", trigger: "blur" }
        // ],
        // createBy: [
        //   { required: true, message: "创建人不能为空", trigger: "blur" }
        // ],
        // createTime: [
        //   { required: true, message: "创建时间不能为空", trigger: "blur" }
        // ],
        // updateBy: [
        //   { required: true, message: "更新人不能为空", trigger: "blur" }
        // ],
        // updateTime: [
        //   { required: true, message: "更新时间不能为空", trigger: "blur" }
        // ],
        // remark: [
        //   { required: true, message: "备注不能为空", trigger: "blur" }
        // ]
      }
    };
  },
  created() {
    this.getList();
    this.getProject();
  },

  methods: {
    findLabel(val) {
      return this.dict.type.comment_module.find(item => item.value == val).lable
    },
    /** 查询项目列表 */
    getProject() {
      this.loading = true;
      getProject().then(response => {        
        this.projects = response.data;
        this.loading = false;
      });
    },
    /** 查询非遗评论列表 */
    getList() {
      this.loading = true;
      listHeritageComment(this.queryParams).then(response => {
        this.heritageCommentList = response.rows;
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
        userName: null,
        content: null,
        photo: null,
        starLevel: null,
        moduleType: null,
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加非遗评论";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getHeritageComment(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改非遗评论";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateHeritageComment(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addHeritageComment(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除非遗评论编号为"' + ids + '"的数据项？').then(function() {
        return delHeritageComment(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('screenSet/heritageComment/export', {
        ...this.queryParams
      }, `heritageComment_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
