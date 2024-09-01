package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串
 *
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class Day10Leet05 {
    public String longestPalindrome(String s) {
        String longest="";
        for(int i=0;i<s.length();i++) {
            String result=getLongestPalindrome(s,i);
            longest=result.length()>longest.length()?result:longest;
        }
        return longest;
    }

    private String getLongestPalindrome(String s, int i) {
        String result1="";
        String result2="";
        int j=0;
        while(i-j>=0&&i+j<s.length()){
            if(s.charAt(i-j)==s.charAt(i+j)){
                result1=s.substring(i-j,i+j+1);
                j++;
            }else{
                break;
            }
        }
        // i=1  1,2 ,0.3
        j=0;
        for(;i-j>=0&&i+j+1<s.length();j++){
            if(s.charAt(i-j)==s.charAt(i+j+1)){
                result2=s.substring(i-j,i+j+2);
            }else{
                break;
            }
        }
        return result1.length()>result2.length()?result1:result2;
    }

    public String longestPalindrome2(String s) {
        int maxLen=1;
        int start=0;
        for(int i=0;i<s.length();i++) {
            int len1=expandAroundCenter(s,i,i);
            int len2=expandAroundCenter(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>maxLen){
                maxLen=len;
                start=i-(maxLen-1)/2;
            }
        }
        return s.substring(start,start+maxLen);
    }

    private int expandAroundCenter(String s,int left,int right){
        while(left<=right&&left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
    @Test
    public void test(){
        String result=longestPalindrome("abba");
        System.out.println(result);
    }
    @Test
    public void test2(){
        // 1 0,3
        System.out.println("aba".substring(0,2));
    }
    @Test
    public void test3(){
        int left=0;int right=0;String s="s";
        // 不管跑几次，左边右边都会多算一次
        while(left<=right&&left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        System.out.println(left);
        System.out.println(right);
        System.out.println(right-left-1);
    }
}
