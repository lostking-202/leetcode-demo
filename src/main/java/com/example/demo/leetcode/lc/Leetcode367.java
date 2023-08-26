package com.example.demo.leetcode.lc;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/valid-perfect-square/
 *
 * 有效的完全平方数
 *
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 *
 * 不能使用任何内置的库函数，如  sqrt 。
 *
 * 提示：
 * 1 <= num <= 2^31 - 1
 */
public class Leetcode367 {

    @Test
    public void test(){
        System.out.println(isPerfectSquare(16));
    }

    public boolean isPerfectSquare2(int num) {
        int left=0;
        int right=num;
        while(left<=right){
            int middle=(left+right)>>1;
            long sq=(long)middle*middle;
            if(sq>num){
                right=middle-1;
            }else if(sq<num){
                left=middle+1;
            }else{
                return true;
            }
        }
        return false;
    }

    public boolean isPerfectSquare(int num) {
        return binarySearch(0,num,num);
    }

    public boolean binarySearch(int m,int n,int num) {
        if(m<n){
            if(m*m==num||n*n==num){
                return true;
            }
            if(n-m==1){
                return false;
            }
            int center=(m+n)>>1;
            return binarySearch(m,center,num)||binarySearch(center,n,num);
        }
        return false;
    }
}
