package com.example.demo.leetcode.lc.tree;

import com.example.demo.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/path-sum/
 *
 * 路径总和
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 提示：
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Leetcode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> sums=new ArrayList<>();
        if(root!=null){
            sums.add(root.val);
            dfs(sums,root);
        }
        return sums.contains(targetSum);
    }
    private void dfs(List<Integer> sums, TreeNode root){
        int val=sums.get(sums.size()-1);
        if(root.left!=null||root.right!=null){
            sums.remove(sums.size()-1);
            if(root.left!=null){
                sums.add(val+root.left.val);
                dfs(sums,root.left);
            }
            if(root.right!=null){
                sums.add(val+root.right.val);
                dfs(sums,root.right);
            }
        }
    }
}
