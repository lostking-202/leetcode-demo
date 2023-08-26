package com.example.demo.leetcode.lc.tree;

import com.example.demo.leetcode.datastructure.TreeNode;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/
 *
 * 验证二叉搜索树
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 提示：
 * 树中节点数目范围在[1, 10^4] 内
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class Leetcode98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root,long minVal,long maxVal){
        if(root==null){
            return true;
        }
        if(root.val>=maxVal||root.val<=minVal){
            return false;
        }
        return isValidBST(root.left,minVal,root.val)&&isValidBST(root.right,root.val,maxVal);
    }
}
