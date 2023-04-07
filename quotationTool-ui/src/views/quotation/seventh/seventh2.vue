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

    <div class="seventhForm">
      <div class="videoBtnWrap">
        <span style="color:#00884a;font-weight: bold;fload:left; font-size: 24px;">博世采暖方案报价</span>
        <img src="../../../assets/images/bosch-letter.png" width="150px" style="margin-bottom: -10px;"/>
      </div>
    </div>
    <div class="info" style="margin: 20px;">
      <div class="info-block">        
        <div class="info-head" style="margin-bottom: 10px;">
          <span style="color:#00884a;font-weight: 700;fload:left;">采暖住宅基本信息</span>
          <el-link type="primary" @click="goFourth" style="float: right;text-decoration: underline;font-size: 16px;font-weight: bold;">编辑修改</el-link>
        </div>
        <div class="info-item">
          <div class="info-item-lable">采暖类型</div><div class="info-item-content">{{this.zhuzhaiText}}</div>
        </div>
        <div class="info-item" v-if="this.zhuzhai=='third'">
          <div class="info-item-lable">是否采用博世壁挂炉</div><div class="info-item-content">{{this.isBosch}}</div>
        </div>
        <div class="info-item" v-if="this.zhuzhai!='third'">
          <div class="info-item-lable">住宅类型</div><div class="info-item-content">{{this.heatingType}}</div>
        </div>
        <div class="info-item">
          <div class="info-item-lable">房屋面积</div><div class="info-item-content">{{this.extent}}</div>
        </div>
        <div class="info-item">
          <div class="info-item-lable">花洒个数</div><div class="info-item-content">{{this.shower}}</div>
        </div>
      </div>
      <div class="info-block">        
        <div class="info-head" style="margin-bottom: 10px;">
          <span style="color:#00884a;font-weight: 700;fload:left;">采暖产品信息</span>
          <el-link type="primary" @click="goFifth" style="float: right;text-decoration: underline;font-size: 16px;font-weight: bold;">编辑修改</el-link>
        </div>
        <div class="info-item">
          <div class="info-item-lable">产品类别</div><div class="info-item-content">{{this.productType}}</div>
        </div>
        <div class="info-item">
          <div class="info-item-lable">系统配件套餐</div><div class="info-item-content">{{this.fittingsType}}</div>
        </div>
        <!-- <div class="info-item">
          <div class="info-item-lable">辅材类别</div><div class="info-item-content">a/b/c</div>
        </div> -->
        <div class="info-item">
          <div class="info-item-lable">产品功率</div><div class="info-item-content">{{this.kwH}}</div>
        </div>
      </div>
      
      <!-- <el-form ref="form" :model="form" label-width="100px" label-position="top" style="margin-top: 20px;">
        <el-form-item>
              <el-checkbox
                v-model="form.agreeClause"
                style="margin: 0px 0px 0px 0px;white-space: pre-wrap;display: inline-flex;">
                <span style="-webkit-transform: scale(0.4);font-size: 8px;">&nbsp;&nbsp;&nbsp;&nbsp;我已阅读并理解</span>
                  <span  @click="agreebtn" style="color: #006ead; font-size: 8px;">《博世热力技术(北京)有限公司个人信息收集声明》</span>
              </el-checkbox>
            </el-form-item>
      </el-form> -->
    </div>
    
    <div class="btn-div">
        <button class="btnContinue" @click="btnContinue">
            确&nbsp;&nbsp;认&nbsp;&nbsp;并&nbsp;&nbsp;提&nbsp;&nbsp;交
        </button>
    </div>
  </div>
