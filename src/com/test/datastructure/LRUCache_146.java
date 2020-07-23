package com.test.datastructure;

import java.util.Hashtable;

public class LRUCache_146 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    class LinkedNode{
        int value;
        int key;
        LinkedNode prev;
        LinkedNode next;
    }
    
    Hashtable<Integer, LinkedNode> table = new Hashtable<>();
    int capacity;
    LinkedNode head;
    LinkedNode tail;
    int count;
    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        LinkedNode node = table.get(key);
        if(node == null) {
            return -1;
        }else {
            //move node to just after head
            moveAfterHead(node);
            return node.value;
        }
    }
    
    private void addNode(LinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    public void put(int key, int value) {
        if(table.get(key) != null) {
            table.get(key).value = value;
            moveAfterHead(table.get(key));
        } else {
            LinkedNode node = new LinkedNode();
            node.value = value;
            node.key = key;
            table.put(key, node);
            addNode(node);
            this.count ++;
            if(this.count > this.capacity) {
                LinkedNode lastNode = popLast();
                table.remove(lastNode.key);
                this.count --;
            }
        }

    }
    
    

    private LinkedNode popLast() {
        LinkedNode lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }

    private void moveAfterHead(LinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
   
}

