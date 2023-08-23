package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/
 *
 *全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 提示：
 *  1 <= nums.length <= 6
 *  -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class Leetcode46 {

    @Test
    public void test(){
        int[] nums={1,2,3};
        List<List<Integer>> results=permute2(nums);
        System.out.println(results);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        permute(results,nums,new ArrayList<>());
        return results;
    }
    private void permute(List<List<Integer>> results,int[] nums,List<Integer> result){
        if(result.size()==nums.length){
            results.add(result);
            return;
        }
        for(Integer num:nums){
            if(result.contains(num)){
                continue;
            }else{
                List<Integer> cur=new ArrayList<>(result);
                cur.add(num);
                permute(results,nums,cur);
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        permute2(results,nums,new ArrayList<>());
        return results;
    }

    private void permute2(List<List<Integer>> results,int[] nums,List<Integer> result){
        if(result.size()==nums.length){
            results.add(result);
            return;
        }
        for(Integer num:nums){
            if(result.contains(num)){
                continue;
            }else{
                result.add(num);
                permute(results,nums,result);
                result.remove(result.size()-1);

            }
        }
    }

}
