package com.example.demo.leetcode.leet20240220;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */
public class Day09Leet01 {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                result= new int[]{list.indexOf(nums[i]), i};
                return result;
            }else{
                list.add(target-nums[i]);
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int[] result={map.get(nums[i]),i};
                return result;
            }else{
                map.put(target-nums[i],i);
            }
        }
        return null;
    }
}
