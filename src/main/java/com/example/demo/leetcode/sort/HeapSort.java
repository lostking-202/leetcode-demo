package com.example.demo.leetcode.sort;

import org.junit.Test;

public class HeapSort {
    //从数组中找出最大或最小的k个数s
    public void heapSort(int[] arr){
        int length=arr.length;
        buildMaxHeap(arr,length);
        for(int i=0;i<length;i++){
            swap(arr,0,length-1-i);
            maxHeapfy(arr,0,length-1-i);
        }
    }
    private void maxHeapfy(int[] arr,int i,int heapSize){
        int left=i*2+1;
        int right=i*2+2;
        int largest=i;
        if(left<heapSize&&arr[left]>arr[largest]){
            largest=left;
        }
        if(right<heapSize&&arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=i){
            swap(arr,largest,i);
            maxHeapfy(arr,largest,heapSize);
        }
    }

    private void buildMaxHeap(int[] arr,int heapSize){
        for(int i=(heapSize-2)>>1;i>=0;i--){
            maxHeapfy(arr,i,heapSize);
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
    public void test2(){
        int[] arr={2,9,-9,7,6,8,0,-1};
        heapSort(arr);
    }
}
