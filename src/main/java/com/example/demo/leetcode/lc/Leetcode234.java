package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/
 *
 *  回文链表
 *
 *  给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *  提示：
 * 链表中节点数目在范围[1, 10^5] 内
 * 0 <= Node.val <= 9
 */
public class Leetcode234 {

    @Test
    public void test(){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        isPalindrome(node1);
    }

    public boolean isPalindrome(ListNode head) {
        StringBuilder sb=new StringBuilder();
        while(head!=null){
            sb.append(head.val);
            head=head.next;
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
