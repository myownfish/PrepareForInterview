package com.test.datastructure;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverseList(node1);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        LinkedList<ListNode> l = new LinkedList<>();
        l.addFirst(new ListNode(head.val));
        while (head.next != null) {
            l.addFirst(new ListNode(head.next.val));
            head = head.next;
            l.getFirst().next = l.get(1);
        }
        l.getLast().next = null;
        ListNode first = l.getFirst();
        return l.getFirst();
//        Stack<ListNode> stack = new Stack<>();
//        stack.add(head);
//        while (head.next != null) {
//            stack.add(head.next);
//            head = head.next;
//        }
//        ListNode root = stack.pop();
//        helper(root, stack);
//        for (int i = stack.size() - 1; i >= 0; i--) {
//            ListNode currentTop = stack.get(i);
//            if (i != stack.size() - 1) {
//                stack.get(i + 1).next = currentTop;
//            }
//            if (i == 0) {
//                stack.get(i).next = null;
//            }
//        }
//        return root;
    }

    public static void helper(ListNode head, Stack<ListNode> stack) {
        
        if (stack.isEmpty()) {
            head.next = null;
            return;
        } else {
            head.next = stack.pop();
            helper(head.next, stack);

        }
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
