<template>
  <div class="gameSelect">    
    <div class="header">
      <img src="@/assets/images/header.jpg"/>
    </div>
    <!-- <div class="topWrap"></div> -->
    <!-- <div class="logoBanner">
      <div class="logo_div">
        <img src="../../../assets/images/bosch_logo.png" class="bosch_logo"/>
      </div>
      <div class="logo_div2">
        <img src="../../../assets/images/bosch_logo2.png" class="bosch_logo2"/>
      </div>
    </div> -->
    <div class="innerWrap">
      <h3></h3>
      <div class="topTips">          
        <span class="tips" style="font-weight: 700;">Eshop派派乐商机数据录入界面</span>
        <br>
        <span class="tips" style="text-indent: 2em;">   数据提交成功后，可以登录管理后台查看、维护、导出数据等。</span>
      </div>
      
      <div class="thirdForm">
        <el-form ref="form" :rules="rules" :model="form" label-width="100px" label-position="top">
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
              placeholder="请选择线索产生时间"
              style="width: 100%;">
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
            <el-input v-model="form.province" placeholder="请输入省份" />
          </el-form-item>
          <el-form-item label="所在城市" prop="city">
            <el-input v-model="form.city" placeholder="请输入城市" />
          </el-form-item>
          <el-form-item label="所在县区" prop="county">
            <el-input v-model="form.county" placeholder="请输入县区" />
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
          <el-form-item label="城市" prop="city">
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
          <el-form-item label="区/县" prop="county">
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
                
        </el-form>
      </div>
    </div>
    <div class="btn-div">
        <el-button class="btnContinue" @click="btnContinue">
            确认并提交
        </el-button>
    </div>
  </div>
</template>
<script>
// import { apiGet } from '@/api/api'
import { pcaData } from '@/api/quotationData/pca.data.js'
import  { getProvince, getCityByProvince, getCountryByCity } from '@/api/quotationApi/pca.js'
import { listEshop, getEshop, delEshop, addEshop, updateEshop } from "@/api/quotationApi/eshop";

export default {
  dicts: ['stadium_type'],
  data() {
    return { 
      storage: window.sessionStorage,
      form: {
          cluesource: '',
          clueqenerationtime: '',
          // regionname: '',
          customername: '',
          customerphone: '',
          province: '',
          city: '',
          county: '',
          address: '',
          problemdescription: '',
          product: '',
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
        //regionOption: pcaData(), //地域信息
        //selectedOptions:[],//当前选中的地域信息
        // regionParams:{
        //         label:'name', //这里可以配置你们后端返回的属性
        //         value:'code',
        //         children:'children',
        //         expandTrigger: 'click',
        //       },//地域信息配置参数
              
      // 表单校验
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
    }
  },
  mounted() {
    let aa = this.storage.getItem("serviceType");
    //alert(aa)
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
    handleChange(value) {
        console.log(value);
    },
    agreebtn(){
      this.$router.push({ path: '/quotation/agreeTerms'})
    },
    onSubmit() {
        console.log('submit!');
    },
    btnContinue2(){
      this.$router.push({ path: '/artificial/receipt', query: { } })
    },
    
    /** 提交按钮 */
    btnContinue() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.$modal.confirm('确认推送数据到eshop接口？').then(function() {
             
          }).then(() => {
            addEshop(this.form).then(response => {
                this.$modal.msgSuccess("推送成功");
              });
          }).catch(() => {});
        }
      });
    },
  },
}
</script>
<style lang="scss" scoped>
@import './pushEshop.scss';
</style>
<style lang="scss">
.el-message-box{
  width: auto !important;
}

#app {
  background: #ffffff !important;
}

</style>