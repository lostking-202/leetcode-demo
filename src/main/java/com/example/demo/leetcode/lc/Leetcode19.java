package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 *
 * 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 */
public class Leetcode19 {

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head==null){
            return null;
        }
        List<ListNode> nodeList=new ArrayList<>();
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode cur=pre;
        while(cur!=null){
            nodeList.add(cur);
            cur=cur.next;
        }
        int nodeListLength=nodeList.size();
        if(n==1){
            nodeList.get(nodeListLength-n-1).next=null;
        }else{
            nodeList.get(nodeListLength-n-1).next=nodeList.get(nodeListLength-n+1);
        }
        return pre.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head==null){
            return null;
        }
        Map<Integer,ListNode> map=new HashMap<>();
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode cur=pre;
        int i=0;
        while(cur!=null){
            map.put(i,cur);
            cur=cur.next;
            i++;
        }
        map.get(i-n-1).next=map.get(i-n+1);
        return pre.next;
    }
}
