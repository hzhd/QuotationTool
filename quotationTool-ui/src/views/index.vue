<template>
  <div class="app-container home">
    <div
      :style="{
        width: `calc(100vw - ${widths}px - 40px)`,
        height: `calc(100vh - ${heights}px - 20px - 8.3vh)`,
      }"
    >
      <div class="home_top">
        <div class="top_left">
          <div class="top_left_title">
            <div>当月预约人数统计</div>
            <div>
              <el-select
                v-model="value"
                @change="selectValue"
                placeholder="请选择"
              >
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                >
                </el-option>
              </el-select>
            </div>
          </div>

          <div id="pie"></div>
        </div>

        <div class="top_right">
          <div class="top_right_title">
            <img
              src="../assets/images/shouye/top_one.png"
              class="icon_img"
              alt=""
            />
            <span>当前预约人数：140人</span>
          </div>

          <div class="top_right_bodys">
            <div class="top_right_body">
              <div class="top_right_body_left">
                <div class="top_right_body_left_title">
                  <div style="display: flex; align-items: center">
                    <img
                      src="../assets/images/shouye/top_two.png"
                      class="icon_img"
                      style="height: 16px; width: 16px; margin-right: 5px"
                      alt=""
                    />
                    <span>剑舞<span style="font-size: 10px">（人）</span></span>
                  </div>
                  <div style="font-size: 10px; color: #8298ae">
                    参与活动 103
                  </div>
                </div>

                <div style="display: flex; justify-content: space-between">
                  <div class="top_right_body_left_body">
                    <div class="top_right_body_left_body_number">
                      <div>+28</div>
                      &nbsp; &nbsp; &nbsp;
                      <div>
                        比上日 &nbsp;
                        <img
                          class="top_right_body_left_body_number_icon"
                          src="../assets/images/sigh.png"
                          alt=""
                        />
                      </div>
                    </div>

                    <div class="top_right_body_left_body_contrast">
                      <div>
                        比上月 <img src="../assets/images/up.png" alt="" /> 19.9%
                      </div>
                      <div>
                        比上年
                        <img src="../assets/images/down.png" alt="" /> 10.5%
                      </div>
                    </div>
                  </div>

                  <div
                    class="top_right_body_right_body zhexian1"
                    id="zhexian1"
                  ></div>
                </div>
              </div>

              <div class="top_right_body_right">
                <div class="top_right_body_right_title">
                  <div>产品影响力分析</div>
                  <div style="font-size: 10px; color: #b4c1ce">查看更多</div>
                </div>

                <div class="top_right_body_right_ph" style="margin: 0 18px" v-if="effectList.length != 0">
                  <div class="top_right_body_right_ph_n1" v-if="effectList.length != 0">
                    <div>
                      <div class="top_right_body_right_ph_n1_icon">置顶</div>
                      NO.01 {{ effectList[0].influenceName }}
                    </div>
                    <div class="top_right_body_right_ph_n1_reli">
                      <img src="../assets/images/shouye/huoyan.png" alt="" />
                      {{ effectList[0].dayNo }}
                    </div>
                  </div>
                  <div class="top_right_body_right_ph_n1">
                    <div>
                      <div
                        class="top_right_body_right_ph_n1_icon"
                        style="
                          background-color: rgba(0, 123, 255, 0.3);
                          color: rgba(0, 123, 255, 1);
                        "
                      >
                        置顶
                      </div>
                      NO.02 {{ effectList[1].influenceName }}
                    </div>
                    <div class="top_right_body_right_ph_n1_reli">
                      <img src="../assets/images/shouye/huoyan.png" alt="" />
                      {{ effectList[1].dayNo }}
                    </div>
                  </div>
                  <div class="top_right_body_right_ph_n1">
                    <div>
                      <div
                        class="top_right_body_right_ph_n1_icon"
                        style="
                          background-color: rgba(85, 205, 136, 0.3);
                          color: rgba(85, 205, 136, 1);
                        "
                      >
                        置顶
                      </div>
                      NO.03 {{ effectList[2].influenceName }}
                    </div>
                    <div class="top_right_body_right_ph_n1_reli">
                      <img src="../assets/images/shouye/huoyan.png" alt="" />
                      {{ effectList[2].dayNo }}
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="top_right_body">
              <div class="top_right_body_left">
                <div class="top_right_body_left_title">
                  <div style="display: flex; align-items: center">
                    <img
                      src="../assets/images/shouye/top_three.png"
                      class="icon_img"
                      style="height: 16px; width: 16px; margin-right: 5px"
                      alt=""
                    />
                    <span
                      >走进二胡世界<span style="font-size: 10px"
                        >（人）</span
                      ></span
                    >
                  </div>
                  <div style="font-size: 10px; color: #8298ae">
                    参与活动 103
                  </div>
                </div>

                <div style="display: flex; justify-content: space-between">
                  <div class="top_right_body_left_body">
                    <div class="top_right_body_left_body_number">
                      <div>+28</div>
                      &nbsp; &nbsp; &nbsp;
                      <div>
                        比上日 &nbsp;
                        <img
                          class="top_right_body_left_body_number_icon"
                          src="../assets/images/sigh.png"
                          alt=""
                        />
                      </div>
                    </div>

                    <div class="top_right_body_left_body_contrast">
                      <div>
                        比上月 <img src="../assets/images/up.png" alt="" /> 17.5%
                      </div>
                      <div>
                        比上年
                        <img src="../assets/images/down.png" alt="" /> 23%
                      </div>
                    </div>
                  </div>

                  <div
                    class="top_right_body_right_body zhexian2"
                    id="zhexian2"
                  ></div>
                </div>
              </div>

              <div class="top_right_body_right">
                <div class="top_right_body_right_title">
                  <div>人数统计</div>
                  <div style="font-size: 10px; color: #b4c1ce">查看更多</div>
                </div>

                <div class="top_right_body_right_ph" style="margin: 0 18px">
                  <div class="top_right_body_right_ph_p1">
                    <div>
                      <img src="../assets/images/shouye/pai1.png" alt="" />
                      金海分馆
                    </div>
                    <div style="color: #8298ae">545人</div>
                  </div>
                  <div class="top_right_body_right_ph_p1">
                    <div>
                      <img src="../assets/images/shouye/pai2.png" alt="" />
                      祝桥镇分馆
                    </div>
                    <div style="color: #8298ae">234人</div>
                  </div>
                  <div class="top_right_body_right_ph_p1">
                    <div>
                      <img src="../assets/images/shouye/pai3.png" alt="" />
                      川沙新镇分馆
                    </div>
                    <div style="color: #8298ae">762人</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="home_bottom">
        <div class="bottom_left">
          <div class="bottom_left_title">
            <div style="display: flex; align-items: center">
              <img
                src="../assets/images/shouye/bottom_one.png"
                alt=""
              />客流时段分析
            </div>
            <div style="color: rgba(180, 193, 206, 1); font-size: 12px">
              自定义设置
            </div>
          </div>

          <div class="bottom_left_body">
            <div
              class="bottom_left_body_li"
              v-for="(item, index) in li_data"
              :key="item.time"
            >
              <div class="bottom_left_body_li_data">
                <div>
                  {{ item.time }}<span style="font-size: 12px">(人数)</span>
                </div>
                <div>{{ item.number }}</div>
                <div>
                  较上月同期 <img :src="item.imgscr" alt="" /> {{ item.bili }}%
                </div>
              </div>
              <div
                class="bottom_left_body_li_echarts"
                :id="`bottom_zhexian${index}`"
              ></div>
            </div>
          </div>
        </div>

        <div class="bottom_right">
          <div class="bottom_right_title">
            <div>活动预告</div>
            <div>查看更多</div>
          </div>
          <div
            class="bottom_right_body"
            v-for="(item, index) in bottomData"
            :key="index"
          >
            <div class="bottom_right_body_li">
              <img :src="imgSrc + item.activityImg" alt="" />
              <div>
                <div style="font-size: 14px">{{ item.name }}</div>
                <div class="bottom_right_body_li_text">{{ item.period }}</div>
                <div></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import echarts from "echarts";
