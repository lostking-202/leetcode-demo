package com.example.demo.leetcode.lc.dp;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/
 *
 * 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 */
public class Leetcode5 {

    @Test
    public void test(){

        String s="aba";
        System.out.println(longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int maxLen=1;
        int length=s.length();
        int start=0;
        Boolean[][] dp=new Boolean[length][length];
        for(int right=1;right<length;right++)
            for (int left=0;left<right;left++){
                if(s.charAt(left)!=s.charAt(right)){
                    dp[left][right]=false;
                    continue;
                }
                if(left==right){
                    dp[left][right]=true;
                // 这里的判断看起来总感觉 判多了
                }else if(right-left<=2){
                    dp[left][right]=true;
                }else{
                    dp[left][right]=dp[left+1][right-1];
                }
                if(dp[left][right]&&right-left+1>maxLen){
                    maxLen=right-left+1;
                    start=left;
                }
            }
        System.out.println(dp);
        return s.substring(start,start+maxLen);
    }

    public String longestPalindrome2(String s) {

        int maxLen=1;
        int start=0;
        for(int i=0;i<s.length();i++){
            int len1=expandAroundCenter(s,i,i);
            int len2=expandAroundCenter(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>maxLen){
                maxLen=len;
                start=i-((maxLen-1)>>1);
            }
        }
        return s.substring(start,start+maxLen);
    }

    private int expandAroundCenter(String s,int left,int right){
        // 不管跑几次，左边右边都会多算一次
        while(left<=right&&left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

}
