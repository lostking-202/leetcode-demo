package com.example.demo.leetcode.lc.dp;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/generate-parentheses/
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 提示：
 *  1 <= n <= 8
 */
public class Leetcode22 {

    // 看的答案
    public List<String> generateParenthesis(int n) {
        Set<String> results=new HashSet<>();
        if(n==1)return Arrays.asList("()");
        for(String gen:generateParenthesis(n-1)){
            for(int i=0;i<gen.length();i++){
                results.add(gen.substring(0,i)+"()"+gen.substring(i,gen.length()));
            }
        }
        return results.stream().collect(Collectors.toList());
    }

    @Test
    public void a(){
        System.out.println(generateParenthesis(3));
    }
}
