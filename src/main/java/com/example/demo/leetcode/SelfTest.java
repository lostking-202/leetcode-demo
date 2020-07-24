package com.example.demo.leetcode;

import org.junit.Test;

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
}
