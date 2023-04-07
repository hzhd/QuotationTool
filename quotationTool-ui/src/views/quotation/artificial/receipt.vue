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
    <!-- <div class="innerWrap">
      <h3></h3>
      <div class="topTips">          
        <span class="tips" style="">您的信息已经成功提交</span>
        <br>
        <span class="tips">为了给您提供更好的服务，请填写以下相关信息，博世热力技术的相关人员将与您取得进一步联系。</span>
      </div>      
    </div>
    <div class="successInfo">
      <img src="../../../assets/images/success.png" class="bosch_logo"/>
    </div> -->
    <div class="center-box">
      <div class="finish-icon">
        <img src="../../../assets/images/success.png" class="bosch_logo"/>
      </div>
      <div class="tit">您的信息已经成功提交</div>
        <p>我们的服务人员会在4小时内联系您，<br>
          注意接听电话，谢谢！</p>
    </div>
  </div>
</template>
<script>
// import { apiGet } from '@/api/api'
export default {
  data() {
    return {
      storage: window.sessionStorage,
      param:{
        name: null,
        nickName: null,
        region: null,
        phonenumber: null,
      }
              
    }
  },
  mounted() {
    this.param.name = this.storage.getItem("name")
    this.param.nickName = this.storage.getItem("nickName")
    this.param.region = this.storage.getItem("region")
    this.param.phonenumber = this.storage.getItem("phonenumber")
    
    //alert(JSON.stringify(this.param))
  },
  methods: {
    gotoHistory(){
      if(!this.name){
        this.$router.push({ path: '/artificial/personInfo'})
      }
    },
    onSubmit() {
      console.log('submit!');
    }
  },
}
</script>
<style lang="scss" scoped>
@import './receipt.scss';
</style>
<style lang="scss">
  .gameSelect .center-box {
    position: relative;
    display: flex;
    flex-flow: column nowrap;
    height: 100%;
    justify-content: center;
    text-align: center;
    margin: 0;
    width: 100%;
}
.gameSelect .center-box .finish-icon {
    position: relative;
    width: 25%;
    margin: -2rem auto 2rem;
}
.center-box img {
    border: none;
    max-width: 100%;
    height: 100px;
}
.gameSelect .center-box .tit {
    font-size: 1rem;
    font-weight: bold;
    margin-bottom: 0.5rem;
}
.center-box p {
    font-size: 0.875rem;
    line-height: 1.5rem;
    color: #3e3a39;
}

</style>