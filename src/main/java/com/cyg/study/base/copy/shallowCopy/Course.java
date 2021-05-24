package com.cyg.study.base.copy.shallowCopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author cyg
 * @date 2021/5/24 11:26
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Course{

    private String id;
    private String name;
}
