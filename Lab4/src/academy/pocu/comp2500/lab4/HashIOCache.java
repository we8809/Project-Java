package academy.pocu.comp2500.lab4;

import java.util.HashMap;
import java.util.Set;

public class HashIOCache<T> {
    class Node {
        Node prev;
        Node next;
        String key;

        public Node(String key) {
            this.key = key;
        }
    }

    private HashMap<T, Node> cache;
    private Node head;
    private Node tail;

    public HashIOCache() {
        this.head = new Node(null);
        this.tail = new Node(null);
        this.cache = new HashMap<T, Node>();

        this.head.next = tail;
        this.head.prev = head;
        this.tail.next = tail;
        this.tail.prev = head;
    }

    public void add(T key) {
        if (cache.containsKey(key)) {
            return;
        }

        Node newNode = new Node(key.toString());
        this.tail.prev.next = newNode;
        newNode.prev = this.tail.prev;
        this.tail.prev = newNode;
        newNode.next = this.tail;

        this.cache.put(key, newNode);
    }

    public String removeFirst() {
        if (this.cache.size() == 0) {
            return null;
        }

        Node removedNode = this.head.next;
        removedNode.prev.next = removedNode.next;
        removedNode.next.prev = removedNode.prev;

        this.cache.remove(removedNode.key);
        return removedNode.key;
    }

    public String removeLast() {
        if (this.cache.size() == 0) {
            return null;
        }

        Node removedNode = this.tail.prev;
        removedNode.prev.next = removedNode.next;
        removedNode.next.prev = removedNode.prev;

        this.cache.remove(removedNode.key);
        return removedNode.key;
    }

    public boolean contains(T key) {
        return (this.cache.containsKey(key));
    }

    public String remove(T key) {
        if (!contains(key)) {
            return null;
        }

        Node removedNode = this.cache.get(key);
        removedNode.prev.next = removedNode.next;
        removedNode.next.prev = removedNode.prev;

        this.cache.remove(removedNode.key);
        return removedNode.key;
    }

    public Set<T> keySet() {
        return this.cache.keySet();
    }

    public int size() {
        return (this.cache.size());
    }
}
