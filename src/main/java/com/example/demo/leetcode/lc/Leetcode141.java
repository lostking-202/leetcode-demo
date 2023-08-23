package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 *
 * 环形链表
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 提示：
 *  链表中节点的数目范围是 [0, 10^4]
 *  -10^5 <= Node.val <= 10^5
 *  pos 为 -1 或者链表中的一个 有效索引 。
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        List<ListNode> nodeList=new ArrayList<>();
        while(head!=null){
            if(nodeList.contains(head)){
                return true;
            }else{
                nodeList.add(head);
            }
            head=head.next;
        }
        return false;
    }
}
