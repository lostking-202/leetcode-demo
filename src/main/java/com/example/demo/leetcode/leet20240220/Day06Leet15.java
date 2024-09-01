package com.example.demo.leetcode.leet20240220;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class Day06Leet15 {
    // todo
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        List<List<Integer>> results=new ArrayList<>();
        int k;
        while(i<=j){
            int res=0-(nums[i]+nums[j]);
            // 2
            if(res>nums[j]){
                i++;
                continue;
            }
            if(res<nums[i]){
                j--;
                continue;
            }
            if(res>=0){
                k=j-1;
                while(k>i){
                    if(nums[k]>res){
                        k--;
                    }else if(nums[k]==res){
                        results.add(Lists.newArrayList(nums[i],nums[k],nums[j]));
                        k--;
                    }else{
                        break;
                    }
                }
                i++;
            }
            if(res<0){
                k=i+1;
                while(k<j){
                    if(nums[k]<res){
                        k++;
                    }else if(nums[k]==res){
                        results.add(Lists.newArrayList(nums[i],nums[k],nums[j]));
                        k++;
                    }else{
                        break;
                    }
                }
                j--;
            }
        }
        return results;

    }
    @Test
    public void test(){
        int[] nums={-1,0,1,2,-1,-4};
        //int[] nums={0,0,0};
        var res=threeSum(nums);
        System.out.println(res);
    }
}
