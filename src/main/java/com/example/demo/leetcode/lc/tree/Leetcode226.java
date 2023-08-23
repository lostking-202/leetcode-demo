package com.example.demo.leetcode.lc.tree;

import com.example.demo.leetcode.datastructure.TreeNode;

/**
 * https://leetcode.cn/problems/invert-binary-tree/
 *
 * 翻转二叉树
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 提示：
 *  树中节点数目范围在 [0, 100] 内
 *  -100 <= Node.val <= 100
 */
public class Leetcode226 {

    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            TreeNode left=root.left;
            TreeNode  right=root.right;
            root.left=right;
            root.right=left;
            invertTree(left);
            invertTree(right);
        }
        return root;
    }
}
