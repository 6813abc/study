package com.cyg.study.dao;

import com.cyg.study.bean.AimMonitorResourceAttribute;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AimMonitorResourceAttributeDao {

    AimMonitorResourceAttribute selectOneAttrByResourceIdAndKey(AimMonitorResourceAttribute attribute);
}
