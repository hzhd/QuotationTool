<template>
  <div class="gameSelect">
    <div class="header">
      <img src="@/assets/images/header.jpg" />
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
        <span class="tips">尊敬的用户，您好！</span>
        <br>
        <span class="tips">为了给您提供更好的服务，请填写以下相关信息，博世热力技术的相关人员将与您取得进一步联系。</span>
      </div>

      <div class="thirdForm">
        <el-form ref="form" :rules="rules" :model="form" label-width="100px" label-position="top">
          <el-form-item label="您的姓氏" prop="name">
            <el-input v-model="form.name" placeholder="请输入您的姓氏"></el-input>
          </el-form-item>
          <el-form-item label="您的称呼" prop="nickName">
            <!-- <el-input v-model="form.nickName" placeholder="请输入您的称呼"></el-input> -->
            <el-select v-model="form.nickName" placeholder="请选择您的称呼">
              <el-option label="先生" value="先生"></el-option>
              <el-option label="女士" value="女士"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="您所在城市" prop="region">
            <!-- <el-select v-model="form.region" placeholder="请选择您的城市">
              <el-option label="上海" value="shanghai"></el-option>
              <el-option label="北京" value="beijing"></el-option>
            </el-select> -->
            <!-- <el-cascader ref="cascader" clearable v-model="form.region" :options="regionOption" :props="regionParams"
              @change="handleChange"></el-cascader> -->
            <!---地区获取插件--->
            <mt-cell title="" is-link @click.native="showPopup">
              <span style="text-align: left;">{{ currentTags }}</span>
            </mt-cell>
            <mt-popup v-model="popupVisible" position="bottom" :modal="true" :closeOnClickModal="false"
              popup-transition="popup-fade" style="width : 100%;">
              <mt-picker :slots="addressList" :show-toolbar="true" ref="familyAddress" :itemHeight=44 valueKey="name"
                @change="onValuesChange">
                <slot>
                  <div class="toolbar">
                    <span class="cancel-container" @click="cancelChoose">取消</span>
                    <span class="confirm-container" @click="confirmChoose">确认</span>
                  </div>
                </slot>
              </mt-picker>
            </mt-popup>

          </el-form-item>
          <el-form-item label="您的联系方式" prop="phonenumber">
            <el-input v-model="form.phonenumber" placeholder="请输入您的手机号"></el-input>
          </el-form-item>
          <el-form-item>
            <el-checkbox v-model="form.agreeClause" style="margin: 0px 0px 0px 0px;white-space: pre-wrap;">
              <span style="-webkit-transform: scale(0.4);font-size: 8px;">&nbsp;&nbsp;&nbsp;&nbsp;我已阅读并理解</span>
              <!-- <br/> -->
              <!-- <el-link type="primary" @click="agreebtn"> -->
              <span @click="agreebtn" style="color: #006ead; font-size: 8px;">《博世热力技术(北京)有限公司个人信息收集声明》</span>
              <!-- </el-link> -->
            </el-checkbox>
          </el-form-item>

        </el-form>
      </div>
    </div>
    <div class="btn-div">
      <el-button class="btnContinue" @click="btnContinue">
        点击生成报价单
      </el-button>
    </div>
  </div>
