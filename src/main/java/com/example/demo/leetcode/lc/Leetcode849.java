package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/maximize-distance-to-closest-person/
 *
 * 给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
 *
 * 至少有一个空座位，且至少有一人已经坐在座位上。
 *
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 *
 * 返回他到离他最近的人的最大距离。
 *
 * 提示：
 *  2 <= seats.length <= 2 * 10^4
 *  seats[i] 为 0 或 1
 *  至少有一个 空座位
 *  至少有一个 座位上有人
 */
public class Leetcode849 {
    @Test
    public void test(){
        int[] seats={1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(seats));
    }

    public int maxDistToClosest(int[] seats) {

        Map<Integer,Integer> map=new HashMap<>();
        int cur=seats.length-1;
        for(int i=0;i<seats.length;i++){

            if(seats[i]==1){
                cur=0;
                map.put(i,cur);
            }else{
                cur++;
                map.put(i,cur);
            }
        }
        cur=seats.length-1;
        for(int i=seats.length-1;i>=0;i--){

            if(seats[i]==1){
                cur=0;
                map.put(i,cur);
            }else{
                cur++;
                map.put(i,Math.min(map.get(i),cur));
            }
        }
        return map.values().stream().max(Integer::compareTo).get();
    }
}
