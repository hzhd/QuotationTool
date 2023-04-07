<template>
  <div class="gameSelect">
    <div class="topWrap"></div>
    <div class="logoBanner">
      <div class="logo_div">
        <img src="../../../assets/images/bosch_logo.png" class="bosch_logo"/>
      </div>
      <div class="logo_div2">
        <img src="../../../assets/images/bosch_logo2.png" class="bosch_logo2"/>
      </div>
    </div>

    <div class="seventhForm">
      <div class="videoBtnWrap">
        <span style="color:#00884a;font-weight: bold;fload:left; font-size: 24px;">博世采暖方案报价</span>
        <img src="../../../assets/images/bosch.png" width="120px" style="margin-bottom: -20px;"/>
      </div>
      <br/>
      <el-form ref="form" :model="form" label-width="100px" label-position="left"  class="zhuzhai-form">
        <div class="head" style="margin-bottom: 10px;">
          <span style="color:#00884a;font-weight: 700;fload:left;">采暖住宅基本信息</span>
          <el-link type="primary" style="width: 38%;float: right;text-decoration: underline;">编辑修改</el-link>
        </div>
        
        <el-form-item label="采暖类型">
          <el-select v-model="form.region" placeholder="请选择">
            <el-option label="60以下" value="shanghai"></el-option>
            <el-option label="60-100" value="beijing"></el-option>
            <el-option label="100-200" value="beijing"></el-option>
            <el-option label="200以上" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="房屋面积">
          <el-select v-model="form.region1" placeholder="请选择">
            <el-option label="6" value="shanghai"></el-option>
            <el-option label="6-10" value="beijing"></el-option>
            <el-option label="10-20" value="beijing"></el-option>
            <el-option label="20以上" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="花洒数量">
          <el-select v-model="form.region1" placeholder="请选择">
            <el-option label="6" value="shanghai"></el-option>
            <el-option label="6-10" value="beijing"></el-option>
            <el-option label="10-20" value="beijing"></el-option>
            <el-option label="20以上" value="beijing"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <el-form ref="form" :model="form" label-width="100px" label-position="left"  class="chanpin-form">
        <div class="head" style="margin-bottom: 10px;">
          <span style="color:#00884a;font-weight: 700;fload:left;">采暖产品信息</span>
          <el-link type="primary" style="width: 38%;float: right;text-decoration: underline;">编辑修改</el-link>
        </div>
        
        <el-form-item label="产品类别">
          <el-select v-model="form.region" placeholder="请选择">
            <el-option label="60以下" value="shanghai"></el-option>
            <el-option label="60-100" value="beijing"></el-option>
            <el-option label="100-200" value="beijing"></el-option>
            <el-option label="200以上" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="系统配件套餐">
          <el-select v-model="form.region1" placeholder="请选择">
            <el-option label="6" value="shanghai"></el-option>
            <el-option label="6-10" value="beijing"></el-option>
            <el-option label="10-20" value="beijing"></el-option>
            <el-option label="20以上" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="辅材类别">
          <el-select v-model="form.region1" placeholder="请选择">
            <el-option label="6" value="shanghai"></el-option>
            <el-option label="6-10" value="beijing"></el-option>
            <el-option label="10-20" value="beijing"></el-option>
            <el-option label="20以上" value="beijing"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产品功率">
          <el-select v-model="form.region1" placeholder="请选择">
            <el-option label="6" value="shanghai"></el-option>
            <el-option label="6-10" value="beijing"></el-option>
            <el-option label="10-20" value="beijing"></el-option>
            <el-option label="20以上" value="beijing"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
    </div>
    <div class="btn-div">
        <button class="btnContinue" @click="btnContinue" style="color: #fff; border:1px; font-size: 18px; background-color:#00884a">
            确&nbsp;&nbsp;认&nbsp;&nbsp;并&nbsp;&nbsp;提&nbsp;&nbsp;交
        </button>
    </div>
  </div>
</template>
<script>
// import { apiGet } from '@/api/api'
export default {
  data() {
    return {
      form:{
        region: '',
        region1: '',
      },
    }
  },
  mounted() {
    
  },
  methods: {
    btnContinue(){
      this.$router.push({ path: '/quotation/eighth', query: { } })
    },
    // 跳转路由
    jumpRouter() {
      window.ss.goPretreatmentPage(this.gameid,this.game);
    },
    onChangeStripe:function(e){
      console.log(e);
      
      this.gameid = e.id;
      this.game = e.name;
    }
  },
}
</script>
<style lang="scss" scoped>
@import './seventh.scss';
</style>