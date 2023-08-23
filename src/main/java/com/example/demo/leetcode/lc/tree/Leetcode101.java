package com.example.demo.leetcode.lc.tree;

import com.example.demo.leetcode.datastructure.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/symmetric-tree/
 *
 * 对称二叉树
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 提示：
 *  树中节点数目在范围 [1, 1000] 内
 *  -100 <= Node.val <= 100
 */
public class Leetcode101 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        return left.val==right.val&&isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }
}
