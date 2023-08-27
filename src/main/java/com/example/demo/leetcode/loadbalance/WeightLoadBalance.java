package com.example.demo.leetcode.loadbalance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 权重随机算法
 */
public class WeightLoadBalance {

    private List<Server> servers=new ArrayList<>();

    private List<Integer> weights=new ArrayList<>();

    public void addServer(Server server,int weight){
        servers.add(server);
        weights.add(weight);
    }

    public Server getServer(){
        int totalWeight=weights.stream().mapToInt(Integer::intValue).sum();
        Random r=new Random();
        int res=r.nextInt(totalWeight)+1;
        int cWeight=0;
        int index=0;
        for(int i=0;i<servers.size();i++){
            cWeight+=weights.get(i);
            if(cWeight>=res){
                index=i;
                break;
            }
        }
        return servers.get(index);
    }

    public static void main(String[] args) {
        WeightLoadBalance loadBalancer = new WeightLoadBalance();

        // 添加服务器和权重
        loadBalancer.addServer(new Server("Server1"), 3);
        loadBalancer.addServer(new Server("Server2"), 2);
        loadBalancer.addServer(new Server("Server3"), 1);

        // 模拟请求分发
        for (int i = 0; i < 100; i++) {
            Server server = loadBalancer.getServer();
            System.out.println("Request " + (i + 1) + " sent to " + server.getName());
        }
    }

}

