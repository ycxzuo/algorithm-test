package com.yczuoxin.algorithm.test.dynamicprogram;

/**
 * 5. 最长回文子串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String test = "babad";
        System.out.println(Solution.longestPalindrome(test));
    }

    static class Solution {
        public static String longestPalindrome(String s) {
            int length = s.length();
            if (length < 2) {
                return s;
            }
            // 动态规划解决，如果之前是回文子串，并且向外扩展的两个字符相同，那么扩展后的字符也是回文子串
            // P(i,j) = P(i+1,j−1) && (Si == Sj)
            boolean[][] dp = new boolean[length][length];
            // 单字符都是回文子串
            for (int i = 0; i < length; i++) {
                dp[i][i] = true;
            }
            int maxLen = 1;
            int begin = 0;
            char[] arr = s.toCharArray();
            // 先处理对角线右边的数据 i 为行，j 为 列，这样比较符合习惯
            for (int j = 1; j < length; j++) {
                for (int i = 0; i < j; i++) {
                    if (arr[i] != arr[j]) {
                        dp[i][j] = false;
                    } else {
                        // 如果字符串小于 3，就默认是回文子串
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            // 如果向外扩展之前也是回文子串，那么扩展之后也是回文子串
                            if (dp[i + 1][j - 1]) {
                                dp[i][j] = true;
                            }
                        }
                        if (dp[i][j] && j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            begin = i;
                        }
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }
    }
}
