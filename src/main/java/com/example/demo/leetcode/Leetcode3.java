package com.example.demo.leetcode;

public class Leetcode3 {
    //删除链表中等于给定值 val 的所有节点。
    //https://leetcode-cn.com/problems/remove-linked-list-elements/
    public ListNode removeElements(ListNode head, int val) {
        ListNode currentNode=head;
        while(currentNode!=null){
            if(currentNode.val==val){
                
            }
            currentNode=currentNode.next;
        }
        return head;
    }


    //https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length=nums.length;
        int[] arr= new int[length];
        for(int i=0;i<length;i++){
           arr[i]=length-1;
        }
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                if(nums[i]>nums[j]){
                    arr[j]--;
                }else if(nums[i]<nums[j]){
                    arr[i]--;
                }else{
                    arr[j]--;
                    arr[i]--;
                }
            }
        }
        return arr;
    }
}

