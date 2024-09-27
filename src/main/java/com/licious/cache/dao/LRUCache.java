package com.licious.cache.dao;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache {
    private final HashMap<String, Node> map = new HashMap<>();
    private final Node head = new Node("", "");
    private final Node tail = new Node("", "");

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private Lock writeLock = lock.writeLock();

    private Lock readLock = lock.readLock();

    int cap = 0;

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public Optional<String> get(String key) {
        readLock.lock();
        try {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                remove(node);
                insert(key, node.val);
                return Optional.of(node.val);
            }
            return Optional.empty();
        }finally {
            readLock.unlock();
        }

    }

    public void put(String key, String value) {
        writeLock.lock();
        try {
            if (map.containsKey(key)) {
                remove(map.get(key));
            } else if (cap == 0) {
                remove(tail.prev);
            } else {
                cap--;
            }
            insert(key, value);
        }finally {
            writeLock.unlock();
        }
    }

    public void insert(String key, String value) {
        // add this in starting
        Node temp = new Node(key, value);
        Node next = head.next;
        temp.next = next;
        temp.prev = head;
        head.next = temp;
        next.prev = temp;
        map.put(key, temp);
    }

    public void remove(Node temp) {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        map.remove(temp.key);
    }
}
