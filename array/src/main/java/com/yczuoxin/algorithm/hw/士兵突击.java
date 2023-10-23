package com.yczuoxin.algorithm.hw;

import java.util.Scanner;

/**
 * 1、题目描述
 * 【士兵突击】
 * 在一个 M ∗ N 的街区中，有一个士兵 S 和一个敌人 E ， 标识 X 为无法通过的街区，标识 B 为可以通过的街区；
 * 士兵在一个单位时间内可以从一个街区移动到相邻的街区（土兵每次只能水平或者垂直方向移动一个街区）；
 * 士兵每次改变方向时，需要额外花费个 单位的时间（士兵第一次移动个街区的时候，不用考虑其初始方向，即只需要一个单位时间即可到达相邻街区）。
 * 计算士兵 S 最少需要多少时间才能到达 E 所在的街区。
 *
 * 【输入描述】
 * 第一行为两个数字，标识街区的大小，M行，N列；（1<=M，N <= 1000，M、N不同时为1）
 * 接下来M行，每行N个字母，字母S表示士兵所在街区，字母E表示敌人所在街区，字母X表示障碍，字母B表示可以经过的街区（只有一个S，一个E）
 *
 * 【输出描述】
 * 最少需要的时间，当士兵S永远无法到达敌人E所在街区时，输出-1
 *
 * 【示例一】
 * 输入：
 * 6 6
 * SBBBBB
 * BXXXXB
 * BBXBBB
 * XBBXXB
 * BXBBXB
 * BBXBEB
 *
 * 输出 ： 13
 * 说明：
 * 当士兵S沿左侧路线时，需要经过9个街区，改变方向7次，共16单位时间；
 * 当士兵S沿右侧路线时，需要经过11个街区，改变方向2次，共13单位时间；
 * 所以最少需要的时间为13
 */
public class 士兵突击 {

    private static final int[][] direction = new int[][]{{1, 0, 1}, {0, 1, 2}, {-1, 0, 3}, {0, -1, 4}};

    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();

            int x = 0;
            int y = 0;
            char[][] arr = new char[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j <n; j++) {
                    String str = in.next();
                    arr[i][j] = str.charAt(0);
                    if (str.equals("S")) {
                        x = i;
                        y = j;
                    }
                }
            }

            boolean[][] visit = new boolean[m][n];
            visit[x][y] = true;
            for (int[] ints : direction) {
                dfs(arr, visit, x + ints[0], y + ints[1], ints[2], 1);
            }
            if (result == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(result);
            }
        }
    }

    private static void dfs(char[][] arr, boolean[][] visit, int x, int y, int dirc, int step) {
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || visit[x][y] || arr[x][y] == 'X') {
            return;
        }
        if (arr[x][y] == 'E') {
            result = Math.min(result, step);
        }
        visit[x][y] = true;
        for (int[] ints : direction) {
            if (ints[2] != dirc) {
                dfs(arr, visit, x + ints[0], y + ints[1], ints[2], step + 2);
            } else {
                dfs(arr, visit, x + ints[0], y + ints[1], ints[2], step + 1);
            }
        }
        visit[x][y] = false;
    }

}
