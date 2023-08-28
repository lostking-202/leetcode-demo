package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/insert-interval/
 *
 * 插入区间
 *
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 提示：
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 10^5
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 10^5
 */
public class Leetcode57 {

    @Test
    public void test(){
        int[][] intervals={{1,3},{6,9}};
        int[] newInrerval={2,5};
        System.out.println(insert(intervals,newInrerval));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] mergedIntervals=Arrays.copyOf(intervals,intervals.length+1);
        mergedIntervals[mergedIntervals.length-1]=newInterval;
        return merge(mergedIntervals);
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


