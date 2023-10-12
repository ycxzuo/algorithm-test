package com.yczuoxin.algorithm.test.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */
public class FourSum {

    public static void main(String[] args) {
        Solution.fourSum(new int[]{2, 2, 2, 2}, 8);
    }

    static class Solution {
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            int length = nums.length;
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            Arrays.sort(nums);
            for (int i = 0; i < length - 3; i++) {
                // 剪枝过程
                // 如果当前遍历的数和上一次遍历的数值相同，就跳过
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 如果前面4个最小的相加都大于目标值，可以直接返回
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                // 如果第一个数加上最后三个最大的数都到不了目标值，可以跳过
                if (nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                    continue;
                }
                int first = nums[i];
                for (int j = i + 1; j < length - 2; j++) {
                    // 剪枝过程
                    // 如果当前遍历的数和上一次遍历的数值相同，就跳过
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    // 如果前面4个最小的相加都大于目标值，可以直接返回
                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    // 如果第一个数加上最后三个最大的数都到不了目标值，可以跳过
                    if (nums[i] + nums[j] + nums[length - 2] + nums[length - 3] < target) {
                        continue;
                    }
                    // 下面执行两数之和的逻辑
                    int left = j + 1;
                    int right = length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            result.add(Arrays.asList(nums[i], nums[j] + nums[left] + nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                        } else if (sum < target) {
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                        } else {
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                        }
                    }
                }
            }
            return result;
        }
    }

}
