package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/first-unique-character-in-a-string/
 *
 *字符串中的第一个唯一字符
 *
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *提示：
 * 1 <= s.length <= 105
 * s 只包含小写字母
 */
public class Leetcode387 {
    @Test
    public void test(){
        System.out.println(firstUniqChar("aabb"));
    }
    public int firstUniqChar(String s) {
        List<Character> cs=new ArrayList<>();
        List<Character> css=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(cs.contains(c)){
                cs.remove(Character.valueOf(c));
                css.add(c);
            }else{
                if(!css.contains(c)){
                    cs.add(c);
                }
            }

        }
        return cs.isEmpty()?-1:s.indexOf(cs.get(0));
    }
}
