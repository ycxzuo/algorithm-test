package com.yczuoxin.algorithm.test.string;

/**
 * 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(Solution.longestCommonPrefix(new String[]{"a", "ab"}));
    }

    static class Solution {
        public static String longestCommonPrefix(String[] strs) {
            int n = strs.length;
            if (n == 1) {
                return strs[0];
            }
            int minLength = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                minLength = Math.min(strs[i].length(), minLength);
            }
            for (int i = 0; i < minLength; i++) {
                int count = 1;
                while (count < n) {
                    if (strs[count].charAt(i) == strs[count - 1].charAt(i)) {
                        count++;
                    } else {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0].substring(0, minLength);
        }
    }

}
