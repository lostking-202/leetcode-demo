package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/merge-sorted-array/
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 *
 */
public class Day13Leet88 {

    // 456000 123
    // 450006 123
    // 400056 123
    // 000456 123


    //[4,0,0,0,0,0]  12356
    // 400006
    // 400056
    // 000456
    // 123456
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i=m-1;int j=n-1;
        while(i>=0&&j>=0){
            if(nums1[i]<=nums2[j]){
                nums1[i+j+1]=nums2[j];
                j--;
            }else{
                // i=2 j=0
                nums1[i+j+1]=nums1[i];
                //nums1[i]=0;
                i--;
            }
        }
        if(i==-1){
            for(int k=j;k>=0;k--){
                nums1[k]=nums2[k];
            }
        }

    }
    @Test
    public void test1(){
        int[] nums1={1,3,5,0,0,0};
        int[] nums2={2,4,6};
        merge(nums1,3,nums2,3);
        Arrays.stream(nums1).forEach(System.out::println);
    }
    @Test
    public void test2(){
        int[] nums1={0,0,0};
        int[] nums2={1,2,3};
        merge(nums1,0,nums2,3);
        Arrays.stream(nums1).forEach(System.out::println);
    }
    @Test
    public void test3(){
        int[] nums1={4,5,6,0,0,0};
        int[] nums2={1,2,3};
        merge(nums1,3,nums2,3);
        Arrays.stream(nums1).forEach(System.out::println);
    }
    @Test
    public void test4(){
        int[] nums1={4,0,0,0,0,0};
        int[] nums2={1,2,3,5,6};
        merge(nums1,1,nums2,5);
        Arrays.stream(nums1).forEach(System.out::println);
    }
}
