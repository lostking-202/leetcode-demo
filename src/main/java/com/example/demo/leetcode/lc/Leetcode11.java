package com.example.demo.leetcode.lc;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/container-with-most-water/
 *
 * 盛最多水的容器
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 提示：
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 */
public class Leetcode11 {

    @Test
    public void test(){
        int[] height={1,2,3,4,5,6,7,8,9};
        System.out.println(maxArea3(height));
    }

    public int maxArea(int[] height) {
        int curMax=0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                int max=(j-i)*Math.min(height[i],height[j]);
                curMax=Math.max(curMax,max);
            }
        }
        return curMax;
    }

    public int maxArea2(int[] height) {
        int i=0;
        int j=height.length-1;
        int currentWidth=j;
        int curMax=currentWidth*(Math.min(height[i],height[j]));
        while(i<j){
            currentWidth--;
            // 永远只需要移动短板
            if(height[i]>height[j]){
                curMax=Math.max(curMax,currentWidth*Math.min(height[i],height[j-1]));
                j--;
            }else{
                curMax=Math.max(curMax,currentWidth*Math.min(height[j],height[i+1]));
                i++;
            }
        }
        return curMax;
    }

    public int maxArea3(int[] height) {
        int i=0;
        int j=height.length-1;
        int curMax=0;
        while(i<j){
            curMax = height[i] < height[j] ?
                    Math.max(curMax, (j - i) * height[i++]):
                    Math.max(curMax, (j - i) * height[j--]);
            System.out.println(curMax);
        }
        return curMax;
    }
}
