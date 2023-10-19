package com.yczuoxin.algorithm.test.doublepoint;

/**
 * 283. 移动零
 * 简单
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        Solution.moveZeroes(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    static class Solution {
        public static void moveZeroes(int[] nums) {
            // 不为 0 的指针
            int index = 0;
            // 遍历数组
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index] = nums[i];
                    index++;
                }
            }
            // 将数组后面的值填充为 0
            for (int i = index; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

}