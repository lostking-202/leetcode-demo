package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 *
 * 移除链表元素
 *
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 提示：
 * 列表中的节点数目在范围 [0, 10^4] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class Leetcode203 {

    @Test
    public void test(){
        ListNode node1=new ListNode(7);
        ListNode node2=new ListNode(7);
        ListNode node3=new ListNode(7);
        ListNode node4=new ListNode(7);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println(removeElements(node1,7));
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head==null)return null;
        ListNode prev=new ListNode(-1);
        prev.next=head;
        ListNode cur=prev;
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return prev.next;
    }
}
