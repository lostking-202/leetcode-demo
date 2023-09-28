package com.example.demo.leetcode.lc.dp;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.cn/problems/is-subsequence/
 *
 * 判断子序列
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 提示：
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 */
public class Leetcode392 {
    @Test
    public void test(){
        String s="acb";
        String t="ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    public boolean isSubsequence(String s, String t) {
        return isSubsequence(0,s,t);
    }
    public boolean isSubsequence(int index,String s, String t) {
        if(index==s.length()){
            return true;
        }
        if(t.length()==0){
            return false;
        }
        char c=s.charAt(index);
        int j=-1;
        if((j=t.indexOf(c))!=-1){
            index++;
            return isSubsequence(index,s,t.substring(j+1));
        }else{
            return false;
        }
    }
}
