package com.cyg.study.query;

import com.cyg.study.bean.StaticValue;
import lombok.Getter;
import lombok.Setter;

/**
 * @author cyg
 * @date 2021/3/24 11:57
 **/
@Setter
@Getter
public class UserQuery {

    private String id;
    private String staticId;
    StaticValue staticValue;
}
