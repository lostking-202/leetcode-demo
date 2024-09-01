package com.example.demo.leetcode.leet20240220;

import com.google.common.collect.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 */
public class Day14Leet141 {

    public boolean hasCycle(ListNode head) {
        List<ListNode> nodeList=new ArrayList<>();
        while(head!=null){
            if(!nodeList.contains(head)){
                nodeList.add(head);
                head=head.next;
            }else{
                return true;
            }
        }
        return false;
    }
    public boolean hasCycle2(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode step1=head;
        ListNode step2=head.next;
        while(step1!=null&&step2!=null&&step2.next!=null){
            if(step1==step2){
                return true;
            }else{
                step1=step1.next;
                step2=step2.next.next;
            }
        }
        return false;
    }
}
