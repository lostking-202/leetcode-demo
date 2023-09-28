package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 *
 * 环形链表 II
 *
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * 提示：
 * 链表中节点的数目范围在范围 [0, 10^4] 内
 * -10^5 <= Node.val <= 10^5
 * pos 的值为 -1 或者链表中的一个有效索引
 */
public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        List<ListNode> nodes=new ArrayList<>();
        while(head!=null){
            if(nodes.contains(head)){
                return head;
            }
            nodes.add(head);
            head=head.next;
        }
        return null;
    }
}
