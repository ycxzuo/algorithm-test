package com.yczuoxin.algorithm.test.array;

import java.util.Arrays;

/**
 * leetcode 66
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位，数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = new int[]{4, 3, 2, 1};
        Arrays.stream(Solution.plusOne(digits)).forEach(System.out::println);
    }

    static class Solution {
        public static int[] plusOne(int[] digits) {
            int n = digits.length;
            for (int i = n - 1; i >= 0; i--) {
                // 该位置不是 9，可以加 1 然后返回
                if (digits[i] != 9) {
                    digits[i] = digits[i] + 1;
                    return digits;
                } else {
                    // 该位置是 9，将 9 变成 0，继续循环
                    digits[i] = 0;
                }
            }
            // 说明全是数字 9
            digits = new int[n + 1];
            digits[0] = 1;
            return digits;
        }
    }
}


