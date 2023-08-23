package com.example.demo.leetcode.lc;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/contains-duplicate/
 *
 * 存在重复元素
 *
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 * 提示：
 *  1 <= nums.length <= 10^5
 *  -10^9 <= nums[i] <= 10^9
 */
public class Leetcode217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums==null){
            return false;
        }
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
            if(list.contains(num)){
                return true;
            }else{
                list.add(num);
            }
        }
        return false;
    }
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set=Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return !(set.size()==nums.length);
    }
}
