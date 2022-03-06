package com.yczuoxin.algorithm.test.string;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLastWord("asd dasd qweqa  "));
    }

    static class Solution {
        public static int lengthOfLastWord(String s) {
            int n = s.length() - 1;
            int ans = 0;
            // 清空尾部的空串
            while (n >= 0 && s.charAt(n) == ' ') {
                n--;
            }
            while (n >= 0 && s.charAt(n) != ' ') {
                n--;
                ans++;
            }
            return ans;
        }
    }

}
