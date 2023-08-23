package com.example.demo.leetcode.lc.dp;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 提升：
 *  1 <= n <= 45
 */
public class Leetcode70 {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] step=new int[n];
        step[0]=1;
        step[1]=2;
        for(int i=2;i<n;i++){
            step[i]=step[i-1]+step[i-2];
        }
        return step[n-1];
    }
}
