package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations-ii/
 *
 * 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class Leetcode47 {

    @Test
    public void test(){
        int[] nums={1,1,2};
        List<List<Integer>> result=permuteUnique(nums);
        System.out.println(result);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        permuteUnique(nums,results,used,new ArrayList<>());
        return results;
    }
    private void permuteUnique(int[] nums,List<List<Integer>> results,boolean[] used,List<Integer> result){
        if(result.size()==nums.length){
            results.add(new ArrayList<>(result));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            if(i>0&&nums[i]==nums[i-1]&&used[i-1]){
                continue;
            }
            result.add(nums[i]);
            used[i]=true;
            // used只针对深入递归有效，用完还原
            permuteUnique(nums,results,used,result);
            used[i]=false;
            result.remove(result.size()-1);
        }
    }
}
