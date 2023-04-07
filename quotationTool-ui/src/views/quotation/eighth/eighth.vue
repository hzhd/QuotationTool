<template>
  <div class="gameSelect">
    <div class="topWrap"></div>
    <!-- <div class="logoBanner">
      <div class="logo_div">
        <img src="../../../assets/images/bosch_logo.png" class="bosch_logo"/>
      </div>
      <div class="logo_div2">
        <img src="../../../assets/images/bosch_logo2.png" class="bosch_logo2"/>
      </div>
    </div> -->
    
    <div class="topTips">          
        <span class="tips">尊敬的<span style="color: rgb(0, 136, 74);">{{this.name}}{{this.nickName}}</span>先生/女士：</span>
        <br>
        <span class="tips">请查收博世热力技术为您生成的专属采暖方案：</span>
    </div>
    <div class="sulutionCard">
      <el-row style="margin: 20px;">
        <!-- <el-col :span="8" v-for="(o, index) in 2" :key="o" :offset="index > 0 ? 2 : 0"> -->
        <el-col :span="10" style="margin-right: 30px;">
          <el-card :body-style="{ padding: '0px' }">
            <img :src="require('@/assets/images/solution1.jpg')" class="image"/>
            <!-- <div style="padding: 14px;">
              <span></span>
              <div class="bottom clearfix">
                <time class="time">{{ currentDate }}</time>
                <el-button type="text" class="button">操作按钮</el-button>
              </div>
            </div> -->
          </el-card>
        </el-col>
        <el-col :span="10">
          <el-card :body-style="{ padding: '0px' }">
            <img :src="require('@/assets/images/solution2.jpg')" class="image"/>
          </el-card>
        </el-col>
      </el-row>
    </div>
    <div class="siteTips">
      <span class="tips">根据采暖方案中的地址信息，为您推荐以下授权门店。</span>
    </div>
    <div class="siteImg">
      <!-- <img src="../../../assets/images/dizhi.jpg" class="site_img" width="100%"/> -->
      <el-image
              :src="require('@/assets/images/dizhi.jpg')"
              fit="scale-down" class="image site_img" @click="goBosch"></el-image>
    </div>
    <!-- <div class="blankDiv"></div> -->
    <div class="bottomImg"></div>  
  </div>
</template>
<script>
// import { apiGet } from '@/api/api'
export default {
  data() {
    return {
      storage: window.sessionStorage,
      form:{
        region: '',
        region1: '',
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
      currentDate: new Date(),
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
    this.setkwh()
    
  },
  methods: {
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
    goBosch(){
      window.location.href="https://wechat.bosch-climate.cn/weixin/dealer/dealer_list.jsp?branch_type_pid=1&lat=31.362686&lng=121.29559"
        + "&ran=" + Math.random()
      
    },
    btnContinue(){
      this.$router.push({ path: '/quotation/second', query: { } })
    },

  },
}
</script>
<style lang="scss" scoped>
@import './eighth.scss';
</style>

<style>
  .site_img:hover{
    /* border: 1px solid #f00; */
    cursor: pointer;
  }
  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
    height: 205px;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
</style>