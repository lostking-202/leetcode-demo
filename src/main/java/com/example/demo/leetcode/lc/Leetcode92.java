package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 *
 * 反转链表 II
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class Leetcode92 {

    @Test
    public void test(){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        System.out.println(reverseBetween(node1,2,4));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
       ListNode d=new ListNode(-1);
       d.next=head;
       ListNode prev=d;
       for(int i=0;i<left-1;i++){
           prev=prev.next;
       }
       ListNode l=prev;
       ListNode leftNode=l.next;

       ListNode rightNode=prev;
        for(int i=0;i<right-left+1;i++){
            rightNode=rightNode.next;
        }
        ListNode rightN=rightNode.next;
        l.next=null;
        rightNode.next=null;
        ListNode rev=reverseListNode(leftNode);

        l.next=rev;
        leftNode.next=rightN;

        return d.next;
    }
    private ListNode reverseListNode(ListNode head){
        ListNode prev=null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}
