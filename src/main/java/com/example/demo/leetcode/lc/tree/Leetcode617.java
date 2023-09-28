package com.example.demo.leetcode.lc.tree;

import com.example.demo.leetcode.datastructure.TreeNode;

/**
 * https://leetcode.cn/problems/merge-two-binary-trees/
 *
 * 合并二叉树
 *
 * 给你两棵二叉树： root1 和 root2 。
 *
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。

 * 返回合并后的二叉树。
 *
 * 注意: 合并过程必须从两个树的根节点开始。
 *
 * 提示：
 * 两棵树中的节点数目在范围 [0, 2000] 内
 * -104 <= Node.val <= 104
 */
public class Leetcode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        TreeNode head=new TreeNode(root1.val+root2.val);
        mergeTrees(root1,root2,head);
        return head;
    }

    public void mergeTrees(TreeNode root1, TreeNode root2,TreeNode head) {
        if(root1.left!=null&&root2.left!=null){
            head.left=new TreeNode(root1.left.val+root2.left.val);
            mergeTrees(root1.left,root2.left,head.left);
        }
        if(root1.left!=null&&root2.left==null){
            head.left=root1.left;
        }
        if(root1.left==null&&root2.left!=null){
            head.left=root2.left;
        }


        if(root1.right!=null&&root2.right!=null){
            head.right=new TreeNode(root1.right.val+root2.right.val);
            mergeTrees(root1.right,root2.right,head.right);
        }
        if(root1.right!=null&&root2.right==null){
            head.right=root1.right;
        }
        if(root1.right==null&&root2.right!=null){
            head.right=root2.right;
        }
    }
}
