package com.yczuoxin.algorithm.hw;

import java.util.Scanner;

/**
 * 1、题目描述
 * 【开心消消乐】
 * <p>
 * 给定一个N行M列的二维矩阵，矩阵中每个位置的数字取值为0或1。矩阵示例如：
 * 1100
 * 0001
 * 0011
 * 1111
 * <p>
 * 现需要将矩阵中所有的1进行反转为0，规则如下：
 * <p>
 * 1） 当点击一个1时，该1便被反转为0，同时相邻的上、下、左、右，以及左上、左下、右上、右下8 个方向的1（如果存在1）均会自动反转为0；
 * <p>
 * 2）进一步地，一个位置上的1被反转为0时，与其相邻的8个方向的1（如果存在1）均会自动反转为0；
 * <p>
 * 按照上述规则示例中的矩阵只最少需要点击2次后，所有值均为0。请问，给定一个矩阵，最少需要点击几次后，所有数字均为0？
 * <p>
 * 【输入描述】
 * 第一行输入两个整数，分别表示矩阵的行数 N 和列数 M，取值范围均为 [1,100]。接下来 N 行表示矩阵的初始值，每行均为 M 个数，取值范围 [0,1]。
 * <p>
 * 【输出描述】
 * 输出一个整数，表示最少需要点击的次数。
 * <p>
 * 【实例一】
 * 输入：
 * 3 3
 * 1 0 1
 * 0 1 0
 * 1 0 1
 * <p>
 * 输出： 1，说明：上述样例中，四个角上的1均在中间的1的相邻8个方向上，因此只需要点击一次即可。
 */
public class 开心消消乐 {

    private static int[][] direction = new int[][]{{1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            // 行数
            int n = in.nextInt();
            // 列数
            int m = in.nextInt();
            // 组装数据
            int [][] table = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    table[i][j] = in.nextInt();
                }
            }

            int result = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (table[i][j] == 1) {
                        // 8 个方向的深度优先
                        dfs(table, i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void dfs(int[][] table, int i, int j) {
        // 边界判断
        if (i < 0 || i >= table.length || j < 0 || j >= table[0].length || table[i][j] == 0) {
            return;
        }
        // 将 1 翻转为 0
        table[i][j] = 0;
        for (int[] direction : direction) {
            dfs(table, i + direction[0], i + direction[1]);
        }
    }

}
