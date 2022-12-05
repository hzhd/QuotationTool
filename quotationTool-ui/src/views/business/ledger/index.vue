<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="档案id" prop="recordId">
        <el-input
          v-model="queryParams.recordId"
          placeholder="请输入档案id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="借阅日期" prop="borrowDate">
        <el-date-picker clearable
          v-model="queryParams.borrowDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择借阅日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="借阅人" prop="borrower">
        <el-input
          v-model="queryParams.borrower"
          placeholder="请输入借阅人"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['business:ledger:add']"
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
          v-hasPermi="['business:ledger:edit']"
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
          v-hasPermi="['business:ledger:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['business:ledger:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="ledgerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="ledgerId" />
      <el-table-column label="档案id" align="center" prop="recordId" />
      <el-table-column label="借阅日期" align="center" prop="borrowDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.borrowDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="借阅人" align="center" prop="borrower" />
      <el-table-column label="预计归还日期" align="center" prop="backDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.backDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="归还状态" align="center" prop="backStatus" />
      <!--<el-table-column label="状态" align="center" prop="status" />-->
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['business:ledger:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:ledger:remove']"
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

    <!-- 添加或修改档案台账对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="档案id" prop="recordId">
          <el-input v-model="form.recordId" placeholder="请输入档案id" />
        </el-form-item>
        <el-form-item label="借阅日期" prop="borrowDate">
          <el-date-picker clearable
            v-model="form.borrowDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择借阅日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="借阅人" prop="borrower">
          <el-input v-model="form.borrower" placeholder="请输入借阅人" />
        </el-form-item>
        <el-form-item label="预计归还日期" prop="backDate">
          <el-date-picker clearable
            v-model="form.backDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择预计归还日期">
          </el-date-picker>
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
import { listLedger, getLedger, delLedger, addLedger, updateLedger } from "@/api/business/ledger";

export default {
  name: "Ledger",
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
      // 档案台账表格数据
      ledgerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        recordId: null,
        borrowDate: null,
        borrower: null,
        backDate: null,
        backStatus: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        backStatus: [
          { required: true, message: "归还状态(0未归还 1已归还)不能为空", trigger: "blur" }
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
    /** 查询档案台账列表 */
    getList() {
      this.loading = true;
      listLedger(this.queryParams).then(response => {
        this.ledgerList = response.rows;
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
        ledgerId: null,
        recordId: null,
        borrowDate: null,
        borrower: null,
        backDate: null,
        backStatus: "0",
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
      this.ids = selection.map(item => item.ledgerId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加档案台账";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const ledgerId = row.ledgerId || this.ids
      getLedger(ledgerId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改档案台账";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.ledgerId != null) {
            updateLedger(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLedger(this.form).then(response => {
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
      const ledgerIds = row.ledgerId || this.ids;
      this.$modal.confirm('是否确认删除档案台账编号为"' + ledgerIds + '"的数据项？').then(function() {
        return delLedger(ledgerIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('business/ledger/export', {
        ...this.queryParams
      }, `ledger_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
