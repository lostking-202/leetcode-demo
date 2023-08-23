package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/plus-one/
 *
 * 加一
 *
 *给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 提示：
 *  1 <= digits.length <= 100
 *  0 <= digits[i] <= 9
 */
public class Leetcode66 {

    @Test
    public void test(){
        int[] digits={1,9,9};
        Arrays.stream(plusOne(digits)).forEach(System.out::println);


    }
    public int[] plusOne(int[] digits) {
        // 只要一步没有进位，就可以返回了
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            if(digits[i]/10==0){
                return digits;
            }
            digits[i]=digits[i]%10;
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}
