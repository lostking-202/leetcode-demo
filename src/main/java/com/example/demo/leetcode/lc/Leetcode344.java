package com.example.demo.leetcode.lc;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.cn/problems/reverse-string/
 *
 * 反转字符串
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 提示：
 * 1 <= s.length <= 10^5
 * s[i] 都是 ASCII 码表中的可打印字符
 */
public class Leetcode344 {

    @Test
    public void test(){
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        if(s==null&&s.length==0){
            return;
        }
        int start=0;
        int end=s.length-1;
        while(start<end){
            swap(start,end,s);
            start++;
            end--;
        }
    }

    private void swap(int start, int end, char[] s) {
        if(start<end){
            s[start]^=s[end];
            s[end]^=s[start];
            s[start]^=s[end];
        }
    }
}
