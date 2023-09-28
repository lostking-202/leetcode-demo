package com.example.demo.leetcode.lc;

import org.junit.jupiter.api.Test;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 *
 * 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *提示：
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 *
 */
public class Leetcode209 {
    @Test
    public void test(){
        int[] nums={1,4,4};
        System.out.println(minSubArrayLen(10,nums));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int minLen=nums.length+1;
        int start=0;
        int end=0;
        int curSum=nums[0];
        int curLen;
        while(end<nums.length){
            while(curSum>=target){
                curLen=end-start+1;
                minLen=Math.min(curLen,minLen);
                curSum-=nums[start];
                start++;
            }
            while(curSum<target){
                end++;
                if(end<nums.length-1){
                    curSum+=nums[end];
                }else{
                    break;
                }
            }
        }
        return minLen==nums.length+1?0:minLen;
    }
}
