package com.example.demo.leetcode.lc.dp;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 *
 * 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class Leetcode300 {

    @Test
    public void test(){
        int[] nums={4,10,4,3,8,9};
                 // 1 2  1 1 1 3
        System.out.println(lengthOfLIS3(nums));

        /*List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(10);
        System.out.println(Collections.binarySearch(list,-1));
*/

        /*int[] nums={4,10,4,3,8,9};
                    // 1 2 1 1 2 3*/


    }


    public int lengthOfLIS3(int[] nums){

        int[] dp=new int[nums.length];
        dp[0]=1;
        int max=1;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp=new int[nums.length];
        int max=1;
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            //每一个数都需要和前面的所有数比较大小
            // dp[i]表示当前最大子序列长度或者没更新
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    // 1 2 1 1 2 3
                    // i=5 j=0 Math.max(1,1+1)
                    // i=5 j=2 Math.max(2,1+1)
                    // i=5 j=3 Math.max(2,1+1)
                    // i=5 j=4 Math.max(2,2+1)
                    dp[i] =  Math.max(dp[j]+1,dp[i]);
                }
            }
            System.out.println(dp[i]);
            max=Math.max(max,dp[i]);
        }
       return max;
    }

    public int lengthOfLIS2(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
            if(list.size()==0||list.get(list.size()-1)<num){
                list.add(num);
            }else{
                int n=Collections.binarySearch(list,num);
                if(n<0){
                    list.set(-n-1,num);
                }else{
                    list.set(n,num);
                }
            }
        }
        return list.size();
    }

}
