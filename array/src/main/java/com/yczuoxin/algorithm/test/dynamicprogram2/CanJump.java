package com.yczuoxin.algorithm.test.dynamicprogram2;

/**
 * 55 跳跃游戏
 *
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 */
public class CanJump {

    public static void main(String[] args) {
        System.out.println(Solution.canJump(new int[]{1,1,1,1,1,1,1,1,0,1}));
    }

    static class Solution {
        public static boolean canJump(int[] nums) {
            if (nums.length < 2) return true;
            int n = nums.length;
            // f 表示调到 i 需要的步数
            int[] f = new int[n + 1];
            int ans = nums[0];
            f[0] = ans;
            for (int i = 1; i < n; i++) {
                // 边界以及 [0,x] 的情况
                if (i > ans) return false;
                // 转移方程，i 是当前的位置，nums[i] 是能跳到的位置
                f[i] = Math.max(f[i - 1], i + nums[i]);
                ans = Math.max(f[i], ans);
                // 只要步数能达到下标是最后一个值的就可以
                if (ans >= n - 1) return true;
            }
            // 针对只有两个数字的，第一个数字不为0，就必然是 true
            return true;
        }
    }
}
