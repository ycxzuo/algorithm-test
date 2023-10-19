package com.yczuoxin.algorithm.test.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 中等
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(Solution.generateParenthesis(3));
    }

    static class Solution {
        /**
         * 理解就是任意一个点，左括号不能小于右括号
         *
         * @param n
         * @return
         */
        public static List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backTrack(result, new StringBuilder(), 0 ,0, n);
            return result;
        }

        /**
         * 回溯法处理
         *
         * @param result    结果集
         * @param current   当前字符串
         * @param left      左括号个数
         * @param right     右括号个数
         * @param max       要求括号数量
         */
        private static void backTrack(List<String> result, StringBuilder current, int left, int right, int max) {
            // 如果到达括号2倍长度，就认为是答案的一种
            if (current.length() == max * 2) {
                result.add(current.toString());
                return;
            }
            //  如果左括号小于总数，那么就是可以尝试增加左括号的
            if (left < max) {
                current.append("(");
                backTrack(result, current, left + 1, right, max);
                // 恢复现场
                current.deleteCharAt(current.length() - 1);
            }
            // 如果右括号数量小于左括号，那么就可以尝试增加右括号
            if (right < left) {
                current.append(")");
                backTrack(result, current, left, right + 1, max);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }



}
