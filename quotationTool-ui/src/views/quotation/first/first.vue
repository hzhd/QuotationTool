<template>
  <div class="gameSelect">
    <div class="bgImage">
      <img src="@/assets/images/first-bg.jpg" class="bgImg">
    </div>
    <div class="header">
      <img src="@/assets/images/header.jpg" class="headerImg" />
    </div>
    <!-- <div id=“weizhi” style="width:100%;min-height:300px;z-index: 20000;position: absolute;top: 200px;left: 0;background-color: bisque;">sdfasdfasfdasdaf</div> -->

    <!-- <div class="topWrap"></div> -->
    <!-- <div class="logoBanner">
      <div class="logo_div">
        <img src="../../../assets/images/bosch_logo.png" class="bosch_logo"/>
      </div>
      <div class="logo_div2">
        <img src="../../../assets/images/bosch_logo2.png" class="bosch_logo2"/>
      </div>
    </div> -->
    <div class="btn-div">
      <button class="btnContinue" @click="btnContinue">
        一键获取博世采暖方案
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
      year: '',
      yearOpts: [],
      qrcodeId: this.$route.query.id || ""
    }
  },
  mounted() {
    this.storage.setItem("qrcodeId", this.qrcodeId)
    // alert(this.storage.getItem("qrcodeId"))
    this.getLocation()
  },
  methods: {
    //获取用户当前位置
    getLocation() {
      var options = {
        enableHighAccuracy: false, //精确定位
        maximumAge: 1000//最长时间
      }
      if (navigator.geolocation) {
        //浏览器支持geolocation
        navigator.geolocation.getCurrentPosition(this.onSuccess, this.onError, options);

      } else {
        console.log('你的浏览器不支持地理定位');//浏览器不支持geolocation
      }
    },

    //成功时
    onSuccess(position) {
      //经度
      var longitude = position.coords.longitude;
      //纬度
      var latitude = position.coords.latitude;
      // //创建地图实例 
      // var map = new BMap.Map("weizhi");
      // //创建一个坐标
      // var point = new BMap.Point(longitude, latitude);
      // //地图初始化，设置中心点坐标和地图级别 
      // map.centerAndZoom(point, 15);
      this.storage.setItem("longitude", longitude)
      this.storage.setItem("latitude", latitude)

    },

    //失败时
    onError(error) {
      switch (error.code) {
        case 1:
          alert("位置服务被拒绝");
          break;
        case 2:
          alert("暂时获取不到位置信息");
          break;
      }

    },
    btnContinue() {
      this.$router.push({ path: '/quotation/second', query: {} })
    },
    // // 获取赛事年份
    // getYearList() {
    //   apiGet('business/competition/selectListYear').then((res) => {
    //     this.yearOpts = res.data.yearList
    //   })
    // },
    // // 获取赛事项
    // getGameList() {
    //   apiGet('business/competition/selectListCompetition', {
    //     comYear: this.year,
    //   }).then((res) => {
    //     this.gameOpts = res.data.competitionList
    //     this.game = ''
    //   })
    // },
    // 跳转路由
    jumpRouter() {
      window.ss.goPretreatmentPage(this.gameid, this.game);
    },
    onChangeStripe: function (e) {
      console.log(e);

      this.gameid = e.id;
      this.game = e.name;
    }
  },
}
</script>
<style lang="scss" scoped>
@import './first.scss';
</style>
<style lang="scss">
#app {
  background: #ffffff !important;
}
</style>