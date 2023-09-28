package com.example.demo.leetcode.lc;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 提示：
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums 是一个非递减数组
 * -10^9 <= target <= 10^9
 */
public class Leetcode34 {
    @Test
    public void test(){
        int[] nums={1};
        int[] res=searchRange(nums,1);
        System.out.println(res);
    }

    // while循环和递归只能留一个
    public int[] searchRange(int[] nums, int target) {
        int[] results={-1,-1};
        if(nums.length==0){
            return results;
        }
        if(target<nums[0]||target>nums[nums.length-1]){
            return results;
        }
        int left=0;
        int right=nums.length-1;
        binarySearch(nums,target,left,right,results);
        return results;
    }
    private void binarySearch(int[] nums,int target,int left,int right,int[] results){
        if(left<=right){
            int middle=(left+right>>1);
            if(nums[middle]>target){
                binarySearch(nums,target,left,middle-1,results);
            }else if(nums[middle]<target){
                binarySearch(nums,target,middle+1,right,results);
            }else{
                if(results[0]==-1){
                    results[0]=middle;
                }else{
                    results[0]=Math.min(results[0],middle);
                }

                if(results[1]==-1){
                    results[1]=middle;
                }else{
                    results[1]=Math.max(results[1],middle);
                }
                binarySearch(nums,target,left,middle-1,results);
                binarySearch(nums,target,middle+1,right,results);
            }
        }
    }
}
