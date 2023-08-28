package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/rotate-list/
 *
 * 旋转链表
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 提示：
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 */
public class Leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {

        List<ListNode> nodeList=new ArrayList<>();
        while(head!=null){
            nodeList.add(head);
            head=head.next;
        }
        if(nodeList.size()==0){
            return null;
        }
        ListNode end=nodeList.get(nodeList.size()-1);;
        end.next=nodeList.get(0);
        nodeList.get(nodeList.size()-1-k%nodeList.size()).next=null;
        if(k%nodeList.size()==0){
            return nodeList.get(0);
        }
        return nodeList.get(nodeList.size()-k%nodeList.size());
    }
}
