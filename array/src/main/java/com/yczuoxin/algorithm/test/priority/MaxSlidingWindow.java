package com.yczuoxin.algorithm.test.priority;

import javafx.util.Pair;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] ints = Solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    static class Solution {
        public static int[] maxSlidingWindow(int[] nums, int k) {
            PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>((pair1, pair2) -> Objects.equals(pair1.getKey(), pair2.getKey()) ? pair2.getValue() - pair1.getValue() : pair2.getKey() - pair1.getKey());
            // 先填充小根堆
            for (int i = 0; i < k; i++) {
                q.add(new Pair<>(nums[i], i));
            }
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            ans[0] = q.peek().getKey();
            for (int i = k; i < n; i++) {
                // 放入小根堆
                q.add(new Pair<>(nums[i], i));
                // 去除下标已经越界的数据
                while (!q.isEmpty() && q.peek().getValue() <= i - k) {
                    q.poll();
                }
                ans[i - k + 1] = q.peek().getKey();
            }
            return ans;
        }
    }
}
