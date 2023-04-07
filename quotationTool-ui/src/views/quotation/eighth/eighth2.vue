<template>
  <div class="page">
    <div class="header">
      <img src="@/assets/images/header.jpg"/>
    </div>
    <div class="center-box">     
          <p>尊敬的<span style="color: rgb(0, 136, 74);">{{this.name}}{{this.nickName}}</span>：</p>
          <p class="tips">请查收博世热力技术为您生成的专属采暖方案：</p>
      <!-- 新房装修 -->
      <div class="result-box" style="margin-bottom:0.5rem" v-if="this.zhuzhai=='first' && this.productType=='一级'">
        <div class="result-item">
          <div class="result-item-desc">
            <p>C7100({{this.kwH}})</p>
            <!-- <p>{{ productType }}</p> -->
            <span>+</span>
            <!-- <p>豪华型辅材</p>-->
            <p>{{ fittingsType }}辅材({{this.groupNumber}}组)</p>
            <p class="price">建议零售价￥{{this.price1}}</p>
          </div>
          <img v-if="this.fittingsType=='豪华型'" :src="require('@/assets/images/productFittings/c7100-haohua.png')" class="image"/>
          <img v-if="this.fittingsType=='舒适型'" :src="require('@/assets/images/productFittings/c7100-shushi.png')" class="image"/>
          <img v-if="this.fittingsType=='经济型'" :src="require('@/assets/images/productFittings/c7100-jingji.png')" class="image"/>
        </div>
        <div class="result-item">
          <div class="result-item-desc">
            <p>G7100({{this.kwH}})</p>
            <span>+</span>
            <p>{{ fittingsType }}辅材({{this.groupNumber}}组)</p>
            
            <p class="price">建议零售价￥{{this.price2}}</p>
          </div>
          <img v-if="this.fittingsType=='豪华型'" :src="require('@/assets/images/productFittings/g7100-haohua.png')" class="image"/>
          <img v-if="this.fittingsType=='舒适型'" :src="require('@/assets/images/productFittings/g7100-shushi.png')" class="image"/>
          <img v-if="this.fittingsType=='经济型'" :src="require('@/assets/images/productFittings/g7100-jingji.png')" class="image"/>
        </div>
      </div>
      <!-- 新房装修 -->
      <div class="result-box" style="margin-bottom:0.5rem" v-if="this.zhuzhai=='first' && this.productType=='二级'">
        <div class="result-item">
          <div class="result-item-desc">
            <p>欧洲贵族({{this.kwH}})</p>
            <!-- <p>{{ productType }}</p> -->
            <span>+</span>
            <!-- <p>豪华型辅材</p>-->
            <p>{{ fittingsType }}辅材({{this.groupNumber}}组)</p>
            <p class="price">建议零售价￥{{this.price1}}</p>
          </div>
          <img v-if="this.fittingsType=='豪华型'" :src="require('@/assets/images/productFittings/guizu-haohua.png')" class="image"/>
          <img v-if="this.fittingsType=='舒适型'" :src="require('@/assets/images/productFittings/guizu-shushi.png')" class="image"/>
          <img v-if="this.fittingsType=='经济型'" :src="require('@/assets/images/productFittings/guizu-jingji.png')" class="image"/>
        </div>
        <div class="result-item">
          <div class="result-item-desc">
            <p>欧洲臻享({{this.kwH}})</p>
            <span>+</span>
            <p>{{ fittingsType }}辅材({{this.groupNumber}}组)</p>
            
            <p class="price">建议零售价￥{{this.price2}}</p>
          </div>
          <img v-if="this.fittingsType=='豪华型'" :src="require('@/assets/images/productFittings/zhenxiang-haohua.png')" class="image"/>
          <img v-if="this.fittingsType=='舒适型'" :src="require('@/assets/images/productFittings/zhenxiang-shushi.png')" class="image"/>
          <img v-if="this.fittingsType=='经济型'" :src="require('@/assets/images/productFittings/zhenxiang-jingji.png')" class="image"/>
        </div>
      </div>
      
      <!-- 已装修房屋 -->
      <div class="result-box" style="margin-bottom:0.5rem" v-if="this.zhuzhai=='second' && this.productType=='一级'">
        <div class="result-item">
          <div class="result-item-desc">
            <p>C7100({{this.kwH}})</p>
            <!-- <p>{{ productType }}</p> -->
            <span>+</span>
            <!-- <p>豪华型辅材</p>-->
            <p>{{ fittingsType }}辅材({{this.groupNumber}}组)</p>
            <p class="price">建议零售价￥{{this.price1}}</p>
          </div>
          <img v-if="this.fittingsType=='豪华型'" :src="require('@/assets/images/productFittings/c7100-haohua.png')" class="image"/>
          <img v-if="this.fittingsType=='舒适型'" :src="require('@/assets/images/productFittings/c7100-shushi.png')" class="image"/>
          <img v-if="this.fittingsType=='经济型'" :src="require('@/assets/images/productFittings/c7100-jingji.png')" class="image"/>
        </div>
        <div class="result-item">
          <div class="result-item-desc">
            <p>G7100({{this.kwH}})</p>
            <span>+</span>
            <p>{{ fittingsType }}辅材({{this.groupNumber}}组)</p>
            
            <p class="price">建议零售价￥{{this.price2}}</p>
          </div>
          <img v-if="this.fittingsType=='豪华型'" :src="require('@/assets/images/productFittings/g7100-haohua.png')" class="image"/>
          <img v-if="this.fittingsType=='舒适型'" :src="require('@/assets/images/productFittings/g7100-shushi.png')" class="image"/>
          <img v-if="this.fittingsType=='经济型'" :src="require('@/assets/images/productFittings/g7100-jingji.png')" class="image"/>
        </div>
      </div>
      <!-- 已装修房屋 -->
      <div class="result-box" style="margin-bottom:0.5rem" v-if="this.zhuzhai=='second' && this.productType=='二级'">
        <div class="result-item">
          <div class="result-item-desc">
            <p>欧洲贵族({{this.kwH}})</p>
            <!-- <p>{{ productType }}</p> -->
            <span>+</span>
            <!-- <p>豪华型辅材</p>-->
            <p>{{ fittingsType }}辅材({{this.groupNumber}}组)</p>
            <p class="price">建议零售价￥{{this.price1}}</p>
          </div>
          <img v-if="this.fittingsType=='豪华型'" :src="require('@/assets/images/productFittings/guizu-haohua.png')" class="image"/>
          <img v-if="this.fittingsType=='舒适型'" :src="require('@/assets/images/productFittings/guizu-shushi.png')" class="image"/>
          <img v-if="this.fittingsType=='经济型'" :src="require('@/assets/images/productFittings/guizu-jingji.png')" class="image"/>
        </div>
        <div class="result-item">
          <div class="result-item-desc">
            <p>欧洲臻享({{this.kwH}})</p>
            <span>+</span>
            <p>{{ fittingsType }}辅材({{this.groupNumber}}组)</p>
            
            <p class="price">建议零售价￥{{this.price2}}</p>
          </div>
          <img v-if="this.fittingsType=='豪华型'" :src="require('@/assets/images/productFittings/zhenxiang-haohua.png')" class="image"/>
          <img v-if="this.fittingsType=='舒适型'" :src="require('@/assets/images/productFittings/zhenxiang-shushi.png')" class="image"/>
          <img v-if="this.fittingsType=='经济型'" :src="require('@/assets/images/productFittings/zhenxiang-jingji.png')" class="image"/>
        </div>
      </div>

      
      <!-- 单机置换 -->
      <div class="result-box" style="margin-bottom:0.5rem" v-if="this.zhuzhai=='third' && this.productType=='一级'">
        <div class="result-item">
          <div class="result-item-desc">
            <p>博世壁挂炉</p>
            <span>+</span>
            <p>C7100({{this.kwH}})</p>
            <!-- <p>{{ productType }}</p> -->
            <p class="price">建议零售价￥{{this.price1}}</p>
          </div>
          <img :src="require('@/assets/images//productFittings/c7100.png')" class="image"/>
        </div>
        <div class="result-item">
          <div class="result-item-desc">
            <p>博世壁挂炉</p>
            <span>+</span>
            <p>G7100({{this.kwH}})</p>            
            <p class="price">建议零售价￥{{this.price2}}</p>
          </div>
          <img :src="require('@/assets/images/productFittings/g7100.png')" class="image"/>
        </div>
      </div>
      <!-- 单机置换 -->
      <div class="result-box" style="margin-bottom:0.5rem" v-if="this.zhuzhai=='third' && this.productType=='二级'">
        <div class="result-item">
          <div class="result-item-desc">
            <p>博世壁挂炉</p>
            <span>+</span>
            <p>欧洲贵族({{this.kwH}})</p>
            <!-- <p>{{ productType }}</p> -->
            <p class="price">建议零售价￥{{this.price1}}</p>
          </div>
          <img :src="require('@/assets/images/productFittings/guizu.png')" class="image"/>
        </div>
        <div class="result-item">
          <div class="result-item-desc">
            <p>博世壁挂炉</p>
            <span>+</span>
            <p>欧洲臻享({{this.kwH}})</p>
            <!-- <p>{{ fittingsType }}</p> -->
            
            <p class="price">建议零售价￥{{this.price2}}</p>
          </div>
          <img :src="require('@/assets/images/productFittings/zhenxiang.png')" class="image"/>
        </div>
      </div>


      <p style="font-weight: 400;color: #888;font-size: 10px;">*此价格为建议零售价，实际价格请以到店咨询为准，更多优惠政策欢迎咨询当地经销商</p>
      
      <p>根据采暖方案中的地址信息，为您推荐以下授权门店。</p>
      <div class="map-show">
            <img src="@/assets/images/dizhi.jpg"  @click="goBosch"/>
      </div>
    </div>
    <div class="bottom">
      <img src="@/assets/images/haibao.jpg">
    </div>
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
      price1: 0,
      price2: 0,
      groupNumber: 1,
      extentNumber: 0,
      log: null,
      lat: null,
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
    this.price1=this.storage.getItem("price1")
    this.price2=this.storage.getItem("price2")
    this.groupNumber=this.storage.getItem("groupNumber")
    this.extentNumber=this.storage.getItem("extentNumber")

    this.gotoHistory()

    this.setkwh()
    
    this.log = this.storage.getItem("longitude")
    this.lat = this.storage.getItem("latitude")
    
  },
  methods: {
    gotoHistory(){
      if(!this.extent||!this.shower){
        this.$router.push({ path: '/quotation/fourth'})
      }else if(!this.productType){
        this.$router.push({ path: '/quotation/fifth'})
      }else if(!this.fittingsType){
        this.$router.push({ path: '/quotation/sixth'})
      }else if(!this.name){
        this.$router.push({ path: '/quotation/third'})
      }
    },
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
      window.location.href="https://wechat.bosch-climate.cn/weixin/dealer/dealer_list.jsp?branch_type_pid=1&lat="+this.lat+"&lng="+this.log//"lat=31.362686&lng=121.29559"
        + "&ran=" + Math.random()
      
    },
    btnContinue(){
      this.$router.push({ path: '/quotation/second', query: { } })
    },

  },
}
</script>
<style lang="scss" scoped>
@import './eighth2.scss';
</style>

<style>
  .site_img:hover{
    /* border: 1px solid #f00; */
    cursor: pointer;
  }
</style>