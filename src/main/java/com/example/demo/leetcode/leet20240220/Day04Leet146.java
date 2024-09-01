package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/lru-cache/description/
 */
public class Day04Leet146 {

    @Test
    public void test(){
        Map<Integer,Integer> map=new LinkedHashMap<>();
        map.put(1,1);
        map.put(2,2);
        System.out.println(map);
    }

}
class LRUCache {

    private LinkedHashMap<Integer,Integer> cache;
    private int maxLen;

    public LRUCache(int capacity) {
        cache=new LinkedHashMap<>(2);
        maxLen=capacity;
    }

    public int get(int key) {
        Integer value=cache.get(key);
        if(value==null){
            return -1;
        }else{
            cache.remove(key);
            cache.put(key,value);
            return value;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key,value);
        }else{
            if(cache.size()>=maxLen){
                cache.remove(cache.keySet().stream().findFirst().get());
            }
        }
        cache.put(key,value);
    }
}
