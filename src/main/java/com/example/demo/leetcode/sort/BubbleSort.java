package com.example.demo.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

// 冒泡排序
public class BubbleSort {
    public void bubbleSort(int[] a){
        int j=0;
        while(j<a.length){
            for(int i=0;i<a.length-j-1;i++){
                if(a[i]>a[i+1]){
                    swap(a,i,i+1);
                }
            }
            j++;
            System.out.println(j);
        }

    }
    private void swap(int[] arr,int a,int b){
        if(a!=b){
            arr[a]^=arr[b];
            arr[b]^=arr[a];
            arr[a]^=arr[b];
        }
    }
    @Test
    public void test(){
        int[] arr={5,3,7,6,4,1,0,2,9,10,8};
        bubbleSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
