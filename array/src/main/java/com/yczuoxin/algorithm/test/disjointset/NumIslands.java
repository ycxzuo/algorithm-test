package com.yczuoxin.algorithm.test.disjointset;

/**
 * 200. 岛屿数量
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class NumIslands {

    public static void main(String[] args) {
//        char[] a1 = new char[]{'1','1','1','1','0'};
//        char[] a2 = new char[]{'1','1','0','1','0'};
//        char[] a3 = new char[]{'1','1','0','0','0'};
//        char[] a4 = new char[]{'0','0','0','0','0'};
        char[] a1 = new char[]{'1','1','0','0','0'};
        char[] a2 = new char[]{'1','1','0','0','0'};
        char[] a3 = new char[]{'0','0','1','0','0'};
        char[] a4 = new char[]{'0','0','0','1','1'};
        System.out.println(Solution.numIslands(new char[][]{a1, a2, a3, a4}));
    }

    static class Solution {

        static int[] pa;
        static int m;
        static int n;
        static int count = 0;

        public static int numIslands(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            pa = new int[m * n];
            int[] dx = new int[]{-1, 0, 0, 1};
            int[] dy = new int[]{0, -1, 1, 0};
            // MakeSet
            for (int i = 0; i < m * n; i++) {
                pa[i] = i;
            }
            // union
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        // 先记载 '1' 的个数
                        count++;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                            if (grid[nx][ny] == '1') {
                                unionSet(num(i, j), num(nx, ny));
                            }
                        }
                    }
                }
            }
            return count;
        }

        private static int num(int x, int y) {
            return x + y * m;
        }

        private static int find(int x) {
            if (pa[x] == x) return x;
            return pa[x] = find(pa[x]);
        }

        private static void unionSet(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                pa[y] = x;
                // 每次合并就减少一个独立的 '1'
                count--;
            }
        }
    }

}
