package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/maximum-subarray/description/
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 */
public class Day07Leet53 {

    public int maxSubArray(int[] nums) {
        int curMax=nums[0];
        int curSum=nums[0];
        // [-2,1,-3,4,-1,2,1,-5,4]
        // -2，-1
        // 1.2
        for(int i=1;i<nums.length;i++){
            if(curSum<0){
                curSum=nums[i];
            }else{
                curSum+=nums[i];
            }
            curMax=Math.max(curSum,curMax);
        }
        return curMax;
    }
    @Test
    public void test(){
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
