package com.yczuoxin.algorithm.test.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 中等
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLongestSubstring("dvdf"));
    }

    static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            char[] arr = s.toCharArray();
            int length = arr.length;
            int result = 0;
            int leftIndex= 0;
            // 用 map 保存每个字符的下标信息
            Map<Character, Integer> map = new HashMap<>();
            // 遍历字符
            for (int i = 0; i < length; i++) {
                char c = arr[i];
                // 如果 map 中有该字符，就说明此时不算该字符，为目前得到的不重复子串
                if (map.containsKey(c)) {
                    // 此处要看是该字符的下标有没有在当前不重复字符的最左边
                    leftIndex = Math.max(leftIndex, map.get(c) + 1);
                }
                result = Math.max(result, i - leftIndex + 1);
                // 更新 map 中的下标
                map.put(c, i);
            }
            return result;
        }
    }

}
