package com.example.demo.leetcode.leet20240220;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Day16Leet46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        deeper(result,res,nums);
        return result;
    }

    private void deeper(List<List<Integer>> result,List<Integer> res,int[] nums){
        if(res.size()==nums.length){
            result.add(new ArrayList<>(res));
        }else{
            for(int i=0;i<nums.length;i++){
                if(res.contains(nums[i])){

                }else{
                    res.add(nums[i]);
                    deeper(result,res,nums);
                    res.remove(Integer.valueOf(nums[i]));
                }

            }
        }
    }
    @Test
    public void test(){
        int[] nums={1,2,3};
        System.out.println(permute(nums));
    }
}
