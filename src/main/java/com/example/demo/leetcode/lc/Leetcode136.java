package com.example.demo.leetcode.lc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/single-number/
 *
 * 只出现一次的数字
 *
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 提示：
 *  1 <= nums.length <= 3 * 10^4
 *  -3 * 10^4 <= nums[i] <= 3 * 10^4
 *  除了某个元素只出现一次以外，其余每个元素均出现两次。
 */
public class Leetcode136 {
    public int singleNumber(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
            if (list.contains(num)){
                list.remove(new Integer(num));
            }else{
                list.add(num);
            }
        }
        return list.get(0);
    }
}
