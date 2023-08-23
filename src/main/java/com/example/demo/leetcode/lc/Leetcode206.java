package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class Leetcode206 {

    public ListNode reverseList(ListNode head) {
        ListNode reversedNode=new ListNode(0);
        while(head!=null) {
            ListNode curNode = new ListNode(head.val);
            if(reversedNode.next==null){
                reversedNode.next=curNode;
            }else{
                curNode.next=reversedNode.next;
                reversedNode.next=curNode;
            }
            head=head.next;
        }
        return reversedNode.next;
    }

    public ListNode reverseList2(ListNode head){
        ListNode result=new ListNode(0);
        while(head!=null){
            ListNode cur=new ListNode(head.val);
            cur.next=result.next;
            result.next=cur;
            head=head.next;
        }
        return result.next;
    }

    // 1->2->3->null
    // 1->null      2-3->null
    // 2->1->null  3->null
    //3->2->1->null

    @Test
    public void test(){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        ListNode result=reverseList3(node1);
        System.out.println(result);
    }


    public ListNode reverseList3(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            //取出旧链表的后几个节点
            ListNode next=curr.next;
            //将旧链表的当前节点接到新链表的前面
            curr.next=prev;
            //重置新链表的头节点
            prev=curr;
            // 重置旧链表的头节点
            curr=next;
            System.out.println(prev);
        }
        return prev;
    }
}
