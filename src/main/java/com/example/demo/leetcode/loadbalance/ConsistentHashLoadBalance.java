package com.example.demo.leetcode.loadbalance;

import java.util.*;

/**
 * 一致性哈希算法
 */
public class ConsistentHashLoadBalance {

    private final int numberOfReplicas;
    private final TreeMap<Integer,String> circle;
    private final List<String> nodes;

    public ConsistentHashLoadBalance(int numberOfReplicas, List<String> nodes) {
        this.numberOfReplicas = numberOfReplicas;
        this.circle = new TreeMap<>();
        this.nodes = new ArrayList<>();
        for(String node:nodes){
            addNode(node);
        }
    }

    public void addNode(String node){
        nodes.add(node);
        for(int i=0;i<numberOfReplicas;i++){
            String virtualNode=node+"_"+i;
            int hash=getHash(virtualNode);
            circle.put(hash,node);
        }
    }

    private int getHash(String key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    public void removeNode(String node){
        nodes.remove(node);
        for(int i=0;i<numberOfReplicas;i++){
            String virtualNode=node+"_"+i;
            int hash=getHash(virtualNode);
            circle.remove(hash,node);
        }
    }

    public String getNode(String key){
        if(circle.isEmpty()){
            return null;
        }
        int hash=getHash(key);
        Map.Entry<Integer, String> entry = circle.ceilingEntry(hash);
        if (entry == null) {
            entry = circle.firstEntry();
        }

        return entry.getValue();
    }

    public static void main(String[] args) {
        ConsistentHashLoadBalance c=new ConsistentHashLoadBalance(3,List.of("Node1","Node2","Node3"));

        HashMap<String,String> map=new HashMap<>();
        map.put("1","1");
        for(int i=1;i<10;i++){
            System.out.println(c.getNode("Key"+i));
        }
    }



}
