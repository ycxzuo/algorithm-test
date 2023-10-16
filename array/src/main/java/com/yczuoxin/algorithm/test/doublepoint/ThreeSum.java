package com.yczuoxin.algorithm.test.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 中等
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> result = Solution.threeSum(new int[]{1, -1, -1, 0});
        for (List<Integer> res : result) {
            for (Integer re : res) {
                System.out.println(re);
            }
            System.out.println("----------------");
        }
    }

    /**
     * @see com.yczuoxin.algorithm.test.hash.TwoSum 两数之和
     */
    static class Solution {
        public static List<List<Integer>> threeSum(int[] nums) {
            // 用两数之和观念做这道题目，先找到第一个数字
            // 可排序也可以不排序，排序方便剪枝，不排序就暴力破解
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            // 这里可以优化为 nums.length - 2，因为后面必须有两个数字才能进行，不过在第二个 for 循环也可以保证这个点
            for (int i = 0; i < nums.length - 2; i++) {
                int first = nums[i];
                // 如果遍历的这个数跟上一次遍历的值相同，则可以跳过
                if (i > 0 && first == nums[i - 1]) {
                    continue;
                }
                // 找第二个数字，这里需要去掉最后一个数值，因为后面可能和第三个数字下标重合，否则就要在下面判断三个数字下标和第二个数字下标相等的情况
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int second = nums[j];
                    // 如果遍历的这个数跟上一次遍历的值相同，则可以跳过
                    if (j > i + 1 && second == nums[j - 1]) {
                        continue;
                    }
                    // 接下来就是找第三个数据
                    int thirdIndex = nums.length - 1;
                    // 如果加起来和数字大于 0，就右边指针向左移动，否则左指针向右移动，等于 0 就可以加入结果集
                    while (thirdIndex > j && first + second + nums[thirdIndex] > 0) {
                        thirdIndex--;
                    }
                    if (thirdIndex == j) {
                        break;
                    }
                    if (first + second + nums[thirdIndex] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(first);
                        list.add(second);
                        list.add(nums[thirdIndex]);
                        result.add(list);
                    }
                }
            }
            return result;
        }
    }

}
