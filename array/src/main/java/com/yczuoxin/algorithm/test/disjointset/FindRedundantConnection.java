package com.yczuoxin.algorithm.test.disjointset;

import java.util.Arrays;

/**
 * 684. 冗余连接
 * 树可以看成是一个连通且 无环的无向图。
 *
 * 给定往一棵n 个节点 (节点值1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges，edges[i] = [ai, bi]表示图中在 ai 和 bi 之间存在一条边。
 *
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组edges中最后出现的边。
 */
public class FindRedundantConnection {

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 2};
        int[] a2 = new int[]{2, 3};
        int[] a3 = new int[]{3, 4};
        int[] a4 = new int[]{1, 4};
        int[] a5 = new int[]{1, 5};
        System.out.println(Arrays.toString(Solution.findRedundantConnection(new int[][]{a1, a2, a3, a4, a5})));
    }

    static class Solution {
        static int[] pa;

        public static int[] findRedundantConnection(int[][] edges) {
            int n = edges.length;
            pa = new int[n + 1];
            // MakeSets
            for (int i = 0; i <= n; i++) pa[i] = i;
            // union
            for (int i = 0; i < n; i++) {
                int[] edge = edges[i];
                int x = edge[0];
                int y = edge[1];
                if (find(x) != find(y)) {
                    unionSet(x, y);
                } else {
                    return edge;
                }
            }
            return new int[0];
        }

        private static int find(int x) {
            if (pa[x] == x) return x;
            return pa[x] = find(pa[x]);
        }

        private static void unionSet(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) pa[x] = y;
        }
    }

}
