package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/summary-ranges/
 *
 * 汇总区间
 *
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * 提示：
 * 0 <= nums.length <= 20
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 */
public class Leetcode228 {
    @Test
    public void test(){
        int[] nums={0,2,3,4,6,8,9};
        System.out.println(summaryRanges2(nums));
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> results=new ArrayList<>();
        if(nums==null||nums.length==0){
            return results;
        }
        for(int i=0;i<nums.length;){
            int left=i;
            i++;
            while(i<nums.length&&nums[i]-nums[i-1]==1){
                i++;
            }
            int right=i-1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[left]));
            if (left < right) {
                temp.append("->");
                temp.append(String.valueOf(nums[right]));
            }
            results.add(temp.toString());
        }
        return results;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> results=new ArrayList<>();
        if(nums==null||nums.length==0){
            return results;
        }
        int i=0;
        int n=nums.length;
        while(i<n){
            int left=i;
            i++;
            while(i<n&&nums[i]-nums[i-1]==1){
                i++;
            }
            int right=i-1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[left]));
            if (left < right) {
                temp.append("->");
                temp.append(String.valueOf(nums[right]));
            }
            results.add(temp.toString());
        }
        return results;
    }
}
