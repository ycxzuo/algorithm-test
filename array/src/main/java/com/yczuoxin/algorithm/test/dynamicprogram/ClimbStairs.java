package com.yczuoxin.algorithm.test.dynamicprogram;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(Solution.climbStairs(4));
    }

    static class Solution {
        public static int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int[] count = new int[n + 1];
            // 人工计算 1 节台阶和 2 节台阶的值
            count[1] = 1;
            count[2] = 2;
            for (int i = 3; i <= n; i++) {
                // 状态转移方程 f(i) = f(i - 1) + f(i - 2);
                count[i] = count[i - 2] + count[i - 1];
            }
            return count[n];
        }
    }

}
