package com.example.demo.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    @Test
    public void test(){
        int[] arr={5,3,7,6,4,1,0,2,9,10,8};
        insertSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void insertSort(int[] a){
        if(a==null||a.length<2){
            return;
        }
        for(int i=1;i<a.length;i++){
            int key=a[i];
            int position=i;
            for(int j=i-1;j>=0;j--){
                if(a[j]>key){
                    a[j+1]=a[j];
                    position--;
                }else{
                    break;
                }
            }
            a[position]=key;
        }
    }
}
