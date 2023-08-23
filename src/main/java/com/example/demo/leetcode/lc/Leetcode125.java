package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * https://leetcode.cn/problems/valid-palindrome/
 *
 * 验证回文串
 *
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 */
public class Leetcode125 {

    @Test
    public void test(){
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        s=s.trim().toLowerCase();
        Queue<String> queue=new ArrayBlockingQueue<>(s.length());
        for(int i=0;i<s.length()>>1;i++){
            queue.add(s.substring(i,i+1));
        }
        for(int i=(s.length()>>1)+1;i<s.length();i++){
            if(!s.substring(i,i+1).equals(queue.poll())){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        s=s.trim().toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(Character c:s.toCharArray()){
            int numberValue=Character.getNumericValue(c);
            if((numberValue<=35&&10<=numberValue)||(numberValue<=9&&0<=numberValue)){
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
