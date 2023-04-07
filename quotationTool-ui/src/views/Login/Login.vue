<template>
  <div class="main">
    <div class="bar">
      <img src="../../assets/line.png" class="img"/>
    </div>
    <div class="img-wrapper">
      <img class="img" src="../../assets/Red.png" />
      <span class="title">博世热力采暖询价管理平台</span>
    </div>
    <div class="loginqq">
      <div class="btn-wrapper">
        <el-button
          @click="login(true)"
          class="btn"
          style="background: #2b81d6; color: white"
          :loading="loading1"
          >账号密码登录</el-button
        >
      </div>
      <div class="btn-wrapper">
        <el-button
          @click="login(false)"
          class="btn"
          style="background: #5ab55e; color: white"
          :loading="loading2"
          >员工SSO登录</el-button
        >
      </div>
    </div>
  </div>
</template>
<script>
// import api from "../api/api";
// const CIAM_OAUTH_URL = process.env.VUE_APP_CIAM_OAUTH_URL;
const ADFS_OAUTH_URL = process.env.VUE_APP_ADFS_OAUTH_URL;
const secret_account = '/index.html#/login';
export default {
  data() {
    return {
      loading1: false,
      loading2: false,
    };
  },
  mounted() {
    // 禁止返回上一页
    history.pushState(null, null, document.URL);
    window.addEventListener("popstate", function () {
      history.pushState(null, null, document.URL);
    });
  },
  methods: {
    login(type) {
      if (type) {
        this.loading1 = true;
        window.location.href = secret_account;
      } else {
        this.loading2 = true;
        window.location.href = ADFS_OAUTH_URL;
      }
    },
  },
};
</script>

<style lang="scss" scoped>
.main {
  display: flex;
  flex-direction: column;
  height: 100%;
  background: url(../../assets/bg1.jpg) no-repeat;
  background-size: 100% 100%;
  background-attachment: fixed;
  .bar {
    height: 1vh;
    .img {
      position: fixed;
      left: 0;
      width: 100%;
      height: 1vh;
    }
  }
  .loginqq {
    margin-top: 15%;
    .btn-wrapper {
      margin-top: 3vh;
      display: flex;
      justify-content: center;
      .btn {
        padding: 2vh 5vw;
        margin: 0 auto;
      }
    }
  }
  .img-wrapper {
    text-align: center;
    position: relative;
    height: 48px;
    line-height: 48px;
    .img {
      position: absolute;
      left: 0;
    }
    .title {
      margin: auto 0;
      font-weight: bold;
      color: white;
      font-size: 1.7rem;
    }
  }
}
</style>
