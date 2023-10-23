package com.yczuoxin.algorithm.hw;

import java.util.Scanner;

/**
 * 1、题目描述
 * 【西天取经】
 * 唐僧师徒四人去西天取经，一路翻山越岭。一日，师徒四人途径一个 mxn 长方形区域，已知
 * 1.将取经队伍作为一个整体，4 人行走相同路线。
 * 2.取经队伍的起点为该长方形区域的左上角，目的地为该长方形区域的右下角
 * 3.行走路线可以向前、后、左、右四个方向前进 (不允许超出该长方形区域)
 * 4.输入包含该区域的长 m 和宽 n、前后移动允许的高度差 t，以及该长方形区域内各点的高度 h。
 * 5.要求该区域内相邻两次移动的高度差在高度 t 范围以内。取经队伍最多有 3 次爆发机会，每使用一次爆发机会，可以让取经队伍一次移动突破高度差限制
 * 请问取经队伍通过该区域最小的移动次数是多少？返回 -1 表示师徒四人无法直接通过该区域。
 *
 * 【输入描述】
 * 输入第一行为三个整数，分别对应为长方形场地的两条边长，和前后移动允许的高度差。三个整数之间以空格分割。
 * 后面是m行，每行n列个数据，表示长方形场地各点的高度。数据之间以空格分割。
 * 0<m，n<=200，0<t<=20
 * 每个点的高度hin满足0<=h[i,j]<=4000，0<=i<m 0<=j<n。
 *
 * 【输出描述】
 * 取经队伍通过该区域最小的移动次数
 *
 * 【示例一】
 * 4 4 10
 * 10 20 30 40
 * 100 120 140 160
 * 200 230 260 290
 * 300 400 500 600
 * 输出
 * 6
 *
 * 【示例二】
 * 输入
 * 1 10 1
 * 11 12 200 14 15 16 317 18 19 20
 * 输出
 * -1
 */
public class 西天取经 {

    private static int[][] directions = {{1, 0,}, {0, 1,}, {-1, 0}, {0, -1}};

    private static int m, n, max;

    private static int minStep;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            m = in.nextInt();
            n = in.nextInt();
            max = in.nextInt();

            minStep = Integer.MAX_VALUE;
            // 组装数据
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            boolean[][] visited = new boolean[m][n];
            dfs(arr, 0, 0, 0, visited, 3);

            if (minStep < 0) {
                System.out.println("-1");
            } else {
                System.out.println(minStep);
            }
        }
    }

    /**
     *
     *
     * @param arr   数据
     * @param x
     * @param y
     * @param step  走过的步数
     * @param visited   是否走过
     * @param boom  爆发次数
     */
    private static void dfs(int[][] arr, int x, int y, int step, boolean[][] visited, int boom) {
        // 边界问题
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || step < 0) {
            return;
        }
        // 到达目标位置
        if (x == m -1 && y == n - 1) {
            minStep = Math.min(minStep, step);
            return;
        }
        // 标记到达过
        visited[x][y] = true;
        // 四个方向递归
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            // 边界
            if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]) {
                continue;
            }
            // 高度差
            int height = Math.abs(arr[x][y] - arr[newX][newY]);

            if (height <= max) {
                dfs(arr, newX, newY, step + 1, visited, boom);
            } else {
                if (boom <= 0) {
                    continue;
                }
                dfs(arr, newX, newY, step + 1, visited, boom - 1);
            }
        }
        visited[x][y] = false;
    }

}
