package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters
 *
 */
public class Day01Leet03 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        String ss="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int index=ss.indexOf(c);
            if(index==-1){
                ss+=c;
            }else{
                ss=ss.substring(index);
            }
            if(maxLen<ss.length()){
                maxLen=ss.length();
            }
        }
        return maxLen;
    }
    @Test
    public void test1(){
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    @Test
    public void test2(){
        String s="bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    @Test
    public void test3(){
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
