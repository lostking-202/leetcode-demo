package com.example.demo.leetcode.lc.tree;

import com.example.demo.leetcode.datastructure.TreeNode;

/**
 * https://leetcode.cn/problems/count-good-nodes-in-binary-tree/
 *
 * 统计二叉树中好节点的数目
 *
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 *
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 *
 * 提示：
 * 二叉树中节点数目范围是 [1, 10^5] 。
 * 每个节点权值的范围是 [-10^4, 10^4] 。
 */
public class Leetcode1448 {

    public int goodNodes(TreeNode root) {
        int[] nums=new int[1];
        int max=0;
        if(root!=null){
            nums[0]++;
            max=root.val;
            goodNodes(nums,root.left,max);
            goodNodes(nums,root.right,max);
        }
        return nums[0];
    }
    private void goodNodes(int[] nums, TreeNode root,int max){
        if(root==null){
            return;
        }
        if(root.val>=max){
            max=root.val;
            nums[0]++;
        }
        goodNodes(nums,root.left,max);
        goodNodes(nums,root.right,max);
    }

}
