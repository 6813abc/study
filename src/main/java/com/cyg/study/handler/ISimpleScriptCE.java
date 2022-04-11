package com.cyg.study.handler;

import org.springframework.stereotype.Service;

/**
 * @author cyg
 * @date 2021/12/30 10:53
 **/
@Service
public abstract class ISimpleScriptCE{

    /**
     * 计算接口
     */
    public abstract String doCompute(String s);
}
