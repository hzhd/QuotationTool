<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <!-- <el-form-item label="数据来源" prop="datasource">
        <el-input
          v-model="queryParams.datasource"
          placeholder="请输入数据来源"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      
      <el-form-item label="线索来源" prop="cluesource">
        <!-- <el-input
          v-model="queryParams.cluesource"
          placeholder="请输入线索来源"
          clearable
          @keyup.enter.native="handleQuery"
        /> -->
        <el-select v-model="queryParams.cluesource" placeholder="请选择线索来源" clearable>
          <el-option
            v-for="dict in dict.type.stadium_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <!-- <el-form-item label="大区名称" prop="regionname">
        <el-input
          v-model="queryParams.regionname"
          placeholder="请输入大区名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      
      <el-form-item label="产品" prop="product">
        <el-input
          v-model="queryParams.product"
          placeholder="请输入产品"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户姓名" prop="customername">
        <el-input
          v-model="queryParams.customername"
          placeholder="请输入客户姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="经销商" prop="distributorname">
        <el-input
          v-model="queryParams.distributorname"
          placeholder="请输入经销商名称"
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
          v-hasPermi="['eshop:eshop:add']"
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
          v-hasPermi="['eshop:eshop:edit']"
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
          v-hasPermi="['eshop:eshop:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['eshop:eshop:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="eshopList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="数据来源" align="center" prop="datasource" />
      <el-table-column label="线索编号" align="center" prop="clueno" />
      <el-table-column label="大区编码" align="center" prop="regioncode" />
      <el-table-column label="状态编码" align="center" prop="statuscode" />
      <el-table-column label="状态名称" align="center" prop="statusname" /> -->
      <el-table-column label="线索来源" align="center" prop="cluesource" />
      <el-table-column label="线索产生时间" align="center" prop="clueqenerationtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.clueqenerationtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column label="大区名称" align="center" prop="regionname" /> -->
      <el-table-column label="客户姓名" align="center" prop="customername" />
      <el-table-column label="客户电话" align="center" prop="customerphone" />
      <el-table-column label="所在省份" align="center" prop="province" />
      <el-table-column label="所在城市" align="center" prop="city" />
      <el-table-column label="所在县区" align="center" prop="county" />
      <el-table-column label="详细地址" align="center" prop="address" />
      <el-table-column label="问题描述" align="center" prop="problemdescription" />
      <el-table-column label="产品" align="center" prop="product" />
      <el-table-column label="推送状态" align="center" prop="remark" >
        <template slot-scope="scope">
          <div :style="{'color':scope.row.remark=='推送失败'? 'red':'blue'}">
            {{scope.row.remark == '推送成功' ? '推送成功' : '推送失败'}}
          </div>
        </template>
      </el-table-column>

      
      <!-- <el-table-column label="配件型号" align="center" prop="accessorymodel" />
      <el-table-column label="对单原因" align="center" prop="lostorderreason" />
      <el-table-column label="丢单原因备注" align="center" prop="lostorderremark" />
      <el-table-column label="客户称谓" align="center" prop="customerappellation" />
      <el-table-column label="客户类型" align="center" prop="customertype" />
      <el-table-column label="省份代码" align="center" prop="provincecode" />
      <el-table-column label="城市代码" align="center" prop="citycode" />
      <el-table-column label="区代码" align="center" prop="countycode" />
      <el-table-column label="安装类型编码" align="center" prop="installationtypecode" />
      <el-table-column label="安装类型名称" align="center" prop="installationtypename" />
      <el-table-column label="心仪采暖方式" align="center" prop="favoriteheating" />
      <el-table-column label="房屋建筑面积" align="center" prop="buildingarea" />
      <el-table-column label="花洒数量" align="center" prop="sprinklerquantity" />
      <el-table-column label="锅炉类型" align="center" prop="boilertype" />
      <el-table-column label="辅材类型" align="center" prop="auxiliarymaterialstype" />
      <el-table-column label="归属门店" align="center" prop="belongingstore" />
      <el-table-column label="锅炉功率" align="center" prop="boilerpower" />
      <el-table-column label="激活状态" align="center" prop="activationstatus" />
      <el-table-column label="销售渠道" align="center" prop="distributionchannel" />
      <el-table-column label="负责人" align="center" prop="responsibleperson" />
      <el-table-column label="负责人联系方式" align="center" prop="responsiblepersonphone" />
      <el-table-column label="门店详细地址" align="center" prop="storeaddress" />
      <el-table-column label="经销商编号" align="center" prop="distributorid" />
      <el-table-column label="经销商名称" align="center" prop="distributorname" />
      <el-table-column label="方案1" align="center" prop="casename1" />
      <el-table-column label="方案2" align="center" prop="casename2" />
      <el-table-column label="产品系列1" align="center" prop="productgroup1" />
      <el-table-column label="产品系列2" align="center" prop="productgroup2" />
      <el-table-column label="产品型号1" align="center" prop="product1" />
      <el-table-column label="产品型号2" align="center" prop="product2" />
      <el-table-column label="报价1" align="center" prop="price1" />
      <el-table-column label="报价2" align="center" prop="price2" />
      <el-table-column label="备注" align="center" prop="remark" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['eshop:eshop:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['eshop:eshop:remove']"
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

    <!-- 添加或修改推送数据对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="50%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        
        <el-form-item label="线索来源" prop="cluesource">
          <!-- <el-input v-model="form.cluesource" placeholder="请输入线索来源" /> -->
          <el-select v-model="form.cluesource" 
            filterable
            allow-create
            default-first-option
            placeholder="请选择线索来源">
              <el-option
                v-for="dict in dict.type.stadium_type"
                :key="dict.value"
                :label="dict.label"
                :value="dict.value"
              ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="线索产生时间" prop="clueqenerationtime">
          <el-date-picker clearable
            v-model="form.clueqenerationtime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:SS"
            placeholder="请选择线索产生时间">
          </el-date-picker>
        </el-form-item>
        <!-- <el-form-item label="大区名称" prop="regionname">
          <el-input v-model="form.regionname" placeholder="请输入大区名称" />
        </el-form-item> -->
        <el-form-item label="客户姓名" prop="customername">
          <el-input v-model="form.customername" placeholder="请输入客户姓名" />
        </el-form-item>
        <el-form-item label="客户电话" prop="customerphone">
          <el-input v-model="form.customerphone" placeholder="请输入客户电话" />
        </el-form-item>
        <!-- <el-form-item label="所在省份" prop="province">
          <el-input v-model="form.province" placeholder="请输入省" />
        </el-form-item>
        <el-form-item label="所在城市" prop="city">
          <el-input v-model="form.city" placeholder="请输入市" />
        </el-form-item>
        <el-form-item label="所在县区" prop="county">
          <el-input v-model="form.county" placeholder="请输入区" />
        </el-form-item> -->
        <el-form-item label="省/直辖市" prop="province">
          <el-select
            v-model="form.province"
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
        <el-form-item label="所在区县" prop="county">
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
        </el-form-item>
        <el-form-item label="您偏好的采暖方案" prop="favoriteheating">
            <el-select
              v-model="form.favoriteheating"
              filterable
              clearable
              placeholder="请选择您偏好的采暖方案"
            >
              <el-option v-for="item in favoriteheatingList" :key="item.paraname" :label="item.paraname" :value="item.paravalue"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="您家的户型面积" prop="buildingarea">
            <el-select
              v-model="form.buildingarea"
              filterable
              clearable
              placeholder="请选择您家的户型面积"
            >
              <el-option v-for="item in buildingareaList" :key="item.paraname" :label="item.paraname" :value="item.paravalue"></el-option>
            </el-select>
          </el-form-item>
        <el-form-item label="详细地址" prop="address">
          <el-input v-model="form.address" type="textarea" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="问题描述" prop="problemdescription">
          <el-input v-model="form.problemdescription" type="textarea" placeholder="请输入问题描述" />
        </el-form-item>
        <el-form-item label="产品" prop="product">
          <el-input v-model="form.product" type="textarea" placeholder="请输入产品" />
        </el-form-item>




        <!-- <el-form-item label="数据来源" prop="datasource">
          <el-input v-model="form.datasource" placeholder="请输入数据来源" />
        </el-form-item>
        <el-form-item label="线索编号" prop="clueno">
          <el-input v-model="form.clueno" placeholder="请输入线索编号" />
        </el-form-item>
        <el-form-item label="大区编码" prop="regioncode">
          <el-input v-model="form.regioncode" placeholder="请输入大区编码" />
        </el-form-item>
        <el-form-item label="状态编码" prop="statuscode">
          <el-input v-model="form.statuscode" placeholder="请输入状态编码" />
        </el-form-item>
        <el-form-item label="状态名称" prop="statusname">
          <el-input v-model="form.statusname" placeholder="请输入状态名称" />
        </el-form-item>
        <el-form-item label="配件型号" prop="accessorymodel">
          <el-input v-model="form.accessorymodel" placeholder="请输入配件型号" />
        </el-form-item>
        <el-form-item label="对单原因" prop="lostorderreason">
          <el-input v-model="form.lostorderreason" placeholder="请输入对单原因" />
        </el-form-item>
        <el-form-item label="丢单原因备注" prop="lostorderremark">
          <el-input v-model="form.lostorderremark" placeholder="请输入丢单原因备注" />
        </el-form-item>
        <el-form-item label="客户称谓" prop="customerappellation">
          <el-input v-model="form.customerappellation" placeholder="请输入客户称谓" />
        </el-form-item>
        <el-form-item label="省份代码" prop="provincecode">
          <el-input v-model="form.provincecode" placeholder="请输入省份代码" />
        </el-form-item>
        <el-form-item label="城市代码" prop="citycode">
          <el-input v-model="form.citycode" placeholder="请输入城市代码" />
        </el-form-item>
        <el-form-item label="区代码" prop="countycode">
          <el-input v-model="form.countycode" placeholder="请输入区代码" />
        </el-form-item>
        <el-form-item label="安装类型编码" prop="installationtypecode">
          <el-input v-model="form.installationtypecode" placeholder="请输入安装类型编码" />
        </el-form-item>
        <el-form-item label="安装类型名称" prop="installationtypename">
          <el-input v-model="form.installationtypename" placeholder="请输入安装类型名称" />
        </el-form-item>
        <el-form-item label="心仪采暖方式" prop="favoriteheating">
          <el-input v-model="form.favoriteheating" placeholder="请输入心仪采暖方式" />
        </el-form-item>
        <el-form-item label="房屋建筑面积" prop="buildingarea">
          <el-input v-model="form.buildingarea" placeholder="请输入房屋建筑面积" />
        </el-form-item>
        <el-form-item label="花洒数量" prop="sprinklerquantity">
          <el-input v-model="form.sprinklerquantity" placeholder="请输入花洒数量" />
        </el-form-item>
        <el-form-item label="归属门店" prop="belongingstore">
          <el-input v-model="form.belongingstore" placeholder="请输入归属门店" />
        </el-form-item>
        <el-form-item label="锅炉功率" prop="boilerpower">
          <el-input v-model="form.boilerpower" placeholder="请输入锅炉功率" />
        </el-form-item>
        <el-form-item label="销售渠道" prop="distributionchannel">
          <el-input v-model="form.distributionchannel" placeholder="请输入销售渠道" />
        </el-form-item>
        <el-form-item label="负责人" prop="responsibleperson">
          <el-input v-model="form.responsibleperson" placeholder="请输入负责人" />
        </el-form-item>
        <el-form-item label="负责人联系方式" prop="responsiblepersonphone">
          <el-input v-model="form.responsiblepersonphone" placeholder="请输入负责人联系方式" />
        </el-form-item>
        <el-form-item label="门店详细地址" prop="storeaddress">
          <el-input v-model="form.storeaddress" placeholder="请输入门店详细地址" />
        </el-form-item>
        <el-form-item label="经销商编号" prop="distributorid">
          <el-input v-model="form.distributorid" placeholder="请输入经销商编号" />
        </el-form-item>
        <el-form-item label="经销商名称" prop="distributorname">
          <el-input v-model="form.distributorname" placeholder="请输入经销商名称" />
        </el-form-item>
        <el-form-item label="方案1" prop="casename1">
          <el-input v-model="form.casename1" placeholder="请输入方案1" />
        </el-form-item>
        <el-form-item label="方案2" prop="casename2">
          <el-input v-model="form.casename2" placeholder="请输入方案2" />
        </el-form-item>
        <el-form-item label="产品系列1" prop="productgroup1">
          <el-input v-model="form.productgroup1" placeholder="请输入产品系列1" />
        </el-form-item>
        <el-form-item label="产品系列2" prop="productgroup2">
          <el-input v-model="form.productgroup2" placeholder="请输入产品系列2" />
        </el-form-item>
        <el-form-item label="产品型号1" prop="product1">
          <el-input v-model="form.product1" placeholder="请输入产品型号1" />
        </el-form-item>
        <el-form-item label="产品型号2" prop="product2">
          <el-input v-model="form.product2" placeholder="请输入产品型号2" />
        </el-form-item>
        <el-form-item label="报价1" prop="price1">
          <el-input v-model="form.price1" placeholder="请输入报价1" />
        </el-form-item>
        <el-form-item label="报价2" prop="price2">
          <el-input v-model="form.price2" placeholder="请输入报价2" />
        </el-form-item> -->
        <!-- <el-form-item label="推送状态" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">推送数据到eShop</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listEshop, getEshop, delEshop, addEshop, updateEshop } from "@/api/quotationApi/eshop";
import { pcaData } from '@/api/quotationData/pca.data.js'
import  { getProvince, getCityByProvince, getCountryByCity } from '@/api/quotationApi/pca.js'

export default {
  name: "Eshop",
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
      // 推送数据表格数据
      eshopList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        datasource: null,
        clueno: null,
        clueqenerationtime: null,
        regioncode: null,
        regionname: null,
        statuscode: null,
        statusname: null,
        cluesource: null,
        product: null,
        accessorymodel: null,
        lostorderreason: null,
        lostorderremark: null,
        customername: null,
        customerappellation: null,
        customertype: null,
        customerphone: null,
        province: null,
        provincecode: null,
        city: null,
        citycode: null,
        county: null,
        countycode: null,
        address: null,
        installationtypecode: null,
        installationtypename: null,
        favoriteheating: null,
        buildingarea: null,
        sprinklerquantity: null,
        boilertype: null,
        auxiliarymaterialstype: null,
        belongingstore: null,
        boilerpower: null,
        activationstatus: null,
        distributionchannel: null,
        responsibleperson: null,
        responsiblepersonphone: null,
        storeaddress: null,
        distributorid: null,
        distributorname: null,
        problemdescription: null,
        casename1: null,
        casename2: null,
        productgroup1: null,
        productgroup2: null,
        product1: null,
        product2: null,
        price1: null,
        price2: null,
        favoriteheating: '',
        buildingarea: '',
      },
      
        
      favoriteheatingList:
        [
          {"paraname":"新房装地暖，美观舒适","paratype":"","paravalue":"新房装地暖，美观舒适"},
          {"paraname":"局部改装暖气片，快速安装","paratype":"","paravalue":"局部改装暖气片，快速安装"},
          {"paraname":"已有采暖设备，升级置换","paratype":"","paravalue":"已有采暖设备，升级置换"},
        ],
        
        buildingareaList:
        [
          {"paraname":"<80㎡","paratype":"","paravalue":"<80㎡"},
          {"paraname":"80-150㎡","paratype":"","paravalue":"80-150㎡"},
          {"paraname":"151-230㎡","paratype":"","paravalue":"151-230㎡"},
          {"paraname":"231-300㎡","paratype":"","paravalue":"231-300㎡"},
          {"paraname":">300㎡","paratype":"","paravalue":">300㎡"},
        ],
      provinceList: pcaData(),
      cityList: [],
      countryList: [],
      // 表单参数
      form: {},
      
      rules: {        
        cluesource: [
          { required: true, message: "来源不能为空", trigger: "blur" },
          { min: 1, max: 20, message: '姓氏名称长度必须介于 1 和 20 之间', trigger: 'blur' }
        ],
        clueqenerationtime: [
          { required: true, message: "来源时间不能为空", trigger: "blur" },
        ],
        // regionname: [
        //   { required: true, message: "大区不能为空", trigger: "blur" },
        // ],
        customername: [
          { required: true, message: "客户名称不能为空", trigger: "blur" },
        ],
        province: [
          { required: true, message: "省份不能为空", trigger: "blur" },
        ],
        city: [
          { required: true, message: "城市不能为空", trigger: "blur" },
        ],
        // county: [
        //   { required: true, message: "县区不能为空", trigger: "blur" },
        // ],
        // address: [
        //   { required: true, message: "地址不能为空", trigger: "blur" },
        // ],
        // problemdescription: [
        //   { required: true, message: "问题描述不能为空", trigger: "blur" },
        // ],
        // product: [
        //   { required: true, message: "产品信息不能为空", trigger: "blur" },
        // ],
        customerphone: [
          { required: true, message: "手机号码不能为空", trigger: "blur" },
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur"
          }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
       
    setProvince($event) {
      const selectedProvince = this.provinceList.filter((i) => i.code == $event.code)[0];
      this.cityList = getCityByProvince($event.code);
      this.form.province = selectedProvince.name;
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
    /** 查询推送数据列表 */
    getList() {
      this.loading = true;
      listEshop(this.queryParams).then(response => {
        this.eshopList = response.rows;
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
        datasource: null,
        clueno: null,
        clueqenerationtime: null,
        regioncode: null,
        regionname: null,
        statuscode: null,
        statusname: null,
        cluesource: null,
        product: null,
        accessorymodel: null,
        lostorderreason: null,
        lostorderremark: null,
        customername: null,
        customerappellation: null,
        customertype: null,
        customerphone: null,
        province: null,
        provincecode: null,
        city: null,
        citycode: null,
        county: null,
        countycode: null,
        address: null,
        installationtypecode: null,
        installationtypename: null,
        favoriteheating: null,
        buildingarea: null,
        sprinklerquantity: null,
        boilertype: null,
        auxiliarymaterialstype: null,
        belongingstore: null,
        boilerpower: null,
        activationstatus: "0",
        distributionchannel: null,
        responsibleperson: null,
        responsiblepersonphone: null,
        storeaddress: null,
        distributorid: null,
        distributorname: null,
        problemdescription: null,
        casename1: null,
        casename2: null,
        productgroup1: null,
        productgroup2: null,
        product1: null,
        product2: null,
        price1: null,
        price2: null,
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
      this.title = "eshop推送数据";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getEshop(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "eshop重新推送";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEshop(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addEshop(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除推送数据编号为"' + ids + '"的数据项？').then(function() {
        return delEshop(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('eshop/eshop/export', {
        ...this.queryParams
      }, `eshop_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
