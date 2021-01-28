package com.cyg.study.service;

import com.cyg.study.bean.StaticValue;
import com.cyg.study.dao.StaticValueDao;
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
    private StaticValueDao staticValueDao;

    /**
     * @param key key
     **/
    public StaticValue getByKey(String key) {
        return staticValueDao.selectOne(key);
    }
}
