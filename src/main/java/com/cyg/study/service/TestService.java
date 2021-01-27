package com.cyg.study.service;

import com.cyg.study.bean.StaticValue;
import com.cyg.study.dao.AimMonitorResourceAttributeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyg
 * @date 2020/9/3 15:20
 **/
@Service
@RestController
public class TestService {


    @Autowired
    private AimMonitorResourceAttributeDao aimMonitorResourceAttributeDao;

    /**
     * 匹配通配规则（resourceCode查询集群，匹配告警规则的集群和resourceCode所在集群）
     *
     * @param key key
     **/
    public StaticValue getByKey(String key) {
        return aimMonitorResourceAttributeDao.selectOne(key);
    }
}
