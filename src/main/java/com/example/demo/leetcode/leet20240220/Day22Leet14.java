package com.example.demo.leetcode.leet20240220;

/**
 * https://leetcode.cn/problems/longest-common-prefix/
 *
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Day22Leet14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        String longestCommonPrefix=strs[0];
        for(int i=1;i<strs.length;i++){
            longestCommonPrefix=findLongestCommonPrefix(longestCommonPrefix,strs[i]);
            if(longestCommonPrefix==""){
                return longestCommonPrefix;
            }
        }
        return longestCommonPrefix;
    }
    public String findLongestCommonPrefix(String longestCommonPrefix,String ss) {
        int i=0;
        for(;i<longestCommonPrefix.length()&&i<ss.length();i++){
            if (longestCommonPrefix.charAt(i)==ss.charAt(i)){
                continue;
            }else{
                return longestCommonPrefix.substring(0,i);
            }
        }
        return longestCommonPrefix.substring(0,i);
    }
}
