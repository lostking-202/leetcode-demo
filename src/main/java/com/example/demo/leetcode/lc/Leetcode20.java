package com.example.demo.leetcode.lc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 3.每个右括号都有一个对应的相同类型的左括号。
 */
public class Leetcode20 {


    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack=new Stack<>();
        for (Character c:s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(map.get(c));
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(!c.equals(stack.pop())){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
