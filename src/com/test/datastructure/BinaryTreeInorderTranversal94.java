package com.test.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTranversal94 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(22);
        root.left.left.right = new TreeNode(33);
        root.right = new TreeNode(11);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(13);
//        inorderTraversal(root);
        stackHelper(root);

    }

    // in-order tranversal: left root right
    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        helper(root, result);
        return result;
    }

    //递归
    public static void helper(TreeNode root, List<Integer> result) {
        if (root != null) {

            if (root.left != null) {
                helper(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                helper(root.right, result);
            }
        }
    }
    
    //stack
    public static List<Integer> stackHelper(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while(currentNode != null || !stack.isEmpty()) {
            while(currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return result;
    }

}

