package com.cyg.study.service;

import com.cyg.study.bean.AimAlarmRule;
import com.cyg.study.bean.AimMonitorResourceAttribute;
import com.cyg.study.dao.AimMonitorResourceAttributeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cyg
 * @date 2020/9/3 15:20
 **/
@Service
public class TestService {


    @Autowired
    private AimMonitorResourceAttributeDao aimMonitorResourceAttributeDao;

    /**
     * 匹配通配规则（resourceCode查询集群，匹配告警规则的集群和resourceCode所在集群）
     *
     * @param rules        告警规则
     * @param resourceCode 资源编码  基础
     **/
    public List<AimAlarmRule> getRuleByClusterName(List<AimAlarmRule> rules, String resourceCode) {
        if (rules != null && !rules.isEmpty() && !org.springframework.util.StringUtils.isEmpty(resourceCode)) {
            //通过resourceCode获取集群
            AimMonitorResourceAttribute attribute = new AimMonitorResourceAttribute();
            attribute.setKey("clusterName");
            attribute.setResourceId(resourceCode);
            attribute = aimMonitorResourceAttributeDao.selectOneAttrByResourceIdAndKey(attribute);
            String clusterName = attribute.getValue();
            if (StringUtils.isEmpty(clusterName)) {
                return rules;
            }
            return rules.stream().filter(rule -> Arrays.asList(rule.getClusterConfig().split(",")).contains(clusterName))
                    .collect(Collectors.toList());
        }
        return rules;
    }
}
