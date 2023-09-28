package com.example.demo.leetcode.lc;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/maximum-enemy-forts-that-can-be-captured/?envType=daily-question&envId=2023-09-02
 *
 * 最多可以摧毁的敌人城堡数目
 *
 * 给你一个长度为 n ，下标从 0 开始的整数数组 forts ，表示一些城堡。forts[i] 可以是 -1 ，0 或者 1 ，其中：
 *
 * -1 表示第 i 个位置 没有 城堡。
 * 0 表示第 i 个位置有一个 敌人 的城堡。
 * 1 表示第 i 个位置有一个你控制的城堡。
 * 现在，你需要决定，将你的军队从某个你控制的城堡位置 i 移动到一个空的位置 j ，满足：
 *
 * 0 <= i, j <= n - 1
 * 军队经过的位置 只有 敌人的城堡。正式的，对于所有 min(i,j) < k < max(i,j) 的 k ，都满足 forts[k] == 0 。
 * 当军队移动时，所有途中经过的敌人城堡都会被 摧毁 。
 *
 * 请你返回 最多 可以摧毁的敌人城堡数目。如果 无法 移动你的军队，或者没有你控制的城堡，请返回 0 。
 *
 * 提示：
 * 1 <= forts.length <= 1000
 * -1 <= forts[i] <= 1
 */
public class Leetcode2511 {
    @Test
    public void test(){
        int[] forts={1,0,0,-1,0,0,-1,0,0,1};
        System.out.println(captureForts(forts));
    }

    public int captureForts(int[] forts) {
        int curMax=0;
        for(int i=0;i<forts.length;i++){
            int tower=0;
            if(forts[i]==1){
                for(int j=i+1;j<forts.length;j++){
                    if(forts[j]==0){
                        tower++;
                    }
                    if(forts[j]==-1){
                        curMax=Math.max(tower,curMax);
                        break;
                    }
                    if(forts[j]==1){
                        break;
                    }
                }
            }
        }
        for(int i=0;i<forts.length;i++){
            int tower=0;
            if(forts[i]==-1){
                for(int j=i+1;j<forts.length;j++){
                    if(forts[j]==0){
                        tower++;
                    }
                    if(forts[j]==1){
                        curMax=Math.max(tower,curMax);
                        break;
                    }
                    if(forts[j]==-1){
                        break;
                    }
                }
            }
        }
        return curMax;
    }
}
