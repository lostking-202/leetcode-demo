package com.example.demo.leetcode.loadbalance;

import java.util.List;
import java.util.Random;

/**
 * 随机算法
 */
public class RandomLoadBalance {

    private List<String> nodes;

    public RandomLoadBalance(List<String> nodes){
        this.nodes=nodes;
    }

    public String selectNode(){
        Random random=new Random();
        int index=random.nextInt(nodes.size());
        return nodes.get(index);
    }

    public static void main(String[] args) {
        List<String> nodes=List.of("A","B","C");

        RandomLoadBalance rlb=new RandomLoadBalance(nodes);
        for(int i=1;i<10;i++){
            System.out.println(rlb.selectNode());
        }
    }
}
