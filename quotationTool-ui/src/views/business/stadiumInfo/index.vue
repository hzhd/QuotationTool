<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="场馆名称" prop="stadiumName">
        <el-input
          v-model="queryParams.stadiumName"
          placeholder="请输入场馆名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      </el-form-item>
             <el-form-item label="场馆类型" prop="stadiumType" >
                <el-select v-model="queryParams.stadiumType" placeholder="场馆类型" clearable>
                  <el-option
                    v-for="dict in dict.type.z_stadium_type"
                    :key="dict.value"
                    :label="dict.label"
                    :value="dict.value"
                  />
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
          v-hasPermi="['business:stadiumInfo:add']"
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
          v-hasPermi="['business:stadiumInfo:edit']"
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
          v-hasPermi="['business:stadiumInfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['business:stadiumInfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="stadiumInfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="stadiumId" />
      <el-table-column label="场馆名称" align="center" prop="stadiumName" />
       <el-table-column label="场馆图片" align="center" prop="stadiumImg" width="100">
              <template slot-scope="scope">
                <image-preview :src="scope.row.stadiumImg" :width="50" :height="50"/>
              </template>
            </el-table-column>
      <el-table-column label="场馆地址" align="center" prop="stadiumAddress" />
      <el-table-column label="场馆可预约数" align="center" prop="appointmentNum" />
      <el-table-column label="是否可预约" align="center" prop="isAppointment" >
       <template slot-scope="scope">
                <dict-tag :options="dict.type.sys_yn_status" :value="scope.row.isAppointment"/>
              </template>
      </el-table-column>
     <el-table-column label="场馆类型" align="center" prop="stadiumType" >
                <template slot-scope="scope">
                                <dict-tag :options="dict.type.z_stadium_type" :value="scope.row.stadiumType"/>
                              </template>
                            </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['business:stadiumInfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:stadiumInfo:remove']"
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

    <!-- 添加或修改场馆信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="场馆名称" prop="stadiumName">
          <el-input v-model="form.stadiumName" placeholder="请输入场馆名称" />
        </el-form-item>
        <el-form-item label="场馆图片" prop="stadiumImg">
                  <image-upload v-model="form.stadiumImg" />
              </el-form-item>
        <el-form-item label="场馆地址" prop="stadiumAddress">
          <el-input v-model="form.stadiumAddress" placeholder="请输入场馆地址" />
        </el-form-item>
        <el-form-item label="场馆介绍" prop="stadiumIntroduce">
         <editor v-model="form.stadiumIntroduce" :min-height="192"/>
        </el-form-item>
        <el-form-item label="场馆可预约数" prop="appointmentNum">
          <el-input v-model="form.appointmentNum" placeholder="请输入场馆可预约数" />
        </el-form-item>
        <el-form-item label="场馆单价" prop="stadiumPrice">
                  <el-input v-model="form.stadiumPrice" placeholder="请输入场馆单价" />
                </el-form-item>
        <el-form-item label="场馆类型" prop="stadiumType">
         <el-select v-model="form.stadiumType" placeholder="场馆类型" >
                          <el-option
                            v-for="dict in dict.type.z_stadium_type"
                            :key="dict.value"
                            :label="dict.label"
                            :value="dict.value"
                          />
                        </el-select>
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
        <el-form-item label="状态">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_normal_disable"
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
import { listStadiumInfo, getStadiumInfo, delStadiumInfo, addStadiumInfo, updateStadiumInfo } from "@/api/business/stadiumInfo";

export default {
  name: "StadiumInfo",
  dicts: ['sys_normal_disable','sys_yn_status','z_stadium_type'],
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
      // 场馆信息表格数据
      stadiumInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        stadiumName: null,
        stadiumAddress: null,
        stadiumIntroduce: null,
        appointmentNum: null,
        isAppointment: null,
        stadiumType: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        isAppointment: [
          { required: true, message: "是否可预约0是 1否不能为空", trigger: "blur" }
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
  },
  methods: {
    /** 查询场馆信息列表 */
    getList() {
      this.loading = true;
      listStadiumInfo(this.queryParams).then(response => {
        this.stadiumInfoList = response.rows;
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
        stadiumId: null,
        stadiumName: null,
        stadiumAddress: null,
        stadiumIntroduce: null,
        appointmentNum: null,
        isAppointment: null,
        stadiumType: null,
        status: "0",
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        stadiumImg: null,
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
      this.ids = selection.map(item => item.stadiumId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加场馆信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const stadiumId = row.stadiumId || this.ids
      getStadiumInfo(stadiumId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改场馆信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.stadiumId != null) {
            updateStadiumInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStadiumInfo(this.form).then(response => {
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
      const stadiumIds = row.stadiumId || this.ids;
      this.$modal.confirm('是否确认删除场馆信息编号为"' + stadiumIds + '"的数据项？').then(function() {
        return delStadiumInfo(stadiumIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('business/stadiumInfo/export', {
        ...this.queryParams
      }, `stadiumInfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
