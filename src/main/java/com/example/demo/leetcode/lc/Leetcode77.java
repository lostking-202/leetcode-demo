package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combinations/
 *
 *  组合
 *
 *  给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Leetcode77 {
    @Test
    public void test(){
        System.out.println(combine(4,2));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results=new ArrayList<>();
        boolean[] use=new boolean[n];
        backTrack(results,n,k,new ArrayList<Integer>(),use,1);
        return results;
    }

    private void backTrack(List<List<Integer>> results, int n, int k,ArrayList<Integer> result,boolean[] use,int start) {
        if(result.size()==k){
            results.add(new ArrayList<>(result));
            return;
        }
        for(int i=start;i<=n;i++){
            if(use[i-1]){
                continue;
            }
            result.add(i);
            use[i-1]=true;
            backTrack(results,n,k,result,use,i);
            result.remove(result.size()-1);
            use[i-1]=false;
        }
    }
}
