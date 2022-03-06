package com.yczuoxin.algorithm.test.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. 宝石与石头
 *
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 *
 */
public class NumJewelsInStones {

    public static void main(String[] args) {
        System.out.println(Solution.numJewelsInStones("aA", "aAAbbbb"));
    }

    static class Solution {
        public static int numJewelsInStones(String jewels, String stones) {
            // 用一个不重复的集合放置，然后遍历字符，看集合里面有没有，有则数量 +1
            Set<Character> set = new HashSet<>();
            for (char c : jewels.toCharArray()) {
                set.add(c);
            }

            int ans = 0;
            for (char c : stones.toCharArray()) {
                if (set.contains(c)) {
                    ans++;
                }
            }
            return ans;
        }
    }

}
