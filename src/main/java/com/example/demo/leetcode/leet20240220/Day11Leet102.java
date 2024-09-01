package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class Day11Leet102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results=new ArrayList<>();
        LinkedList<TreeNode> temp=new LinkedList<>();
        if(root==null){
            return results;
        }
        temp.add(root);
        getEveryLevel(results,temp);
        return results;
    }

    private void getEveryLevel(List<List<Integer>> results, LinkedList<TreeNode> temp) {
       if(temp.isEmpty()){
           return;
       }
       List<Integer> tempList=new ArrayList<>();
       int size= temp.size();
       for(int i=0;i<size;i++){
           TreeNode node=temp.poll();
           tempList.add(node.val);
           if(node.left!=null){
               temp.add(node.left);
           }
           if(node.right!=null){
               temp.add(node.right);
           }
       }
       results.add(tempList);
       getEveryLevel(results,temp);
    }

    @Test
    public void test(){
        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(9);
        TreeNode node3=new TreeNode(20);
        TreeNode node4=new TreeNode(15);
        TreeNode node5=new TreeNode(7);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        System.out.println(levelOrder(node1));
        /*LinkedList<TreeNode> list=new LinkedList<>();
        list.add(new TreeNode(9));
        list.add(new TreeNode(20));

        System.out.println(list.poll().val);

        System.out.println(list.poll().val);*/
    }
}
