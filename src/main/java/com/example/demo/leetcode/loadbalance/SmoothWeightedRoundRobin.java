package com.example.demo.leetcode.loadbalance;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 平滑加权轮询
 */
public class SmoothWeightedRoundRobin {

    private List<Server> servers=new ArrayList<>();
    private List<Integer> weights=new ArrayList<>();
    private List<Integer> currentWeights=new ArrayList<>();
    private AtomicInteger currentIndex=new AtomicInteger(0);

    public void addServer(Server server,int weight){
        servers.add(server);
        weights.add(weight);
        currentWeights.add(weight);
    }

    public Server getNextServer() {
        int maxIndex = 0;
        int maxWeight= currentWeights.get(0);
        for (int i = 1; i < currentWeights.size(); i++) {
            if (maxWeight >= currentWeights.get(i)) {

            } else {
                maxIndex = i ;
                maxWeight=currentWeights.get(i);
            }
        }
        int plusWeight=0;
        for (int i = 0; i < currentWeights.size() ; i++) {
            if (i != maxIndex) {
                currentWeights.set(i, currentWeights.get(i) + weights.get(i));
                plusWeight+=weights.get(i);
            }
        }
        currentWeights.set(maxIndex, currentWeights.get(maxIndex) - plusWeight);
        return servers.get(maxIndex);
    }

    public static void main(String[] args) {
        SmoothWeightedRoundRobin loadBalancer = new SmoothWeightedRoundRobin();

        // 添加服务器和权重
        loadBalancer.addServer(new Server("Server1"), 5);
        loadBalancer.addServer(new Server("Server2"), 3);
        loadBalancer.addServer(new Server("Server3"), 2);

        // 模拟请求分发
        for (int i = 0; i < 20; i++) {
            Server server = loadBalancer.getNextServer();
            System.out.println("Request " + (i + 1) + " sent to " + server.getName());
        }
    }
}

