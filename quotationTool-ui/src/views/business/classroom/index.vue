<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
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
      <el-form-item label="教室名称" prop="classroomName">
        <el-input
          v-model="queryParams.classroomName"
          placeholder="请输入教室名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!--<el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_normal_disable"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>-->
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
          v-hasPermi="['business:classroom:add']"
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
          v-hasPermi="['business:classroom:edit']"
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
          v-hasPermi="['business:classroom:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['business:classroom:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="classroomList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="classroomId" />
      <el-table-column label="所属场馆" align="center" prop="stadiumId" />
      <el-table-column label="教室名称" align="center" prop="classroomName" />
      <el-table-column label="教室地址" align="center" prop="classroomAddress" />
      <el-table-column label="教室介绍" align="center" prop="classroomIntroduce" />
      <el-table-column label="是否可预约" align="center" prop="isAppointment" >
       <template slot-scope="scope">
                <dict-tag :options="dict.type.sys_yn_status" :value="scope.row.isAppointment"/>
              </template>
            </el-table-column>
      <el-table-column label="可预约数" align="center" prop="appointmentNum" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['business:classroom:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:classroom:remove']"
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

    <!-- 添加或修改教室管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="所属场馆" prop="stadiumId">
          <el-input v-model="form.stadiumId" placeholder="请输入所属场馆" />
        </el-form-item>
        <el-form-item label="教室名称" prop="classroomName">
          <el-input v-model="form.classroomName" placeholder="请输入教室名称" />
        </el-form-item>
        <el-form-item label="教室图片" prop="classroomImg">
                  <el-input v-model="form.classroomImg" placeholder="请输入教室名称" />
                </el-form-item>
        <el-form-item label="教室地址" prop="classroomAddress">
          <el-input v-model="form.classroomAddress" placeholder="请输入教室地址" />
        </el-form-item>
        <el-form-item label="教室介绍" prop="classroomIntroduce">
          <el-input v-model="form.classroomIntroduce" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="可预约数" prop="appointmentNum">
                         <el-input v-model="form.appointmentNum"  placeholder="请输入可预约数" />
                  </el-form-item>
        <el-form-item label="是否可预约" prop="isAppointment">
          <el-radio-group v-model="form.isAppointment">
                     <el-radio
                       v-for="dict in dict.type.sys_yn_status"
                       :key="dict.value"
         :label="dict.value"
                     >{{dict.label}}</el-radio>
                   </el-radio-group>
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
import { listClassroom, getClassroom, delClassroom, addClassroom, updateClassroom } from "@/api/business/classroom";

export default {
  name: "Classroom",
  dicts: ['sys_normal_disable','sys_yn_status'],
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
      // 教室管理表格数据
      classroomList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        stadiumId: null,
        classroomName: null,
        classroomAddress: null,
        classroomIntroduce: null,
        isAppointment: null,
        appointmentNum: null,
        status: null,
      },
      stadiumList: [],
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        stadiumId: [
          { required: true, message: "所属场馆不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "状态不能为空", trigger: "blur" }
        ],
        delFlag: [
          { required: true, message: "删除标志不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getStadiumList();
  },
  methods: {
    /** 查询教室管理列表 */
    getList() {
      this.loading = true;
      listClassroom(this.queryParams).then(response => {
        this.classroomList = response.rows;
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
        classroomId: null,
        stadiumId: null,
        classroomName: null,
        classroomAddress: null,
        classroomIntroduce: null,
        isAppointment: null,
        appointmentNum: null,
        status: "0",
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        classroomImg: null,
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
      this.ids = selection.map(item => item.classroomId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加教室管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const classroomId = row.classroomId || this.ids
      getClassroom(classroomId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改教室管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.classroomId != null) {
            updateClassroom(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addClassroom(this.form).then(response => {
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
      const classroomIds = row.classroomId || this.ids;
      this.$modal.confirm('是否确认删除教室管理编号为"' + classroomIds + '"的数据项？').then(function() {
        return delClassroom(classroomIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('business/classroom/export', {
        ...this.queryParams
      }, `classroom_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
