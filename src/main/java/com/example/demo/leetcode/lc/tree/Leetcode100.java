package com.example.demo.leetcode.lc.tree;

import com.example.demo.leetcode.datastructure.TreeNode;

/**
 * https://leetcode.cn/problems/same-tree/
 *
 * 相同的树
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 提示：
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -10^4 <= Node.val <= 10^4
 */
public class Leetcode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null&&q!=null){
            return false;
        }
        if(p!=null&&q==null){
            return false;
        }
        return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }
}