import { subscribeNames, infoNames, activityNums } from "@/api/index";
export default {
  name: "Index",
  data() {
    return {
      imgSrc: process.env.VUE_APP_BASE_API,
      pieName: "",
      pieData: "",
      heights: "",
      widths: "",
      options: [],
      value: "",
      // 折线图列表数据
      li_data: [
        {
          time: "09:00",
          number: "50",
          bili: "43",
          imgscr: require("../assets/images/up.png"),
          color: "rgba(236, 78, 78, 1)",
          value: [820, 932, 901, 934, 1290, 1330, 1320],
        },
        {
          time: "10:00",
          number: "60",
          bili: "10",
          imgscr: require("../assets/images/down.png"),
          color: "rgba(85, 205, 136, 1)",
          value: [1231, 899, 1060, 1000, 1020, 952, 865],
        },
        {
          time: "11:00",
          number: "88",
          bili: "20",
          imgscr: require("../assets/images/down.png"),
          color: "rgba(85, 205, 136, 1)",
          value: [1231, 1158, 1100, 960, 1060, 952, 865],
        },
        {
          time: "12:00",
          number: "102",
          bili: "36",
          imgscr: require("../assets/images/up.png"),
          color: "rgba(236, 78, 78, 1)",
          value: [856, 925, 996, 1000, 900, 1260, 1320],
        },
        {
          time: "13:00",
          number: "110",
          bili: "10",
          imgscr: require("../assets/images/down.png"),
          color: "rgba(85, 205, 136, 1)",
          value: [1320, 1220, 1120, 1100, 1063, 983, 961],
        },
        {
          time: "14:00",
          number: "68",
          bili: "26",
          imgscr: require("../assets/images/up.png"),
          color: "rgba(236, 78, 78, 1)",
          value: [800, 950, 1020, 1050, 1188, 1228, 1298],
        },
      ],
      // 产品影响力排名
      effectList: [],
      bottomData: [
        {
          type: "说唱",
          time: "9月20日 8:30",
        },
        {
          type: "剑舞",
          time: "9月21日 9:30",
        },
        {
          type: "灶文化",
          time: "9月21日 9:30",
        },
      ],
    };
  },
  mounted() {
    
    var that = this;
    // this.heights =
    //   document.getElementsByClassName("navbar")[0].offsetHeight +
    //   document.getElementsByClassName("tags-view-container")[0].offsetHeight;

    this.widths =
      document.getElementsByClassName("sidebar-container")[0].offsetWidth;
    this.drawPie();
    this.topEcharts("zhexian1");
    this.topEcharts("zhexian2");
    for (let i = 0; i < this.li_data.length; i++) {
      this.topEchartss(`bottom_zhexian${i}`, this.li_data[i]);
    }
    // 产品影响力
    infoNames().then((res) => {
      that.effectList = res;
    });
    // 下拉框数据， 渲染柱状图
    subscribeNames().then((res) => {
      for (let a = 0; a < res.length; a++) {
        var obj = {
          value: res[a],
          label: res[a],
        };
        that.options.push(obj);
      }
    });
    // 活动预告
    activityNums().then((res) => {
      that.bottomData = res
    });
    setTimeout(function () {
      that.value = that.options[0].value;
    }, 300);
  },
  methods: {
    drawPie() {
      var myChart1 = this.echarts.init(document.getElementById("pie"));
      var option = {
        color: ["#EC4E4E", "#2063EF", "#F5AC15"],
        legend: {},
        tooltip: {},
        grid: {
          width: "80%",
          top: "20%",
        },
        xAxis: {
          type: "category",
          name: "(天)",
          data: [],
        },
        yAxis: {
          name: "(人)",
          splitLine: {
            show: false,
          },
          // splitNumber: 3,
        },
        // barWidth: 15,
        // barGap: 1,
        // Declare several bar series, each will be mapped
        // to a column of dataset.source by default.
        series: [
          {
            data: [],
            type: "bar",
          },
        ],
      };

      for (let i = 1; i < 31; i++) {
        option.xAxis.data.push(`09-${i < 10 ? "0" + i : i}`);
        option.series[0].data.push(Math.round(Math.random() * 100));
      }

      myChart1.setOption(option);
    },
    topEcharts(name) {
      var myChart = this.echarts.init(document.getElementById(name));
      // var myChart = this.echarts.init(document.getElementById('bottom_zhexian0'));

      var option;

      option = {
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: ["10-20", "10-25", "10-28", "11-03", "11-09", "11-13", "11-18"],
          axisLine: {
            show: false,
          },
          axisTick: {
            show: false,
          },
          splitLine: {
            show: false,
          },
          axisLabel: {
            color: "rgba(130, 152, 174, 1)",
          },
          splitNumber: 3,
        },
        grid: {
          top: "60%",
        },
        yAxis: {
          type: "value",
          axisLine: {
            show: false,
          },
          axisTick: {
            show: false,
          },
          splitLine: {
            show: false,
          },
          axisLabel: {
            show: false,
          },
          splitNumber: 3,
        },
        series: [
          {
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: "line",
            areaStyle: {
              color: {
                type: "linear",
                x: 0,
                y: 0,
                x2: 0,
                y2: 1,
                colorStops: [
                  {
                    offset: 0,
                    color: "rgba(85, 205, 136, 1)", // 0% 处的颜色
                  },
                  {
                    offset: 1,
                    color: "#fff", // 100% 处的颜色
                  },
                ],
                global: false, // 缺省为 false
              },
            },
            lineStyle: {
              color: "rgba(85, 205, 136, 1)",
            },
            symbolSize: 0,
          },
        ],
      };

      option && myChart.setOption(option);
    },
    topEchartss(name, data) {
      var myChart = this.echarts.init(document.getElementById(name));
      // var myChart = this.echarts.init(document.getElementById('bottom_zhexian0'));

      var option;

      option = {
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: ["10-20", "10-25", "10-28", "11-03", "11-09", "11-13", "11-18"],
          axisLine: {
            show: false,
          },
          axisTick: {
            show: false,
          },
          splitLine: {
            show: false,
          },
          axisLabel: {
            color: "rgba(130, 152, 174, 1)",
          },
          splitNumber: 3,
        },
        yAxis: {
          type: "value",
          axisLine: {
            show: false,
          },
          axisTick: {
            show: false,
          },
          splitLine: {
            show: false,
          },
          axisLabel: {
            show: false,
          },
          splitNumber: 3,
        },
        grid: {
          width: "80%",
          top: "20%",
          left: "20",
          bottom: "30%",
        },
        series: [
          {
            data: data.value,
            type: "line",
            areaStyle: {
              color: {
                type: "linear",
                x: 0,
                y: 0,
                x2: 0,
                y2: 1,
                colorStops: [
                  {
                    offset: 0,
                    color: data.color, // 0% 处的颜色
                  },
                  {
                    offset: 1,
                    color: "#fff", // 100% 处的颜色
                  },
                ],
                global: false, // 缺省为 false
              },
            },
            lineStyle: {
              color: data.color,
            },
            symbolSize: 0,
          },
        ],
      };

      option && myChart.setOption(option);
    },
    selectValue() {
      this.drawPie();
      console.log(this.value);
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
}

