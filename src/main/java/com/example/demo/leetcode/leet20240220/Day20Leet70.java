package com.example.demo.leetcode.leet20240220;


import org.junit.Test;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 *
 * 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Day20Leet70 {

    public int climbStairs(int n) {
        int[] nums=new int[n+1];
        if(n==1||n==2){
            return n;
        }
        nums[1]=1;
        nums[2]=2;
        for(int i=3;i<nums.length;i++){
            nums[i]=nums[i-1]+nums[i-2];
        }
        return nums[n];
    }

    @Test
    public void test(){
        System.out.println(climbStairs(1));
    }
}
