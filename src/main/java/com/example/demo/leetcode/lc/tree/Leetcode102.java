package com.example.demo.leetcode.lc.tree;

import com.example.demo.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 提示：
 *  树中节点数目在范围 [0, 2000] 内
 *  -1000 <= Node.val <= 1000
 */
public class Leetcode102 {
    // 保存层级信息很重要
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results=new ArrayList<>();
        levelHelper(results,root,0);
        return results;
    }

    public void levelHelper(List<List<Integer>> list, TreeNode root, int height) {
        if (root == null){
            return;
        }
        if (height >= list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(height).add(root.val);
        levelHelper(list, root.left, height + 1);
        levelHelper(list, root.right, height + 1);
    }
}
