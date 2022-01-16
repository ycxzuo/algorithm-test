package com.yczuoxin.algorithm.test.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class PermuteUnique {

    public static void main(String[] args) {
        List<List<Integer>> lists = Solution.permuteUnique(new int[]{1, 1, 2});
        lists.forEach(System.out::println);
    }

    static class Solution {

        static List<List<Integer>> result = new ArrayList<>();

        public static List<List<Integer>> permuteUnique(int[] nums) {
            int count = nums.length;
            boolean[] used = new boolean[count];
            List<Integer> sub = new ArrayList<>(count);
            // 排序，将相同的值放到一起
            Arrays.sort(nums);
            chose(used, sub, nums, count);
            return result;
        }

        private static void chose(boolean[] used, List<Integer> sub, int[] nums, int count) {
            // 边界问题
            if (sub.size() == count) {
                result.add(new ArrayList<>(sub));
                return;
            }
            for (int i = 0; i < count; i++) {
                // 如果前面的值相同，并且前面的值都没有资格使用，那么后面的值都不许使用
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue;
                }
                // 处理
                sub.add(nums[i]);
                used[i] = true;
                chose(used, sub, nums, count);
                // 还原现场
                sub.remove(sub.size() - 1);
                used[i] = false;
            }
        }
    }
}
