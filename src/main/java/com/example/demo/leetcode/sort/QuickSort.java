package com.example.demo.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

//快速排序算法
public class QuickSort {
    @Test
    public void test(){
        int[] arr={5,3,7,6,4,1,0,2,9,10,8};
        quickSort2(arr);
    }
    public void quickSort(int[] array){
        Stack<Integer> stack=new Stack<>();
        stack.push(array.length-1);
        stack.push(0);
        while(!stack.empty()){
            int i=stack.pop();
            int j=stack.pop();
            int k=partition(array,i,j);
            if(k>i){
                stack.push(k-1);
                stack.push(i);
            }
            if(j>k){
                stack.push(j);
                stack.push(k+1);
            }
        }
    }
    private int partition(int[] array,int start,int end){
        int pivot=array[start];
        while(start<end){
            while(start<end&&array[end]>=pivot){
                --end;
            }
            swap(array,start,end);
            while(start<end&&array[start]<=pivot){
                ++start;
            }
            swap(array,start,end);
        }
        return start;
    }
    private void swap(int[] arr,int a,int b){
        if(a!=b){
            arr[a]^=arr[b];
            arr[b]^=arr[a];
            arr[a]^=arr[b];
        }
    }

    public void quickSort2(int[] array){
        partition2(array,0,array.length-1);
        System.out.println(array);
    }
    private void partition2(int[] array,int start,int end){
        int pivot=array[start];
        int i=start;
        int j=end;
        while(start<end){
            while(start<end&&array[end]>=pivot){
                --end;
            }
            swap(array,start,end);
            while(start<end&&array[start]<=pivot){
                ++start;
            }
            swap(array,start,end);
        }
        if(start-1>i)partition2(array,i,start-1);
        if(end+1<j)partition2(array,end+1,j);
    }

    public void quickSort3(int[] array,int start,int end){
        if(start<end){
            int key=array[start];
            int i =start;
            for(int j=start+1;j<=end;j++){
                if(key>array[j]){
                    i+=1;
                    swap(array,j,i);
                }
            }
            array[start]=array[i];
            array[i]=key;
            quickSort3(array,start,i-1);
            quickSort3(array,i+1,end);
        }
    }
    @Test
    public void test3(){
        int[] arr={5,3,7,6,4,1,0,2,9,10,8};
        quickSort3(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

}
