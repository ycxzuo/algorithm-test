package com.yczuoxin.algorithm.test.string;

/**
 * 709. 转换成小写字母
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 */
public class ToLowerCase {

    public static void main(String[] args) {
        System.out.println(Solution.toLowerCase("AbCdEfG"));
    }

    static class Solution {
        public static String toLowerCase(String s) {
            StringBuilder result = new StringBuilder();
            for (char c : s.toCharArray()) {
                // 如果是大写，就替换成小写
                if (c >= 'A' && c  <= 'Z') {
                    c = (char) (c - 'A' + 'a');
                }
                result.append(c);
            }
            return result.toString();
        }
    }

}