</template>
<script>
import myaddress from '@/api/quotationData/chinaArea.json'        //这是json格式的省市区数据自行下载
import { pcaData } from '@/api/quotationData/pca.data.js'
import { getProvince, getCityByProvince, getCountryByCity } from '@/api/quotationApi/pca.js'
import loglat from '@/api/quotationData/loglat.json'
export default {
  data() {
    return {
      storage: window.sessionStorage,
      form: {
        name: '',
        region: [],
        nickName: '',
        phonenumber: '',
        agreeClause: false,
        regionCity: '',
        regionProvince: '',
        regionCountry: '',
      },
      regionOption: pcaData(), //地域信息
      selectedOptions: [],//当前选中的地域信息
      regionParams: {
        label: 'name', //这里可以配置你们后端返回的属性
        value: 'code',
        children: 'children',
        expandTrigger: 'click',
      },//地域信息配置参数


      extent: null,
      shower: null,
      fittingsType: null,
      productType: null,
      zhuzhai: null,
      loglatList: loglat.RECORDS,
      log: null,
      lat: null,

      // 表单校验
      rules: {
        name: [
          { required: true, message: "姓氏不能为空", trigger: "blur" },
          { min: 1, max: 20, message: '姓氏名称长度必须介于 1 和 20 之间', trigger: 'blur' }
        ],
        nickName: [
          { required: true, message: "称呼不能为空", trigger: "blur" },
          { min: 1, max: 20, message: '称呼长度必须介于 1 和 20 之间', trigger: 'blur' }
        ],
        region: [
          { required: true, message: "地区不能为空", trigger: "blur" },
        ],
        phonenumber: [
          { required: true, message: "手机号码不能为空", trigger: "blur" },
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur"
          }
        ]
      },
      //地区选择插件属性
      myaddress: myaddress.childList,
      address: null,
      currentTags: "请选择",
      currentCode: "",
      handler: function (e) {
        e.preventDefault()
      },
      popupVisible: false,
      province: '',//省
      city: '',//市
      county: '',//县
      provinceCode: '',//省级代码
      cityCode: '', //市级代码
      countyCode: '',//县级代码
      regionInit: false,//禁止地区选择器自动初始化，picker组件会默认进行初始化，导致一进入页面就会默认选中一个初始3级地址
    }
  },
  created() {
    // 获取所有省市区
    // axios.get("/api/address").then(res => {
    //     if (res) {
    //         this.address = res
    //     }
    // })
    this.address = this.myaddress
  },
  mounted() {
    this.extent = this.storage.getItem("extent")
    this.shower = this.storage.getItem("shower")
    this.productType = this.storage.getItem("productType")
    this.fittingsType = this.storage.getItem("fittingsType")
    this.zhuzhai = this.storage.getItem("zhuzhai")
    this.gotoHistory()
    //数据回显
    this.form.name = this.storage.getItem("name")
    this.form.region = this.storage.getItem("region")
    this.form.nickName = this.storage.getItem("nickName")
    this.form.phonenumber = this.storage.getItem("phonenumber")
    this.form.regionProvince = this.storage.getItem("regionProvince")
    this.form.regionCity = this.storage.getItem("regionCity")
    this.form.regionCountry = this.storage.getItem("regionCountry")
    if (this.form.region != null) {
      this.currentTags = this.form.regionProvince + "/" + this.form.regionCity + "/" + this.form.regionCountry
    }
    console.log(this.form.region)

  },
  methods: {
    gotoHistory() {
      if (!this.extent || !this.shower) {
        this.$router.push({ path: '/quotation/fourth' })
      } else if (!this.productType) {
        this.$router.push({ path: '/quotation/fifth' })
      } else if (!this.fittingsType && this.zhuzhai && this.zhuzhai != 'third') {
        this.$router.push({ path: '/quotation/sixth' })
      }
    },
    handleChange(value) {
      this.form.region = value
      console.log(value);

      //处理城市问题13,1303,130321
      // let provinceStr = this.region.split(',')[0]
      // let cityStr = this.region.split(',')[1]
      let provinceStr = value[0]
      let cityStr = value[1]
      let countryStr = value[2]
      let provinceList = this.regionOption;
      this.form.regionProvince = provinceList.filter((i) => i.code == provinceStr)[0].name;
      let cityList = getCityByProvince(provinceStr);
      this.form.regionCity = cityList.filter((i) => i.code == cityStr)[0].name;
      let countryList = getCountryByCity(cityStr, cityList);
      this.form.regionCountry = countryList.filter((i) => i.code == countryStr)[0].name;
      // alert(this.form.regionCity+"/"+this.form.regionCountry+"/"+this.form.regionProvince);
      //debugger
      let cityList2 = this.loglatList.filter((i) => i.name == this.form.regionProvince)[0].children;
      let city2 = cityList2.filter((i) => i.name == String(this.form.regionCity).slice(0, 2) || i.name == String(this.form.region.regionCountry).slice(0, 2))[0]
      if (city2 == undefined) {
        this.log = cityList2[0].log
        this.lat = cityList2[0].lat
      } else {
        this.log = city2.log;
        this.lat = city2.lat;
      }
      this.storage.setItem("longitude", this.log)
      this.storage.setItem("latitude", this.lat)

      //alert(this.log+"/"+this.lat)


    },
    /** 提交按钮 */
    btnContinue: function () {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.agreeClause == false) {
            this.$notify.warning({
              title: "提示",
              message: "请阅读并理解《博世(中国)有限公司个人信息保护政策》",
            });
            return
          }

          this.storage.setItem("name", this.form.name);
          this.storage.setItem("nickName", this.form.nickName);
          this.storage.setItem("region", this.form.region);
          this.storage.setItem("phonenumber", this.form.phonenumber);
          this.storage.setItem("regionCity", this.form.regionCity);
          this.storage.setItem("regionCountry", this.form.regionCountry);
          this.storage.setItem("regionProvince", this.form.regionProvince);
          if (this.form.name != undefined && this.form.name) {
            //updateUser(this.form).then(response => {
            //this.$modal.msgSuccess("修改成功");
            this.$router.push({ path: '/quotation/seventh2', query: {} })
            //});
          } else {
            //addUser(this.form).then(response => {
            this.$modal.msgSuccess("新增成功");
            //});
          }
        }
      });
    },
    agreebtn() {
      this.storage.setItem("name", this.form.name);
      this.storage.setItem("nickName", this.form.nickName);
      this.storage.setItem("region", this.form.region);
      this.storage.setItem("phonenumber", this.form.phonenumber);
      this.storage.setItem("regionCity", this.form.regionCity);
      this.storage.setItem("regionCountry", this.form.regionCountry);
      this.storage.setItem("regionProvince", this.form.regionProvince);
      this.$router.push({ path: '/quotation/agreeTerms' })
    },
    onSubmit() {
      console.log('submit!');
    },
    // 跳转路由
    jumpRouter() {
      window.ss.goPretreatmentPage(this.gameid, this.game);
    },
    onChangeStripe: function (e) {
      console.log(e);

      this.gameid = e.id;
      this.game = e.name;
    },
    //地区选择插件
    closeTouch() {
      document.getElementsByTagName('body')[0].addEventListener('touchmove', this.handler, { passive: false })//阻止默认事件
    },
    openTouch() {
      document.getElementsByTagName('body')[0].removeEventListener('touchmove', this.handler, { passive: false })//打开默认事件
    },
    getProvinceArr() {
      let provinceArr = [];
      if (this.address) {
        this.address.forEach(function (item) {
          let obj = {};
          obj.name = item.name;
          obj.code = item.code;
          provinceArr.push(obj);
        });
      }
      return provinceArr;
    },
    //遍历json，返回市级对象数组
    getCityArr(province) {
      let cityArr = [];
      if (this.address) {
        this.address.forEach(function (item) {
          if (item.name === province) {
            item.childList.forEach(function (args) {
              let obj = {};
              obj.name = args.name;
              obj.code = args.code;
              cityArr.push(obj);
            });
          }
        });
      }
      return cityArr;
    },
    //遍历json，返回县级对象数组
    getCountyArr(province, city) {
      let countyArr = [];
      if (this.address) {
        this.address.forEach(function (item) {
          if (item.name === province) {
            item.childList.forEach(function (args) {
              if (args.name === city) {
                args.childList.forEach(function (param) {
                  let obj = {};
                  obj.name = param.name;
                  obj.code = param.code;
                  countyArr.push(obj);
                })
              }
            });
          }
        })
      }
      return countyArr;
    },
    showPopup() {
      this.popupVisible = true
      this.closeTouch();
    },
    cancelChoose() {
      this.popupVisible = false;
      this.openTouch();
    },
    confirmChoose() {
      let vals = this.$refs.familyAddress.getValues()
      this.getFamilyAddress(vals)
      this.popupVisible = false;
      this.openTouch();
    },
    getFamilyAddress(vals) {
      this.province = vals[0].name
      this.city = vals[1].name
      this.provinceCode = vals[0].code
      this.cityCode = vals[1].code
      if (vals[2] != null) {
        this.county = vals[2].name
        this.countyCode = vals[2].code
      }else{
        this.county=""
        this.countyCode=""
      }
      this.currentTags = this.province + '/' + this.city + '/' + this.county
      this.currentCode = this.provinceCode + ',' + this.cityCode + ',' + this.countyCode
      this.form.region = this.currentCode
      this.form.regionProvince = this.province
      this.form.regionCity = this.city
      this.form.regionCountry = this.county
      console.log("当前地址：" + this.currentTags)
      console.log("当前地址编码：" + this.currentCode)
    },
    onValuesChange(picker, values) {
      if (this.regionInit) {
        let provinceArr = this.getProvinceArr();
        picker.setSlotValues(0, provinceArr);
        let cityArr = this.getCityArr(values[0].name);
        picker.setSlotValues(1, cityArr);
        let countyArr = this.getCountyArr(values[0].name, values[1].name);
        picker.setSlotValues(2, countyArr);
      } else {
        this.regionInit = true;
      }
    },
  },
  computed: {
    addressList: function () {
      if (this.address) {
        let provinceArr = this.getProvinceArr();
        //处理回显
        let cityArr = null
        let countyArr = null
        // if (this.form.region != null) {
        //   cityArr = this.getCityArr(this.form.regionCity);
        //   countyArr = this.getCountyArr(this.form.regionCity, this.form.regionCountry);
        // } else {
        cityArr = this.getCityArr("北京市");
        countyArr = this.getCountyArr("北京市", "市辖区");
        // }
        return [
          {
            flex: 1,
            values: provinceArr, //省份数组
            className: 'slot1',
            textAlign: 'center'
          },
          {
            divider: true,
            content: '-',
            className: 'slot2'
          },
          {
            flex: 1,
            values: cityArr,
            className: 'slot3',
            textAlign: 'center'
          },
          {
            divider: true,
            content: '-',
            className: 'slot4'
          },
          {
            flex: 1,
            values: countyArr,
            className: 'slot5',
            textAlign: 'center'
          }
        ]
      }
      return []
    }
  },
}
</script>
<style lang="scss" scoped>
@import './third.scss';
</style>
<style lang="scss">
#app {
  background: #ffffff !important;
}

.el-select-dropdown__wrap {
  max-height: 10000px !important;
}
</style>
<style>
.toolbar {
  width: 100%;
  display: flex;
  text-align: center;
  background: #F7F7F7;
  border-bottom: 1px solid #EEE;
}

.toolbar span {
  flex: 1;
  font-size: 16px;
  color: #26a2ff;
  line-height: 44px;
}

.mint-cell-title {
  flex: 0 !important;
}

.mint-cell {
  min-height: 40px !important;
  border: 1px solid #dddddd !important;
  border-radius: 4px !important;
}
</style>