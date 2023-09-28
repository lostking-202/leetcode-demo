package com.example.demo.leetcode.lc;

/**
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 *
 * 有序数组的平方
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 提示：
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 已按 非递减顺序 排序
 *
 *
 * 进阶：
 *
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class Leetcode977 {
    public int[] sortedSquares(int[] nums) {
        int len=nums.length;
        int left=0;
        int right=len-1;
        int[] res=new int[len];
        while(left<=right){
            len--;
            // 相加等同于比较绝对值
            if(nums[left]+nums[right]<0){
                res[len]=nums[left]*nums[left];
                left++;
            }else{
                res[len]=nums[right]*nums[right];
                right--;
            }
        }
        return res;
    }
}
