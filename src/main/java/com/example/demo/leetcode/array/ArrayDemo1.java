package com.example.demo.leetcode.array;

import org.junit.Test;

public class ArrayDemo1 {
    @Test
    public void test1(){
        int[] nums1= {1,2};
        int[] nums2= {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    //在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
    //返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
    public int numPairsDivisibleBy60I(int[] time) {
        int count=0;
        for(int i=0;i<time.length-1;i++){
            for(int j=i+1;j<time.length;j++){
                if((time[i]+time[j])%60==0){
                    count++;
                }
            }
        }
        return count;
    }

    public int numPairsDivisibleBy60II(int[] time) {
        int count=0;

        return count;
    }
    public boolean canThreePartsEqualSum(int[] A) {
        int sum1=0;
        int j;
        for(int i=0;i<A.length;i++) {
            sum1+= A[i];
        }
        if(sum1%3!=0) {
            return false;
        }else {
            j=sum1/3;
            int sum2=0;
            for(int i=0;i<A.length-2;i++) {
                sum2+=A[i];
                if(j!=sum2) {
                    continue;
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums=new int[nums1.length+nums2.length];
        int m=0;
        int n=0;
        for(int i=0;i<nums.length/2+1;i++){

            if(m>nums1.length-1){
                nums[i]=nums2[n];
                n++;
            }else if(n>nums2.length-1){
                nums[i]=nums1[m];
                m++;
            }else{
                if(nums1[m]>nums2[n]){
                    nums[i]=nums2[n];
                    n++;
                }else{
                    nums[i]=nums1[m];
                    m++;
                }
            }

        }
        int size=nums.length;
        if(size%2==0){
            return (nums[size/2-1]+nums[size/2]+0.0)/2;
        }else{
            return nums[(size-1)/2];
        }
    }

    //https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
    public int missingNumber1(int[] nums) {
        int sum1=0;
        int sum2=0;
        for(int i=0;i<nums.length;i++){
            sum1+=nums[i];
        }
        for(int i=0;i<=nums.length;i++){
            sum2+=i;
        }
        return sum2-sum1;
    }

    public int missingNumber2(int[] nums) {
        int sum1=0;
        int sum2=0;
        for(int i=0;i<nums.length;i++){
            sum1+=nums[i];
        }
        for(int i=0;i<=nums.length;i++){
            sum2+=i;
        }
        return sum2-sum1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=n-1,j=m-1;i>-1;){
            if(j<0){
                nums1[i]=nums2[i];
                i--;
            }else{
                if(nums2[i]>nums1[j]){
                    nums1[i+j+1]=nums2[i];
                    i--;
                }else{
                    nums1[j+i+1]=nums1[j];
                    nums1[j]=Integer.MIN_VALUE;
                    j--;
                }
            }
        }
    }

    //https://leetcode-cn.com/problems/shuffle-the-array/
    //n=4 0 0--1 4--2 1--3 5--4 2--5 6--6 3--7 7
    public int[] shuffle(int[] nums, int n) {
        int[] array=new int[nums.length];
        for(int i=0;i<array.length;i++){
            if(i%2==0){
                array[i]=nums[i/2];
            }else{
                array[i]=nums[i/2+n];
            }
        }
        return array;
    }

    @Test
    public void test3(){
        int[] nums1={2,0};
        int[] nums2={1};
        merge(nums1,1,nums2,1);
    }
}
