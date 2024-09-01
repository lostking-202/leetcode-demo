package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
// 删除链表的倒数第 N 个结点
// 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
public class Day19Leet19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode cur=pre;
        List<ListNode> nodes=new ArrayList<>();
        while(cur!=null){
            nodes.add(cur);
            cur=cur.next;
        }
        // n=2 size=6 2.next=4
        // n=1 size=6 3.next=null
        // n=5 size=6 0.next=2
        if(n==1){
            nodes.get(nodes.size()-n-1).next=null;
        }else{
            nodes.get(nodes.size()-n-1).next=nodes.get(nodes.size()-n+1);
        }
        return pre.next;
    }
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
        ListNode res=removeNthFromEnd(node5,1);

        System.out.println(res);
    }
}
