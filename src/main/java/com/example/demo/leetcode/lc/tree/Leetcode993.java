package com.example.demo.leetcode.lc.tree;

import com.example.demo.leetcode.datastructure.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/cousins-in-binary-tree/
 *
 * 二叉树的堂兄弟节点
 *
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 *提示：
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 */
public class Leetcode993 {

    public boolean isCousins2(TreeNode root, int x, int y) {
        // 不需要收集所有层信息
        // 每次收集一层节点的信息就可以了，相当于同时拿到下一层的信息
        List<List<TreeNode>> nodes=new ArrayList<>();
        List<List<Integer>> values=new ArrayList<>();
        dfs(nodes,values,root,0);
        for(int i=0;i<values.size();i++){
            if (values.get(i).contains(x)&&values.get(i).contains(y)){
                if(i>0){
                   for(TreeNode node:nodes.get(i-1)){
                       if(node.left!=null&&node.right!=null){
                           if((node.left.val==x&&node.right.val==y)||((node.left.val==y&&node.right.val==x))){
                               return false;
                           }
                       }
                   }
                }
                return true;
            }
        }
        return false;
    }

    private void dfs(List<List<TreeNode>> nodes, List<List<Integer>> values, TreeNode root, int i) {
        if(root==null){
            return;
        }
        if(nodes.get(i)==null){
            List<TreeNode> node=new ArrayList<>();
            nodes.add(node);
            List<Integer> value=new ArrayList<>();
            values.add(value);
        }
        nodes.get(i).add(root);
        values.get(i).add(root.val);
        dfs(nodes,values,root.left,i+1);
        dfs(nodes,values,root.right,i+1);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        // 每次只存储当前层
        LinkedList<TreeNode> queue=new LinkedList<>();
        LinkedList<Integer> value=new LinkedList<>();
        queue.add(root);
        value.add(root.val);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode poll=queue.poll();
                if(poll.left!=null&&poll.right!=null){
                    if ((poll.left.val == x && poll.right.val == y) || (poll.left.val == y && poll.right.val == x)) {
                        return false;
                    }
                }
                if(poll.left!=null){
                    queue.offer(poll.left);
                    value.offer(poll.left.val);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                    value.offer(poll.right.val);
                }
            }
            if(value.contains(x)&&value.contains(y)){
                return true;
            }
            value.clear();
        }
        return false;
    }
}
