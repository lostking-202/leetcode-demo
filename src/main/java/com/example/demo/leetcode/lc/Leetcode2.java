package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 *
 * 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */
public class Leetcode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode cur=result;
        //进位
        boolean plus=false;
        while((l1!=null||l2!=null)||plus){
            int a;
            int l1val=l1==null?0:l1.val;
            int l2val=l2==null?0:l2.val;
            if(!plus){
                a=l1val+l2val;
            }else{
                a=l1val+l2val+1;
            }
            if(a/10==1){
                plus=true;
            }else{
                plus=false;
            }
            ListNode curr=new ListNode(a%10);
            cur.next=curr;
            cur=curr;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        return result.next;
    }
}
