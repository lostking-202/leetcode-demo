package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/
 *
 *  合并区间
 *
 *  以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *提示：
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 */
public class Leetcode56 {
    @Test
    public void test(){
        int[][] intervals={{1,4},{2,3}};
        int[][] res=merge2(intervals);
        System.out.println(res);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> Integer.valueOf(o[0])));
        int[][] results=new int[intervals.length][2];
        int index=0;
        for(int i=0;i<intervals.length;i++){
            int left=intervals[i][0];
            int right=intervals[i][1];
            if(index==0||results[index-1][1]<left){
                results[index]=new int[]{left,right};
                index++;
            }else{
                results[index-1][1]=Math.max(results[index-1][1],right);
            }
        }
        return Arrays.copyOf(results,index);

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> Integer.valueOf(o[0])));
        List<int[]> res=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int left=intervals[i][0];
            int right=intervals[i][1];
            // 下一个区间不需要与上一个未合并区间比，只需要与已合并区间的最后一个元素比
            if(res.size()==0||res.get(res.size()-1)[1]<left){
                res.add(new int[]{left,right});
            }else{
                res.get(res.size()-1)[1]=Math.max(right,res.get(res.size()-1)[1]);
            }
        }
        return res.toArray(new int[res.size()-1][]);
    }
}
