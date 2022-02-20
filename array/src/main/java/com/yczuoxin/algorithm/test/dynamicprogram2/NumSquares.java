package com.yczuoxin.algorithm.test.dynamicprogram2;

/**
 * 279 完全平方数
 *
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 */
public class NumSquares {

    public static void main(String[] args) {
        System.out.println(Solution.numSquares(11));
    }

    static class Solution {
        public static int numSquares(int n) {
            // f 表示调到 i 需要的步数
            int[] f = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                // 默认填充最大值
                int minValue = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    // 当做一个背包大小为 n 的背包问题，每次放入 j * j 的体积
                    minValue = Math.min(minValue, f[i - j * j]);
                }
                f[i] = minValue + 1;
            }
            return f[n];
        }
    }

}
