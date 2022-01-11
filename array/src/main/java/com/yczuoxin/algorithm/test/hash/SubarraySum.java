package com.yczuoxin.algorithm.test.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 */
public class SubarraySum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int k = 3;
        System.out.println(Solution.subarraySum(nums, k));
    }

    static class Solution {
        // 求连续的和，可以考虑用前缀和的方式解决
        public static int subarraySum(int[] nums, int k) {
            // key -> 前 n 项和，value -> 出现的次数
            int sum = 0;
            int count = 0;
            Map<Integer, Integer> mapping = new HashMap<>();
            // 默认 0 出现过一次
            mapping.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                // 如果前 n 项和有满足的条件的
                if (mapping.containsKey(sum - k)) {
                    count += mapping.get(sum - k);
                }
                // 并把前 n 项和为 sum 的次数维护在 mapping 中
                mapping.put(sum, mapping.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }

}
