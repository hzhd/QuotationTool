<template>
    <div class="form-item">
        <mt-cell title="家庭地址" is-link @click.native="showPopup">
            <span>{{ currentTags }}</span>
        </mt-cell>
        <mt-popup v-model="popupVisible" position="bottom" :modal="true" :closeOnClickModal="false"
            popup-transition="popup-fade" style="width : 100%;">
            <mt-picker :slots="addressList" :show-toolbar="true" ref="familyAddress" :itemHeight=44 valueKey="name"
                @change="onValuesChange">
                <slot>
                    <div class="toolbar">
                        <span class="cancel-container" @click="cancelChoose">取消</span>
                        <span class="confirm-container" @click="confirmChoose">确认</span>
                    </div>
                </slot>
            </mt-picker>
        </mt-popup>
    </div>
</template>
<script>
import myaddress from '@/api/quotationData/chinaArea.json'        //这是json格式的省市区数据自行下载

export default {
    name: "cityPicker",
    data() {
        return {
            myaddress: myaddress.childList,
            address: null,
            currentTags: "请选择",
            currentCode: "",
            handler: function (e) {
                e.preventDefault()
            },
            popupVisible: false,
            province: '',//省
            city: '',//市
            county: '',//县
            provinceCode: '',//省级代码
            cityCode: '', //市级代码
            countyCode: '',//县级代码
            regionInit: false,//禁止地区选择器自动初始化，picker组件会默认进行初始化，导致一进入页面就会默认选中一个初始3级地址
        }
    },
    created() {
        // 获取所有省市区
        // axios.get("/api/address").then(res => {
        //     if (res) {
        //         this.address = res
        //     }
        // })
        this.address = this.myaddress
    },
    methods: {
        closeTouch() {
            document.getElementsByTagName('body')[0].addEventListener('touchmove', this.handler, { passive: false })//阻止默认事件
        },
        openTouch() {
            document.getElementsByTagName('body')[0].removeEventListener('touchmove', this.handler, { passive: false })//打开默认事件
        },
        getProvinceArr() {
            let provinceArr = [];
            if (this.address) {
                this.address.forEach(function (item) {
                    let obj = {};
                    obj.name = item.name;
                    obj.code = item.code;
                    provinceArr.push(obj);
                });
            }
            return provinceArr;
        },
        //遍历json，返回市级对象数组
        getCityArr(province) {
            let cityArr = [];
            if (this.address) {
                this.address.forEach(function (item) {
                    if (item.name === province) {
                        item.childList.forEach(function (args) {
                            let obj = {};
                            obj.name = args.name;
                            obj.code = args.code;
                            cityArr.push(obj);
                        });
                    }
                });
            }
            return cityArr;
        },
        //遍历json，返回县级对象数组
        getCountyArr(province, city) {
            let countyArr = [];
            if (this.address) {
                this.address.forEach(function (item) {
                    if (item.name === province) {
                        item.childList.forEach(function (args) {
                            if (args.name === city) {
                                args.childList.forEach(function (param) {
                                    let obj = {};
                                    obj.name = param.name;
                                    obj.code = param.code;
                                    countyArr.push(obj);
                                })
                            }
                        });
                    }
                })
            }
            return countyArr;
        },
        showPopup() {
            this.popupVisible = true
            this.closeTouch();
        },
        cancelChoose() {
            this.popupVisible = false;
            this.openTouch();
        },
        confirmChoose() {
            let vals = this.$refs.familyAddress.getValues()
            this.getFamilyAddress(vals)
            this.popupVisible = false;
            this.openTouch();
        },
        getFamilyAddress(vals) {
            this.province = vals[0].name
            this.city = vals[1].name
            this.provinceCode = vals[0].code
            this.cityCode = vals[1].code
            if (vals[2] != null) {
                this.county = vals[2].name
                this.countyCode = vals[2].code
            }
            this.currentTags = this.province + '/' + this.city + '/' + this.county
            this.currentCode = this.provinceCode + '/' + this.cityCode + '/' + this.countyCode
            console.log("当前地址：" + this.currentTags)
            console.log("当前地址编码：" + this.currentCode)
        },
        onValuesChange(picker, values) {
            if (this.regionInit) {
                let provinceArr = this.getProvinceArr();
                picker.setSlotValues(0, provinceArr);
                let cityArr = this.getCityArr(values[0].name);
                picker.setSlotValues(1, cityArr);
                let countyArr = this.getCountyArr(values[0].name, values[1].name);
                picker.setSlotValues(2, countyArr);
            } else {
                this.regionInit = true;
            }
        }
    },
    computed: {
        addressList: function () {
            if (this.address) {
                let provinceArr = this.getProvinceArr();
                let cityArr = this.getCityArr("北京市");
                let countyArr = this.getCountyArr("北京市", "市辖区");
                return [
                    {
                        flex: 1,
                        values: provinceArr, //省份数组
                        className: 'slot1',
                        textAlign: 'center'
                    },
                    {
                        divider: true,
                        content: '-',
                        className: 'slot2'
                    },
                    {
                        flex: 1,
                        values: cityArr,
                        className: 'slot3',
                        textAlign: 'center'
                    },
                    {
                        divider: true,
                        content: '-',
                        className: 'slot4'
                    },
                    {
                        flex: 1,
                        values: countyArr,
                        className: 'slot5',
                        textAlign: 'center'
                    }
                ]
            }
            return []
        }
    }
}
</script>
<!-- <style scoped lang="less">
.toolbar {
    width: 100%;
    display: flex;
    text-align: center;
    background: #F7F7F7;
    border-bottom: 1px solid #EEE;

    span {
        flex: 1;
        font-size: 16px;
        color: #26a2ff;
        line-height: 44px;
    }
}
</style> -->
<style>
.toolbar {
    width: 100%;
    display: flex;
    text-align: center;
    background: #F7F7F7;
    border-bottom: 1px solid #EEE;
}

.toolbar span {
    flex: 1;
    font-size: 16px;
    color: #26a2ff;
    line-height: 44px;
}
</style>