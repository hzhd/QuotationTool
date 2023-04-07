<template>
  <div class="gameSelect">
    <div class="bgImage">
      <img src="@/assets/images/second-bg.jpg" class="bgImg">
    </div>
    <div class="header">
      <img src="@/assets/images/header.jpg" class="headerImg"/>
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
    <div class="second">
      <span class="bt1"  @click="btnContinue">进入自助报价系统<br/>获取采暖匹配方案</span>
      <span class="bt2"  @click="btnServer">已提前选好心仪产品<br/>需要人工服务</span>
    </div>
  </div>
</template>
<script>
// import { apiGet } from '@/api/api'
export default {
  data() {
    return { 
      storage: window.sessionStorage
    }
  },
  mounted() {
    
  },
  methods: {
    btnContinue(){      
      this.storage.setItem("serviceType", "selfService");
      this.$router.push({ path: '/quotation/fourth', query: { } })
    },
    btnServer(){
      this.storage.setItem("serviceType", "artificial");
      // alert("请拨打客服电话。");
      this.$router.push({ path: '/artificial/personInfo', query: { } })

    },
  },
}
</script>
<style lang="scss" scoped>
@import './second.scss';
</style>
<style lang="scss">
#app {
  background: #ffffff !important;
}
.el-select-dropdown__wrap {
  max-height: 10000px!important;
}
</style>