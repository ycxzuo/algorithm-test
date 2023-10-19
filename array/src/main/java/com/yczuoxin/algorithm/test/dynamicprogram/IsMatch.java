package com.yczuoxin.algorithm.test.dynamicprogram;

/**
 * 10. 正则表达式匹配
 * 困难
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *
 * 示例 1：
 *
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class IsMatch {

    public static void main(String[] args) {
        System.out.println(Solution.isMatch("ab", ".*"));
    }

    static class Solution {
        public static boolean isMatch(String s, String p) {
            int lengthS = s.length();
            int lengthP = p.length();
            // 此时db[0][0] 被两个空串占用，dp 内 所有的字符下标对应的之前下标 + 1
            boolean[][] dp = new boolean[lengthS + 1][lengthP + 1];
            dp[0][0] = true;

            // 初始化首行，只有 p 在第二个字符都是 * 的时候，才可能匹配空串是 true
            for (int j = 2; j < lengthP + 1; j+=2) {
                dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';

            }
            for (int i = 1; i < lengthS + 1; i++) {
                for (int j = 1; j < lengthP + 1; j++) {
                    if (p.charAt(j - 1) == '*') {
                        // 此时，* = 0
                        if (dp[i][j - 2]) {
                            dp[i][j] = true;
                            // 此时 * = 1
                        } else if (dp[i - 1][j]){
                            char ch = p.charAt(j - 2);
                            // 如果字符匹配上
                            if (ch == s.charAt(i - 1) || ch == '.') {
                                dp[i][j] = true;
                            }
                        }
                    } else if (dp[i - 1][j - 1] && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')) {
                            dp[i][j] = true;
                    }
                }
            }
            return dp[lengthS][lengthP];
        }
    }

}
