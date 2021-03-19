package com.cyg.study.controller;

import com.cyg.study.bean.StaticValue;
import com.cyg.study.config.VisiableThreadPoolTaskExecutor;
import com.cyg.study.service.TestService;
import com.cyg.study.service.UserThreadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author cyg
 * @date 2020/9/1 10:08
 **/
@Slf4j
@RestController
public class TestController {

    @Autowired
    TestService testService;
    @Autowired
    private UserThreadService userThreadService;
    @Autowired
    private VisiableThreadPoolTaskExecutor visiableThreadPoolTaskExecutor;

    @RequestMapping("/test")
    public StaticValue pluginTest(String key) {
        log.debug("入参：{}", key);
        return testService.getByKey(key);
    }

    @GetMapping("asyncServiceExecutor")
    public Object  serviceTest() throws JSONException {
        userThreadService.serviceTest();
        Map map  = new ConcurrentHashMap();
        ThreadPoolExecutor threadPoolExecutor = visiableThreadPoolTaskExecutor.getThreadPoolExecutor();
        map.put("ThreadNamePrefix", visiableThreadPoolTaskExecutor.getThreadNamePrefix());
        map.put("TaskCount", threadPoolExecutor.getTaskCount());
        map.put("completedTaskCount", threadPoolExecutor.getCompletedTaskCount());
        map.put("activeCount", threadPoolExecutor.getActiveCount());
        map.put("queueSize", threadPoolExecutor.getQueue().size());
        return map;
    }
}
