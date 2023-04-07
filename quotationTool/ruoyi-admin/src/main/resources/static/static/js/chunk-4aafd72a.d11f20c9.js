(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4aafd72a"],{c59e:function(e,t,i){e.exports=i.p+"static/img/video.c372f4d2.png"},e2f5:function(e,t,i){"use strict";i.r(t);var a=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("el-form",{directives:[{name:"show",rawName:"v-show",value:e.showSearch,expression:"showSearch"}],ref:"queryForm",attrs:{model:e.queryParams,size:"small",inline:!0,"label-width":"68px"}},[a("el-form-item",{attrs:{label:"电影名称",prop:"movieName"}},[a("el-input",{attrs:{placeholder:"请输入电影名称",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.movieName,callback:function(t){e.$set(e.queryParams,"movieName",t)},expression:"queryParams.movieName"}})],1),a("el-form-item",{attrs:{label:"电影类型",prop:"movieType"}},[a("el-select",{attrs:{placeholder:"请选择电影类型",clearable:""},model:{value:e.queryParams.movieType,callback:function(t){e.$set(e.queryParams,"movieType",t)},expression:"queryParams.movieType"}},e._l(e.dict.type.movie_type,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),a("el-form-item",{attrs:{label:"归属场馆",prop:"guishuAddr"}},[a("el-input",{attrs:{placeholder:"请输入电影归属场馆",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.guishuAddr,callback:function(t){e.$set(e.queryParams,"guishuAddr",t)},expression:"queryParams.guishuAddr"}})],1),a("el-form-item",{attrs:{label:"入库时间"}},[a("el-date-picker",{staticStyle:{width:"240px"},attrs:{"value-format":"yyyy-MM-dd",type:"daterange","range-separator":"-","start-placeholder":"开始日期","end-placeholder":"结束日期"},model:{value:e.daterangeCreateTime,callback:function(t){e.daterangeCreateTime=t},expression:"daterangeCreateTime"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:e.handleQuery}},[e._v("搜索")]),a("el-button",{attrs:{icon:"el-icon-refresh",size:"mini"},on:{click:e.resetQuery}},[e._v("重置")])],1)],1),a("el-row",{staticClass:"mb8",attrs:{gutter:10}},[a("el-col",{attrs:{span:1.5}},[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["business:viewing:add"],expression:"['business:viewing:add']"}],attrs:{type:"primary",plain:"",icon:"el-icon-plus",size:"mini"},on:{click:e.handleAdd}},[e._v("新增")])],1),a("el-col",{attrs:{span:1.5}},[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["business:viewing:export"],expression:"['business:viewing:export']"}],attrs:{type:"warning",plain:"",icon:"el-icon-download",size:"mini"},on:{click:e.handleExport}},[e._v("导出")])],1),a("right-toolbar",{attrs:{showSearch:e.showSearch},on:{"update:showSearch":function(t){e.showSearch=t},"update:show-search":function(t){e.showSearch=t},queryTable:e.getList}})],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{data:e.viewingList},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),a("el-table-column",{attrs:{label:"电影名称",align:"center",prop:"movieName"}}),a("el-table-column",{attrs:{label:"电影类型",align:"center",prop:"movieType"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("dict-tag",{attrs:{options:e.dict.type.movie_type,value:t.row.movieType}})]}}])}),a("el-table-column",{attrs:{label:"电影图片",align:"center",prop:"movieMsg",width:"100"},scopedSlots:e._u([{key:"default",fn:function(e){return[a("image-preview",{attrs:{src:e.row.movieMsg,width:50,height:50}})]}}])}),a("el-table-column",{attrs:{label:"放映时间",align:"center",prop:"time",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(e.parseTime(t.row.time,"{y}-{m}-{d}")))])]}}])}),a("el-table-column",{attrs:{label:"放映地点",align:"center",prop:"site"}}),a("el-table-column",{attrs:{label:"电影片段",align:"center",prop:"moviePianduan"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.moviePianduan?a("img",{staticStyle:{width:"45px",height:"35px"},attrs:{src:i("c59e")},on:{click:function(i){return e.voicePlay(t.row.moviePianduan)}}}):e._e(),t.row.moviePianduan?e._e():a("div",[e._v("暂无数据")])]}}])}),a("el-table-column",{attrs:{label:"温馨提示",align:"center",prop:"tishi","show-overflow-tooltip":!0}}),a("el-table-column",{attrs:{label:"最大观影人数",align:"center",prop:"maxPeople"}}),a("el-table-column",{attrs:{label:"归属场馆",align:"center",prop:"guishuAddr"}}),a("el-table-column",{attrs:{label:"入库时间",align:"center",prop:"createTime"}}),a("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["business:viewing:edit"],expression:"['business:viewing:edit']"}],attrs:{size:"mini",type:"text",icon:"el-icon-edit"},on:{click:function(i){return e.handleUpdate(t.row)}}},[e._v("修改")]),a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["business:viewing:remove"],expression:"['business:viewing:remove']"}],attrs:{size:"mini",type:"text",icon:"el-icon-delete"},on:{click:function(i){return e.handleDelete(t.row)}}},[e._v("删除")])]}}])})],1),a("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total > 0"}],attrs:{total:e.total,page:e.queryParams.pageNum,limit:e.queryParams.pageSize},on:{"update:page":function(t){return e.$set(e.queryParams,"pageNum",t)},"update:limit":function(t){return e.$set(e.queryParams,"pageSize",t)},pagination:e.getList}}),a("el-dialog",{attrs:{title:e.title,visible:e.open,width:"50%","append-to-body":""},on:{"update:visible":function(t){e.open=t}}},[a("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"电影名称",prop:"movieName"}},[a("el-input",{attrs:{placeholder:"请输入电影名称"},model:{value:e.form.movieName,callback:function(t){e.$set(e.form,"movieName",t)},expression:"form.movieName"}})],1),a("el-form-item",{attrs:{label:"电影介绍"}},[a("editor",{attrs:{"min-height":192},model:{value:e.form.movieJieshao,callback:function(t){e.$set(e.form,"movieJieshao",t)},expression:"form.movieJieshao"}})],1),a("el-form-item",{attrs:{label:"电影类型",prop:"movieType"}},[a("el-select",{attrs:{placeholder:"请选择电影类型"},model:{value:e.form.movieType,callback:function(t){e.$set(e.form,"movieType",t)},expression:"form.movieType"}},e._l(e.dict.type.movie_type,(function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1),a("el-form-item",{attrs:{label:"电影图片"}},[a("image-upload",{model:{value:e.form.movieMsg,callback:function(t){e.$set(e.form,"movieMsg",t)},expression:"form.movieMsg"}})],1),a("el-form-item",{attrs:{label:"观影人数",prop:"viewingNo"}},[a("el-input",{attrs:{placeholder:"请输入观影人数"},model:{value:e.form.viewingNo,callback:function(t){e.$set(e.form,"viewingNo",t)},expression:"form.viewingNo"}})],1),a("el-form-item",{attrs:{label:"观影热度",prop:"viewingHot"}},[a("el-input",{attrs:{placeholder:"请输入观影热度"},model:{value:e.form.viewingHot,callback:function(t){e.$set(e.form,"viewingHot",t)},expression:"form.viewingHot"}})],1),a("el-form-item",{attrs:{label:"放映时间",prop:"time"}},[a("el-date-picker",{attrs:{clearable:"",type:"date","value-format":"yyyy-MM-dd",placeholder:"请选择放映时间"},model:{value:e.form.time,callback:function(t){e.$set(e.form,"time",t)},expression:"form.time"}})],1),a("el-form-item",{attrs:{label:"放映地点",prop:"site"}},[a("el-input",{attrs:{placeholder:"请输入放映地点"},model:{value:e.form.site,callback:function(t){e.$set(e.form,"site",t)},expression:"form.site"}})],1),a("el-form-item",{attrs:{label:"电影片段"}},[a("file-upload",{model:{value:e.form.moviePianduan,callback:function(t){e.$set(e.form,"moviePianduan",t)},expression:"form.moviePianduan"}})],1),a("el-form-item",{attrs:{label:"温馨提示",prop:"tishi"}},[a("el-input",{attrs:{placeholder:"请输入温馨提示"},model:{value:e.form.tishi,callback:function(t){e.$set(e.form,"tishi",t)},expression:"form.tishi"}})],1),a("el-form-item",{attrs:{label:"最大观影人数",prop:"maxPeople"}},[a("el-input",{attrs:{placeholder:"请输入最大观影人数"},model:{value:e.form.maxPeople,callback:function(t){e.$set(e.form,"maxPeople",t)},expression:"form.maxPeople"}})],1),a("el-form-item",{attrs:{label:"电影归属场馆",prop:"guishuAddr"}},[a("el-input",{attrs:{placeholder:"请输入电影归属场馆"},model:{value:e.form.guishuAddr,callback:function(t){e.$set(e.form,"guishuAddr",t)},expression:"form.guishuAddr"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.submitForm}},[e._v("确 定")]),a("el-button",{on:{click:e.cancel}},[e._v("取 消")])],1)],1),a("el-dialog",{attrs:{title:"电影片段",visible:e.openVideo,"append-to-body":""},on:{"update:visible":function(t){e.openVideo=t}}},[e.openVideo?a("video",{attrs:{width:"100%",height:"30%",src:e.httpSrc+e.openVideoSrc,controls:""}}):e._e()])],1)},l=[],n=i("5530"),o=(i("d81d"),i("b775"));function r(e){return Object(o["a"])({url:"/business/viewing/list",method:"get",params:e})}function s(e){return Object(o["a"])({url:"/business/viewing/"+e,method:"get"})}function m(e){return Object(o["a"])({url:"/business/viewing",method:"post",data:e})}function u(e){return Object(o["a"])({url:"/business/viewing",method:"put",data:e})}function c(e){return Object(o["a"])({url:"/business/viewing/"+e,method:"delete"})}var d={name:"Viewing",dicts:["movie_type"],data:function(){return{loading:!0,ids:[],single:!0,multiple:!0,showSearch:!0,total:0,viewingList:[],title:"",open:!1,daterangeTime:[],daterangeCreateTime:[],openVideo:!1,openVideoSrc:"",queryParams:{pageNum:1,pageSize:10,movieName:null,movieJieshao:null,movieMsg:null,viewingNo:null,viewingHot:null,time:null,site:null,delStatus:null,moviePianduan:null,tishi:null,maxPeople:null,guishuAddr:null,movieType:null},form:{},rules:{}}},created:function(){this.getList()},methods:{voicePlay:function(e){this.openVideo=!0,this.openVideoSrc=e},getList:function(){var e=this;this.loading=!0,this.queryParams.params={},null!=this.daterangeTime&&""!=this.daterangeTime&&(this.queryParams.params["beginTime"]=this.daterangeTime[0],this.queryParams.params["endTime"]=this.daterangeTime[1]),null!=this.daterangeCreateTime&&""!=this.daterangeCreateTime&&(this.queryParams.params["beginCreateTime"]=this.daterangeCreateTime[0],this.queryParams.params["endCreateTime"]=this.daterangeCreateTime[1]),r(this.queryParams).then((function(t){e.viewingList=t.rows,e.total=t.total,e.loading=!1}))},cancel:function(){this.open=!1,this.reset()},reset:function(){this.form={id:null,movieName:null,movieJieshao:null,movieMsg:null,viewingNo:null,viewingHot:null,time:null,site:null,delStatus:"0",moviePianduan:null,tishi:null,maxPeople:null,guishuAddr:null,movieType:null,createTime:null,updateTime:null},this.resetForm("form")},handleQuery:function(){this.queryParams.pageNum=1,this.getList()},resetQuery:function(){this.daterangeTime=[],this.daterangeCreateTime=[],this.resetForm("queryForm"),this.handleQuery()},handleSelectionChange:function(e){this.ids=e.map((function(e){return e.id})),this.single=1!==e.length,this.multiple=!e.length},handleAdd:function(){this.reset(),this.open=!0,this.title="添加电影统计"},handleUpdate:function(e){var t=this;this.reset();var i=e.id||this.ids;s(i).then((function(e){t.form=e.data,t.open=!0,t.title="修改电影统计"}))},submitForm:function(){var e=this;this.$refs["form"].validate((function(t){t&&(null!=e.form.id?u(e.form).then((function(t){e.$modal.msgSuccess("修改成功"),e.open=!1,e.getList()})):m(e.form).then((function(t){e.$modal.msgSuccess("新增成功"),e.open=!1,e.getList()})))}))},handleDelete:function(e){var t=this,i=e.id||this.ids;this.$modal.confirm('是否确认删除电影统计编号为"'+i+'"的数据项？').then((function(){return c(i)})).then((function(){t.getList(),t.$modal.msgSuccess("删除成功")})).catch((function(){}))},handleExport:function(){this.download("business/viewing/export",Object(n["a"])({},this.queryParams),"viewing_".concat((new Date).getTime(),".xlsx"))}}},p=d,h=i("2877"),f=Object(h["a"])(p,a,l,!1,null,null,null);t["default"]=f.exports}}]);