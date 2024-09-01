package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 */
public class Day08Leet21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result=new ListNode(0);
        ListNode curNode=result;
        while(true){
            if(list1==null&&list2==null){
                break;
            }
            if(list1==null){
                curNode.next=list2;
                break;
            }
            if(list2==null){
                curNode.next=list1;
                break;
            }
            if(list1.val>list2.val){
                curNode.next=new ListNode(list2.val);
                curNode=curNode.next;
                list2=list2.next;
            }else{
                curNode.next=new ListNode(list1.val);
                curNode=curNode.next;
                list1=list1.next;
            }
        }
        return result.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode result=new ListNode(0);
        ListNode curNode=result;
        while(true){
            if(list1==null&&list2==null){
                break;
            }
            if(list1==null){
                curNode.next=list2;
                break;
            }
            if(list2==null){
                curNode.next=list1;
                break;
            }
            if(list1.val>list2.val){
                curNode.next=list2;
                curNode=curNode.next;
                list2=list2.next;
            }else{
                curNode.next=list1;
                curNode=curNode.next;
                list1=list1.next;
            }
        }
        return result.next;
    }
    @Test
    public void test(){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        ListNode node4=new ListNode(1);
        ListNode node5=new ListNode(3);
        ListNode node6=new ListNode(4);
        node4.next=node5;
        node5.next=node6;
        ListNode res=mergeTwoLists2(node1,node4);
        System.out.println(res);
    }
}
