<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="课件名称" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入课件名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      
      <el-form-item label="课程状态" prop="classStatus">
        <el-select v-model="queryParams.classStatus" placeholder="请选择课程状态" clearable>
          <el-option
            v-for="dict in dict.type.class_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="归属场馆" prop="place">
        <el-input
          v-model="queryParams.place"
          placeholder="请输入归属场馆"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="${comment}" prop="createTime">
        <el-date-picker clearable
          v-model="queryParams.createTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择${comment}">
        </el-date-picker>
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
        >删除</el-button>
      </el-col>
      <!-- <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['business:course:export']"
        >导出</el-button>
      </el-col> -->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="courseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
          <el-table-column type="index" width="55" label="序号" align="center"/>
      <!-- <el-table-column label="主键id" align="center" prop="id" /> -->
      <el-table-column label="课件名称" align="center" prop="title" show-overflow-tooltip/>
      <!-- <el-table-column label="课件内容" align="center" prop="content" /> -->
      <!-- <el-table-column label="报名条件" align="center" prop="signCondition" show-overflow-tooltip/> -->
      <el-table-column label="课件图片" align="center" prop="imageUrl" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.imageUrl" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="收费标准" align="center" prop="chargeStandard">
        <template slot-scope="scope">
          <span>
            <h3 v-if="scope.row.chargeStandard==0">免费</h3>
            <h3 v-else>{{scope.row.chargeStandard}}</h3>
          </span>
        </template>
      </el-table-column>
      <el-table-column label="教师姓名" align="center" prop="teacherName"  width="100"/>
      <el-table-column label="教师照片" align="center" prop="teacherImage" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.teacherImage" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <!-- <el-table-column label="教师介绍" align="center" prop="teacherIntroduce" show-overflow-tooltip/> -->
      <!-- <el-table-column label="安排时间" align="center" prop="classSchedule" show-overflow-tooltip/> -->
      <el-table-column label="报名时间" align="center" prop="signTime" show-overflow-tooltip/>
      <el-table-column label="课时" align="center" prop="period" width="60" />
      <!-- <el-table-column label="教室安排" align="center" prop="classroom" show-overflow-tooltip/> -->
      <!-- <el-table-column label="咨询电话" align="center" prop="telephone" show-overflow-tooltip/> -->
      <el-table-column label="课程状态" align="center" prop="classStatus" width="100">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.class_status" :value="scope.row.classStatus"/>
        </template>
      </el-table-column>
      <!-- <el-table-column label="课堂笔记" align="center" prop="note" show-overflow-tooltip/> -->
      <el-table-column label="归属场馆" align="center" prop="place" show-overflow-tooltip/>
      <!-- <el-table-column label="直播链接" align="center" prop="liveUrl" show-overflow-tooltip/> -->
      <!-- <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column> -->
      <!-- <el-table-column label="备注" align="center" prop="remark" /> -->
      <!-- <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['business:course:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:course:remove']"
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

    <!-- 添加或修改慕课库数据维护对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="50%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="课件名称" prop="title">
          <el-input v-model="form.title" placeholder="请输入课件名称" />
        </el-form-item>
        <el-form-item label="课件内容">
          <editor v-model="form.content" :min-height="192"/>
        </el-form-item>
        <el-form-item label="课件报名条件" prop="signCondition">
          <editor v-model="form.signCondition" :min-height="192" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="课件图片">
          <image-upload v-model="form.imageUrl"/>
        </el-form-item>
        <el-form-item label="收费标准" prop="chargeStandard">
          <el-input v-model="form.chargeStandard" placeholder="请输入收费标准" />
        </el-form-item>
        <el-form-item label="教师姓名" prop="teacherName">
          <el-input v-model="form.teacherName"  type="textarea" placeholder="请输入教师姓名" />
        </el-form-item>
        <el-form-item label="教师照片">
          <image-upload v-model="form.teacherImage"/>
        </el-form-item>
        <el-form-item label="教师介绍" prop="teacherIntroduce">
          <editor v-model="form.teacherIntroduce" :min-height="192" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="课程安排时间" prop="classSchedule">
          <editor v-model="form.classSchedule" :min-height="192" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="报名时间" prop="signTime">
          <editor v-model="form.signTime" :min-height="192" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="课时" prop="period">
          <el-input v-model="form.period" placeholder="请输入课时" />
        </el-form-item>
        <el-form-item label="教室安排" prop="classroom">
          <editor v-model="form.classroom" :min-height="192" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="咨询电话" prop="telephone">
          <editor v-model="form.telephone" :min-height="192" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="课程状态">
          <el-radio-group v-model="form.classStatus">
            <el-radio
              v-for="dict in dict.type.class_status"
              :key="dict.value"
