package com.example.demo.leetcode.lc.tree;

import com.example.demo.leetcode.datastructure.TreeNode;
import com.sun.source.tree.Tree;

/**
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 *
 * 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class Leetcode111 {

    public int minDepth2(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=minDepth2(root.left);
        int right=minDepth2(root.right);
        return (left==0||right==0)?left+right+1:Math.min(left,right)+1;
    }

    public int minDepth(TreeNode root) {
        return minDepth(root,0);
    }

    private int minDepth(TreeNode root,int dep){
        if(root==null){
            return dep;
        }
        dep++;
        if(root.left==null&&root.right==null){
            return dep;
        }else if(root.left==null){
            return minDepth(root.right,dep);
        }else if(root.right==null){
            return minDepth(root.left,dep);
        }else{
            return Math.min(minDepth(root.left,dep),minDepth(root.right,dep));
        }
    }
}
