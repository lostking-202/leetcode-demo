package com.example.demo.leetcode.lc;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum/
 *
 * 组合总和
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 提示：
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 */
public class Leetcode39 {

    @Test
    public void test(){
        int[] candidates={2,3,7};
        System.out.println(combinationSum(candidates,7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results=new ArrayList<>();
        backTrack(results,candidates,target,new ArrayList<Integer>(),0);
        return results;
    }

    private void backTrack(List<List<Integer>> results, int[] candidates, int target, ArrayList<Integer> integers,int start) {
        if(target==0){
            results.add(new ArrayList<>(integers));
            return;
        }

        // 每个位置可以重复选，但是选了后面的就不选前面的了
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>target){
                continue;
            }
            integers.add(candidates[i]);
            backTrack(results,candidates,target-candidates[i],integers,i);
            integers.remove(integers.size()-1);
        }
    }
}
