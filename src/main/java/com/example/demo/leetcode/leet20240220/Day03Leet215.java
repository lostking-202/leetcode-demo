package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Day03Leet215 {
    public int findKthLargest(int[] nums, int k) {
        return  Arrays.stream(nums).sorted().boxed().collect(Collectors.toList()).get(nums.length-k);
    }
    @Test
    public void test1(){
        int[] nums={3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2));
    }
}
