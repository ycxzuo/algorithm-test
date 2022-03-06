package com.yczuoxin.algorithm.test.string;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(Solution.firstUniqChar("leetcode"));
        System.out.println(Solution.firstUniqChar("loveleetcode"));
    }

    static class Solution {
        public static int firstUniqChar(String s) {
            int[] arr = new int[26];
            int n = s.length();
            for (int i = 0; i < n; i++) {
                // 因为都是小写的
                arr[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < n; i++) {
                if (arr[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

}
