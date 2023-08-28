package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 *
 * 链表的中间结点
 *
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 提示：
 * 链表的结点数范围是 [1, 100]
 * 1 <= Node.val <= 100
 */
public class Leetcode876 {
    @Test
    public void test(){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(1);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        middleNode(node1);
    }
    public ListNode middleNode(ListNode head) {
        List<ListNode> nodeList=new ArrayList<>();
        while(head!=null){
            nodeList.add(head);
            head=head.next;
        }
        return nodeList.get(nodeList.size()/2);

    }
}
