package com.example.demo.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.cn/problems/single-number-iii/
 *
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 */
public class Leetcode260 {

    public int[] singleNumber(int[] nums) {
        if(nums==null||nums.length<2){
            return null;
        }
        Map<Integer,Boolean> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],true);
            }else{
                map.put(nums[i],false);
            }
        }
        List<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer, Boolean> entry:map.entrySet()){
            if(!entry.getValue()){
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    @Test
    public void test(){
        int[] nums={1,2,1,3,2,5};
        Arrays.stream(singleNumber(nums)).forEach(System.out::println);
    }

    public int[] singleNumber2(int[] nums) {
        if(nums==null||nums.length<2){
            return null;
        }
        Map<Integer,Boolean> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.remove(nums[i]);
            }else{
                map.put(nums[i],false);
            }
        }
        return map.keySet().stream().mapToInt(Integer::intValue).toArray();
    }
}
