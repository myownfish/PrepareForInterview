package com.test.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTranversal144 {

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
//        preorderTraversal(root);
//        stackHelper(root);
        System.out.println(linkedListHelper(root));

    }

    // Pre-order tranversal:  root left right
    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        helper(root, result);
        return result;
    }

    //递归
    public static void helper(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            if (root.left != null) {
                helper(root.left, result);
            }
            
            if (root.right != null) {
                helper(root.right, result);
            }
        }
    }
    
    //stack: root left right
    public static List<Integer> stackHelper(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
//        stack.p
        return result;
    }
    
    public static List<Integer> linkedListHelper(TreeNode root) {
//        LinkedList<TreeNode> stack = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
          return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
          TreeNode node = stack.pop();
          output.add(node.val);
          if (node.right != null) {
            stack.add(node.right);
          }
          if (node.left != null) {
            stack.add(node.left);
          }
        }
        return output;

    }

}

