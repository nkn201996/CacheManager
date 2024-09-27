package com.licious.cache.service;

import com.licious.cache.dao.LRUCache;
import com.licious.cache.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    // Cache Initialization
    private final LRUCache cache = new LRUCache(3);

    public void put(String k, String v) {
        cache.put(k, v);
    }

    public String get(String k) {
        return cache.get(k).orElseThrow(() -> new NotFoundException(k));
    }

}
