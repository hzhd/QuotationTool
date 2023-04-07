<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <!-- <el-form-item label="所属大区" prop="area">
        <el-select v-model="queryParams.area" placeholder="请选择大区" clearable>
          <el-option
            v-for="dict in dict.type.stadium_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item> -->
      <el-form-item label="所属大区" prop="area">
          <el-select
            v-model="queryParams.area"
            filterable
            clearable
            placeholder="请选择大区"
            style="width:100%;"
          >
          <el-option v-for="item in regionList" :key="item.paraname" :label="item.paraname" :value="item.paraname"></el-option>
          </el-select>
      </el-form-item>
      <!-- <el-form-item label="省份" prop="provence">
        <el-select v-model="queryParams.provence" placeholder="请选择省份" clearable>
          <el-option
            v-for="dict in dict.type.stadium_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="城市" prop="city">
        <el-select v-model="queryParams.city" placeholder="请选择城市" clearable>
          <el-option
            v-for="dict in dict.type.stadium_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item> -->
      <el-form-item label="销售名称" prop="salesName">
        <el-input
          v-model="queryParams.salesName"
          placeholder="请输入销售名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="经销商" prop="dealerName">
        <el-input
          v-model="queryParams.dealerName"
          placeholder="请输入经销商名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动名称" prop="activityName">
        <el-input
          v-model="queryParams.activityName"
          placeholder="请输入活动名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="活动时间">
        <el-date-picker
          v-model="daterangeStartTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="信息来源" prop="source">
        <el-select v-model="queryParams.source" placeholder="请选择信息来源" clearable>
          <el-option
            v-for="dict in dict.type.stadium_type"
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
          v-hasPermi="['business:barcode:add']"
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
          v-hasPermi="['business:barcode:edit']"
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
          v-hasPermi="['business:barcode:remove']"
        >删除</el-button>
      </el-col>
      <!-- <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['business:barcode:export']"
        >导出</el-button>
      </el-col> -->
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="barcodeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="主键" align="center" prop="id" /> -->
      <el-table-column label="大区" align="center" prop="area">
        <!-- <template slot-scope="scope">
          <dict-tag :options="dict.type.stadium_type" :value="scope.row.area"/>
        </template> -->
      </el-table-column>
      <el-table-column label="省份" align="center" prop="provence">
        <!-- <template slot-scope="scope">
          <dict-tag :options="dict.type.stadium_type" :value="scope.row.provence"/>
        </template> -->
      </el-table-column>
      <el-table-column label="城市" align="center" prop="city">
        <!-- <template slot-scope="scope">
          <dict-tag :options="dict.type.stadium_type" :value="scope.row.city"/>
        </template> -->
      </el-table-column>
      <!-- <el-table-column label="销售编号" align="center" prop="salesCode" /> -->
      <el-table-column label="销售名称" align="center" prop="salesName" />
      <!-- <el-table-column label="经销商编号" align="center" prop="dealerCode" /> -->
      <el-table-column label="经销商名称" align="center" prop="dealerName"  show-overflow-tooltip/>
      <el-table-column label="活动名称" align="center" prop="activityName" />
      <el-table-column label="活动时间" align="center" prop="startTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column label="活动结束时间" align="center" prop="endTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column> -->
      <el-table-column label="信息来源" align="center" prop="source">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.stadium_type" :value="scope.row.source"/>
        </template>
      </el-table-column>
      <!-- <el-table-column label="图片路经" align="center" prop="barcodePath" /> -->
      <el-table-column
        label="图片"
        align="center"
        prop="barcodePath"
        width="100"
      >
        <template slot-scope="scope">
          <image-preview :src="scope.row.barcodePath" :width="50" :height="50" />
        </template>
      </el-table-column>
      <el-table-column label="路经" align="center" prop="remark"  show-overflow-tooltip />
      <!-- <el-table-column label="备注" align="center" prop="remark" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['business:barcode:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:barcode:remove']"
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

    <!-- 添加或修改生成二维码对话框 -->
    <el-dialog :title="title" :visible.sync="open"  width="50%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="所属大区" prop="area">
          <el-select
            v-model="form.area"
            filterable
            clearable
            placeholder="请选择大区"
          >
            <el-option v-for="item in regionList" :key="item.paraname" :label="item.paraname" :value="item.paravalue"></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="省份" prop="provence">
          <el-select v-model="form.provence" placeholder="请选择省份">
            <el-option
              v-for="dict in dict.type.stadium_type"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
          <el-input v-model="form.provence" placeholder="请输入省份" />
        </el-form-item>
        <el-form-item label="城市" prop="city">
          <el-select v-model="form.city" placeholder="请选择城市">
            <el-option
              v-for="dict in dict.type.stadium_type"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
          <el-input v-model="form.city" placeholder="请输入城市" />
        </el-form-item> -->
        <el-form-item label="省/直辖市" prop="provence">
          <el-select
            v-model="form.provence"
            value-key="code"
            @change="setProvince"
            placeholder="请选择省/直辖市"
          >
            <el-option
              v-for="item in provinceList"
              :key="item.code"
              :label="item.name"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="所在城市" prop="city">
          <el-select
            v-model="form.city"
            value-key="code"
            @change="setCity"
            placeholder="请选择城市"
          >
            <el-option
              v-for="item in cityList"
              :key="item.code"
              :label="item.name"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="所在区县" prop="county">
          <el-select
            v-model="form.county"
            value-key="code"
            @change="setCountry"
            placeholder="请选择区县"
          >
            <el-option
              v-for="item in countryList"
              :key="item.code"
              :label="item.name"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item> -->
        <!-- <el-form-item label="销售编号" prop="salesCode">
          <el-input v-model="form.salesCode" placeholder="请输入销售编号" />
        </el-form-item> -->
        <!-- <el-form-item label="销售名称" prop="salesName">
          <el-input v-model="form.salesName" placeholder="请输入销售名称" />
        </el-form-item> -->
        <!-- <el-form-item label="经销商编号" prop="dealerCode">
          <el-input v-model="form.dealerCode" placeholder="请输入经销商编号" />
        </el-form-item> -->
        <el-form-item label="销售名称" prop="county">
          <el-select
            v-model="form.salesName"
            value-key="sales_name"
            placeholder="请选择销售人员"
            filterable
            allow-create
            default-first-option
          >
            <!-- <el-option
              v-for="item in this.salesList.RECORDS"
              :key="item.id"
              :label="item.sales_name"
              :value="item.sales_name"
            >
            </el-option> -->
            <el-option
              v-for="item in this.salesList"
              :key="item.id"
              :label="item.sales_name"
              :value="item.sales_name"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="经销商名称" prop="dealerName">
          <el-input v-model="form.dealerName" placeholder="请输入经销商名称" />
        </el-form-item> -->
        <el-form-item label="经销商名称" prop="county">
          <el-select
            v-model="form.dealerName"
            value-key="distributor_name"
            placeholder="请选择经销商名称"
            filterable
            allow-create
            default-first-option
          >
            <!-- <el-option
              v-for="item in this.dealerList.RECORDS"
              :key="item.id"
              :label="item.distributor_name"
              :value="item.distributor_name"
            >
            </el-option> -->
            <el-option
              v-for="item in this.dealerList"
              :key="item.id"
              :label="item.distributor_name"
              :value="item.distributor_name"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="活动名称" prop="activityName">
          <el-input v-model="form.activityName" placeholder="请输入活动名称" />
        </el-form-item>
        <el-form-item label="活动开始时间" prop="startTime">
          <el-date-picker clearable
            v-model="form.startTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择活动开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="活动结束时间" prop="endTime">
          <el-date-picker clearable
            v-model="form.endTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择活动结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="信息来源" prop="source">
          <el-select v-model="form.source" placeholder="请选择信息来源">
            <el-option
              v-for="dict in dict.type.stadium_type"
              :key="dict.value"
              :label="dict.label"
