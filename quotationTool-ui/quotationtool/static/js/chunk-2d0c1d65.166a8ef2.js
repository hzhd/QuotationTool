(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0c1d65"],{"486a":function(e,t,l){"use strict";l.r(t);var o=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("div",{staticClass:"app-container"},[l("el-form",{directives:[{name:"show",rawName:"v-show",value:e.showSearch,expression:"showSearch"}],ref:"queryForm",attrs:{model:e.queryParams,size:"small",inline:!0,"label-width":"68px"}},[l("el-form-item",{attrs:{label:"场地名称",prop:"siteName"}},[l("el-input",{attrs:{placeholder:"请输入场地名称",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleQuery(t)}},model:{value:e.queryParams.siteName,callback:function(t){e.$set(e.queryParams,"siteName",t)},expression:"queryParams.siteName"}})],1),l("el-form-item",[l("el-button",{attrs:{type:"primary",icon:"el-icon-search",size:"mini"},on:{click:e.handleQuery}},[e._v("搜索")]),l("el-button",{attrs:{icon:"el-icon-refresh",size:"mini"},on:{click:e.resetQuery}},[e._v("重置")])],1)],1),l("el-row",{staticClass:"mb8",attrs:{gutter:10}},[l("right-toolbar",{attrs:{showSearch:e.showSearch},on:{"update:showSearch":function(t){e.showSearch=t},"update:show-search":function(t){e.showSearch=t},queryTable:e.getList}})],1),l("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],attrs:{data:e.peopleList},on:{"selection-change":e.handleSelectionChange}},[l("el-table-column",{attrs:{type:"index",width:"55",label:"序号",align:"center"}}),l("el-table-column",{attrs:{label:"场地名称",align:"center",prop:"siteName"}}),l("el-table-column",{attrs:{label:"进入人数(日)",align:"center",prop:"inPeopleDay"}}),l("el-table-column",{attrs:{label:"出入人数(日)",align:"center",prop:"outPeopleDay"}}),l("el-table-column",{attrs:{label:"进入人数(周)",align:"center",prop:"inPeopleWeek"}}),l("el-table-column",{attrs:{label:"出入人数(周)",align:"center",prop:"outPeopleWeek"}}),l("el-table-column",{attrs:{label:"进入人数(月)",align:"center",prop:"inPeopleMonth"}}),l("el-table-column",{attrs:{label:"出入人数(月)",align:"center",prop:"outPeopleMonth"}}),l("el-table-column",{attrs:{label:"进入人数(年)",align:"center",prop:"inPeopleYear"}}),l("el-table-column",{attrs:{label:"出入人数(年)",align:"center",prop:"outPeopleYear"}}),l("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[l("el-button",{directives:[{name:"hasPermi",rawName:"v-hasPermi",value:["business:people:edit"],expression:"['business:people:edit']"}],attrs:{size:"mini",type:"text",icon:"el-icon-edit"},on:{click:function(l){return e.handleUpdate(t.row)}}},[e._v("修改")])]}}])})],1),l("pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total > 0"}],attrs:{total:e.total,page:e.queryParams.pageNum,limit:e.queryParams.pageSize},on:{"update:page":function(t){return e.$set(e.queryParams,"pageNum",t)},"update:limit":function(t){return e.$set(e.queryParams,"pageSize",t)},pagination:e.getList}}),l("el-dialog",{attrs:{title:e.title,visible:e.open,width:"1000px","append-to-body":""},on:{"update:visible":function(t){e.open=t}}},[l("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[l("el-form-item",{attrs:{label:"场地名称",prop:"siteName"}},[l("el-input",{attrs:{placeholder:"请输入场地名称"},model:{value:e.form.siteName,callback:function(t){e.$set(e.form,"siteName",t)},expression:"form.siteName"}})],1),l("el-form-item",{attrs:{label:"日进入人数",prop:"inPeopleDay"}},[l("el-input",{attrs:{placeholder:"请输入日进入人数"},model:{value:e.form.inPeopleDay,callback:function(t){e.$set(e.form,"inPeopleDay",t)},expression:"form.inPeopleDay"}})],1),l("el-form-item",{attrs:{label:"日出入人数",prop:"outPeopleDay"}},[l("el-input",{attrs:{placeholder:"请输入日出入人数"},model:{value:e.form.outPeopleDay,callback:function(t){e.$set(e.form,"outPeopleDay",t)},expression:"form.outPeopleDay"}})],1),l("el-form-item",{attrs:{label:"周进入人数",prop:"inPeopleWeek"}},[l("el-input",{attrs:{placeholder:"请输入周进入人数"},model:{value:e.form.inPeopleWeek,callback:function(t){e.$set(e.form,"inPeopleWeek",t)},expression:"form.inPeopleWeek"}})],1),l("el-form-item",{attrs:{label:"周出入人数",prop:"outPeopleWeek"}},[l("el-input",{attrs:{placeholder:"请输入周出入人数"},model:{value:e.form.outPeopleWeek,callback:function(t){e.$set(e.form,"outPeopleWeek",t)},expression:"form.outPeopleWeek"}})],1),l("el-form-item",{attrs:{label:"月进入人数",prop:"inPeopleMonth"}},[l("el-input",{attrs:{placeholder:"请输入月进入人数"},model:{value:e.form.inPeopleMonth,callback:function(t){e.$set(e.form,"inPeopleMonth",t)},expression:"form.inPeopleMonth"}})],1),l("el-form-item",{attrs:{label:"月出入人数",prop:"outPeopleMonth"}},[l("el-input",{attrs:{placeholder:"请输入月出入人数"},model:{value:e.form.outPeopleMonth,callback:function(t){e.$set(e.form,"outPeopleMonth",t)},expression:"form.outPeopleMonth"}})],1),l("el-form-item",{attrs:{label:"年进入人数",prop:"inPeopleYear"}},[l("el-input",{attrs:{placeholder:"请输入年进入人数"},model:{value:e.form.inPeopleYear,callback:function(t){e.$set(e.form,"inPeopleYear",t)},expression:"form.inPeopleYear"}})],1),l("el-form-item",{attrs:{label:"年出入人数",prop:"outPeopleYear"}},[l("el-input",{attrs:{placeholder:"请输入年出入人数"},model:{value:e.form.outPeopleYear,callback:function(t){e.$set(e.form,"outPeopleYear",t)},expression:"form.outPeopleYear"}})],1)],1),l("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[l("el-button",{attrs:{type:"primary"},on:{click:e.submitForm}},[e._v("确 定")]),l("el-button",{on:{click:e.cancel}},[e._v("取 消")])],1)],1)],1)},a=[],n=l("5530"),r=(l("d81d"),l("b775"));function i(e){return Object(r["a"])({url:"/business/people/list",method:"get",params:e})}function s(e){return Object(r["a"])({url:"/business/people/"+e,method:"get"})}function u(e){return Object(r["a"])({url:"/business/people",method:"post",data:e})}function p(e){return Object(r["a"])({url:"/business/people",method:"put",data:e})}function c(e){return Object(r["a"])({url:"/business/people/"+e,method:"delete"})}var m={name:"People",data:function(){return{loading:!0,ids:[],single:!0,multiple:!0,showSearch:!0,total:0,peopleList:[],title:"",open:!1,queryParams:{pageNum:1,pageSize:10,siteName:null,inPeopleDay:null,outPeopleDay:null,inPeopleWeek:null,outPeopleWeek:null,inPeopleMonth:null,outPeopleMonth:null,inPeopleYear:null,outPeopleYear:null,delStatus:null},form:{},rules:{}}},created:function(){this.getList()},methods:{getList:function(){var e=this;this.loading=!0,i(this.queryParams).then((function(t){e.peopleList=t.rows,e.total=t.total,e.loading=!1}))},cancel:function(){this.open=!1,this.reset()},reset:function(){this.form={id:null,siteName:null,inPeopleDay:null,outPeopleDay:null,inPeopleWeek:null,outPeopleWeek:null,inPeopleMonth:null,outPeopleMonth:null,inPeopleYear:null,outPeopleYear:null,delStatus:"0"},this.resetForm("form")},handleQuery:function(){this.queryParams.pageNum=1,this.getList()},resetQuery:function(){this.resetForm("queryForm"),this.handleQuery()},handleSelectionChange:function(e){this.ids=e.map((function(e){return e.id})),this.single=1!==e.length,this.multiple=!e.length},handleAdd:function(){this.reset(),this.open=!0,this.title="添加进出人数统计"},handleUpdate:function(e){var t=this;this.reset();var l=e.id||this.ids;s(l).then((function(e){t.form=e.data,t.open=!0,t.title="修改进出人数统计"}))},submitForm:function(){var e=this;this.$refs["form"].validate((function(t){t&&(null!=e.form.id?p(e.form).then((function(t){e.$modal.msgSuccess("修改成功"),e.open=!1,e.getList()})):u(e.form).then((function(t){e.$modal.msgSuccess("新增成功"),e.open=!1,e.getList()})))}))},handleDelete:function(e){var t=this,l=e.id||this.ids;this.$modal.confirm('是否确认删除进出人数统计编号为"'+l+'"的数据项？').then((function(){return c(l)})).then((function(){t.getList(),t.$modal.msgSuccess("删除成功")})).catch((function(){}))},handleExport:function(){this.download("business/people/export",Object(n["a"])({},this.queryParams),"people_".concat((new Date).getTime(),".xlsx"))}}},h=m,d=l("2877"),f=Object(d["a"])(h,o,a,!1,null,null,null);t["default"]=f.exports}}]);