package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/3sum/
 *
 * 三数之和
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 提示：
 *  3 <= nums.length <= 3000
 *  -10^5 <= nums[i] <= 10^5
 */
public class Leetcode15 {

    @Test
    public void test(){
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }





















    // 看的答案
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>0){
                break;
            }
            int left=i+1;
            int right=nums.length-1;
            int target=-nums[i];
            while(left<right){
                int sum=nums[left]+nums[right];
                if(sum==target){
                    results.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum>target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return results;
    }
}
