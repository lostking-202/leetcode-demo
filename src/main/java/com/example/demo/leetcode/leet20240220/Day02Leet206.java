package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

import java.util.List;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * https://leetcode.cn/problems/reverse-linked-list/description/
 * 提示：
 *
 *  链表中节点的数目范围是 [0, 5000]
 *  -5000 <= Node.val <= 5000
 */
public class Day02Leet206 {
    public ListNode reverseList(ListNode head) {
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
        ListNode reverseNode=reverseList(node1);
        System.out.println(reverseNode);
    }
}
