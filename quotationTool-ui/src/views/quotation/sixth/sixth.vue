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
        <span class="tips">尊敬的用户，您好！</span>
        <br>
        <span class="tips">为了给您提供更好的服务，请填写一下相关信息，自助服务系统将为您生成专属的采暖方案。</span>
      </div>   
      <div class="bigualu">
        <span style="margin:20px;font-size: 20px;color: #00884a;font-weight: 700;">第三步：选择您所需的系统配套套餐</span><br/><br/>
      </div>
      <div class="center-box">
        <section class="content-area container area-city">
            <div class="home-list">
                <div class="home-item" data-id="1"  data-value="豪华型" :class="{ activeTag: isActive1 }" @click="setActive1">
                    <img class="chioce" src="../../../assets/images/tc-haohuaxing.jpg" />
                    <img class="home-item-img" src="../../../assets/images/tc-haohuaxing.jpg" />
                </div>
                <div class="home-item" data-id="2"  data-value="舒适型" :class="{ activeTag: isActive2 }" @click="setActive2">
                    <img class="chioce" src="../../../assets/images/tc-shushixing.jpg" />
                    <img class="home-item-img" src="../../../assets/images/tc-shushixing.jpg" />
                </div>
                <div class="home-item" data-id="3"  data-value="经济型" :class="{ activeTag: isActive3 }" @click="setActive3">
                    <img class="chioce" src="../../../assets/images/tc-jingjixing.jpg" />
                    <img class="home-item-img" src="../../../assets/images/tc-jingjixing.jpg" />
                </div>
            </div>
        </section>
      </div>
      
    </div>
    <div class="btn-div">
        <button class="btnContinue" @click="btnContinue">
          下&nbsp;&nbsp;&nbsp;&nbsp;一&nbsp;&nbsp;&nbsp;&nbsp;步
        </button>
    </div>
  </div>
</template>
<script>
// import { apiGet } from '@/api/api'
export default {
  data() {
    return {
      storage: window.sessionStorage,
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      isActive1: false,
      isActive2: false,
      isActive3: false,
      activeName: 'first',
      
      extent: null,
      shower: null,
      productType: null,
    }
  },
  mounted() {
    this.extent=this.storage.getItem("extent")
    this.shower=this.storage.getItem("shower")
    this.productType=this.storage.getItem("productType")

    this.gotoHistory()
    
    //数据回显
    if(this.storage.getItem("fittingsType")=='豪华型'){
      this.isActive1 = true
      this.isActive2 = false
      this.isActive3 = false
    }else if(this.storage.getItem("fittingsType")=='舒适型'){
      this.isActive2 = true
      this.isActive1 = false
      this.isActive3 = false
    }else{
      this.isActive3 = true
      this.isActive1 = false
      this.isActive2 = false
    }
    
  },
  methods: {
    gotoHistory(){
      if(!this.extent||!this.shower){
        this.$router.push({ path: '/quotation/fourth'})
      }else if(!this.productType){
        this.$router.push({ path: '/quotation/fifth'})
      }
    },
    setActive1() {
      this.isActive1 = true
      this.isActive2 = false
      this.isActive3 = false
    },
    setActive2() {
      this.isActive2 = true
      this.isActive1 = false
      this.isActive3 = false
    },
    setActive3() {
      this.isActive3 = true
      this.isActive1 = false
      this.isActive2 = false
    },
    
    handleClick(tab, event) {
      console.log(tab, event);
    },
    onSubmit() {
        console.log('submit!');
    },
    
    /** 提交按钮 */
    btnContinue: function () {
      if (this.isActive1) {
          this.storage.setItem("fittingsType", '豪华型');
      }else if(this.isActive2){
        this.storage.setItem("fittingsType", '舒适型');
      }else if(this.isActive3){
        this.storage.setItem("fittingsType", '经济型');
      }else{
        this.$notify.warning({
          title: "提示",
          message: "请选择系统配件套餐",
          position: 'top-right',
        });
        return
      }
      this.$router.push({ path: '/quotation/third', query: {} })
    },
  },
}
</script>
<style lang="scss" scoped>
@import './sixth.scss';
</style>
<style lang="scss">
#app {
  background: #ffffff !important;
}

.home-item-img{
  // height: 95px;
  /* width: 80%; */
  max-width: 100%;
  margin-bottom: 20px;
  margin-top: 20px;
  box-shadow: 0px 0px 10px #d6d6d6;
}
.chioce{
  // height: 95px;
  /* width: 80%; */
  max-width: 100%;
  display: none;
}

.home-list .home-item{  
  display: flex;
  justify-content: center;
  align-items: center;
}

.home-list .home-item:hover .chioce {
  display: block;  
  // height: 95px;
  max-width: 100%;
  margin-bottom: 20px;
  margin-top: 20px;
  transition: width 2s;
  border: rgb(0, 136, 74) 2px solid;
  box-shadow: 0px 5px 10px rgb(0, 136, 74);
}

.home-list .home-item:hover .home-item-img {
  display: none;
}


.home-list .home-item.activeTag .chioce {
  display: block;  
  // height: 95px;
  max-width: 100%;
  margin-bottom: 20px;
  margin-top: 20px;
  transition: width 2s;
  border: rgb(0, 136, 74) 2px solid;
  box-shadow: 0px 5px 10px rgb(0, 136, 74);
}

.home-list .home-item.activeTag .home-item-img {
  display: none;
}

</style>