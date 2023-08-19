package com.example.demo.selftest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SelfTest {

    //给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    //https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode currentNode=head;
        while(currentNode.next!=null){
            if(currentNode.val==currentNode.next.val){
                currentNode.next=currentNode.next.next;
            }else{
                currentNode=currentNode.next;
            }
        }
        return head;
    }

    //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
    //元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
    //https://leetcode-cn.com/problems/remove-element/
    public int removeElement(int[] nums, int val) {
        int count=0;
        int[] b=new int[nums.length];
        for(int i=0;i<nums.length;){
            if(val==nums[i]){
                for(int j=i;j<nums.length;j++){
                    nums[j]=nums[j+1];
                }
                nums[nums.length-1-i]=b[nums.length-1-i];
            }
        }
        return nums.length-count;
    }

    @Test
    public void test1(){
        ListNode a=new ListNode(1);
        a.next=new ListNode(1);
        a.next.next=new ListNode(2);
        a.next.next.next=new ListNode(3);
        a.next.next.next.next=new ListNode(3);
        deleteDuplicates(a);
    }
    public void quickSort(int[] array,int start,int end){
        if(start<end){
            int i=start;
            int key=array[start];
            for(int j=start+1;j<=end;j++){
                if(key>array[j]){
                    i+=1;
                    swap(array,j,i);
                }
            }
            array[start]=array[i];
            array[i]=key;
            quickSort(array,start,i-1);
            quickSort(array,i+1,end);
        }
    }
    public void swap(int[] array,int a,int b){
        if(a!=b){
            array[a]^=array[b];
            array[b]^=array[a];
            array[a]^=array[b];
        }
    }
    public void mergeSort(int[] array,int a,int b){
        if(a<b){
            int center=(a+b)>>1;
            mergeSort(array,a,center);
            mergeSort(array,center+1,b);
            mergeSort(array,a,center,b);
        }
    }

    public void mergeSort(int[] array,int left,int center,int right){
        int length=right-left+1;
        int[] tmp=new int[length];
        int tmpIndex=0;
        int _left=left;
        int _right= center+1;
        while(_left<center&&_right<right){
            if(array[_left]>array[_right]){
                tmp[tmpIndex++]=array[_right++];
            }else{
                tmp[tmpIndex++]=array[_left++];
            }
        }
        while(_right<right){
            tmp[tmpIndex++]=array[_right++];
        }
        while(_left<center){
            tmp[tmpIndex++]=array[_left++];
        }
        tmpIndex=0;
        while(tmpIndex<length){
            array[left+tmpIndex]=tmp[tmpIndex++];
        }

    }

    public void insertSort(int[] array){
        if(array==null||array.length<2){
            return;
        }
        for(int i=1;i<array.length;i++){
            int key=array[i];
            int position=i;
            for(int j=i-1;j>=0;j--){
                if(array[i]<array[j]){
                    array[j+1]=array[j];
                    position--;
                }else{
                    break;
                }
            }
            array[position]=key;
        }
    }

    public void test(){
        HashMap<String,String> map=new HashMap<>();
        map.put("a","A");
    }

    @Test
    public void testCombineLetters(){
        List<String> letters=new ArrayList<>();
        letters.add("abc");
        letters.add("def");
        letters.add("ghi");
        combineLetters(letters);
    }

    public void combineLetters(List<String> letters){
        List<String> results=new ArrayList<>();
        List<String> combines=new ArrayList<>();
        combineLetters(combines,letters,results);
        System.out.println(combines);
        System.out.println(results);
    }
    public void combineLetters(List<String> combines,List<String> letters,List<String> results){
        if(combines.size()==letters.size()){
            results.add(String.join("",combines));
            return;
        }

        String letter= letters.get(combines.size());

        for(int i=0;i<letter.length();i++){
            combines.add(letter.substring(i,i+1));
            combineLetters(combines,letters,results);
            combines.remove(combines.size()-1);
        }
    }

    public void mergeSort2(int[] array,int a,int b){
        if(a<b){
            int center=(a+b)>>1;
            mergeSort2(array,a, center);
            mergeSort2(array,center+1,b);
            mergeSort2(array,a,center,b);
        }
    }

    private void mergeSort2(int[] array,int left,int center,int right){
        int length=right-left+1;
        int[] tmp=new int[length];
        int tmpIndex=0;
        int _left=left;
        int _right=center+1;
        while(_left<=center&&_right<=right){
            if(array[_left]<=array[_right]){
                tmp[tmpIndex++]=array[_left++];
            }else{
                tmp[tmpIndex++]=array[_right++];
            }
        }
        while(_right<=right){
            tmp[tmpIndex++]=array[_right++];
        }
        while(_left<=center){
            tmp[tmpIndex++]=array[_left++];
        }
        tmpIndex=0;
        while(tmpIndex<length){
            array[left+tmpIndex]=tmp[tmpIndex++];
        }
    }

    @Test
    public void mergeSort2Test(){
        int[] arr={5,3,7,6,4,1,0,2,9,10,8};
        mergeSort2(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void quickSort2(int[] array,int start,int end){
        if(start<end){
            int key=array[start];
            int i=start;
            for(int j=start+1;j<=end;j++){
                if(array[j]<key){
                    i++;
                    swap(array,i,j);
                }
            }
            array[start]=array[i];
            array[i]=key;
            quickSort2(array,start,i-1);
            quickSort2(array,i+1,end);
        }
    }

    @Test
    public void quickSort2Test(){
        int[] arr={5,3,7,6,4,1,0,2,9,10,8};
        quickSort2(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

}
