<template>
    <div id="apiDoc">
        <el-container id="callDetail">
            <el-header>
                话单录音推送接口说明
            </el-header>
            <el-main>
                <div style="font-weight:bold;padding:10px;"></div>
                <el-descriptions title="接口概述">
                    <el-descriptions-item label="接口描述">能力开放平台为服务商推送话单录音信息的接口</el-descriptions-item>
                    <el-descriptions-item label="接口协议">HTTPPOST</el-descriptions-item>
                    <el-descriptions-item label="数据格式">JSON</el-descriptions-item>
                    <el-descriptions-item label="接口调用方向">能力开放平台→服务商</el-descriptions-item>
                    <el-descriptions-item label="相应说明">用户成功收到推送后，须返回200成功的状态码报文，否则系统将按推送失败处理。</el-descriptions-item>
                </el-descriptions>
                <div style="font-weight:bold;padding:10px;padding-left:0;">发送数据样例</div>
                <div style="background-color: #eee;">
                <!-- 文本 -->
                    <sapn style="color:#333;">
                        <div data-type="object" style="padding:10px;">
                            {
                            <div style="padding:15px;">
                                <span class="json_key" contenteditable="true">"sessionid"</span>:<span class="json_string" contenteditable="true">"09a0e830-4f45-11e8-ac22-0050568b2cb9-1400345900"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"displayNbr"</span>:<span class="json_string" contenteditable="true">"18011000000"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"callerNbr"</span>:<span class="json_string" contenteditable="true">"18011000000"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"calledNbr"</span>:<span class="json_string" contenteditable="true">"18011000002"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"serviceNbr"</span>:<span class="json_string" contenteditable="true">"18011000000"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"serviceNbrB"</span>:<span class="json_string" contenteditable="true">"18011000001"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"dialTime"</span>:<span class="json_string" contenteditable="true">"20190114020150"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"ringTime"</span>:<span class="json_string" contenteditable="true">"20190114020152"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"startTime"</span>:<span class="json_string" contenteditable="true">"20190114020156"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"endTime"</span>:<span class="json_string" contenteditable="true">"20190114020227"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"duration "</span>:<span class="json_string" contenteditable="true">"31"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"minDuration"</span>:<span class="json_string" contenteditable="true">"1"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"serviceType"</span>:<span class="json_string" contenteditable="true">"yly-caller"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"disposition"</span>:<span class="json_string" contenteditable="true">"FAILED"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"voiceAddress"</span>:<span class="json_string" contenteditable="true">"xx.xx:xxxx/xx/xxxxx/xxxxxxx.wav"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"voiceAddressIn"</span>:<span class="json_string" contenteditable="true">"xx.xx:xxxx/xx/xxxxx/xxxxxxx-in.wav"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"voiceAddressOut"</span>:<span class="json_string" contenteditable="true">"xx.xx:xxxx/xx/xxxxx/xxxxxx-out.wav"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"md5Value"</span>:<span class="json_string" contenteditable="true">"5574e7d87bea11eab1d9fa163e314221"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"md5ValueIn"</span>:<span class="json_string" contenteditable="true">"5574e7d87bea11eab1d9fa163e314222"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"md5ValueOut"</span>:<span class="json_string" contenteditable="true">"5574e7d87bea11eab1d9fa163e314223"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"extensionNum"</span>:<span class="json_string" contenteditable="true">"10"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"userData"</span>:<span class="json_string" contenteditable="true">"abcdefg"</span>
                            </div>
                            }
                        </div>
                    </sapn>
                </div>
                <div style="font-weight:bold;padding:10px;padding-left:0;">发送参数说明</div>
                <div>
                <!-- 列表 -->
                    <el-table :data="callDetailList" >
                    <el-table-column prop="1" label="编号" width="100"></el-table-column>
                    <el-table-column prop="2" label="参数名称" width="150"></el-table-column>
                    <el-table-column prop="3" label="数据类型" width="150"></el-table-column>
                    <el-table-column prop="4" label="是否必填" width="150"></el-table-column>
                    <el-table-column prop="5" label="长度" width="150"></el-table-column>                    
                    <el-table-column prop="6" label="注释"></el-table-column>
                    </el-table>
                </div>
                <div style="font-weight:bold;padding:10px;padding-left:0;">返回说明</div>
                <div style="padding-bottom:10px;">正常情况下，第三方用户会返回下述JSON数据包给本平台：</div>
                <div style="background-color: #eee;padding:10px;">
                <!-- 文本 -->
                    {code: 200, msg: “操作成功”}
                </div>

            </el-main>
        </el-container>
        <el-container id="voiceContent">
            <el-header>
                转录文本推送接口说明
            </el-header>
            <el-main>
                <el-descriptions title="接口概述">
                    <el-descriptions-item label="接口描述">能力开放平台为服务商推送转录文本信息的接口</el-descriptions-item>
                    <el-descriptions-item label="接口协议">HTTPPOST</el-descriptions-item>
                    <el-descriptions-item label="数据格式">JSON</el-descriptions-item>
                    <el-descriptions-item label="接口调用方向">能力开放平台→服务商</el-descriptions-item>
                    <el-descriptions-item label="相应说明">用户成功收到推送后，须返回200成功的状态码报文，否则系统将按推送失败处理。</el-descriptions-item>
                </el-descriptions>
                <div style="font-weight:bold;padding:10px;padding-left:0;">发送数据样例</div>
                <div style="background-color: #eee;">
                <!-- 文本 -->                    
                <sapn style="color:#333;">
                    <div data-type="object" style="padding:10px;">
                        {
                            <br>&nbsp;&nbsp;&nbsp;&nbsp;
                        <div style="padding:10px;">
                            <span class="json_key" contenteditable="true">"sessionId"</span>:<span class="json_string" contenteditable="true">"1790015584715492022022313573502551287874"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;
                            <span class="json_key" contenteditable="true">"data"</span>:
                            <span data-type="array" data-size="5"><i style="cursor:pointer;" class="fa fa-minus-square-o" onclick="hide(this)"></i>[<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <div style="padding-left:30px;padding-right:30px;">
                                <span data-type="object"><i style="cursor:pointer;" class="fa fa-minus-square-o" onclick="hide(this)"></i>{
                                    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"voiceType"</span>:<span class="json_string" contenteditable="true">"1"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"callerNbr"</span>:<span class="json_string" contenteditable="true">"18939958756"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"calledNbr"</span>:<span class="json_string" contenteditable="true">"15258152939"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"finalSentence"</span>:<span class="json_string" contenteditable="true">"办理过喂。"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"startMs"</span>:<span class="json_number" contenteditable="true">350</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"endMs"</span>:<span class="json_number" contenteditable="true">1580</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span data-type="object"><i style="cursor:pointer;" class="fa fa-minus-square-o" onclick="hide(this)"></i>{<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"voiceType"</span>:<span class="json_string" contenteditable="true">"2"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"callerNbr"</span>:<span class="json_string" contenteditable="true">"18939958756"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"calledNbr"</span>:<span class="json_string" contenteditable="true">"15258152939"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"finalSentence"</span>:<span class="json_string" contenteditable="true">"嗯，没事，我做个设限。"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"startMs"</span>:<span class="json_number" contenteditable="true">3240</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"endMs"</span>:<span class="json_number" contenteditable="true">4830</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span data-type="object"><i style="cursor:pointer;" class="fa fa-minus-square-o" onclick="hide(this)"></i>{<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"voiceType"</span>:<span class="json_string" contenteditable="true">"1"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"callerNbr"</span>:<span class="json_string" contenteditable="true">"18939958756"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"calledNbr"</span>:<span class="json_string" contenteditable="true">"15258152939"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"finalSentence"</span>:<span class="json_string" contenteditable="true">"嗯，没事，我做个设限。"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"startMs"</span>:<span class="json_number" contenteditable="true">3400</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"endMs"</span>:<span class="json_number" contenteditable="true">4900</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span data-type="object"><i style="cursor:pointer;" class="fa fa-minus-square-o" onclick="hide(this)"></i>{<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"voiceType"</span>:<span class="json_string" contenteditable="true">"1"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"callerNbr"</span>:<span class="json_string" contenteditable="true">"18939958756"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"calledNbr"</span>:<span class="json_string" contenteditable="true">"15258152939"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"finalSentence"</span>:<span class="json_string" contenteditable="true">"好拜拜，嗯。"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"startMs"</span>:<span class="json_number" contenteditable="true">5300</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"endMs"</span>:<span class="json_number" contenteditable="true">7130</span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span data-type="object"><i style="cursor:pointer;" class="fa fa-minus-square-o" onclick="hide(this)"></i>{<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"voiceType"</span>:<span class="json_string" contenteditable="true">"2"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"callerNbr"</span>:<span class="json_string" contenteditable="true">"18939958756"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"calledNbr"</span>:<span class="json_string" contenteditable="true">"15258152939"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"finalSentence"</span>:<span class="json_string" contenteditable="true">"啊，嗯。"</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"startMs"</span>:<span class="json_number" contenteditable="true">5960</span>,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="json_key" contenteditable="true">"endMs"</span>:
                                    <span class="json_number" contenteditable="true">7010</span>
                                    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    }</span><br>&nbsp;&nbsp;&nbsp;&nbsp;
                            </div>
                            ]</span>
                        </div>
                            <br/>
                        }
                    </div>
                </sapn>
                </div>
                <div style="font-weight:bold;padding:10px;padding-left:0;">发送参数说明</div>
                <div>
                <!-- 列表 -->
                    <el-table :data="voiceContentList" >
                    <el-table-column prop="1" label="编号" width="100"></el-table-column>
                    <el-table-column prop="2" label="参数名称" width="150"></el-table-column>
                    <el-table-column prop="3" label="数据类型" width="150"></el-table-column>
                    <el-table-column prop="4" label="是否必填" width="150"></el-table-column>
                    <el-table-column prop="5" label="长度" width="150"></el-table-column>                    
                    <el-table-column prop="6" label="注释"></el-table-column>
                    </el-table>
                </div>
                <div style="font-weight:bold;padding:10px;padding-left:0;">返回说明</div>
                <div style="padding-bottom:10px;">正常情况下，第三方用户会返回下述JSON数据包给本平台：</div>
                <div style="background-color: #eee;padding:10px;">
                <!-- 文本 -->
                    {code: 200, msg: “操作成功”}
                </div>

            </el-main>
        </el-container>
    </div>
</template>

<script>

export default {
    data(){
        return{
            callDetailList: [
                {
                1: '1',
                2: 'session_id',
                3: 'String',
                4: 'Y',
                5: '50',
                6: '通话唯一标识'
                },
                {
                1: '2',
                2: 'displayNbr',
                3: 'String',
                4: 'N',
                5: '50',
                6: '显示号码'
                },
                {
                1: '3',
                2: 'callerNbr',
                3: 'String',
                4: 'N',
                5: '50',
                6: '主叫号码'
                },
                {
                1: '4',
                2: 'calledNbr',
                3: 'String',
                4: 'N',
                5: '50',
                6: '被叫号码'
                },
                {
                1: '5',
                2: 'serviceNbr',
                3: 'String',
                4: 'Y',
                5: '50',
                6: '业务号码，云中继：云中继为虚中继号码，注：直显实中继为实中继号码。'
                },
                {
                1: '6',
                2: 'serviceNbrB',
                3: 'String',
                4: 'N',
                5: '50',
                6: '业务号码B，云中继:云中继业务为实中继号码，注：其他业务为空'
                },
                {
                1: '7',
                2: 'dialTime',
                3: 'String',
                4: 'N',
                5: '30',
                6: '拨打时间(YYYYMMDDHH24MISS)'
                },
                {
                1: '8',
                2: 'ringTime',
                3: 'String',
                4: 'N',
                5: '30',
                6: '振铃时间(YYYYMMDDHH24MISS)呼叫没有振铃传空串'
                },
                {
                1: '9',
                2: 'startTime',
                3: 'String',
                4: 'N',
                5: '30',
                6: '开始时间(YYYYMMDDHH24MISS)'
                },
                {
                1: '10',
                2: 'endTime',
                3: 'String',
                4: 'N',
                5: '30',
                6: '结束时间(YYYYMMDDHH24MISS)'
                },
                {
                1: '11',
                2: 'duration',
                3: 'String',
                4: 'N',
                5: '10',
                6: '通话时长(单位:秒)'
                },
                {
                1: '12',
                2: 'minDuration',
                3: 'String',
                4: 'N',
                5: '10',
                6: '通话时长(单位:分钟)'
                },
                {
                1: '13',
                2: 'serviceType',
                3: 'String',
                4: 'N',
                5: '50',
                6: '话单类型,yly-caller云录音主叫,yly-callee云录音被叫,yzj-caller云中继主叫,yzj-callee云中继被叫,recyzj-caller云中继录音主叫,recyzj-callee云中继录音被叫,gzh-callee工作号被叫 gzh-caller工作号主叫'
                },
                {
                1: '14',
                2: 'disposition',
                3: 'String',
                4: 'N',
                5: '45',
                6: '通话响应状态,NO ANSWER(	无应答),NO ANSWER (NULL record)	(无应答),FAILED (失败),BUSY (忙),ANSWERED (	应答),CONGESTION(拥挤)'
                },
                {
                1: '15',
                2: 'voiceAddress',
                3: 'String',
                4: 'N',
                5: '500',
                6: '混合语音文件地址,根据地址可以下载,没有录音文件时传空字符串'
                },
                {
                1: '16',
                2: 'voiceAddressIn',
                3: 'String',
                4: 'N',
                5: '500',
                6: '主叫一方语音文件地址,根据地址可以下载,没有录音文件时传空字符串'
                },
                {
                1: '17',
                2: 'voiceAddressOut',
                3: 'String',
                4: 'N',
                5: '500',
                6: '被叫一方语音文件地址,根据地址可以下载,没有录音文件时传空字符串'
                },
                {
                1: '18',
                2: 'md5Value',
                3: 'String',
                4: 'N',
                5: '32',
                6: '混合录音文件md5值'
                },
                {
                1: '19',
                2: 'md5ValueIn',
                3: 'String',
                4: 'N',
                5: '32',
                6: '主叫一方录音文件md5值'
                },
                {
                1: '20',
                2: 'md5ValueOut',
                3: 'String',
                4: 'N',
                5: '32',
                6: '被叫一方录音文件md5值'
                },
                {
                1: '21',
                2: 'extensionNum',
                3: 'String',
                4: 'N',
                5: '50',
                6: '分机号'
                },
                {
                1: '22',
                2: 'userData',
                3: 'String',
                4: 'N',
                5: '32',
                6: '用户自定义数据'
                }

            ],
            voiceContentList: [
                {
                1: '1',
                2: 'session_id',
                3: 'String',
                4: 'Y',
                5: '50',
                6: '通话唯一标识'
                },
                {
                1: '2',
                2: 'voiceType',
                3: 'String',
                4: 'Y',
                5: '50',
                6: '语音类型:1：主叫,2：被叫'
                },
                {
                1: '3',
                2: 'callerNbr',
                3: 'String',
                4: 'Y',
                5: '50',
                6: '语主叫号码'
                },
                {
                1: '4',
                2: 'calledNbr',
                3: 'String',
                4: 'Y',
                5: '50',
                6: '被叫号码'
                },
                {
                1: '5',
                2: 'finalSentence',
                3: 'String',
                4: 'Y',
                5: '5000',
                6: '单句最终识别结果'
                },
                {
                1: '6',
                2: 'startMs',
                3: 'String',
                4: 'N',
                5: '50',
                6: '单句结束时间'
                },
                {
                1: '7',
                2: 'endMs',
                3: 'String',
                4: 'N',
                5: '50',
                6: '单句开始时间'
                }
            ]
        }
    }

}
</script>

<style>
.el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
}
.json_key {
    color: #92278f;
    font-weight: bold;
}
.json_string {
    color: #3ab54a;
    font-weight: bold;
    margin-left: 10px;
}
</style>