package com.cyg.study.controller;

import com.cyg.study.bean.StaticValue;
import com.cyg.study.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyg
 * @date 2020/9/1 10:08
 **/
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/test")
    public StaticValue pluginTest(String key) {
        return testService.getByKey(key);
    }
}
