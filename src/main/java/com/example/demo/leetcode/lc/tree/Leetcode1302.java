package com.example.demo.leetcode.lc.tree;

import com.example.demo.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/deepest-leaves-sum/
 *
 * 层数最深叶子节点的和
 *
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 *
 *提示：
 * 树中节点数目在范围 [1, 10^4] 之间。
 * 1 <= Node.val <= 100
 */
public class Leetcode1302 {

    public int deepestLeavesSum2(TreeNode root) {
        LinkedList<TreeNode> nodes=new LinkedList<>();
        int sum=0;
        if(root!=null){
            nodes.add(root);
        }
        while(!nodes.isEmpty()){
            int n=nodes.size();
            sum=0;
            for (int i=0;i<n;i++){
                TreeNode node=nodes.poll();
                if(node.left!=null){
                    nodes.add(node.left);
                }
                if(node.right!=null){
                    nodes.add(node.right);
                }
                sum+=node.val;
            }
        }
        return sum;
    }
    public int deepestLeavesSum(TreeNode root) {
        List<List<TreeNode>> nodeLists=new ArrayList<>();
        dfs(nodeLists,root,0);
        int sum=0;
        for(TreeNode n:nodeLists.get(nodeLists.size()-1)){
            sum+=n.val;
        }
        return sum;
    }

    private void dfs(List<List<TreeNode>> nodeLists, TreeNode root, int i) {
        if(root==null){
            return;
        }
        if(nodeLists.get(i)==null){
            List<TreeNode> ns=new ArrayList<>();
            nodeLists.add(ns);
        }
        nodeLists.get(i).add(root);
        dfs(nodeLists,root.left,i+1);
        dfs(nodeLists,root.right,i+1);
    }
}
