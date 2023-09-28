package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/partition-list/
 *
 * 分隔链表
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class Leetcode86 {
    @Test
    public void test(){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(4);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(2);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(2);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        System.out.println(partition(node1,3));
    }
    public ListNode partition(ListNode head, int x) {
        ListNode prevMin=new ListNode(-201);
        ListNode prevMax=new ListNode(201);
        prevMin.next=head;
        ListNode curMin=prevMin;
        ListNode curMax=prevMax;
        ListNode cur=prevMin.next;
        while(cur!=null){
            if(cur.val<x){
                curMin.next=new ListNode(cur.val);
                curMin=curMin.next;
            }else{
                curMax.next=new ListNode(cur.val);
                curMax=curMax.next;
            }
            cur=cur.next;
        }
        curMin.next=prevMax.next;

        return prevMin.next;
    }
}
