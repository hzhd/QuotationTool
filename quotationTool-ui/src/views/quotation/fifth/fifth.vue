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
        <span class="tips">为了给您提供更好的服务，请填写以下相关信息，自助服务系统将为您生成专属的采暖方案。</span>
      </div>
      <div class="bigualu">
        <span style="margin:20px;font-size: 20px;color: #00884a;font-weight: 700;">第二步：选择您心仪的壁挂炉类型</span><br /><br />
      </div>
      <div class="center-box">
        <section class="content-area container area-city">
          <!-- <h2 class="band-title text-center"><img src="../img/thirdicon.png" alt="Alternate Text" />是否为新装修？锅炉替换?
				    </h2> -->
          <div class="home-list">
            <div class="home-item" data-id="1" data-value="冷凝炉" :class="{ activeTag: isActive1 }" @click="setActive1">
              <img class="chioce-fifth" src="../../../assets/images/lengninglu2.jpg" />
              <img class="home-item-image" src="../../../assets/images/lengninglu.jpg" />
              <!-- <p>一级能效冷凝炉</p> -->
            </div>
            <div class="home-item" data-id="2" data-value="常规炉" :class="{ activeTag: isActive2 }" @click="setActive2">
              <img class="chioce-fifth" src="../../../assets/images/changguilu2.jpg" />
              <img class="home-item-image" src="../../../assets/images/changguilu.jpg" />
              <!-- <p>二级能效常规炉</p> -->
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
      extent: null,
      shower: null,
    }
  },
  mounted() {
    this.extent=this.storage.getItem("extent")
    this.shower=this.storage.getItem("shower")
    this.gotoHistory()
    //数据回显
    if(this.storage.getItem("productType")=='一级'){
      this.isActive1 = true
      this.isActive2 = false
    }else{
      this.isActive2 = true
      this.isActive1 = false
    }
  },
  methods: {
    gotoHistory(){
      if(!this.extent||!this.shower){
        this.$router.push({ path: '/quotation/fourth'})
      }
    },
    setActive1() {
      this.isActive1 = true
      this.isActive2 = false
    },
    setActive2() {
      this.isActive2 = true
      this.isActive1 = false
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
          this.storage.setItem("productType", '一级');
      }else if(this.isActive2){
        this.storage.setItem("productType", '二级');
      }else {
        this.$notify.warning({
          title: "提示",
          message: "请选择产品类型",
          position: 'top-right',
        });
        return
      }
      if(this.storage.getItem("zhuzhai")&&this.storage.getItem("zhuzhai")=='third'){        
        this.$router.push({ path: '/quotation/third', query: {} })
      }else{
        this.$router.push({ path: '/quotation/sixth', query: {} })
      }
    },
  },
}
</script>
<style lang="scss" scoped>
@import './fifth.scss';
</style>
<style>
#app {
  background: #ffffff !important;
}

.home-item-image {
  max-width: 100%;
  margin-bottom: 20px;
  margin-top: 20px;
}

.chioce-fifth {
  /* height: 170px; */
  max-width: 100%;
  margin-bottom: 20px;
  margin-top: 20px;
  display: none;
}

.home-list .home-item {
  display: flex;
  justify-content: center;
  align-items: center;
}

.home-list .home-item:hover .chioce-fifth {
  display: block;
  /* height: 170px; */
  max-width: 100%;
  margin-bottom: 20px;
  margin-top: 20px;
  transition: width 2s;
  border: rgb(0, 136, 74) 2px solid;
  box-shadow: 0px 5px 10px rgb(0, 136, 74);
}

.home-list .home-item:hover .home-item-image {
  display: none;
}


.home-list .home-item.activeTag .chioce-fifth {
  display: block;
  /* height: 170px; */
  max-width: 100%;
  margin-bottom: 20px;
  margin-top: 20px;
  transition: width 2s;
  border: rgb(0, 136, 74) 2px solid;
  box-shadow: 0px 5px 10px rgb(0, 136, 74);
}

.home-list .home-item.activeTag .home-item-image {
  display: none;
}






.home-list .home-item:hover p {
  background: #1e64a9;
  color: #ffffff;
  margin-top: 30px;
  border: #168b0e 1px;
}

.home-list .home-item .active p {
  background: #1e64a9;
  color: #ffffff;
  margin-top: 30px;
}

.home-list .home-item .active {
  border: 1px solid #0a90c9;
  border-radius: 5px;
  background-image: url(../../../assets/images/bosch_logo.png);
  background-position: 101% 101%;
  background-size: 24px;
  background-repeat: no-repeat;
}
</style>