package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-the-duplicate-number/
 *
 * 寻找重复数
 *
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * 提示：
 * 1 <= n <= 10^5
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *
 * 进阶：
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？
 */
public class Leetcode287 {
    // 1 2 3 4 5 6 7 7

    @Test
    public void test(){
        int[] nums={1,2,3,6,6,4,5};
        System.out.println(findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        // slow=1 fast=2
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
            System.out.print(slow);
            System.out.print("---");
            System.out.println(fast);
        }while (slow!=fast);
        System.out.println(slow);
        System.out.println("------------------------------");
        // 其实可以简单理解为第一个元素一定在环外，因为索引为0，不可能会有元素走到这里 i>=1
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
            System.out.print(slow);
            System.out.print("---");
            System.out.println(fast);
        }
        return slow;
    }
}
