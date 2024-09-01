package com.example.demo.leetcode.leet20240220;

/**
 * https://leetcode.cn/problems/symmetric-tree/
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class Day21Leet101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null&&right!=null){
            return false;
        }
        if(right==null&&left!=null){
            return false;
        }
        return left.val==right.val&&isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }
}
