package com.test.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTranversal145 {

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
        List<Integer> result1 = postorderTraversal(root);
        List<Integer> result2 = stackHelper(root);
        System.out.println(result1.equals(result2));

    }

    // post-order tranversal: left  right  root
    public static List<Integer> postorderTraversal(TreeNode root) {

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
            if (root.right != null) {
                helper(root.right, result);
            }
            result.add(root.val);
        }
    }
    
    //stack
    public static List<Integer> stackHelper(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
          return output;
        }
        
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if(node.left != null) {
                stack.add(node.left);
            }
            if(node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
        
    }
    
}

