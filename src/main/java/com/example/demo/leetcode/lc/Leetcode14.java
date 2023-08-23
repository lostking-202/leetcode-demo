package com.example.demo.leetcode.lc;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/longest-common-prefix/
 *
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 */
public class Leetcode14 {
    @Test
    public void test(){
       String[] strs= {"cir","car"};
       System.out.println(longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return null;
        }
        String a=strs[0];
        for(int i=1;i<strs.length;i++){
            a=getCommonPrefix(a,strs[i]);
        }
        return a;
    }

    private String getCommonPrefix(String a, String str) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<a.length()&&i<str.length();i++){
            if(a.charAt(i)!=str.charAt(i)){
                break;
            }else{
                sb.append(a.charAt(i));
            }
        }
        return sb.toString();
    }
}
