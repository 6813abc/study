package com.cyg.study.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2016 Asiainfo
 *
 * @ClassName: AimAlarmRule
 * @Description: 告警规则
 * @version: v1.0.0
 * @author: longyh
 * @date: 2018/4/13 14:13
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Data
@ToString
public class AimAlarmRule implements Serializable {

    private static final long serialVersionUID = 6949343366306876182L;

    /**
     * 指标体系后告警规则id,会和其他系统对接
     * 告警id(20位，由时间戳和随机数组成)
     */
    private String id;

    /**
     * 规则ID
     */
    private Integer ruleId;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;
    /**
     * 规则类型
     */
    private String type;
    /**
     * 告警级别
     */
    private String alarmLevel;
    /**
     * 规则条件
     */
    private String ruleData;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 状态，U生效，E失效
     */
    private String state;
    /**
     * 创建日期
     */
    private Timestamp createDate;
    /**
     * 通知方式
     */
    private String notification;
    /**
     * 告警用户组
     */
    private String userGroup;
    /**
     * 告警集群配置，多个逗号隔开
     */
    private String clusterConfig;

  /*  *//**
     * 告警条件
     *//*
    private AlarmCondition alarmCondition;

    *//**
     * 告警动作
     *//*
    private List<AimAlarmRuleAction> aimAlarmRuleActions;*/

    /**
     * 扩展数据
     */
    private String extraParams;
    private Map<String, String> extraMap;

    /*** 指标层*/
    private String layer;
    /*** 指标监控对象分类*/
    private String monitorType;
    /*** 指标监控对象*/
    private String monitor;
    /*** 指标监控对象ID*/
    private String monitorCode;
    /*** 指标指标编码*/
    private String indexCode;
    /*** 指标指标名称*/
    private String indexName;
    /*** 指标实例主键集合*/
    private String instanceIds;
    /*** 指标资源名称*/
    private String resourceName;
    /*** 指标资源代码*/
    private String resourceCode;
    /*** 指标资源类型*/
    private String resourceType;
    /*** 指标实例名称*/
    private String instanceName;
    /*** 指标采集周期*/
    private String collectCycle;
    /*** 指标采集类型*/
    private String collectType;
    /*** 指标数据类型*/
    private String dataType;
    /*** 指标单位*/
    private String indexUnit;
    /*** 指标状态*/
    private short indexState;
    /*** 指标集群名称*/
    private String applicationName;
    /*负责人*/
    private String master;
    /*订阅人*/
    private String follower;

  /*  private List<ExternalUser> userList;

    private List<AlarmSubscribeUser> subUserList;*/


}
