package com.example.demo.leetcode.search;

import org.junit.Test;

/**
 * 二分查找
 */
public class BinarySearch {
    public int binarySearch(int[] arr,int target){
        return binarySearch(arr,target,0,arr.length-1);
    }
    public int binarySearch(int[] arr,int target,int left,int right){
        if(left==right){
            if(arr[left]!=target){
                return -1;
            }else{
                return left;
            }
        }else{
            //先找中间
            int middle=(left+right)>>1;
            if(arr[middle]==target)return middle;
            if(arr[middle]>target){
                return binarySearch(arr,target,left,middle);
            }
            if (arr[middle]<target){
                return binarySearch(arr,target,middle+1,right);
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[] arr={1,2,3,4,5,6,7};
        System.out.println(binarySearch(arr,8));
    }
}
