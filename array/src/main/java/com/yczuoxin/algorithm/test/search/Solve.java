package com.yczuoxin.algorithm.test.search;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class Solve {

    public static void main(String[] args) {
        char[] char1 = new char[]{'X', 'X', 'X', 'X'};
        char[] char2 = new char[]{'X', 'O', 'O', 'X'};
        char[] char3 = new char[]{'X', 'X', 'X', 'X'};
        char[] char4 = new char[]{'X', 'O', 'X', 'X'};
        char[][] board = new char[][]{char1, char2, char3, char4};
        Solution.solve(board);
        for (char[] chars : board) {
            System.out.println(chars);
        }
    }

    static class Solution {
        private static int m;
        private static int n;
        private static char[][] copy;
        private static int[] dx = new int[]{-1, 0, 0, 1};
        private static int[] dy = new int[]{0, -1, 1, 0};

        public static void solve(char[][] board) {
            // 理解只要 O 的连通块没有在边界，就都要替换成 X
            // 所以要把这两种 O 打上不同的标记，然后替换
            m = board.length;
            n = board[0].length;
            copy = board;
            // 处理纵边界
            for (int i = 0; i < m; i++) {
                dfs(i, 0);
                dfs(i, n - 1);
            }
            // 处理横边界
            for (int i = 0; i < n; i++) {
                dfs(0, i);
                dfs(m - 1, i);
            }
            // 遍历所有的点，A -> O, O -> X，结束
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 这两个 if 写反了会有问题，当然可以用 else if 解决，此处偷懒
                    if (copy[i][j] == 'O') {
                        copy[i][j] = 'X';
                    }
                    if (copy[i][j] == 'A') {
                        copy[i][j] = 'O';
                    }
                }
            }

        }

        private static void dfs(int x, int y) {
            if (x < 0 || x >= m || y < 0 || y >= n || copy[x][y] != 'O') {
                return;
            }
            // 题意说明只可能是 X 或 O，所以用临时的 A 代表不能替换的 O，剩下的 O 就可以都换成 X
            copy[x][y] = 'A';
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                dfs(nx, ny);
            }
        }
    }

}
