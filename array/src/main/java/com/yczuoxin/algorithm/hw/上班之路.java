package com.yczuoxin.algorithm.hw;

import java.util.Scanner;

/**
 * Jungle 生活在美丽的蓝鲸城，大马路都是方方正正，但是每天马路的封闭情况都不一样。
 * 地图由以下元素组成：
 * 1）”.” — 空地，可以达到;
 * 2）”*” — 路障，不可达到;
 * 3）”S” — Jungle的家;
 * 4）”T” — 公司.
 * 其中我们会限制Jungle拐弯的次数，同时Jungle可以清除给定个数的路障，现在你的任务是计算Jungle是否可以从家里出发到达公司。
 * <p>
 * 【输入描述】
 * 输入的第一行为两个整数t,c（0<=t,c<=100）, t代表可以拐弯的次数，c代表可以清除的路障个数。
 * 输入的第二行为两个整数n,m（1<=n,m<=100）,代表地图的大小。
 * 接下来是n行包含m个字符的地图。n和m可能不一样大。
 * 我们保证地图里有S和T。
 * <p>
 * 【输出描述】
 * 输出是否可以从家里出发到达公司，是则输出YES，不能则输出NO。
 * <p>
 * 【示例1】
 * 输入：
 * <p>
 * 2 0
 * 5 5
 * ..S..
 * ****.
 * T....
 * ****.
 * .....
 * 输出：
 * YES
 * <p>
 * 【示例2】
 * 输入：
 * <p>
 * 1 2
 * 5 5
 * .*S*.
 * *****
 * ..*..
 * *****
 * T....
 * 输出： NO
 */
public class 上班之路 {

    /**
     * {横坐标方位，纵坐标方位，面向方向}
     */
    private static int[][] directions = {{1, 0, 1}, {0, 1, 2}, {-1, 0, 3}, {0, -1, 4}};

    private static char[][] chars;

    private static int rows, cols, maxTurns, maxDestroy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            maxTurns = scanner.nextInt();
            maxDestroy = scanner.nextInt();

            rows = scanner.nextInt();
            cols = scanner.nextInt();

            chars = new char[rows][cols];

            for (int i = 0; i < rows; i++) {
                String string = scanner.next();
                chars[i] = string.toCharArray();
            }

            int sx = 0, sy = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if ('S' == chars[i][j]) {
                        sx = i;
                        sy = j;
                        break;
                    }
                }
            }
            if ('S' != chars[sx][sy]) {
                System.out.println("No");
            }
            boolean[][] visit = new boolean[rows][cols];
            if (dfs(sx, sy, 0, 0, 0, visit)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    /**
     * 深度优先遍历
     *
     * @param x        当前 x 坐标
     * @param y        当前  坐标
     * @param turns    转弯次数
     * @param destroy  毁坏障碍次数
     * @param dispatch 面朝放向
     * @param visit    是否走过
     * @return
     */
    private static boolean dfs(int x, int y, int turns, int destroy, int dispatch, boolean[][] visit) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return false;
        }
        if ('T' == (chars[x][y])) {
            return true;
        }
        visit[x][y] = true;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY= y + direction[1];
            if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || visit[newX][newY]) {
                continue;
            }
            if (chars[newX][newY] == '*') {
                if (destroy >= maxDestroy) {
                    continue;
                }
                if (dispatch == 0 || dispatch == direction[2]) {
                    if (dfs(newX, newY, turns, destroy + 1, direction[2], visit)) {
                        return true;
                    }
                } else {
                    if (turns >= maxTurns) {
                        continue;
                    }
                    dfs(newX, newY, turns + 1, destroy + 1, direction[2], visit);
                }
            } else {
                if (dispatch == 0 || dispatch == direction[2]) {
                    if (dfs(newX, newY, turns, destroy, direction[2], visit)) {
                        return true;
                    }
                } else {
                    if (turns >= maxTurns) {
                        continue;
                    }
                    if (dfs(newX, newY, turns + 1, destroy, direction[2], visit)) {
                        return true;
                    }
                }
            }
        }
        visit[x][y] = false;
        return false;
    }

}
