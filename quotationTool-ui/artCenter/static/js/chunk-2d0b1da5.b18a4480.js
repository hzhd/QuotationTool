(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0b1da5"],{"222a":function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container"},[a("el-form",{directives:[{name:"show",rawName:"v-show",value:e.showSearch,expression:"showSearch"}],ref:"queryForm",attrs:{model:e.queryParams,size:"small",inline:!0,"label-width":"68px"}},[a("el-form-item",{attrs:{label:"图片名称",prop:"picName"}},[a("el-input",{attrs:{placeholder:"请输入图片名称",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.picName,callback:function(t){e.$set(e.queryParams,"picName",t)},expression:"queryParams.picName"}})],1),a("el-form-item",{attrs:{label:"归属场馆",prop:"stadiumId"}},[a("el-select",{attrs:{placeholder:"请选择活动区域"},model:{value:e.queryParams.stadiumId,callback:function(t){e.$set(e.queryParams,"stadiumId",t)},expression:"queryParams.stadiumId"}},e._l(e.stadiumList,(function(e,t){return a("el-option",{key:t,attrs:{label:e.stadium_name,value:e.id}})})),1)],1),a("el-form-item",{attrs:{label:"图片标签",prop:"picTag"}},[a("el-input",{attrs:{placeholder:"请输入图片标签",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.picTag,callback:function(t){e.$set(e.queryParams,"picTag",t)},expression:"queryParams.picTag"}})],1),a("el-form-item",{attrs:{label:"创建时间"}},[a("el-date-picker",{staticStyle:{width:"240px"},attrs:{"value-format":"yyyy-MM-dd",type:"daterange","range-separator":"-","start-placeholder":"开始日期","end-placeholder":"结束日期"},model:{value:e.daterangeCreateTime,callback:function(t){e.daterangeCreateTime=t},expression:"daterangeCreateTime"}})],1),a("el-form-item",[a("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:e.handleQuery}},[e._v("搜索")]),a("el-button",{attrs:{icon:"el-icon-refresh",size:"mini"},on:{click:e.resetQuery}},[e._v("重置")])],1)],1),a("el-row",{staticClass:"mb8",attrs:{gutter:10}},[a("el-col",{attrs:{span:1.5}},[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["media:picture:add"],expression:"['media:picture:add']"}],attrs:{type:"primary",plain:"",icon:"el-icon-plus",size:"mini"},on:{click:e.handleAdd}},[e._v("新增")])],1),a("el-col",{attrs:{span:1.5}},[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["media:picture:export"],expression:"['media:picture:export']"}],attrs:{type:"warning",plain:"",icon:"el-icon-download",size:"mini"},on:{click:e.handleExport}},[e._v("导出")])],1),a("right-toolbar",{attrs:{showSearch:e.showSearch},on:{"update:showSearch":function(t){e.showSearch=t},"update:show-search":function(t){e.showSearch=t},queryTable:e.getList}})],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{data:e.pictureList},on:{"selection-change":e.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),a("el-table-column",{attrs:{label:"序号",align:"center",prop:"id"}}),a("el-table-column",{attrs:{label:"图片名称",align:"center",prop:"picName"}}),a("el-table-column",{attrs:{label:"图片类型",align:"center",prop:"picTypeLabel"}}),a("el-table-column",{attrs:{label:"图片标签",align:"center",prop:"picTag"}}),a("el-table-column",{attrs:{label:"归属场馆",align:"center",prop:"stadiumLabel"}}),a("el-table-column",{attrs:{label:"图片介绍",align:"center",prop:"picIntro"}}),a("el-table-column",{attrs:{label:"图片路径",align:"center",prop:"picPath",width:"100"},scopedSlots:e._u([{key:"default",fn:function(e){return[a("image-preview",{attrs:{src:e.row.picPath,width:50,height:50}})]}}])}),a("el-table-column",{attrs:{label:"温馨提示",align:"center",prop:"picTip"}}),a("el-table-column",{attrs:{label:"入库时间",align:"center",prop:"createTime"}}),a("el-table-column",{attrs:{label:"状态",align:"center",prop:"picStatusLabel"}}),a("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["media:picture:edit"],expression:"['media:picture:edit']"}],attrs:{size:"mini",type:"text",icon:"el-icon-edit"},on:{click:function(a){return e.handleUpdate(t.row)}}},[e._v("修改")]),a("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["media:picture:remove"],expression:"['media:picture:remove']"}],attrs:{size:"mini",type:"text",icon:"el-icon-delete"},on:{click:function(a){return e.handleDelete(t.row)}}},[e._v("删除")])]}}])})],1),a("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total > 0"}],attrs:{total:e.total,page:e.queryParams.pageNum,limit:e.queryParams.pageSize},on:{"update:page":function(t){return e.$set(e.queryParams,"pageNum",t)},"update:limit":function(t){return e.$set(e.queryParams,"pageSize",t)},pagination:e.getList}}),a("el-dialog",{attrs:{title:e.title,visible:e.open,width:"50%","append-to-body":""},on:{"update:visible":function(t){e.open=t}}},[a("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"图片名称",prop:"picName"}},[a("el-input",{attrs:{placeholder:"请输入图片名称"},model:{value:e.form.picName,callback:function(t){e.$set(e.form,"picName",t)},expression:"form.picName"}})],1),a("el-form-item",{attrs:{label:"归属场馆",prop:"stadiumId"}},[a("el-select",{attrs:{placeholder:"请选择归属场馆"},model:{value:e.form.stadiumId,callback:function(t){e.$set(e.form,"stadiumId",t)},expression:"form.stadiumId"}},e._l(e.stadiumList,(function(e,t){return a("el-option",{key:t,attrs:{label:e.stadium_name,value:e.id}})})),1)],1),a("el-form-item",{attrs:{label:"图片类型",prop:"picType"}},[a("el-select",{attrs:{placeholder:"请选择图片类型"},model:{value:e.form.picType,callback:function(t){e.$set(e.form,"picType",t)},expression:"form.picType"}},e._l(e.picTypeList,(function(e,t){return a("el-option",{key:t,attrs:{label:e.dictLabel,value:e.dictValue}})})),1)],1),a("el-form-item",{attrs:{label:"图片标签",prop:"picTag"}},[a("el-input",{attrs:{placeholder:"请输入图片标签"},model:{value:e.form.picTag,callback:function(t){e.$set(e.form,"picTag",t)},expression:"form.picTag"}})],1),a("el-form-item",{attrs:{label:"图片介绍",prop:"picIntro"}},[a("el-input",{attrs:{type:"textarea",placeholder:"请输入内容"},model:{value:e.form.picIntro,callback:function(t){e.$set(e.form,"picIntro",t)},expression:"form.picIntro"}})],1),a("el-form-item",{attrs:{label:"图片路径"}},[a("image-upload",{model:{value:e.form.picPath,callback:function(t){e.$set(e.form,"picPath",t)},expression:"form.picPath"}})],1),a("el-form-item",{attrs:{label:"温馨提示",prop:"picTip"}},[a("el-input",{attrs:{type:"textarea",placeholder:"请输入内容"},model:{value:e.form.picTip,callback:function(t){e.$set(e.form,"picTip",t)},expression:"form.picTip"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:e.submitForm}},[e._v("确 定")]),a("el-button",{on:{click:e.cancel}},[e._v("取 消")])],1)],1)],1)},r=[],l=a("5530"),n=(a("d81d"),a("b775"));function s(e){return Object(n["a"])({url:"/media/picture/list",method:"get",params:e})}function o(e){return Object(n["a"])({url:"/media/picture/"+e,method:"get"})}function c(e){return Object(n["a"])({url:"/media/picture",method:"post",data:e})}function u(e){return Object(n["a"])({url:"/media/picture",method:"put",data:e})}function p(e){return Object(n["a"])({url:"/media/picture/"+e,method:"delete"})}function m(e){return Object(n["a"])({url:"/media/picture/queryStadium",method:"get"})}function d(e){return Object(n["a"])({url:"/system/dict/data/type/pic_type",method:"get"})}var h={name:"Picture",data:function(){return{loading:!0,ids:[],single:!0,multiple:!0,showSearch:!0,total:0,pictureList:[],title:"",open:!1,daterangeCreateTime:[],queryParams:{pageNum:1,pageSize:10,picName:null,picType:null,stadiumId:null,picTag:null,picIntro:null,picPath:null,picTip:null,picStatus:null,creatorId:null,createTime:null,updatorId:null,delTag:null,recVersion:null},stadiumList:[],picTypeList:[],form:{},rules:{picName:[{required:!0,message:"图片名称不能为空",trigger:"blur"}],picType:[{required:!0,message:"图片类型不能为空",trigger:"change"}],stadiumId:[{required:!0,message:"归属场馆，关联场馆记录不能为空",trigger:"blur"}],picPath:[{required:!0,message:"图片路径不能为空",trigger:"blur"}],picStatus:[{required:!0,message:"图片状态，0=待审核、1=审核中、2=审核未通过、3=待发布、4=已发布不能为空",trigger:"blur"}],creatorId:[{required:!0,message:"新增记录的操作员ID不能为空",trigger:"blur"}],createTime:[{required:!0,message:"创建时间不能为空",trigger:"blur"}],updatorId:[{required:!0,message:"修改记录的操作员ID不能为空",trigger:"blur"}],updateTime:[{required:!0,message:"修改时间不能为空",trigger:"blur"}],recVersion:[{required:!0,message:"记录版本号不能为空",trigger:"blur"}]}}},created:function(){this.getStadiumList(),this.getList(),this.getQueryPicType()},methods:{getList:function(){var e=this;this.loading=!0,this.queryParams.params={},null!=this.daterangeCreateTime&&""!=this.daterangeCreateTime&&(this.queryParams.params["beginCreateTime"]=this.daterangeCreateTime[0],this.queryParams.params["endCreateTime"]=this.daterangeCreateTime[1]),s(this.queryParams).then((function(t){e.pictureList=t.rows,e.total=t.total,e.loading=!1}))},getStadiumList:function(){var e=this;m({}).then((function(t){e.stadiumList=t.data}))},getQueryPicType:function(){var e=this;d({}).then((function(t){e.picTypeList=t.data}))},cancel:function(){this.open=!1,this.reset()},reset:function(){this.form={id:null,picName:null,picType:null,stadiumId:null,picTag:null,picIntro:null,picPath:null,picTip:null,picStatus:0,creatorId:null,createBy:null,createTime:null,updatorId:null,updateBy:null,updateTime:null,delTag:null,recVersion:null},this.resetForm("form")},handleQuery:function(){this.queryParams.pageNum=1,this.getList()},resetQuery:function(){this.daterangeCreateTime=[],this.resetForm("queryForm"),this.handleQuery()},handleSelectionChange:function(e){this.ids=e.map((function(e){return e.id})),this.single=1!==e.length,this.multiple=!e.length},handleAdd:function(){this.reset(),this.open=!0,this.title="添加图片基本信息库"},handleUpdate:function(e){var t=this;this.reset();var a=e.id||this.ids;o(a).then((function(e){t.form=e.data,t.open=!0,t.title="修改图片基本信息库"}))},submitForm:function(){var e=this;this.$refs["form"].validate((function(t){t&&(null!=e.form.id?u(e.form).then((function(t){e.$modal.msgSuccess("修改成功"),e.open=!1,e.getList()})):c(e.form).then((function(t){e.$modal.msgSuccess("新增成功"),e.open=!1,e.getList()})))}))},handleDelete:function(e){var t=this,a=e.id||this.ids;this.$modal.confirm('是否确认删除图片基本信息库编号为"'+a+'"的数据项？').then((function(){return p(a)})).then((function(){t.getList(),t.$modal.msgSuccess("删除成功")})).catch((function(){}))},handleExport:function(){this.download("media/picture/export",Object(l["a"])({},this.queryParams),"picture_".concat((new Date).getTime(),".xlsx"))}}},f=h,g=a("2877"),b=Object(g["a"])(f,i,r,!1,null,null,null);t["default"]=b.exports}}]);