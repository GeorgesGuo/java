package com;

import java.util.LinkedList;
import java.util.Queue;

public class level {

    class TreeNode{
        char value;
        TreeNode left;
        TreeNode right;
        public TreeNode(char value){
            this.value=value;
        }
    }
    /*
    层次遍历输出⼆叉树：给定⼀个整数⼆叉树，要求从上往下输出每层的元素值。
    */
    public void level (TreeNode root){
        if(root == null){
            return;
        }
        LinkedList<TreeNode>queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node +" ");
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }
}
