<template>
  <div>
    <div style="position: fixed; top: 0; left: 0; width: 100%; z-index: 100">
      <div class="navbar">
        <!-- <hamburger id="hamburger-container" :is-active="sidebar.opened" class="hamburger-container" @toggleClick="toggleSideBar" /> -->
        <div style="display: flex; align-content: center">
          <img src="../../assets/images/logo.png" alt="" class="logos" />
          <div class="titles">浦东群艺馆数字化应用平台</div>
        </div>
        <!-- <breadcrumb id="breadcrumb-container" class="breadcrumb-container" v-if="!topNav"/> -->
        <!-- <top-nav id="topmenu-container" class="topmenu-container" v-if="topNav" /> -->

        <div class="right-menu">
          <!-- <template v-if="device!=='mobile'">
        <search id="header-search" class="right-menu-item" />

        <el-tooltip content="源码地址" effect="dark" placement="bottom">
          <ruo-yi-git id="ruoyi-git" class="right-menu-item hover-effect" />
        </el-tooltip>

        <el-tooltip content="文档地址" effect="dark" placement="bottom">
          <ruo-yi-doc id="ruoyi-doc" class="right-menu-item hover-effect" />
        </el-tooltip>

        <screenfull id="screenfull" class="right-menu-item hover-effect" />

        <el-tooltip content="布局大小" effect="dark" placement="bottom">
          <size-select id="size-select" class="right-menu-item hover-effect" />
        </el-tooltip>

      </template> -->

          <el-dropdown
            class="avatar-container right-menu-item hover-effect"
            trigger="click"
          >
            <div class="avatar-wrapper">
              <img :src="avatar" class="user-avatar" />
              <i class="el-icon-caret-bottom" />
            </div>
            <el-dropdown-menu slot="dropdown">
              <router-link to="/user/profile">
                <el-dropdown-item>个人中心</el-dropdown-item>
              </router-link>
              <!-- <el-dropdown-item @click.native="setting = true">
                <span>布局设置</span>
              </el-dropdown-item> -->
              <el-dropdown-item @click.native="dialogVisible = true">
                <span>登录背景</span>
              </el-dropdown-item>
              <el-dropdown-item divided @click.native="logout">
                <span>退出登录</span>
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </div>
    <div style="height: 67px; width: 100%"></div>

    <el-dialog
      title="登录页面背景更换"
      :visible.sync="dialogVisible"
      width="30%"
      top="20vh"
      :before-close="handleClose"
    >
      <image-upload v-model="form.backgroundMsg" :limit="1" />

      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="loginBgImg">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import Breadcrumb from "@/components/Breadcrumb";
import TopNav from "@/components/TopNav";
import Hamburger from "@/components/Hamburger";
import Screenfull from "@/components/Screenfull";
import SizeSelect from "@/components/SizeSelect";
import Search from "@/components/HeaderSearch";
import RuoYiGit from "@/components/RuoYi/Git";
import RuoYiDoc from "@/components/RuoYi/Doc";
import { putImg, getImg } from "@/api/login";

export default {
  components: {
    Breadcrumb,
    TopNav,
    Hamburger,
    Screenfull,
    SizeSelect,
    Search,
    RuoYiGit,
    RuoYiDoc,
  },

  data() {
    return {
      imgSrc: process.env.VUE_APP_BASE_API,
      dialogVisible: false,
      form: {
        backgroundMsg: "  ",
      },
    };
  },
  computed: {
    ...mapGetters(["sidebar", "avatar", "device"]),
    setting: {
      get() {
        return this.$store.state.settings.showSettings;
      },
      set(val) {
        this.$store.dispatch("settings/changeSetting", {
          key: "showSettings",
          value: val,
        });
      },
    },
    topNav: {
      get() {
        return this.$store.state.settings.topNav;
      },
    },
  },
  mounted() {
    var that = this
    getImg().then((response) => {
      that.form.backgroundMsg = that.imgSrc + response.backgroundMsg
    });
  },
  methods: {
    handleClose(done) {
        this.dialogVisible = false
    },
    loginBgImg() {
      var that = this;
      putImg(that.form).then((response) => {
        
        that.$message({
          message: '修改成功',
          type: 'success',
          center: true
        });
        that.dialogVisible = false
      });
    },
    toggleSideBar() {
      this.$store.dispatch("app/toggleSideBar");
    },
    async logout() {
      this.$confirm("确定注销并退出系统吗？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.$store.dispatch("LogOut").then(() => {
            location.href = "/index";
          });
        })
        .catch(() => {});
    },
  },
};
</script>

<style lang="scss" scoped>
.navbar {
  width: 100% !important;
  height: 67px;
  display: flex;
  justify-content: space-between;
  overflow: hidden;
  position: relative;
  background: #fff;
  box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);

  .hamburger-container {
    line-height: 46px;
    height: 100%;
    float: left;
    cursor: pointer;
    transition: background 0.3s;
    -webkit-tap-highlight-color: transparent;

    &:hover {
      background: rgba(0, 0, 0, 0.025);
    }
  }

  .breadcrumb-container {
    float: left;
  }

  .topmenu-container {
    position: absolute;
    left: 50px;
  }

  .errLog-container {
    display: inline-block;
    vertical-align: top;
  }

  .right-menu {
    float: right;
    height: 100%;
    line-height: 50px;

    &:focus {
      outline: none;
    }

    .right-menu-item {
      display: inline-block;
      padding: 0 8px;
      height: 100%;
      font-size: 18px;
      color: #5a5e66;
      vertical-align: text-bottom;

      &.hover-effect {
        cursor: pointer;
        transition: background 0.3s;

        &:hover {
          background: rgba(0, 0, 0, 0.025);
        }
      }
    }

    .avatar-container {
      margin-right: 30px;
      display: flex;
      align-items: center;

      .avatar-wrapper {
        position: relative;
        height: 40px;

        .user-avatar {
          cursor: pointer;
          width: 40px;
          height: 40px;
          border-radius: 10px;
        }

        .el-icon-caret-bottom {
          cursor: pointer;
          position: absolute;
          right: -20px;
          top: 25px;
          font-size: 12px;
        }
      }
    }
  }
}

.logos {
  width: 221px;
  height: 67px;
  line-height: 87px;
  margin-left: 21px;
  margin-right: 8px;
}

.titles {
  font-size: 21px;
  font-weight: bold;
  color: #333333;
  line-height: 67px;
  letter-spacing: 2px;
  display: inline-block;
}
</style>
