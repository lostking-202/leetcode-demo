package com.example.demo.leetcode.lc.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 *
 * 分割等和子集
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class Leetcode416 {

    // 很难理解

    @Test
    public void test(){
        int[] nums={1,5,11,5};
        System.out.println(canPartition(nums));
    }


    public boolean canPartition3(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];

        dp[0][0] = true;

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }

            if (dp[i][target]) {
                return true;
            }
        }
        return dp[len - 1][target];
    }

    //dp[i][j]表示数组中前i个元素的和是否可以组成和为j，很明显dp[0][0]=true，表示前0个元素（也就是没有元素）可以组成和为0

    public boolean canPartition2(int[] nums){
        int sum= Arrays.stream(nums).sum();
        if(sum %2==1){
            return false;
        }
        int target=sum/2;
        int length=nums.length;
        boolean[][] dp=new boolean[length][target+1];
        dp[0][0]=true;
        if(nums[0]<=target){
            dp[0][nums[0]]=true;
        }
        for(int i=1;i<length;i++){

            for(int j=0;j<=target;j++){
                // dp[0][1]=true;
                // i=1 j=1 nums[1]=5 dp[1][1]=dp[0][1]=true
                // i=1 j=2 nums[1]=5 dp[1][2]=dp[0][2]=false
                // i=2 j=5 nums[2]=5 dp[2][5]=dp[1][5]||dp[1][5-num[2]]=false||true=true
                // i=2 j=6 nums[2]=5 dp[2][6]=dp[1][6]||dp[1][6-num[2]]=false||true=true

                // 总数减去当前数字 为0相当于没加没减
                // 不为0相当于多了个多并一个[j-num[i]]

                //结果具有传递性，多一个位置不多物品肯定行
                if(j>=nums[i]){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
            /*if(dp[i][target]){
                return true;
            }*/
        }
        return dp[length-1][target];
    }

    public boolean canPartition(int[] nums) {
        int sum= Arrays.stream(nums).sum();
        if(sum%2==1){
            return false;
        }
        int target=sum/2;
        Boolean[][] map=new Boolean[nums.length][target+1];
        boolean flag=dfs(nums,0,target,map);
        return flag;
    }

    private boolean dfs(int[] nums, int index, int target, Boolean[][] map) {
        if(target==0){
            return true;
        }
        if(index==nums.length||target<0){
            return false;
        }
        if(map[index][target]!=null){
            return map[index][target];
        }
        boolean select=dfs(nums,index+1,target-nums[index],map);
        boolean unselect=dfs(nums,index+1,target,map);
        if(select||unselect){
            map[index][target]=true;
            return true;
        }
        map[index][target]=false;
        return false;

    }
}
