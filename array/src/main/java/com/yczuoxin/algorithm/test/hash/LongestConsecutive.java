package com.yczuoxin.algorithm.test.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 中等
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        System.out.println(Solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    static class Solution {
        public static int longestConsecutive(int[] nums) {
            // 存放数字的容器，方便查找
            Set<Integer> intSet = new HashSet<>();
            for (int num : nums) {
                intSet.add(num);
            }
            // 最长连续长度维护，因为一个数字连续长度最小也是 1
            int longest = 1;
            for (Integer integer : intSet) {
                // 进行剪枝，如果比自己小 1 的都已经算过了，自己就不用再参与计算了
                if (!intSet.contains(integer - 1)) {
                    int size = 1;
                    int currentNum = integer;
                    // 如果容器中有比自己大 1 的数字，就找出最长的连续大小
                    while (intSet.contains(currentNum + 1)) {
                        currentNum++;
                        size++;
                    }
                    longest = Math.max(longest, size);
                }
            }
            return longest;
        }
    }

}
