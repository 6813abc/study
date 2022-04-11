package com.cyg.study.controller;

import com.cyg.study.service.DynamicLoadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyg
 * @date 2021/12/30 11:11
 **/
@Slf4j
@RestController
public class DynamicLoadController {

    @Autowired
    DynamicLoadService dynamicLoadService;

    @GetMapping("/exec")
    public String execute(String scriptSource) throws Exception {
        return dynamicLoadService.execute(scriptSource);
    }
}
