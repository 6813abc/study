package com.cyg.study.dao;

import com.cyg.study.bean.StaticValue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StaticValueDao {

    StaticValue selectOne(String key);
}
