package com.cyg.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyg
 * @date 2020/9/1 10:08
 **/
@RestController
public class PluginController {

    @RequestMapping("/plugin")
    public String pluginTest(String param) {
        System.out.println("param:" + param);
        return "返回值：" + param;
    }
}
