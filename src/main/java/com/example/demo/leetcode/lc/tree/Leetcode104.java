package com.example.demo.leetcode.lc.tree;

import com.example.demo.leetcode.datastructure.TreeNode;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 *
 * 二叉树的最大深度
 *
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * 提示：
 * 树中节点的数量在 [0, 10^4] 区间内。
 * -100 <= Node.val <= 100
 */
public class Leetcode104 {

    @Test
    public void test(){
        TreeNode treeNode=new TreeNode(3);
        System.out.println(maxDepth(treeNode));
    }

    public void plusOne(int i){
        i++;
    }

    public int maxDepth(TreeNode root) {
        int dep=0;
        return maxDepth(root,dep);
    }
    private int maxDepth(TreeNode root,int dep){
        if(root!=null){
            dep++;
            return Math.max(maxDepth(root.left,dep),maxDepth(root.right,dep));
        }else{
            return dep;
        }
    }
}
