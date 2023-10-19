package com.yczuoxin.algorithm.test.dynamicprogram;

/**
 * 32. 最长有效括号
 * 困难
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(Solution.longestValidParentheses("()(())"));
    }

    static class Solution {
        public static int longestValidParentheses(String s) {
            int result = 0;
            int length = s.length();
            int[] dp = new int[length + 1];
            // 空串作为占位符占第一个位置
            dp[0] = 0;
            // 所有字符是下标是 i - 1
            for (int i = 2; i < length + 1; i++) {
                if (s.charAt(i - 1) == ')') {
                    if (s.charAt(i - 2) == '(') {
                        // 如果前一个字符是 ( 的动规方程
                        dp[i] = dp[i - 2] + 2;
                    } else if (i - dp[i - 1] > 1 && s.charAt(i - dp[i - 1] - 2) == '(') {
                        // 如果前一个字符是 ) 的动规方程，i - dp[i - 1] - 2  查看构成最长括号的前一个字符是 ( 就能跟前面的组起来
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    result = Math.max(result, dp[i]);
                }
            }
            return result;
        }
    }

}
