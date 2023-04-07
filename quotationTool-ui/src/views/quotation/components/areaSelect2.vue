<template>
    <div>
        <main class="add-address col-xs-y scroll-y">

            <div class="item item1 flex-box-x arrow" tapmode @click="showAddress">
                <div class="left">所在地区</div>
                <div class="right col-xs-x">
                    <input type="text" placeholder="请选择" v-model="changeRegion" readonly="true">
                </div>
            </div>
            <mt-popup v-model="isShow" position="bottom" popup-transition="popup-fade" closeOnClickModal="true"
                style="width: 100%;">
                <div class="popup-div1">
                    <div class="font-red font-s2 popup-div2" @click="onSumbile"
                        style="font-size: 18px; padding-left: 80%; padding-top: 10px;">确定<!--确定--></div>
                </div>
                <mt-picker :slots="myAddressSlots" value-key="p" @change="onMyAddressChange" showToolbar></mt-picker>
            </mt-popup>

        </main>
    </div>
</template>    
<script>
import myaddress from '@/api/quotationData/chinaArea.json'        //这是json格式的省市区数据自行下载

export default {
    name: 'address_add',
    data() {
        return {
            isShow: false,
            lv1Form: {
                consignee: '',
                mobile: '',
                default: false,
                province: '',
                city: '',
                region: '',
                detail: ''
            },
            region: '',
            changeRegion: '',
            goOrder: this.$route.params.goOrder, // 判断是否回跳订单页面
            myAddressSlots: [],
            provinceIndex: 0,
            cityIndex: 0,
            regionIndex: 0,
            defaultIndex: false,
            provinceValue: []
        }
    },
    watch: {
        isShow: function (val, oldval) {
            if (val === false && this.defaultIndex === false) {
                this.remeberIndex(this.lv1Form.province, this.lv1Form.city, this.lv1Form.region)// 处理回显
                this.myAddressSlots = []
                this.$nextTick(() => {
                    this.myAddressSlots = [{
                        flex: 1,
                        defaultIndex: this.provinceIndex,
                        values: Object.values(this.myaddress)[2], // 省份数组
                        className: 'slot1',
                        textAlign: 'center',
                        valueKey: 'name',
                    }, {
                        flex: 1,
                        defaultIndex: this.cityIndex,
                        values: (Object.values(this.myaddress)[2])[this.provinceIndex].childList,
                        className: 'slot2',
                        textAlign: 'center',
                        valueKey: 'name',
                    }, {
                        flex: 1,
                        defaultIndex: this.regionIndex,
                        values: ((Object.values(this.myaddress)[2])[this.provinceIndex].childList)[this.cityIndex].childList,
                        className: 'slot3',
                        textAlign: 'center',
                        valueKey: 'name',
                    }]
                })
            }
        }
    },
    mounted() {
        debugger
        // 处理三级联动的逻辑
        let address = JSON.stringify(myaddress)//.replace(/n/g, 'p')
        //address = address.replace(/s/g, 'p')
        //address = address.replace(/市辖区/, '市辖区 ')
        this.myaddress = JSON.parse(address)
        // 处理回显
        this.myAddressSlots = [{
            flex: 1,
            defaultIndex: this.provinceIndex,
            values: Object.values(this.myaddress)[2], // 省份数组
            className: 'slot1',
            textAlign: 'center',
            valueKey: 'name',
        }, {
            flex: 1,
            defaultIndex: this.cityIndex,
            values: (Object.values(this.myaddress)[2])[this.provinceIndex].childList,
            className: 'slot2',
            textAlign: 'center',
            valueKey: 'name',
        }, {
            flex: 1,
            defaultIndex: this.regionIndex,
            values: ((Object.values(this.myaddress)[2])[this.provinceIndex].childList)[this.cityIndex].childList,
            className: 'slot3',
            textAlign: 'center',
            valueKey: 'name',
        }]
        this.provinceValue = this.myAddressSlots
    },
    methods: {
        // 打开地区选择器
        // 设置详细地址
        showAddress() {
            this.isShow = true
            this.defaultIndex = false
        },
        onMyAddressChange(picker, values) {
            if (values[0]) {
                picker.setSlotValues(1, values[0].childList)
                picker.setSlotValues(2, values[1].childList)
            }
            // this.c = Object.keys(values[2].p)
            if (values[0]) {
                this.province = values[0].name
            }
            if (values[1]) {
                this.city = values[1].name
            }
            if (values[2]) {
                this.region = values[2].name
            }
            // this.province = values[0].p
            // console.log(this.province)
            //    this.city = values[1].p
            //    this.region = values[2].p
        },
        // 点击确定关闭选择器
        onSumbile() {
            if (!this.province) {
                this.province = (Object.values(this.myaddress)[2])[0].name
                this.city = ((Object.values(this.myaddress)[2])[this.provinceIndex].childList)[0].name
                this.region = (((Object.values(this.myaddress)[2])[this.provinceIndex].childList)[this.cityIndex].childList)[0].name
            }
            this.lv1Form.province = this.province
            this.lv1Form.city = this.city.trim()
            this.lv1Form.region = this.region
            this.changeRegion = this.lv1Form.province + ' ' + this.lv1Form.city + ' ' + this.lv1Form.region
            this.isShow = false
            this.provinceValue = this.myAddressSlots
            this.defaultIndex = true
        },
        remeberIndex(province, city, region) {
            for (let i = 0; i < (Object.values(this.myaddress)[2]).length; i++) {
                if (province === (Object.values(this.myaddress)[2])[i].name) {
                    this.provinceIndex = i
                }
            }
            for (let i = 0; i < ((Object.values(this.myaddress)[2])[this.provinceIndex].childList).length; i++) {
                if (city === ((Object.values(this.myaddress)[2])[this.provinceIndex].childList)[i].name) {
                    this.cityIndex = i
                }
            }
            for (let i = 0; i < (((Object.values(this.myaddress)[2])[this.provinceIndex].childList)[this.cityIndex].childList).length; i++) {
                if (region === (((Object.values(this.myaddress)[2])[this.provinceIndex].childList)[this.cityIndex].childList)[i].name) {
                    this.regionIndex = i
                }
            }
        },
    },
}
</script>