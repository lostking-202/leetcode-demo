package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 */
public class Leetcode4 {

    @Test
    public void test(){
        int[] nums1={1,2};
        int[] nums2={3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length=nums1.length+nums2.length;
        List<Integer> set=Stream.concat(Arrays.stream(nums1).boxed(),Arrays.stream(nums2).boxed()).sorted().collect(Collectors.toList());
        if(length%2==0){
            return (set.get(length/2-1)+set.get(length/2))/2.0;
        }else{
            return set.get(length/2);
        }
    }

}
