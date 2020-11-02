package com.cyg.study.controller;

import com.cyg.study.bean.AimAlarmRule;
import com.cyg.study.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyg
 * @date 2020/9/1 10:08
 **/
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/test")
    public void pluginTest() {
        List<AimAlarmRule> rules = new ArrayList<>();
        AimAlarmRule rule1 = new AimAlarmRule();
        rule1.setClusterConfig("test-web-prod-yyt,test-busi-ocrm-yyt,test-wf-group");
        rules.add(rule1);
        AimAlarmRule rule2 = new AimAlarmRule();
        rule2.setClusterConfig("prenew-web-irsc-yyt");
        rules.add(rule2);
        String resourceCode = "5000000011";
        List<AimAlarmRule> aimAlarmRules = testService.getRuleByClusterName(rules, resourceCode);
        aimAlarmRules.forEach(aimAlarmRule -> System.out.println(aimAlarmRule.getClusterConfig()));
    }
}
