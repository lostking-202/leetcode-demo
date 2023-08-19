package com.example.demo.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int maxLength=1;
        int current=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==1){
                current++;
                maxLength= Math.max(maxLength,current);
            }else{
                current=1;
            }
        }
        return maxLength;
    }

    @Test
    public void test(){
        int[] nums={100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
