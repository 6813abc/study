package com.cyg.study.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyg
 * @date 2021/5/26 9:55
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tree {
    private Integer value;
    private Tree left;
    private Tree right;
}
