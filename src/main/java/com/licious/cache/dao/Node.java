package com.licious.cache.dao;

import lombok.Data;

@Data
public class Node {
    String val;
    String key;
    Node next;
    Node prev;

    Node(String key, String val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
