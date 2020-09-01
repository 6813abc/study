package com.cyg.study.becn;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author cyg
 * @date 2020/9/1 16:12
 **/
@Data
@AllArgsConstructor
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
