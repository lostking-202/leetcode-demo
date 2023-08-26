package com.example.demo.leetcode.lc.dp;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 *
 * 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 提示：
 *  1 <= prices.length <= 10^5
 *  0 <= prices[i] <= 10^4
 */
public class Leetcode121 {

    @Test
    public void test(){
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit3(prices));
    }
























    public int maxProfit3(int[] prices){
        int hold=prices[0];
        int unhold=0;
        int max=unhold;
        for(int i=1;i< prices.length;i++){
            hold=Math.min(hold,prices[i]);
            unhold=prices[i]-hold;
            max=Math.max(max,unhold);
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        //很明显我们可以得出
        //dp[i][0]=max(dp[i-1][0],dp[i-1][1]+prices[i]);
        //同理我们可以得出第i+1天结束的时候我们持有股票的最大利润
        //dp[i][1]=max(dp[i -1][1], -prices[i])；
        //边界条件就是第1天的时候，如果我们不持有股票，那么
        //dp[0][0]=0;
        //如果持有股票，那么
        //dp[0][1]=-prices[0]=-7

        //dp[1][0]=max(dp[0][0],dp[0][1]+price[1])=-6
        //dp[1][1]=max(dp[0][1], -prices[1])=-prices[1]=-1

        //dp[2][0]=max(dp[1][0],dp[1][1]+price[2])=4
        //dp[2][1]=max(dp[1][1], -prices[2])=-1

        //dp[3][0]=max(dp[2][0],dp[2][1]+price[3])=4
        //dp[3][1]=max(dp[2][1], -prices[3])=-1
        int[] max=new int[prices.length];
        max[0]=0;
        int curMax=0;
        for(int i=1;i<prices.length;i++){
            max[i]=0;
            for(int j=0;j<i;j++){
                max[i]=Math.max(max[i],prices[i]-prices[j]);
            }
            curMax=Math.max(max[i],curMax);
        }
        return curMax;
    }

    // 保持持有最小，出手-持有最大
    public int maxProfit2(int[] prices) {
        //很明显我们可以得出
        //dp[i][0]=max(dp[i-1][0],dp[i-1][1]+prices[i]);
        //同理我们可以得出第i+1天结束的时候我们持有股票的最大利润
        //dp[i][1]=max(dp[i -1][1], -prices[i])；
        //边界条件就是第1天的时候，如果我们不持有股票，那么
        //dp[0][0]=0;
        //如果持有股票，那么
        //dp[0][1]=-prices[0]=-7

        //dp[1][0]=max(dp[0][0],dp[0][1]+price[1])=-6
        //dp[1][1]=max(dp[0][1], -prices[1])=-prices[1]=-1

        //dp[2][0]=max(dp[1][0],dp[1][1]+price[2])=4
        //dp[2][1]=max(dp[1][1], -prices[2])=-1

        //dp[3][0]=max(dp[2][0],dp[2][1]+price[3])=4
        //dp[3][1]=max(dp[2][1], -prices[3])=-1
        if(prices==null||prices.length<2){
            return 0;
        }
        int hold=prices[0];
        int unhold=0;
        for(int i=1;i<prices.length;i++){
            unhold=Math.max(unhold,prices[i]-hold);
            hold=Math.min(hold,prices[i]);
        }
        return unhold;
    }
}
