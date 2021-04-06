package com.cyg.study.dao;

import com.cyg.study.Query.UserQuery;
import com.cyg.study.bean.StaticValue;
import com.cyg.study.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StaticValueDao {

    StaticValue selectOne(String key);

    List<UserQuery> findUser();
}
