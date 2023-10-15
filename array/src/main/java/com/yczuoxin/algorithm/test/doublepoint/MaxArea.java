package com.yczuoxin.algorithm.test.doublepoint;

/**
 * 11. 盛最多水的容器
 * 中等
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 */
public class MaxArea {

    public static void main(String[] args) {
        System.out.println(Solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(Solution.maxArea(new int[]{1,1}));
    }

    static class Solution {
        public static int maxArea(int[] height) {
            // 最大面积记录
            int maxArea = 0;
            // 左边下标
            int left = 0;
            // 右边的下标
            int right = height.length - 1;

            while (left < right) {
                // 如果左边高度小于右边高度
                if (height[left] < height[right]) {
                    // 面积为左边高度乘以两个坐标之间的差值
                    maxArea = Math.max(maxArea, height[left] * (right - left));
                    // 左边低，所以往右边找高的位置才可能比现在的面积大
                    left++;
                } else if (height[left] > height[right]) {
                    maxArea = Math.max(maxArea, height[right] * (right - left));
                    right--;
                } else {
                    maxArea = Math.max(maxArea, height[right] * (right - left));
                    left++;
                    right--;
                }
            }
            return maxArea;
        }
    }

}
