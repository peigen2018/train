package com.dbapp.analyse.stream.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class AdultLogBody {

    /**
     * 日志类型（审计日志中一定是 audit
     * "logType":"${logType}",
     */
    private String logType;
    /**
     * 记录发生时间（Unix 时间戳微秒）
     * "startTime":"${dateTimeFmt}",
     */
    private String startTime;
    /**
     * 原始 SQL 长度
     * "sqlLen":"${sqlLen}"
     */
    private String sqlLen;
    /**
     * 操作系统用户名
     * "clientUserName":"${clientUser}"
     */
    private String clientUserName;

    /**
     * 主机名
     * "srcHostName":"${hostName}",
     */
    private String srcHostName;
    /**
     * "dvcAction":"${dvcAction}"
     */
    private String dvcAction;

    /**
     * ${dmac} 目的物理地址
     * "destMacAddress":"${dmacFmt}",
     */
    private String destMacAddress;

    /**
     * ${opType} 操作类型 id(枚举见后文表格《数据库操作类型》)
     */
    private String opType;

    /**
     * ${dbName}	数据库名/实例名
     * "databaseName":"${dbName}",
     */
    private String databaseName;
    /**
     * "srcMacAddress":"${smacFmt}",
     * ${smacFmt}	来源物理地址（格式化成aa: 11: aa: 11: aa: 11格式）
     */
    private String srcMacAddress;
    /**
     * //    ${dip}	目的IP
     * "destAddress":"${dip}",
     */
    private String destAddress;
    /**
     * "logSessionId":"${sessionid}"
     * ${sessionid}	会话ID
     */
    private String logSessionId;
    /**
     * "alarmFlag":"${alarmFlag}",
     * ${alarmFlag}	是否告警
     */
    private String alarmFlag;

    /**
     * "responseCode":"${result}",
     * ${result}	语句执行结果标识-1: 空值,0: 执行失败,1: 执行成功,2: 未执行,3: 返回中
     */
    private String responseCode;

    /**
     * ${dport}	目的端口
     * "destPort":"${dport}",
     */
    private String destPort;
    /**
     * "srcUserName":"${loginUser}",
     * ${loginUser}	数据库用户名
     */
    private String srcUserName;
    /**
     * ${relateIp}	关联IP
     * "relateIp":"${relateIp}",
     */
    private String relateIp;
    /**
     * ${payload}	SQL语句或参数
     * "payload":"${payload}",
     */
    private String payload;
    /**
     * ${severity}	威胁等级
     * "severity":"${severity}",
     */
    private String severity;
    /**
     * "srcAddress":"${sip}",
     * ${sip}	源IP
     */
    private String srcAddress;
    /**
     * "clientPrg":"${clientPrg}"
     * ${clientPrg}	客户端工具名
     */
    private String clientPrg;
    //
    /**
     * "dataSet":"${dataSet}",
     * ${dataSet}	返回结果集
     */
    private String dataSet;
    /**
     * "relateUser":"${relateUser}"
     * ${relateUser}	关联账号
     */
    private String relateUser;
    /**
     * "tenant":"${tenant}",
     * ${tenant}	租户
     */
    private String tenant;
    /**
     * "sqlId":"${sqlid}",
     * ${sqlid}	SQL模板ID
     */
    private String sqlId;
    /**
     * "costTime":"${cost}",
     * ${cost}	执行时长(μs)
     */
    private String costTime;
    /**
     * "databaseType":"${dbType}",
     * ${dbType}	数据库类型
     */
    private String databaseType;
    /**
     * "ruleName":"${alarmName}",
     * ${alarmName}	规则名称
     */
    private String ruleName;
    /**
     * "errorMessage":"${resultDesc}",
     * ${resultDesc}	执行错误信息
     */
    private String errorMessage;
    /**
     * "accessId":"${accessid}"
     * ${accessid}	审计ID号
     */
    private String accessId;
    /**
     * "relateUserInfo":"${relateInfo}",
     * ${relateInfo}	关联人具体信息
     */
    private String relateUserInfo;
    /**
     * "effectRow":"${effectRow}"
     * ${effectRow}	影响行数
     */
    private String effectRow;
    /**
     * "srcPort":"${sport}"
     * ${sport}	源端口
     */
    private String srcPort;
    /**
     * "dataSetSize":"${dataSetSize}"
     * ${dataSetSize}	返回结果集长度
     */
    private String dataSetSize;
    /**
     * "relateUrl":"${relateUrl}"
     * ${relateUrl}	关联URL
     */
    private String relateUrl;

    /**
     * "deviceAddress":"${deviceAddress}"
     * ${deviceAddress}	设备管理口地址
     */
    private String deviceAddress;
    //            "deviceSendProductName":"DBAudit",
    private String deviceSendProductName;
    //            "deviceSendProductVersion":"v4.0.61",
    private String deviceSendProductVersion;
    //            "collectorReceiptTime":"${dateTimeFmt}",
    private String collectorReceiptTime;
    //            "deviceReceiptTime":"${dateTimeFmt}",
    private String deviceReceiptTime;
    //            "endTime":"${dateTimeFmt}",
    private String endTime;
    //            "catTechnique":"/UNKNOW",
    private String catTechnique;
    /**
     * "catBehavior":"${catBehavior}",
     * ${catBehavior}	事件行为分类
     */
    private String catBehavior;
    /**
     * "catOutcome":"${catOutcome}"
     * ${catOutcome}	事件结果分类
     */
    private String catOutcome;

    /**
     *  "direction":"${direction}"
     * ${direction}	数据流方向
     */
    private String direction;
    /**
     *  "eventId":"${eventId}"
     *  ${eventId}	事件ID（全系统唯一ID）
     */
    private String eventId;
}