.home_top {
  display: flex;
  justify-content: space-between;
  margin-bottom: 3.9vh;

  .top_left {
    width: 41.2%;
    min-width: 41.2%;
    height: 36.8vh;
    background-color: #fff;
    border-radius: 13px;
    padding: 15px 20px;
    box-sizing: border-box;

    .top_left_title {
      font-weight: bold;
      color: #2a3850;
      font-size: 24px;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    #pie {
      width: 100%;
      height: 100%;
    }
  }

  .top_right {
    width: 100%;
    margin-left: 29px;

    .top_right_title {
      width: 100%;
      height: 5.2vh;
      background-color: #fff;
      line-height: 5.2vh;
      border-radius: 13px;
      margin-bottom: 13px;

      display: flex;
      align-items: center;
      img {
        margin-right: 25px;
        margin-left: 20px;
      }
      span {
        font-size: 14px;
      }
    }

    .top_right_body {
      display: flex;
      justify-content: space-between;

      .top_right_body_left {
        width: 56%;
        min-width: 56%;
        background-color: #fff;
        border-radius: 8px;
        height: 14.1vh;

        .top_right_body_left_title {
          height: 32px;
          width: 100%;
          border-bottom: 1px solid #f5f6fa;
          display: flex;
          justify-content: space-between;
          align-items: center;
          padding: 0 18px;
          box-sizing: border-box;
          font-size: 14px;
        }

        .top_right_body_left_body {
          padding: 6px 26px 11px 22px;
          box-sizing: border-box;
          display: flex;
          height: 10.5vh;
          flex-direction: column;
          justify-content: space-around;

          .top_right_body_left_body_number div:nth-of-type(1) {
            display: inline-block;
            font-size: 26px;
            margin-right: 5px;
          }
          .top_right_body_left_body_number div:nth-of-type(2) {
            display: inline-block;
            font-size: 6px;
          }

          .top_right_body_left_body_number_icon {
            width: 12px;
            height: 12px;
          }
          .top_right_body_left_body_contrast {
            font-size: 6px;
            div {
              display: flex;
              align-items: center;
            }

            img {
              width: 11px;
              height: 14px;
              margin-left: 8px;
              margin-right: 3px;
            }
          }
        }

        .top_right_body_right_body {
          width: 50%;
          height: 10.5vh;
          padding: 6px 26px 11px 22px;
          box-sizing: border-box;
        }
      }

      .top_right_body_right {
        width: 43%;
        background-color: #fff;
        border-radius: 8px;
        height: 14.1vh;

        .top_right_body_right_title {
          height: 32px;
          width: 100%;
          display: flex;
          justify-content: space-between;
          align-items: center;
          padding: 0 18px;
          box-sizing: border-box;
          font-size: 14px;
          cursor: pointer;
          box-shadow: 0px 8px 27px 0px rgba(66, 107, 176, 0.06);
        }

        .top_right_body_right_ph_n1 {
          width: 100%;
          height: calc((14.1vh - 32px) / 3);
          display: flex;
          align-items: center;
          justify-content: space-between;
          box-sizing: border-box;
          font-size: 13px;
          border-bottom: 1px solid #f0f4fb;

          .top_right_body_right_ph_n1_icon {
            padding: 1px 3px;
            background-color: rgba(250, 54, 53, 0.3);
            color: #fa3635;
            margin-right: 5px;
            border-radius: 5px;
          }

          div{
            display: flex;

            img{
              margin-right: 3px;
              width: 10px;
              height: 12px;
            }
          }
        }

        .top_right_body_right_ph_p1 {
          width: 100%;
          height: calc((14.1vh - 32px) / 3);
          display: flex;
          align-items: center;
          justify-content: space-between;
          font-size: 12px;
          color: #2a3850;

          div {
            display: flex;
            align-items: center;
            img {
              width: 20px;
              height: 22px;
              margin-right: 5px;
            }
          }
        }
      }
    }
  }
}

