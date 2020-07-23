package com.test.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTraversal102 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // TODO Auto-generated method stub

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(22);
        root.left.left.right = new TreeNode(33);
        root.right = new TreeNode(11);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(13);
        levelOrder(root);

    }

    public static List<List<Integer>> levelOrderBfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> traversalTree = new LinkedList<TreeNode>();
        traversalTree.add(root);

        List<Integer> subResult = new ArrayList<Integer>();
//        subResult.add(root.val);
//        result.add(subResult);
        int level = 0;
        LinkedList<TreeNode> levelNode = new LinkedList<TreeNode>();
        while (!traversalTree.isEmpty()) {
            TreeNode currentNode = traversalTree.poll();
            subResult.add(currentNode.val); 
            
            level++;
            if (currentNode != null && currentNode.left!= null) {
                levelNode.add(currentNode.left);
            } 
            if (currentNode != null && currentNode.right != null) {
                levelNode.add(currentNode.right);
            } 
            
//            if (currentNode.left != null) {
//                subResult.add(currentNode.left.val);
//            }
//            if (currentNode.right != null) {
//                subResult.add(currentNode.right.val);
//            }
            if (traversalTree.isEmpty()) {
                result.add(subResult);
                subResult = new ArrayList<Integer>();
                traversalTree.addAll(levelNode);
                levelNode = new LinkedList<TreeNode>();
            }

        }

        return result;

    }
    public static List<List<Integer>> levelOrderDfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfsHelper(root, 1, result);
        return result;

    }
    
    public static void dfsHelper(TreeNode node, int level, List<List<Integer>> result) {
        //terminator?
        if(node == null) return;
        
        if(result.size() < level) {
            result.add(new ArrayList<>());
        }
        
        //process current logic
        result.get(level-1).add(node.val);

        dfsHelper(node.left, level + 1, result);
        dfsHelper(node.right, level + 1, result);

    }
    
    static List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public static void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

         // fulfil the current level
         levels.get(level).add(node.val);

         // process child nodes for the next level
         if (node.left != null)
            helper(node.left, level + 1);
         if (node.right != null)
            helper(node.right, level + 1);
    }
    
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

}
