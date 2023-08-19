package com.example.demo.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    @Test
    public void mergeSortTest1(){
        //int[] arr={4,3,2,1};
        int[] arr={5,3,7,6,4,1,0,2,9,10,8};
        mergeSort1(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }
    public void mergeSort1(int[] array,int left,int right){
        if(left<right){
            int center=(left+right)>>1;
            mergeSort1(array,left,center);
            mergeSort1(array,center+1,right);
            merge(array,left,center,right);
        }
    }
    public void merge(int[] data,int left,int center,int right){
        int length=right-left+1;
        int[] tmp=new int[length];
        int tempIndex=0;
        int _left=left;
        int _right=center+1;
        while(_left<=center&&_right<=right){
            if(data[_left]<=data[_right]){
                tmp[tempIndex++]=data[_left++];
            }else{
                tmp[tempIndex++]=data[_right++];
            }
        }
        while(_right<=right){
            tmp[tempIndex++]=data[_right++];
        }
        while(_left<=center){
            tmp[tempIndex++]=data[_left++];
        }
        tempIndex=0;
        while(tempIndex<length){
            data[left+tempIndex]=tmp[tempIndex++];
        }
    }


}