:value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="图片路经" prop="barcodePath">
          <el-input v-model="form.barcodePath" type="textarea" placeholder="请输入内容" />
        </el-form-item> -->
        
        <!-- <el-form-item label="图片路经">
          <image-upload v-model="form.barcodePath" />
        </el-form-item> -->
        <el-form-item label="二维码路经" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="" readonly/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">生 成 二 维 码</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getSalesList, getDistributorList, listBarcode, getBarcode, delBarcode, addBarcode, updateBarcode } from "@/api/business/barcode";
import { pcaData } from '@/api/quotationData/pca.data.js'
import  { getProvince, getCityByProvince, getCountryByCity } from '@/api/quotationApi/pca.js'
import sales from '@/api/quotationData/sales.json'
import dealers from '@/api/quotationData/distributor.json'

export default {
  name: "Barcode",
  dicts: ['stadium_type'],
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
      // 生成二维码表格数据
      barcodeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 备注时间范围
      daterangeStartTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        area: null,
        provence: null,
        city: null,
        salesCode: null,
        salesName: null,
        dealerCode: null,
        dealerName: null,
        activityName: null,
        startTime: null,
        endTime: null,
        source: null,
        barcodePath: null,
      },
      provinceList: pcaData(),
      cityList: [],
      countryList: [],
      // 表单参数
      form: {},
      salesList: sales.RECORDS,
      dealerList: dealers.RECORDS,
      // salesList: [],
      // dealerList: [],
      
      regionList:
      [
        {"paraname":"华东区域","paratype":"","paravalue":"华东区域"},
        {"paraname":"华中区域","paratype":"","paravalue":"华中区域"},
        {"paraname":"华北区域","paratype":"","paravalue":"华北区域"},
        {"paraname":"西南区域","paratype":"","paravalue":"西南区域"},
        {"paraname":"西南区域","paratype":"","paravalue":"西南区域"},
        {"paraname":"湖北区域","paratype":"","paravalue":"湖北区域"},
        {"paraname":"其他区域","paratype":"","paravalue":"其他区域"},
      ],
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  mounted(){    
    // alert('aaa'+JSON.stringify(this.salesList.RECORDS))
    // this.getSalesList()
    // this.getDistributorList()
  },
  methods: {
    getSalesList(){
      this.loading = true;
      getSalesList().then(response => {
        this.salesList = response.data;
        this.loading = false;
      });
    },
    
    getDistributorList(){
      this.loading = true;
      getDistributorList().then(response => {
        this.dealerList = response.data;
        this.loading = false;
      });
    },

    //数据格式化
    f_startChargeSeqStat(row){
      for(var value of this.startChargeSeqStat){
        if(JSON.stringify(row.startChargeSeqStat)===value.paravalue){
          return value.paraname
        }
      }

    },
    setProvince($event) {
      const selectedProvince = this.provinceList.filter((i) => i.code == $event.code)[0];
      this.cityList = getCityByProvince($event.code);
      this.form.provence = selectedProvince.name;
      this.form.city = null;
      this.form.county = null;
    },
    setCity($event) {
      const selectedCity = this.cityList.filter((i) => i.code == $event.code)[0];
      this.countryList = getCountryByCity($event.code, this.cityList);
      this.form.city = selectedCity.name;
      this.form.county = null;
    },
    setCountry($event) {
      const selectedCountry = this.countryList.filter((i) => i.code == $event.code)[0];
      this.form.county = selectedCountry.name;
    },
    /** 查询生成二维码列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeStartTime && '' != this.daterangeStartTime) {
        this.queryParams.params["beginStartTime"] = this.daterangeStartTime[0];
        this.queryParams.params["endStartTime"] = this.daterangeStartTime[1];
      }
      listBarcode(this.queryParams).then(response => {
        this.barcodeList = response.rows;
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
        area: null,
        provence: null,
        city: null,
        salesCode: null,
        salesName: null,
        dealerCode: null,
        dealerName: null,
        activityName: null,
        startTime: null,
        endTime: null,
        source: null,
        barcodePath: null,
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
      this.daterangeStartTime = [];
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
      this.title = "添加生成二维码";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getBarcode(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改生成二维码";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          // alert(JSON.stringify(this.form))
          console.log(JSON.stringify(this.form))
          if (this.form.id != null) {
            updateBarcode(this.form).then(response => {              
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBarcode(this.form).then(response => {
              // alert(JSON.stringify(response))
              // this.form.remark = response.msg;
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
      this.$modal.confirm('是否确认删除生成二维码编号为"' + ids + '"的数据项？').then(function() {
        return delBarcode(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('barcode/barcode/export', {
        ...this.queryParams
      }, `barcode_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
