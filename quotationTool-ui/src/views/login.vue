<template>
  <div class="login" :style="{'background-image': `url(${imgSrc + backgroundImgs})`}">
    <div></div>
    <el-form
      ref="loginForm"
      :model="loginForm"
      :rules="loginRules"
      class="login-form"
    >
      <h3 class="title">浦东群艺馆数字化应用平台</h3>
      <div class="paddings">
        <el-form-item prop="username">
          <el-input
            v-model="loginForm.username"
            type="text"
            auto-complete="off"
            placeholder="输入您的账号或手机号"
          >
            <svg-icon
              slot="prefix"
              icon-class="user"
              class="el-input__icon input-icon"
            />
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            v-model="loginForm.password"
            type="password"
            auto-complete="off"
            placeholder="输入您的密码"
            @keyup.enter.native="handleLogin"
          >
            <svg-icon
              slot="prefix"
              icon-class="password"
              class="el-input__icon input-icon"
            />
          </el-input>
        </el-form-item>
        <el-form-item prop="code" v-if="captchaEnabled">
          <el-input
            v-model="loginForm.code"
            auto-complete="off"
            placeholder="输入验证码"
            style="width: 50%"
            @keyup.enter.native="handleLogin"
          >
            <svg-icon
              slot="prefix"
              icon-class="validCode"
              class="el-input__icon input-icon"
            />
          </el-input>
          <div class="login-code">
            <img :src="codeUrl" @click="getCode" class="login-code-img" />
          </div>
        </el-form-item>

        <!-- <el-checkbox
          v-model="loginForm.rememberMe"
          style="margin: 0px 0px 25px 0px"
          >同意并遵守<span style="color: blue">《xxx条款》</span></el-checkbox
        >
        <span style="color: red; font-size: 13px" v-show="rememberMeFalse"
          >请勾选同意条款</span
        > -->

        <el-form-item style="width: 100%">
          <el-button
            :loading="loading"
            size="medium"
            type="primary"
            style="width: 100%;"
            @click.native.prevent="handleLogin"
          >
            <span v-if="!loading">登 录</span>
            <span v-else>登 录 中...</span>
          </el-button>
          <div
            style="
              float: right;
              width: 100%;
              display: flex;
              justify-content: space-between;
            "
          >
            <!-- <router-link class="link-type" :to="'/register'"
              >忘记密码</router-link
            >
            <router-link class="link-type" :to="'/register'"
              >立即注册</router-link
            > -->
          </div>
        </el-form-item>
      </div>
    </el-form>
    <!--  底部  -->
    <img src="../assets/images/logo.png" class="logoss" alt="">
    <div class="el-login-footer"></div>
  </div>
</template>

<script>
import { getCodeImg, getImg } from "@/api/login";
import Cookies from "js-cookie";
import { encrypt, decrypt } from "@/utils/jsencrypt";

export default {
  name: "Login",
  data() {
    return {
      imgSrc: process.env.VUE_APP_BASE_API,
      codeUrl: "",
      loginForm: {
        username: "admin",
        password: "admin123",
        rememberMe: true,
        code: "",
        uuid: "",
      },
      loginRules: {
        username: [
          { required: true, trigger: "blur", message: "请输入您的账号" },
        ],
        password: [
          { required: true, trigger: "blur", message: "请输入您的密码" },
        ],
        code: [{ required: true, trigger: "change", message: "请输入验证码" }],
      },
      loading: false,
      // 验证码开关
      captchaEnabled: true,
      // 注册开关
      register: false,
      redirect: undefined,
      // 条款勾选验证
      rememberMeFalse: false,
      inputWidths: '',
      backgroundImgs: ''
    };
  },
  watch: {
    $route: {
      handler: function (route) {
        this.redirect = route.query && route.query.redirect;
      },
      immediate: true,
    },
  },
  created() {
    this.getCode();
    this.getCookie();
    var that = this
    getImg().then((response) => {
      that.backgroundImgs = response.backgroundMsg
    });
  },
  methods: {
    getCode() {
      getCodeImg().then((res) => {
        this.captchaEnabled =
          res.captchaEnabled === undefined ? true : res.captchaEnabled;
        if (this.captchaEnabled) {
          this.codeUrl = "data:image/gif;base64," + res.img;
          this.loginForm.uuid = res.uuid;
        }
      });
    },
    getCookie() {
      const username = Cookies.get("username");
      const password = Cookies.get("password");
      const rememberMe = Cookies.get("rememberMe");
      this.loginForm = {
        username: username === undefined ? this.loginForm.username : username,
        password:
          password === undefined ? this.loginForm.password : decrypt(password),
        rememberMe: rememberMe === undefined ? false : Boolean(rememberMe),
      };
    },
    handleLogin() {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          // if (this.loginForm.rememberMe) {
            this.rememberMeFalse = false;
            this.loading = true;
            if (this.loginForm.rememberMe) {
              Cookies.set("username", this.loginForm.username, { expires: 30 });
              Cookies.set("password", encrypt(this.loginForm.password), {
                expires: 30,
              });
              Cookies.set("rememberMe", this.loginForm.rememberMe, {
                expires: 30,
              });
            } else {
              Cookies.remove("username");
              Cookies.remove("password");
              Cookies.remove("rememberMe");
            }
            this.$store
              .dispatch("Login", this.loginForm)
              .then(() => {
                this.$router
                  .push({ path: this.redirect || "/" })
                  .catch(() => {});
              })
              .catch(() => {
                this.loading = false;
                if (this.captchaEnabled) {
                  this.getCode();
                }
              });
          // } else {
          //   this.rememberMeFalse = true;
          //   return
          // }
        }
      });
    },
  },
};
</script>

<style rel="stylesheet/scss" lang="scss">
.login {
  display: flex;
  justify-content: space-around;
  align-items: center;
  height: 100%;
  background-size: 100% 100%;
}
.title {
  margin: 0px auto 30px auto;
  text-align: center;
  font-weight: 500;
  color: #111111;
  font-size: 26px;
  font-weight: 500;
  margin-top: 5vh;
}

.paddings{
  padding: 0 45px;
  box-sizing: border-box;
}

.login-form {
  border-radius: 6px;
  background: #ffffff;
  width: 25.5%;
  height: 450px;
  letter-spacing: 1px;
  padding: 25px 25px 5px 25px;
  .el-input {
    height: 38px;
    input {
      height: 38px;
    }
  }
  .input-icon {
    height: 39px;
    width: 14px;
    margin-left: 2px;
  }
}
.login-tip {
  font-size: 13px;
  text-align: center;
  color: #bfbfbf;
}
.login-code {
  height: 38px;
  float: right;
  img {
    cursor: pointer;
    vertical-align: middle;
  }
}
.el-login-footer {
  height: 40px;
  line-height: 40px;
  position: fixed;
  bottom: 0;
  width: 100%;
  text-align: center;
  color: #fff;
  font-family: Arial;
  font-size: 12px;
  letter-spacing: 1px;
}
.login-code-img {
  height: 38px;
}

.logoss{
  position: fixed;
  top: 20px;
  left: 20px;
  width: 221px;
  height: 80px;
}
</style>
