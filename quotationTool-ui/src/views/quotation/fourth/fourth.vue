<template>
  <div class="gameSelect">
    <div class="header">
      <img src="@/assets/images/header.jpg" />
    </div>
    <!-- <div class="innerWrap">
      <h3></h3>
      <div class="topTips">
        <span class="tips">尊敬的用户，您好！</span>
        <br>
        <span class="tips">为了给您提供更好的服务，请填写以下相关信息，自助服务系统将为您生成专属的采暖方案。</span>
      </div>
      <div class="fourthTab">
        <div class="zhuzhai">
          <span style="margin:20px;font-size: 20px;color: #00884a;font-weight: 700;">第一步：采暖住宅基本信息</span><br /><br />
          <span style="margin: 20px;font-size: 14px; font-weight: 700;color: #606266;">*请选择您所需的住宅采暖类型；</span><br />
        </div>
        /**这里填充切换标签的部分 */
      </div>

    </div> -->

    <div class="center-box">
      <p>尊敬的用户，您好！</p>
      <p>为了给您提供更好的服务，请填写以下相关信息，<br>
        自助服务系统将为您生成专属的采暖方案。</p>
      <form id="quotationForm" name="quotationForm" method="post">
        <div class="step-tit">第一步：采暖住宅基本信息</div>
        <p>*请选择您所需的住宅采暖类型：</p>
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="新房装修" name="first">
            <div class="fourthForm" style="">
              <el-form ref="form1" :rules="rules1" :model="form1" label-width="100px" label-position="top">
                <el-form-item label="" prop="heatingType1">
                  <el-checkbox-group v-model="form1.heatingType1" @change="statusChange">
                    <div class="type-item">
                      <div class="type-pic"><img :src="require('@/assets/images/fourth-img1.jpg')"></div>
                      <div class="type-desc">
                        <el-checkbox label="散热器" name="heatingType1"></el-checkbox>
                        <label class="radio-txt">
                          <div class="desc-tips">注*易于安装，随开随关。</div>
                        </label>
                      </div>
                    </div>
                    <div class="type-item">
                      <div class="type-pic"><img :src="require('@/assets/images/fourth-img2.jpg')"></div>
                      <div class="type-desc">
                        <el-checkbox label="地暖系统" name="heatingType1"></el-checkbox>
                        <label class="radio-txt">
                          <div class="desc-tips">注*精准控温，设计美观。</div>
                        </label>
                      </div>
                    </div>
                  </el-checkbox-group>
                </el-form-item>
                <el-form-item label="*请选择您的预估采暖面积" prop="extent1">
                  <el-select v-model="form1.extent1" placeholder="请选择采暖面积" style="width: 97%;">
                    <el-option label="<80㎡" value="a"></el-option>
                    <el-option label="80-150㎡" value="b"></el-option>
                    <el-option label="151-230㎡" value="c"></el-option>
                    <el-option label="231-300㎡" value="d"></el-option>
                    <el-option label=">300㎡" value="e"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="*请选择您的淋雨花洒数量" prop="shower1">
                  <el-select v-model="form1.shower1" placeholder="请选择花洒数量" style="width: 97%;">
                    <el-option label="1个" value="a"></el-option>
                    <el-option label="2个" value="b"></el-option>
                    <el-option label="3个" value="c"></el-option>
                  </el-select>
                </el-form-item>
              </el-form>
            </div>
          </el-tab-pane>
          <el-tab-pane label="已装修房屋" name="second">

            <div class="fourthForm">
              <el-form ref="form2" :model="form2" :rules="rules2" label-width="100px" label-position="top">
                <el-form-item label="" prop="heatingType2">
                  <el-checkbox-group v-model="form2.heatingType2" @change="statusChange">
                    <div class="type-item">
                      <div class="type-pic"><img :src="require('@/assets/images/fourth-img1.jpg')"></div>
                      <div class="type-desc">
                        <el-checkbox label="散热器" name="heatingType2"></el-checkbox>
                        <label class="radio-txt">
                          <div class="desc-tips">注*易于安装，随开随关。</div>
                        </label>
                      </div>
                    </div>
                    <div class="type-item">
                      <div class="type-pic"><img :src="require('@/assets/images/fourth-img2.jpg')"></div>
                      <div class="type-desc">
                        <el-checkbox label="地暖系统" name="heatingType2"></el-checkbox>
                        <label class="radio-txt">
                          <div class="desc-tips">注*精准控温，设计美观。</div>
                        </label>
                      </div>
                    </div>
                  </el-checkbox-group>
                </el-form-item>
                <el-form-item label="*请选择您的预估采暖面积" prop="extent2">
                  <el-select v-model="form2.extent2" placeholder="请选择采暖面积" style="width: 97%;">
                    <el-option label="<80㎡" value="a"></el-option>
                    <el-option label="80-150㎡" value="b"></el-option>
                    <el-option label="151-230㎡" value="c"></el-option>
                    <el-option label="231-300㎡" value="d"></el-option>
                    <el-option label=">300㎡" value="e"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="*请选择您的淋雨花洒数量" prop="shower2">
                  <el-select v-model="form2.shower2" placeholder="请选择花洒数量" style="width: 97%;">
                    <el-option label="1个" value="a"></el-option>
                    <el-option label="2个" value="b"></el-option>
                    <el-option label="3个" value="c"></el-option>
                  </el-select>
                </el-form-item>
              </el-form>
            </div>
          </el-tab-pane>
          <el-tab-pane label="单机置换" name="third">

            <div class="fourthForm">
              <el-form ref="form3" :model="form3" :rules="rules3" label-width="100px" label-position="top">
                <el-form-item label="*您之前使用的是否为博世壁挂炉？" prop="isBosch3">
                  <el-select v-model="form3.isBosch3" placeholder="请选择之前是否博世" style="width: 97%">
                    <el-option label="是" value="1"></el-option>
                    <el-option label="否" value="0"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="*请选择您的预估采暖面积" prop="extent3">
                  <el-select v-model="form3.extent3" placeholder="请选择采暖面积" style="width: 97%;">
                    <el-option label="<80㎡" value="a"></el-option>
                    <el-option label="80-150㎡" value="b"></el-option>
                    <el-option label="151-230㎡" value="c"></el-option>
                    <el-option label="231-300㎡" value="d"></el-option>
                    <el-option label=">300㎡" value="e"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="*请选择您的淋雨花洒数量" prop="shower3">
                  <el-select v-model="form3.shower3" placeholder="请选择花洒数量" style="width: 97%;">
                    <el-option label="1个" value="a"></el-option>
                    <el-option label="2个" value="b"></el-option>
                    <el-option label="3个" value="c"></el-option>
                  </el-select>
                </el-form-item>
              </el-form>
            </div>
          </el-tab-pane>
        </el-tabs>
      </form>
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
      form1: {
        heatingType1: [],
        extent1: '',
        shower1: '',
      },
      form2: {
        heatingType2: [],
        extent2: '',
        shower2: '',
      },
      form3: {
        extent3: '',
        shower3: '',
        isBosch3: '',
      },
      activeName: 'first',
      // 表单校验
      rules1: {
        heatingType1: [
          { required: true, message: "采暖类型不能为空", trigger: "blur" },
        ],
        extent1: [
          { required: true, message: "面积不能为空", trigger: "blur" },
        ],
        shower1: [
          { required: true, message: "花洒数量不能为空", trigger: "blur" },
        ],
      },
      // 表单校验
      rules2: {
        heatingType2: [
          { required: true, message: "采暖类型不能为空", trigger: "blur" },
        ],
        extent2: [
          { required: true, message: "面积不能为空", trigger: "blur" },
        ],
        shower2: [
          { required: true, message: "花洒数量不能为空", trigger: "blur" },
        ],
      },
      rules3: {
        extent3: [
          { required: true, message: "面积不能为空", trigger: "blur" },
        ],
        shower3: [
          { required: true, message: "花洒数量不能为空", trigger: "blur" },
        ],
        isBosch3: [
          { required: true, message: "之前是否博世不能为空", trigger: "blur" },
        ],
      }
    }
  },
  mounted() {
    //数据回显
    this.activeName = this.storage.getItem("zhuzhai")||"first"
    if (this.storage.getItem("zhuzhai") == 'first') {
      this.form1.heatingType1 = [this.storage.getItem("heatingType")]
      this.form1.extent1 = this.storage.getItem("extent")
      this.form1.shower1 = this.storage.getItem("shower")
    } else if (this.storage.getItem("zhuzhai") == 'second') {
      this.form2.heatingType2 = [this.storage.getItem("heatingType")]
      this.form2.extent2 = this.storage.getItem("extent")
      this.form2.shower2 = this.storage.getItem("shower")
    } else {
      this.form3.isBosch3 = this.storage.getItem("isBosch")
      this.form3.extent3 = this.storage.getItem("extent")
      this.form3.shower3 = this.storage.getItem("shower")
    }

  },
  methods: {
    statusChange(value) {
      if (this.form1.heatingType1.length > 1) {
        this.form1.heatingType1.splice(0, 1)
      }
      if (this.form2.heatingType2.length > 1) {
        this.form2.heatingType2.splice(0, 1)
      }
    },
    handleClick(tab, event) {
      console.log(tab, event);
    },
    onSubmit() {
      console.log('submit!');
    },
    /** 提交按钮 */
    btnContinue: function () {
      if (this.activeName == "first") {
        // this.$refs["form1"].validate(valid => {
        //   if(valid){
        //     alert("校验通过")
        //   }else{
        //     alert("未校验通过")
        //   }
        // })
        this.$refs["form1"].validate(valid => {
          if (valid) {
            if (this.form1.extent1 != null) {
              //updateUser(this.form).then(response => {
              //this.$modal.msgSuccess("修改成功");
              this.storage.setItem("heatingType", this.form1.heatingType1);
              this.storage.setItem("extent", this.form1.extent1);
              this.storage.setItem("shower", this.form1.shower1);
              // this.storage.setItem("isBosch", this.form1.isBosch);
              this.storage.setItem("zhuzhai", this.activeName);
              let param = {}
              param.heatingType = this.storage.getItem("heatingType")
              param.extent = this.storage.getItem("extent")
              param.shower = this.storage.getItem("shower")
              param.zhuzhai = this.storage.getItem("zhuzhai")
              //alert(JSON.stringify(param))
              this.$router.push({ path: '/quotation/fifth', query: {} })
              //});
            }
          }
        });
      }

      if (this.activeName == "second") {
        this.$refs["form2"].validate(valid => {
          if (valid) {
            this.storage.setItem("heatingType", this.form2.heatingType2);
            this.storage.setItem("extent", this.form2.extent2);
            this.storage.setItem("shower", this.form2.shower2);
            // this.storage.setItem("isBosch", this.form1.isBosch);
            this.storage.setItem("zhuzhai", this.activeName);
            let param = {}
            param.heatingType = this.storage.getItem("heatingType")
            param.extent = this.storage.getItem("extent")
            param.shower = this.storage.getItem("shower")
            //alert(JSON.stringify(param))
            this.$router.push({ path: '/quotation/fifth', query: {} })
          }
        });
      }
      if (this.activeName == "third") {
        this.$refs["form3"].validate(valid => {
          if (valid) {
            this.storage.setItem("extent", this.form3.extent3);
            this.storage.setItem("shower", this.form3.shower3);
            this.storage.setItem("isBosch", this.form3.isBosch3);
            this.storage.setItem("zhuzhai", this.activeName);
            let param = {}
            param.extent = this.storage.getItem("extent")
            param.shower = this.storage.getItem("shower")
            param.isBosch = this.storage.getItem("isBosch")
            //alert(JSON.stringify(param))
            this.$router.push({ path: '/quotation/fifth', query: {} })
          }
        });
      }
    },
  },
}
</script>
<style lang="scss" scoped>
@import './fourth.scss';
</style>
<style lang="scss">
#app {
  background: #ffffff !important;
}

.el-select-dropdown__wrap {
  max-height: 10000px !important;
}</style>