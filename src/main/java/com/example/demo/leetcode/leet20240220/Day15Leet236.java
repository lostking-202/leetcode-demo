package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Day15Leet236 {

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        parent.put(root,null);
        queue.add(root);
        while(!parent.containsKey(p)||!parent.containsKey(q)){
            TreeNode node=queue.poll();
            if(node.left!=null){
                parent.put(node.left,node);
                queue.add(node.left);
            }
            if(node.right!=null){
                parent.put(node.right,node);
                queue.add(node.right);
            }
        }
        // 3,null 5,3 1,3
        Set<TreeNode> ancestors=new HashSet<>();
        while(p!=null){
            ancestors.add(p);
            p=parent.get(p);
        }
        while(!ancestors.contains(q)){
            q=parent.get(q);
        }
        return q;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }
        // root=7 root.left=null root.right.right=null null
        TreeNode left=lowestCommonAncestor2(root.left,p,q);
        TreeNode right=lowestCommonAncestor2(root.right,p,q);
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        return root;
    }

    @Test
    public void test1(){
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(5);
        TreeNode node3=new TreeNode(1);
        TreeNode node4=new TreeNode(6);
        TreeNode node5=new TreeNode(2);
        TreeNode node6=new TreeNode(0);
        TreeNode node7=new TreeNode(8);
        TreeNode node8=new TreeNode(7);
        TreeNode node9=new TreeNode(4);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.left=node6;
        node3.right=node7;
        node5.left=node8;
        node5.right=node9;
        System.out.println(lowestCommonAncestor2(node8,node9,node7).val);
    }
}
