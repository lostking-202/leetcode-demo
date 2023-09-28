package com.example.demo.leetcode.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/majority-element/
 *
 * 多数元素
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *提示：
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 */
public class Leetcode169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> numsMap=new HashMap<>();
        for(int num:nums){
            int count;
            if(numsMap.containsKey(num)){
                count=numsMap.get(num);
                count++;

            }else{
               count=1;
            }
            numsMap.put(num,count);
            if(count>nums.length/2){
                return num;
            }
        }
        return -1;
    }
}
