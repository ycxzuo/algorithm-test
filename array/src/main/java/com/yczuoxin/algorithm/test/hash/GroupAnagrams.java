package com.yczuoxin.algorithm.test.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 * 中等
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(Solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    static class Solution {
        public static List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> group = new HashMap<>();
            for (String str : strs) {
                // 获取字符
                char[] arr = str.toCharArray();
                // 对字符排序
                Arrays.sort(arr);
                String newWord = new String(arr);
                // 利用 hashMap 的特性将相同字符的字符串收集起来
                List<String> stringList = group.getOrDefault(newWord, new ArrayList<>());
                stringList.add(str);
                group.put(newWord, stringList);
            }
            return new ArrayList<>(group.values());
        }
    }

}