</template>
<script>
// import { apiGet } from '@/api/api'
import { listEshop, getEshop, delEshop, addEshop, addEshopQuotation, updateEshop } from "@/api/quotationApi/eshop";
export default {
  data() {
    return {
      storage: window.sessionStorage,
      form:{
        agreeClause: false
      },
      heatingType: null,
      extent: null,
      shower: null,
      isBosch: null,
      zhuzhai: null,
      name: null,
      nickName: null,
      region: null,
      phonenumber: null,
      fittingsType: null,
      productType: null,
      kwH: null,
      zhuzhaiText: null,
      regionCity: null,
      regionCountry: null,
      regionProvince: null,
      groupNumber: 1,
      extentNumber: 0,
      qrcodeId: null,
      param: {        
        heatingType: null,
        extent: null,
        shower: null,
        isBosch: null,
        zhuzhai: null,
        name: null,
        nickName: null,
        region: null,
        phonenumber: null,
        fittingsType: null,
        productType: null,
        kwH: null,
        zhuzhaiText: null,
        regionCity: null,
        regionCountry: null,
        regionProvince: null,
        qrcodeId: null,
        casename1: null,
        productgroup1: null,
        product1: null,
        price1: 0,
        casename2: null,
        productgroup2: null,
        product2: null,
        price2: 0,

      },
    }
  },
  mounted() {
    this.heatingType=this.storage.getItem("heatingType")
    this.extent=this.storage.getItem("extent")
    this.shower=this.storage.getItem("shower")
    this.isBosch=this.storage.getItem("isBosch")==1?"是":"否"
    this.zhuzhai=this.storage.getItem("zhuzhai")
    this.name=this.storage.getItem("name")
    this.nickName=this.storage.getItem("nickName")
    this.region=this.storage.getItem("region")
    this.phonenumber=this.storage.getItem("phonenumber")
    this.productType=this.storage.getItem("productType")
    this.fittingsType=this.storage.getItem("fittingsType")
    this.regionCity=this.storage.getItem("regionCity")
    this.regionCountry=this.storage.getItem("regionCountry")
    this.regionProvince=this.storage.getItem("regionProvince")
    this.qrcodeId=this.storage.getItem("qrcodeId")
    
    this.gotoHistory()

    this.setkwh()
    this.setExtent()
    this.setShower()
    this.setZhuzhai()
  },
  methods: {
    gotoHistory(){
      if(!this.extent||!this.shower){
        this.$router.push({ path: '/quotation/fourth'})
      }else if(!this.productType){
        this.$router.push({ path: '/quotation/fifth'})
      }else if(!this.fittingsType&&this.zhuzhai&&this.zhuzhai!='third'){
        this.$router.push({ path: '/quotation/sixth'})
      }else if(!this.name){
        this.$router.push({ path: '/quotation/third'})
      }
    },
    setExtent(){
      let mc = this.extent;
      switch(mc){
        case 'a':
          this.extent='<80㎡'
          this.extentNumber=80
          break
        case 'b':
          this.extent='80-150㎡'
          this.extentNumber=115
          break
        case 'c':
          this.extent='151-230㎡'
          this.extentNumber=190
          break
        case 'd':
          this.extent='231-300㎡'
          this.extentNumber=265
          break
        case 'e':
          this.extent='>300㎡'
          this.extentNumber=300
          break          
      }
    },
    setShower(){
      let mc = this.shower
      switch(mc){
        case 'a':
          this.shower='1个'
          break
        case 'b':
          this.shower='2个'
          break
        case 'c':
          this.shower='3个'
          break   
      }
    },
    setkwh(){
      let mc = this.extent;
      switch(mc){
        case 'a':
          this.kwH='18kw'
          break
        case 'b':
          this.kwH='24kw'
          break
        case 'c':
          this.kwH='28kw'
          break
        case 'd':
          this.kwH='35kw'
          break
        case 'e':
          this.kwH='38kw'
          break             
      }

    },
    setZhuzhai(){
      let mc = this.zhuzhai;
      switch(mc){
        case 'first':
          this.zhuzhaiText='新房装修'
          break
        case 'second':
          this.zhuzhaiText='已装修房屋'
          break
        case 'third':
          this.zhuzhaiText='单机置换'
          break
      }

    },
    goFourth(){
      this.$router.push({ path: '/quotation/fourth'})
    },
    goFifth(){
      this.$router.push({ path: '/quotation/fifth'})
    },
    agreebtn(){
      this.$router.push({ path: '/quotation/agreeTerms'})
    },
    /** 提交按钮 */
    btnContinue: function () {
      // if(this.form.agreeClause==false){
      //   this.$notify.warning({
      //     title: "提示",
      //     message: "请阅读并理解《博世热力技术(北京)有限公司个人信息收集声明》",
      //     position: 'top-right',
      //   });
      //   return
      // }
      let quantityShower = 0
      //转换花洒个数
      if(this.shower){
        quantityShower = this.shower.slice(0,1)
      }

      this.param.favoriteheating=this.heatingType
      this.param.buildingarea=this.extent
      this.param.sprinklerquantity=quantityShower
      this.param.statusname=this.isBosch
      this.param.installationtypename=this.zhuzhaiText
      this.param.customername=this.name
      this.param.customerappellation=this.nickName
      this.param.city=this.regionCity
      this.param.county=this.regionCountry
      this.param.province=this.regionProvince
      this.param.customerphone=this.phonenumber
      this.param.auxiliarymaterialstype=this.fittingsType
      this.param.boilerpower=this.kwH
      this.param.qrcodeId = this.qrcodeId
      this.param.casename1 = '推荐方案1'//方案1
      this.param.casename2 = '推荐方案2'//方案2
      this.param.productgroup1  = this.fittingsType//产品系列1
      this.param.productgroup2  = this.fittingsType//产品系列2
      this.param.product1 = null//产品型号1
      this.param.product2 = null//产品型号2
      this.param.price1 = 0//报价1
      this.param.price2 = 0//报价2

      this.param.price = null
      //推荐方案信息
      //产品计算价格
      if(this.productType=='一级'){
        this.param.product1='C7100'
        this.param.product2='G7100'
        this.param.price1+=25600
        this.param.price2+=11000        
      }else{//二级能效的计算
        this.param.product1='欧洲贵族'
        this.param.product2='欧洲臻享'
        this.param.price1+=20000
        this.param.price2+=18000
      }
      //辅材计算价格、、散热片：地区单价*暖气片组数、、地板采暖：地区单价*输入面积*0.7
      if(this.zhuzhai!='third'){
          if(this.heatingType=='散热片'){    
            if(this.regionProvince=='河北省'||this.regionProvince=='宁夏'||this.regionProvince=='西藏'){
              this.groupNumber=3
              if(this.fittingsType=='豪华型'){
                this.param.price1+=3500*3
                this.param.price2+=3500*3
              }else if(this.fittingsType=='舒适型'){
                this.param.price1+=3000*3
                this.param.price2+=3000*3
              }else if(this.fittingsType=='经济型'){
                this.param.price1+=2300*3
                this.param.price2+=2300*3
              }
            }else{
              this.groupNumber=2
              if(this.fittingsType=='豪华型'){
                this.param.price1+=3500*2
                this.param.price2+=3500*2
              }else if(this.fittingsType=='舒适型'){
                this.param.price1+=3000*2
                this.param.price2+=3000*2
              }else if(this.fittingsType=='经济型'){
                this.param.price1+=2300*2
                this.param.price2+=2300*2
              }
            }
          }else{            
            if(this.fittingsType=='豪华型'){
              this.param.price1+=475*this.extentNumber*0.7
              this.param.price2+=475*this.extentNumber*0.7
            }else if(this.fittingsType=='舒适型'){
              this.param.price1+=350*this.extentNumber*0.7
              this.param.price2+=350*this.extentNumber*0.7
            }else if(this.fittingsType=='经济型'){
              this.param.price1+=160*this.extentNumber*0.7
              this.param.price2+=160*this.extentNumber*0.7
            }
          }          
        }
      
      this.param.product=this.param.product1+' or ' + this.param.product2

      this.storage.setItem("casename1", this.param.casename1)
      this.storage.setItem("productgroup1", this.param.productgroup1)
      this.storage.setItem("product1", this.param.product1)
      this.storage.setItem("price1", this.param.price1)
      this.storage.setItem("casename2", this.param.casename2)
      this.storage.setItem("productgroup2", this.param.productgroup2)
      this.storage.setItem("product2", this.param.product2)
      this.storage.setItem("price2", this.param.price2)
      this.storage.setItem("groupNumber", this.groupNumber)
      this.storage.setItem("extentNumber", this.extentNumber)

      if (this.extent||this.shower||this.zhuzhai||this.name||this.nickName||this.region||this.phonenumber||this.productType||this.qrcodeId) {
        
        //this.$refs["form"].validate(valid => {
        //  if (valid) {
            // this.$modal.confirm('确认提交当前显示的报价信息？').then(function() {
              
            // }).then(() => {
              addEshopQuotation(this.param).then(response => {
                this.$modal.msgSuccess("报价成功");
                this.$router.push({ path: '/quotation/eighth2', query: { } })
              });
            // }).catch(() => {});
        //  }
        //});
      }else{
        this.$modal.msgSuccess("填写数据不完整，请重新填写");
      }
    },
  },
}
</script>
<style lang="scss" scoped>
@import './seventh.scss';
</style>
<style lang="scss">
.el-message-box{
  width: auto !important;
}
#app {
  background: #ffffff !important;
}
</style>