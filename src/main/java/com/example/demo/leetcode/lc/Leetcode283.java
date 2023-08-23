package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/move-zeroes/
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 提示:
 *  1 <= nums.length <= 10^4
 *  -2^31 <= nums[i] <= 2^31 - 1
 *
 */
public class Leetcode283 {
    @Test
    public void test(){
        int[] nums={0,1};
        moveZeroes2(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
    public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]!=0){
                        swap(nums,i,j);
                        break;
                    }
                }
            }
        }
    }
    private void swap(int[] nums,int a,int b){
        if(a!=b){
            nums[a]^=nums[b];
            nums[b]^=nums[a];
            nums[a]^=nums[b];
        }
    }

    public void moveZeroes2(int[] nums){
        int m=0;
        for(int i=1;i<nums.length;i++){
            if(nums[m]==0){
                if(nums[i]!=0){
                    swap(nums,m,i);
                    m++;
                }
            }else{
                m++;
            }
        }
    }


}
