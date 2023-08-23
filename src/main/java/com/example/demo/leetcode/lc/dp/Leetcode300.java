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
        /*int[] nums={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));*/

        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        System.out.println(Collections.binarySearch(list,7));

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
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    //d[0]=1 d[1]=1 d[2]=1 d[3]=2 d[4]=2 d[4]=3 d[5]=4 d[6]=[4] d[7]=4
                    // i=6 j=0  dp[6] = Math.max(dp[6], dp[0] + 1)=2;
                    ///i=6 j=1  dp[6] = Math.max(dp[6], dp[1] + 1)=2;
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
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
                }
            }
        }
        return list.size();
    }

}
