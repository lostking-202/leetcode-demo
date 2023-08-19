package com.example.demo.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 选择排序
 *
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 *
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 *
 * 重复第二步，直到所有元素均排序完毕。
 *
 */
public class SelectSort {

    @Test
    public void test(){
        int[] arr={5,3,7,6,4,1,0,2,9,10,8};
        selectSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void selectSort(int[] a){
        int n=a.length;
        int min;
        int minIndex;
        for(int i=0;i<n-1;i++){
            min=a[i];
            minIndex=i;
            for(int j=i+1;j<n;j++){
                if(a[j]<min){
                    min=a[j];
                    minIndex=j;
                }
            }
            //swap or not
            swap(a,i,minIndex);
        }

    }

    private void swap(int[] arr,int a,int b){
        if(a!=b){
            arr[a]^=arr[b];
            arr[b]^=arr[a];
            arr[a]^=arr[b];
        }
    }
}
