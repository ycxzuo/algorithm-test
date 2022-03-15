package com.yczuoxin.algorithm.test.priority;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 136. 邻值查找
 *
 * 给定一个长度为 n 的序列 A，A 中的数各不相同。
 *
 * 对于 A 中的每一个数 Ai，求：
 *
 * min1≤j<i|Ai−Aj|
 * 以及令上式取到最小值的 j（记为 Pi）。若最小值点不唯一，则选择使 Aj 较小的那个。
 */
public class SearchSolution {

    public static void main(String[] args) {
        List<Pair<Integer, Integer>> search = Solution.search(new int[]{4, 5, 6, 1, 2, 3, 7, 8, 9, 10});
        for (int i = 0; i < search.size(); i++) {
            System.out.println(search.get(i).getKey() + " " + search.get(i).getValue());
        }
    }

    static class Solution {
        static List<Pair<Integer, Integer>> search(int[] arr) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int n = arr.length;
            List<Pair<Integer, Integer>> ans = new ArrayList<>();
            map.put(arr[0], 1);
            for (int i = 1; i < n; i++) {
                int data = arr[i];
                // 因为下标是从 1 开始的，所以下标都要加 1
                map.put(data, i + 1);
                // 比放入值的节点大的树节点
                Map.Entry<Integer, Integer> higherEntry = map.higherEntry(data);
                // 比放入值的节点小的树节点
                Map.Entry<Integer, Integer> lowerEntry = map.lowerEntry(data);
                if (higherEntry == null) {
                    // 因为小的值需要交换使符号为正
                    ans.add(new Pair<>(data - lowerEntry.getKey(), lowerEntry.getValue()));
                } else if (lowerEntry == null) {
                    ans.add(new Pair<>(higherEntry.getKey() - data, higherEntry.getValue()));
                } else {
                    ans.add(higherEntry.getKey() - data < data - lowerEntry.getKey() ? new Pair<>(higherEntry.getKey() - data, higherEntry.getValue()) : new Pair<>(data - lowerEntry.getKey(), lowerEntry.getValue()));
                }
            }
            return ans;
        }

    }

}
