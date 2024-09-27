package com.licious.cache.controller.rest;

import com.licious.cache.dto.CacheData;
import com.licious.cache.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cache")
public class CacheController {
    private final CacheService cacheService;

    @Autowired
    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping()
    public ResponseEntity<String> getValue(@RequestParam String key) {
        return ResponseEntity.ok("{\"value\" : \""+cacheService.get(key)+"\"}");
    }

    @PutMapping()
    public ResponseEntity<?> updateValue(@RequestBody CacheData cacheData) {
        cacheService.put(cacheData.getKey(), cacheData.getValue());
        return ResponseEntity.noContent().build();
    }
}
