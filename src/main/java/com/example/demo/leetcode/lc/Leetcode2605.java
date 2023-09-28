package com.example.demo.leetcode.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/form-smallest-number-from-two-digit-arrays/
 *
 * 从两个数字数组里生成最小数字
 *
 * 给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
 *
 * 提示：
 * 1 <= nums1.length, nums2.length <= 9
 * 1 <= nums1[i], nums2[i] <= 9
 * 每个数组中，元素 互不相同 。
 */
public class Leetcode2605 {
    public int minNumber(int[] nums1, int[] nums2) {
        int min1=9;
        List<Integer> nums1List=new ArrayList<>();
        for(int num1:nums1){
            nums1List.add(num1);
            min1=Math.min(min1,num1);
        }
        int min2=9;
        int sameMin=10;
        for(int num2:nums2){
            min2=Math.min(min2,num2);
            if(nums1List.contains(num2)){
                sameMin=Math.min(sameMin,num2);
            }
        }
        if (sameMin==10){
            return min1>min2?min2*10+min1:min1*10+min2;
        }else{
            return sameMin;
        }
    }
}
