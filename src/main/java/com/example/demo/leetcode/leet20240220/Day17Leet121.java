package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class Day17Leet121 {

    public int maxProfit(int[] prices) {
        int sold=0;
        int minIndex=0;
        int maxIndex=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[maxIndex]){
                maxIndex=i;
                int curremtSold=prices[i]-prices[minIndex];
                sold=Math.max(sold,curremtSold);
            }
            if(prices[i]<prices[minIndex]){
                minIndex=i;
                maxIndex=i;
                if(maxIndex>minIndex){
                    int curremtSold=prices[maxIndex]-prices[minIndex];
                    sold=Math.max(sold,curremtSold);
                }else{
                    int curremtSold=prices[i]-prices[minIndex];
                    if(curremtSold>sold){
                        sold=curremtSold;
                        maxIndex=i;
                    }
                }
            }
        }
        return sold;
    }

    public int maxProfit2(int[] prices) {
        int hold=prices[0];
        int unhold=0;
        int max=unhold;
        for (int i=1;i<prices.length;i++){
            hold=Math.min(prices[i],hold);
            unhold=prices[i]-hold;
            max=Math.max(unhold,max);
        }
        return max;
    }

    public int maxProfit3(int[] prices) {
        int sold=0;
        int minIndex=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[minIndex]){
                minIndex=i;
            }
            int curremtSold=prices[i]-prices[minIndex];
            if(curremtSold>sold){
                sold=curremtSold;
            }
        }
        return sold;
    }

    @Test
    public void test(){
        int[] prices={7,2,5,3,6,4,1,9};
        System.out.println(maxProfit3(prices));
    }
}
