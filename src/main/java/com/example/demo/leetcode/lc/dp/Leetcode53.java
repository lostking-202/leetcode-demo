package com.example.demo.leetcode.lc.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-subarray/
 *
 * 最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 */
public class Leetcode53 {

    @Test
    public void test(){
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }


























    public int maxSubArray(int[] nums) {
        int cur=nums[0];
        int max=cur;
        for(int i=1;i<nums.length;i++){
            // 前面的和小于0就抛掉，否则不抛掉
            cur=Math.max(cur,0)+nums[i];
            System.out.println(cur);
            max=Math.max(cur,max);
        }
        return max;
    }
}
