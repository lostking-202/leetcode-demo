package com.example.demo.leetcode.lc;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/number-of-ways-to-buy-pens-and-pencils/
 *
 * 买钢笔和铅笔的方案数
 *
 * 给你一个整数 total ，表示你拥有的总钱数。同时给你两个整数 cost1 和 cost2 ，分别表示一支钢笔和一支铅笔的价格。你可以花费你部分或者全部的钱，去买任意数目的两种笔。
 *
 * 请你返回购买钢笔和铅笔的 不同方案数目 。
 *
 *提示：
 * 1 <= total, cost1, cost2 <= 10^6
 */
public class Leetcode2204 {

    @Test
    public void test(){
        System.out.println(waysToBuyPensPencils(10,99,9));
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long way=1l;
        if(total<cost1&&total<cost2){
            return way;
        }
        return Math.max(waysToBuyPensPencils(total,cost1,cost2,way),waysToBuyPensPencils(total,cost2,cost1,way));
    }

    private long waysToBuyPensPencils(int total,int cost1,int cost2,long way){
        int m=total/cost1;
        for(int i=0;i<m;i++){
            way+=(total-cost1*i)/cost2+1;
        }
        return way;
    }
}
