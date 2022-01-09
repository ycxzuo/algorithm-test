package com.yczuoxin.algorithm.test.hash;

import java.util.HashMap;
import java.util.Map;

public class FindShortestSubArray {

    public static void main(String[] args) {
        int[] question = new int[]{1,2,2,3,1,4,2};
        System.out.println(Solution.findShortestSubArray(question));
    }

    static class Solution {
        public static int findShortestSubArray(int[] nums) {
            // int[0] 代表数字， int[1] 代表第一次出现时的下标， int[2] 代表第最后出现时的下标，长度就等于 int[2] - int[1]
            Map<Integer, int[]> mapping = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (mapping.containsKey(nums[i])) {
                    mapping.get(nums[i])[0]++;
                    mapping.get(nums[i])[2] = i;
                } else {
                    mapping.put(nums[i], new int[]{1, i, i});
                }
            }
            // 遍历
            int maxCount = 0;
            int minLength = 0;
            for (Map.Entry<Integer, int[]> entry : mapping.entrySet()) {
                int[] data = entry.getValue();
                if (data[0] > maxCount) {
                    maxCount = data[0];
                    minLength = data[2] - data[1] + 1;
                } else if (data[0] == maxCount && data[2] - data[1] < minLength) {
                    minLength = data[2] - data[1] + 1;
                }
            }
            return minLength;
        }
    }

}
