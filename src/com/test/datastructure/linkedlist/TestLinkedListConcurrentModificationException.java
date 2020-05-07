package com.test.datastructure.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TestLinkedListConcurrentModificationException {

    public static void main(String[] args) {

        LinkedList<String> l = new LinkedList<>();
        l.add("first");
        l.add("second");
        l.add("third");
        /*
         * if the list is structurally modified at any time after the Iterator is
         * created, in any way except through the list-iterator's own {@code remove} or
         * {@code add} methods, the list-iterator will throw a {@code
         * ConcurrentModificationException}. Thus, in the face of concurrent
         * modification, the iterator fails quickly and cleanly, rather than risking
         * arbitrary, non-deterministic behavior at an undetermined time in the future.
         * 
         * structurally modified: means it is add/deleted, the length of the list is changed.
         * update the value is not a structually modification.
         * So l.set(0, "firstchange"); will not cause ConcurrentModificationException.
         * In ListItr, it has a variable called expectedModCount which is initialied with the modCount of
         * Linkedlist. When iterator calls next(), add(), remove() and ect, it will check whether expectedModCount
         * is the same as modCount. if not means, the List is changed after iterator is created, it will
         * throw ConcurrentModificationException.
         * 
         */
        ListIterator<String> iterator = l.listIterator();
        iterator.next();
        l.remove(); //will cause ConcurrentModificationException
//        l.set(0, "firstchange"); ////will not cause ConcurrentModificationException
        iterator.set("test");
//        iterator.next();
//        iterator.add("fourth");
//        iterator.remove();
    }

}
