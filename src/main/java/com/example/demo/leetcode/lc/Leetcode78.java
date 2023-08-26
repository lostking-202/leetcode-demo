package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/
 *
 * 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 提示：
 *  1 <= nums.length <= 10
 *  -10 <= nums[i] <= 10
 *  nums 中的所有元素 互不相同
 */
public class Leetcode78 {

    @Test
    public void test(){
        int[] nums={1,2,3};
        System.out.println(subsets(nums));
    }
    // 看的答案
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        results.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            List<List<Integer>> tempResults=new ArrayList<>();
            for(int j=0;j<results.size();j++){
                List<Integer> temp=new ArrayList<>(results.get(j));
                temp.add(nums[i]);
                tempResults.add(temp);
            }
            results.addAll(tempResults);
        }
        return results;
    }
}
