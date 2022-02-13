package com.yczuoxin.algorithm.test.dynamicprogram;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 */
public class MinimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        sub.add(2);
        triangle.add(new ArrayList<>(sub));

        sub = new ArrayList<>();
        sub.add(3);
        sub.add(4);
        triangle.add(new ArrayList<>(sub));

        sub = new ArrayList<>();
        sub.add(6);
        sub.add(5);
        sub.add(7);
        triangle.add(new ArrayList<>(sub));

        sub = new ArrayList<>();
        sub.add(4);
        sub.add(1);
        sub.add(8);
        sub.add(3);
        triangle.add(new ArrayList<>(sub));

        System.out.println(Solution.minimumTotal(triangle));

        sub = new ArrayList<>();
        sub.add(-10);
        triangle.add(new ArrayList<>(sub));
        System.out.println(Solution.minimumTotal(triangle));
    }


    static class Solution {
        public static int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] fmin = new int[n][n];
            fmin[0][0] = triangle.get(0).get(0);
            // 如果只有一个元素，下面的 j 越界
            if (triangle.size() == 1) {
                return fmin[0][0];
            }
            for (int i = 1; i < n; i++) {
                fmin[i][0] = fmin[i - 1][0] + triangle.get(i).get(0);
                for (int j = 1; j < i; j++) {
                    // 状态转移方程 fmin[i][j] = min(fmin[i − 1][j − 1], fmin[i − 1][j]) + c[i][j]
                    fmin[i][j] = Math.min(fmin[i - 1][j], fmin[i - 1][j - 1]) + triangle.get(i).get(j);
                }
                // 三角形右边的斜边会被忘记，所以要单独加入
                fmin[i][i] = fmin[i - 1][i - 1] + triangle.get(i).get(i);
            }
            // 遍历最后一行，找到最小的和
            int ans = fmin[n - 1][0];
            for (int i = 1; i < n; i++) {
                ans = Math.min(ans, fmin[n - 1][i]);
            }
            return ans;
        }
    }

}
