package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 *
 * 相交链表
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 提示：
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 1 <= m, n <= 3 * 10^4
 * 1 <= Node.val <= 10^5
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
 */
public class Leetcode160 {
    @Test
    public void test(){
        // [4,1,8,4,5]
        ListNode node1=new ListNode(4);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(8);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        //
        ListNode node6=new ListNode(5);
        ListNode node7=new ListNode(6);
        ListNode node8=new ListNode(1);
        node6.next=node7;
        node7.next=node8;
        node8.next=node3;
        System.out.println(getIntersectionNode(node1,node6));
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        while(curA!=null){
            ListNode cur=headB;
            while(cur!=null){
                if(curA==cur){
                    return curA;
                }
                cur=cur.next;
            }
            curA=curA.next;
        }
        return null;
    }
}
