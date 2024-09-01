package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 3.每个右括号都有一个对应的相同类型的左括号。
 */
public class Day12Leet20 {
    public boolean isValid(String s) {
        LinkedList<Character> temp=new LinkedList<>();
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                temp.push(map.get(s.charAt(i)));
            }else{
                if(!Objects.equals(temp.poll(),(s.charAt(i)))){
                    return false;
                };
            }
        }
        return temp.isEmpty();
    }

    @Test
    public void test1(){
        System.out.println(isValid("{}"));
    }
    @Test
    public void test2(){
        System.out.println(isValid("()[]{}"));
    }
    @Test
    public void test3(){
        System.out.println(isValid("(]"));
    }
    @Test
    public void test4(){
        System.out.println(isValid("([])"));
    }
    @Test
    public void test5(){
        LinkedList<Character> temp=new LinkedList<>();
        temp.push('(');
        temp.push('{');
        System.out.println(temp.poll());
        System.out.println(temp.poll());
    }
}
