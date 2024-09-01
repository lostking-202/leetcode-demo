package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 */
public class Day05Leet25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int i=0;
        ListNode preNode=new ListNode(0);
        preNode.next=head;
        ListNode pre=preNode;
        ListNode cur=head;
        ListNode tempHead;
        ListNode reverseHead=pre.next;
        ListNode nextList;
        while(cur!=null){
            i++;
            if(i>=k){
                i=0;
                tempHead=reverseHead;
                nextList=cur.next;
                pre.next=null;
                cur.next=null;
                ListNode reverseList=reverseList(tempHead);
                pre.next=reverseList;
                pre=reverseHead;
                reverseHead.next=nextList;
                cur=reverseHead;
                reverseHead=nextList;

            }else{

            }
            cur=cur.next;
        }
        return preNode.next;
    }
    private ListNode reverseList(ListNode head) {
        ListNode curNode=head;
        ListNode preNode=null;
        ListNode tempNode=null;
        while(curNode!=null){
            tempNode=curNode;
            curNode=tempNode.next;
            tempNode.next=preNode;
            preNode=tempNode;
        }
        return tempNode;
    }
    @Test
    public void test1(){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode reverseNode=reverseKGroup(node1,2);
        System.out.println(reverseNode);
    }
}