:label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="课堂笔记" prop="note">
          <editor v-model="form.note" :min-height="192" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="归属场馆" prop="place">
          <el-input v-model="form.place" placeholder="请输入归属场馆" />
        </el-form-item>
        <el-form-item label="直播链接" prop="liveUrl">
          <el-input v-model="form.liveUrl" placeholder="请输入直播链接" />
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
import { listCourse, getCourse, delCourse, addCourse, updateCourse } from "@/api/business/course";

export default {
  name: "Course",
  dicts: ['class_status'],
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
      // 慕课库数据维护表格数据
      courseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        content: null,
        signCondition: null,
        imageUrl: null,
        chargeStandard: null,
        teacherName: null,
        teacherImage: null,
        teacherIntroduce: null,
        classSchedule: null,
        signTime: null,
        period: null,
        classroom: null,
        telephone: null,
        classStatus: null,
        note: null,
        place: null,
        liveUrl: null,
        createTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        title: [
          { required: true, message: "课件名称不能为空", trigger: "blur" }
        ],
        // content: [
        //   { required: true, message: "课件内容不能为空", trigger: "blur" }
        // ],
        // signCondition: [
        //   { required: true, message: "课件报名条件不能为空", trigger: "blur" }
        // ],
        // imageUrl: [
        //   { required: true, message: "课件图片不能为空", trigger: "blur" }
        // ],
        // chargeStandard: [
        //   { required: true, message: "收费标准不能为空", trigger: "blur" }
        // ],
        // teacherName: [
        //   { required: true, message: "教师姓名不能为空", trigger: "blur" }
        // ],
        // teacherImage: [
        //   { required: true, message: "教师照片不能为空", trigger: "blur" }
        // ],
        // teacherIntroduce: [
        //   { required: true, message: "教师介绍不能为空", trigger: "blur" }
        // ],
        // classSchedule: [
        //   { required: true, message: "课程安排时间不能为空", trigger: "blur" }
        // ],
        // signTime: [
        //   { required: true, message: "报名时间不能为空", trigger: "blur" }
        // ],
        // period: [
        //   { required: true, message: "课时不能为空", trigger: "blur" }
        // ],
        // classroom: [
        //   { required: true, message: "教室安排不能为空", trigger: "blur" }
        // ],
        // telephone: [
        //   { required: true, message: "咨询电话不能为空", trigger: "blur" }
        // ],
        // classStatus: [
        //   { required: true, message: "课程状态不能为空", trigger: "blur" }
        // ],
        // note: [
        //   { required: true, message: "课堂笔记不能为空", trigger: "blur" }
        // ],
        // place: [
        //   { required: true, message: "归属场馆不能为空", trigger: "blur" }
        // ],
        // liveUrl: [
        //   { required: true, message: "直播链接不能为空", trigger: "blur" }
        // ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询慕课库数据维护列表 */
    getList() {
      this.loading = true;
      listCourse(this.queryParams).then(response => {
        this.courseList = response.rows;
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
        title: null,
        content: null,
        signCondition: null,
        imageUrl: null,
        chargeStandard: null,
        teacherName: null,
        teacherImage: null,
        teacherIntroduce: null,
        classSchedule: null,
        signTime: null,
        period: null,
        classroom: null,
        telephone: null,
        classStatus: 0,
        note: null,
        place: null,
        liveUrl: null,
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
      this.title = "添加慕课库数据维护";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCourse(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改慕课库数据维护";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCourse(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCourse(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除慕课库数据维护编号为"' + ids + '"的数据项？').then(function() {
        return delCourse(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('business/course/export', {
        ...this.queryParams
      }, `course_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
