(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d230a86"],{ece7:function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("el-form",{directives:[{name:"show",rawName:"v-show",value:e.showSearch,expression:"showSearch"}],ref:"queryForm",attrs:{model:e.queryParams,size:"small",inline:!0,"label-width":"68px"}},[a("el-form-item",{attrs:{label:"活动名称",prop:"name"}},[a("el-input",{attrs:{placeholder:"请输入活动名称",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.name,callback:function(t){e.$set(e.queryParams,"name",t)},expression:"queryParams.name"}})],1),a("el-form-item",{attrs:{label:"归属场馆",prop:"attrSite"}},[a("el-input",{attrs:{placeholder:"请输入归属场馆",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.attrSite,callback:function(t){e.$set(e.queryParams,"attrSite",t)},expression:"queryParams.attrSite"}})],1),a("el-form-item",{attrs:{label:"活动状态",prop:"activityType"}},[a("el-input",{attrs:{placeholder:"请输入活动状态",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.activityType,callback:function(t){e.$set(e.queryParams,"activityType",t)},expression:"queryParams.activityType"}})],1),a("el-form-item",{attrs:{label:"入库时间"}},[a("el-date-picker",{staticStyle:{width:"240px"},attrs:{"value-format":"yyyy-MM-dd",type:"daterange","range-separator":"-","start-placeholder":"开始日期","end-placeholder":"结束日期"},model:{value:e.daterangeCreateTime,callback:function(t){e.daterangeCreateTime=t},expression:"daterangeCreateTime"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:e.handleQuery}},[e._v("搜索")]),a("el-button",{attrs:{icon:"el-icon-refresh",size:"mini"},on:{click:e.resetQuery}},[e._v("重置")])],1)],1),a("el-row",{staticClass:"mb8",attrs:{gutter:10}},[a("el-col",{attrs:{span:1.5}},[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["business:activity:add"],expression:"['business:activity:add']"}],attrs:{type:"primary",plain:"",icon:"el-icon-plus",size:"mini"},on:{click:e.handleAdd}},[e._v("新增")])],1),a("el-col",{attrs:{span:1.5}},[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["business:activity:export"],expression:"['business:activity:export']"}],attrs:{type:"warning",plain:"",icon:"el-icon-download",size:"mini"},on:{click:e.handleExport}},[e._v("导出")])],1),a("right-toolbar",{attrs:{showSearch:e.showSearch},on:{"update:showSearch":function(t){e.showSearch=t},"update:show-search":function(t){e.showSearch=t},queryTable:e.getList}})],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{data:e.activityList},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),a("el-table-column",{attrs:{label:"主键",align:"center",prop:"activityId"}}),a("el-table-column",{attrs:{label:"活动名称",align:"center",prop:"name"}}),a("el-table-column",{attrs:{label:"图片",align:"center",prop:"activityImg",width:"100"},scopedSlots:e._u([{key:"default",fn:function(e){return[a("image-preview",{attrs:{src:e.row.activityImg,width:50,height:50}})]}}])}),a("el-table-column",{attrs:{label:"活动详情",align:"center","show-overflow-tooltip":"true",prop:"activityDetails"}}),a("el-table-column",{attrs:{label:"活动介绍视频",align:"center",prop:"activityVideo"}}),a("el-table-column",{attrs:{label:"活动地址",align:"center",prop:"activityAddr"}}),a("el-table-column",{attrs:{label:"活动承办方",align:"center",prop:"activityContractor"}}),a("el-table-column",{attrs:{label:"活动周期",align:"center","show-overflow-tooltip":"true",prop:"period"}}),a("el-table-column",{attrs:{label:"温馨提示",align:"center",prop:"hint"}}),a("el-table-column",{attrs:{label:"活动最大参与人数",align:"center",prop:"maxPeople"}}),a("el-table-column",{attrs:{label:"活动状态",align:"center",prop:"activityType"}}),a("el-table-column",{attrs:{label:"归属场馆",align:"center",prop:"attrSite"}}),a("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["business:activity:edit"],expression:"['business:activity:edit']"}],attrs:{size:"mini",type:"text",icon:"el-icon-edit"},on:{click:function(a){return e.handleUpdate(t.row)}}},[e._v("修改")]),a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["business:activity:remove"],expression:"['business:activity:remove']"}],attrs:{size:"mini",type:"text",icon:"el-icon-delete"},on:{click:function(a){return e.handleDelete(t.row)}}},[e._v("删除")])]}}])})],1),a("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total > 0"}],attrs:{total:e.total,page:e.queryParams.pageNum,limit:e.queryParams.pageSize},on:{"update:page":function(t){return e.$set(e.queryParams,"pageNum",t)},"update:limit":function(t){return e.$set(e.queryParams,"pageSize",t)},pagination:e.getList}}),a("el-dialog",{attrs:{title:e.title,visible:e.open,width:"50%","append-to-body":""},on:{"update:visible":function(t){e.open=t}}},[a("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"活动名称",prop:"name"}},[a("el-input",{attrs:{placeholder:"请输入活动名称"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),a("el-form-item",{attrs:{label:"图片"}},[a("image-upload",{model:{value:e.form.activityImg,callback:function(t){e.$set(e.form,"activityImg",t)},expression:"form.activityImg"}})],1),a("el-form-item",{attrs:{label:"活动详情"}},[a("editor",{attrs:{"min-height":192},model:{value:e.form.activityDetails,callback:function(t){e.$set(e.form,"activityDetails",t)},expression:"form.activityDetails"}})],1),a("el-form-item",{attrs:{label:"活动介绍视频"}},[a("file-upload",{model:{value:e.form.activityVideo,callback:function(t){e.$set(e.form,"activityVideo",t)},expression:"form.activityVideo"}})],1),a("el-form-item",{attrs:{label:"活动地址",prop:"activityAddr"}},[a("el-input",{attrs:{placeholder:"请输入活动地址"},model:{value:e.form.activityAddr,callback:function(t){e.$set(e.form,"activityAddr",t)},expression:"form.activityAddr"}})],1),a("el-form-item",{attrs:{label:"活动承办方",prop:"activityContractor"}},[a("el-input",{attrs:{placeholder:"请输入活动承办方"},model:{value:e.form.activityContractor,callback:function(t){e.$set(e.form,"activityContractor",t)},expression:"form.activityContractor"}})],1),a("el-form-item",{attrs:{label:"活动周期",prop:"period"}},[a("el-input",{attrs:{placeholder:"请输入活动周期"},model:{value:e.form.period,callback:function(t){e.$set(e.form,"period",t)},expression:"form.period"}})],1),a("el-form-item",{attrs:{label:"温馨提示",prop:"hint"}},[a("el-input",{attrs:{placeholder:"请输入温馨提示"},model:{value:e.form.hint,callback:function(t){e.$set(e.form,"hint",t)},expression:"form.hint"}})],1),a("el-form-item",{attrs:{label:"活动最大参与人数",prop:"maxPeople"}},[a("el-input",{attrs:{placeholder:"请输入活动最大参与人数"},model:{value:e.form.maxPeople,callback:function(t){e.$set(e.form,"maxPeople",t)},expression:"form.maxPeople"}})],1),a("el-form-item",{attrs:{label:"归属场馆",prop:"attrSite"}},[a("el-input",{attrs:{placeholder:"请输入归属场馆"},model:{value:e.form.attrSite,callback:function(t){e.$set(e.form,"attrSite",t)},expression:"form.attrSite"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.submitForm}},[e._v("确 定")]),a("el-button",{on:{click:e.cancel}},[e._v("取 消")])],1)],1)],1)},r=[],l=a("5530"),n=(a("d81d"),a("b775"));function o(e){return Object(n["a"])({url:"/business/activity/list",method:"get",params:e})}function s(e){return Object(n["a"])({url:"/business/activity/"+e,method:"get"})}function c(e){return Object(n["a"])({url:"/business/activity",method:"post",data:e})}function u(e){return Object(n["a"])({url:"/business/activity",method:"put",data:e})}function m(e){return Object(n["a"])({url:"/business/activity/"+e,method:"delete"})}var p={name:"Activity",data:function(){return{loading:!0,ids:[],single:!0,multiple:!0,showSearch:!0,total:0,activityList:[],title:"",open:!1,daterangeCreateTime:[],queryParams:{pageNum:1,pageSize:10,name:null,activityImg:null,activityDetails:null,activityVideo:null,activityAddr:null,activityContractor:null,period:null,hint:null,maxPeople:null,activityType:null,attrSite:null,createTime:null,delStatus:null},form:{},rules:{}}},created:function(){this.getList()},methods:{getList:function(){var e=this;this.loading=!0,this.queryParams.params={},null!=this.daterangeCreateTime&&""!=this.daterangeCreateTime&&(this.queryParams.params["beginCreateTime"]=this.daterangeCreateTime[0],this.queryParams.params["endCreateTime"]=this.daterangeCreateTime[1]),o(this.queryParams).then((function(t){e.activityList=t.rows,e.total=t.total,e.loading=!1}))},cancel:function(){this.open=!1,this.reset()},reset:function(){this.form={activityId:null,name:null,activityImg:null,activityDetails:null,activityVideo:null,activityAddr:null,activityContractor:null,period:null,hint:null,maxPeople:null,activityType:null,attrSite:null,createTime:null,delStatus:"0"},this.resetForm("form")},handleQuery:function(){this.queryParams.pageNum=1,this.getList()},resetQuery:function(){this.daterangeCreateTime=[],this.resetForm("queryForm"),this.handleQuery()},handleSelectionChange:function(e){this.ids=e.map((function(e){return e.activityId})),this.single=1!==e.length,this.multiple=!e.length},handleAdd:function(){this.reset(),this.open=!0,this.title="添加活动库数据"},handleUpdate:function(e){var t=this;this.reset();var a=e.activityId||this.ids;s(a).then((function(e){t.form=e.data,t.open=!0,t.title="修改活动库数据"}))},submitForm:function(){var e=this;this.$refs["form"].validate((function(t){t&&(null!=e.form.activityId?u(e.form).then((function(t){e.$modal.msgSuccess("修改成功"),e.open=!1,e.getList()})):c(e.form).then((function(t){e.$modal.msgSuccess("新增成功"),e.open=!1,e.getList()})))}))},handleDelete:function(e){var t=this,a=e.activityId||this.ids;this.$modal.confirm('是否确认删除活动库数据编号为"'+a+'"的数据项？').then((function(){return m(a)})).then((function(){t.getList(),t.$modal.msgSuccess("删除成功")})).catch((function(){}))},handleExport:function(){this.download("business/activity/export",Object(l["a"])({},this.queryParams),"activity_".concat((new Date).getTime(),".xlsx"))}}},d=p,h=a("2877"),y=Object(h["a"])(d,i,r,!1,null,null,null);t["default"]=y.exports}}]);