.home_bottom {
  display: flex;
  justify-content: space-between;
  .bottom_left {
    width: 63vw;
    min-width: 63vw;
    margin-right: 20px;

    .bottom_left_title {
      display: flex;
      width: 100%;
      align-items: center;
      justify-content: space-between;
      padding: 0 21px;
      box-sizing: border-box;
      height: 41.33px;
      background-color: #fff;
      border-radius: 13px;
      font-size: 16px;
      margin-bottom: 1.2vh;

      img {
        width: 21px;
        height: 21px;
        margin-right: 5px;
      }
    }

    .bottom_left_body {
      width: 100%;
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;

      .bottom_left_body_li {
        width: 32%;
        margin-bottom: 10px;
        display: flex;
        justify-content: space-between;
        height: 16vh;
        border-radius: 8px;
        background-color: #fff;
        box-sizing: border-box;

        .bottom_left_body_li_data {
          padding: 20px 10px;
          box-sizing: border-box;
          display: flex;
          flex-direction: column;
          justify-content: space-between;
        }

        .bottom_left_body_li_data div:nth-of-type(1) {
          font-size: 16px;
        }
        .bottom_left_body_li_data div:nth-of-type(2) {
          font-size: 32px;
          margin: 0.9vh 0 1.2vh;
        }
        .bottom_left_body_li_data div:nth-of-type(3) {
          font-size: 10px;
          display: flex;
          align-items: center;

          img {
            width: 10px;
            height: 12px;
            margin-left: 5px;
          }
        }

        .bottom_left_body_li_echarts {
          padding: 3.3vh 20px 10px;
          box-sizing: border-box;
          height: calc(18vh - 20px) !important;
          width: 60%;
        }
      }
    }
  }

  .bottom_right {
    width: 100%;
    height: 39.8vh;
    background-color: #fff;
    border-radius: 10px;
    overflow: hidden;

    .bottom_right_title {
      display: flex;
      justify-content: space-between;
      align-items: center;
      width: 100%;
      height: 3.7vh;
      border-radius: 10px;
      padding: 0 15px;
      box-sizing: border-box;
      box-shadow: 0px 8px 27px 0px rgba(66, 107, 176, 0.06);
      font-size: 16px;
      margin-bottom: 1.3vh;
    }

    .bottom_right_title div:nth-of-type(2) {
      color: rgba(180, 193, 206, 1);
      font-size: 11px;
      cursor: pointer;
    }

    .bottom_right_body_li {
      width: 100%;
      padding: 1.3vh 13px;
      box-sizing: border-box;
      display: flex;
      border-bottom: 1px solid #eeeeee;

      img {
        width: 6vw;
        height: calc((36vh - (8 * 1.3vh)) / 3);
        margin-right: 15px;
        border-radius: 5px;
      }

      .bottom_right_body_li_text {
        color: red;
        line-height: 6.6vh;

        font-weight: 500;
        font-size: 18px;
      }
    }

    .bottom_right_body_li div:nth-of-type(2) {
      display: flex;
      flex-direction: column;
      justify-content: space-between;
    }
  }
}

.top_right_bodys {
  display: flex;
  flex-direction: column;
  height: calc(100% - 5.2vh - 13px);
  justify-content: space-between;
}

.icon_img {
  width: 20px;
  height: 20px;
}
</style>

