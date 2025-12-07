package org.jaideep.beserk300;

import java.util.*;

class Node {
    int key;
    int data;
    Node next;
    Node prev;

    Node(int key, int data) {
        this.key = key;
        this.data = data;
    }
}

class DoublyList {
    Node head;
    Node tail;
    int size;

    DoublyList() {
        head = null;
        tail = null;
        size = 0;
    }

    Node addNode(int key, int data) {
        Node node = new Node(key, data);
        node.prev = node.next = null;

        if(tail == null) { // empty list
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
        return node;
    }

    void remove(Node node) {
        if(node == null) return;

        if(node.prev != null) node.prev.next = node.next;
        else head = node.next; // node was head

        if(node.next != null) node.next.prev = node.prev;
        else tail = node.prev; // node was tail

        node.prev = node.next = null;
        size--;
    }

    Node removeFirst() { // remove LRU (head)
        if(head == null) return null;
        Node temp = head;
        remove(head);
        return temp;
    }
}

public class LRUCache {
    static int limit;
    static DoublyList cache;
    static Map<Integer, Node> tracker;

    LRUCache(int cap) {
        limit = cap;
        cache = new DoublyList();
        tracker = new HashMap<>();
    }

    public static int get(int key) {
        if(!tracker.containsKey(key)) return -1;

        Node node = tracker.get(key);
        cache.remove(node);       // move to tail
        cache.addNode(node.key, node.data);
        tracker.put(key, cache.tail); // update tracker to new node
        return node.data;
    }

    public static void put(int key, int value) {
        if(tracker.containsKey(key)) {
            Node node = tracker.get(key);
            node.data = value;
            cache.remove(node);
            cache.addNode(node.key, node.data);
            tracker.put(key, cache.tail);
        } else {
            if(cache.size >= limit) {
                Node lru = cache.removeFirst();
                tracker.remove(lru.key);
            }
            Node node = cache.addNode(key, value);
            tracker.put(key, node);
        }
    }
}
