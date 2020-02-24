package com.test.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NaryTreeLevelOrderTraversal429 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Node node1 = new Node(5);
        Node node2 = new Node(6);
        List list1 = new ArrayList();
        list1.add(node1);
        list1.add(node2);
        Node node3 = new Node(3, list1);
        Node node4 = new Node(2);
        Node node5 = new Node(4);
        List list2 = new ArrayList();
        list2.add(node3);
        list2.add(node4);
        list2.add(node5);
        Node root = new Node(1, list2);

        List<List<Integer>> result = levelOrder(root);

    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        helper(root, 0, result);
        return result;
    }

    private static void helper(Node root, int i, List<List<Integer>> result) {
        List<Integer> levelList = null;
        if (result.size() > i) {
            levelList = result.get(i);
        }

        if (levelList == null) {
            levelList = new ArrayList<>();
            result.add(i, levelList);
        }
        levelList.add(root.val);
        int nextLevel = ++i;
        if (root.children != null) {
            for (Node node : root.children) {
                helper(node, nextLevel, result);
            }
        }
    }
    
    
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        List<Node> previousLayer = Arrays.asList(root);

        while (!previousLayer.isEmpty()) {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> previousVals = new ArrayList<>();
            for (Node node : previousLayer) {
                previousVals.add(node.val);
                currentLayer.addAll(node.children);
            }
            result.add(previousVals);
            previousLayer = currentLayer;
        }

        return result;
    }


}
