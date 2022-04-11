package com.cyg.study.service;

import com.cyg.study.handler.ISimpleScriptCE;
import com.cyg.study.util.groovy.GroovyJavaFactory;
import org.springframework.stereotype.Service;

/**
 * @author cyg
 * @date 2021/12/30 11:11
 **/
@Service
public class DynamicLoadService {

    public String execute(String scriptSource) throws Exception {
        final ISimpleScriptCE instance = GroovyJavaFactory.loadInstance("ScriptJava" + 1, scriptSource, ISimpleScriptCE.class);
        return instance.doCompute("aaa");
    }
}
