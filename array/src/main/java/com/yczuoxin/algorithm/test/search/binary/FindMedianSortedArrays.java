package com.yczuoxin.algorithm.test.search.binary;

/**
 * 4. 寻找两个正序数组的中位数
 * 困难
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 *
 *
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        System.out.println(Solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

    static class Solution {
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int total = nums1.length + nums2.length;
            if (total % 2 == 1) {
                int mid = total / 2;
                return getMidData(nums1, nums2, mid);
            } else {
                int mid1 = total / 2 - 1;
                int mid2 = total / 2;
                return (getMidData(nums1, nums2, mid1 + 1) + getMidData(nums1, nums2, mid2 + 1)) / 2.0d;
            }
        }

        private static double getMidData(int[] nums1, int[] nums2, int mid) {
            int length1 = nums1.length;
            int length2 = nums2.length;

            int index1 = 0;
            int index2 = 0;
            // 可以这样理解，先取中位数的中位数，哪个数组的数字大，那么另一个数组的前这么多位肯定就不是中位数，可以舍弃
            // 于是一直用二分查找法，直至找到中位数并返回
            while (true) {
                // 如果数组1 已经没有数了，直接去数组2 的数据即可
                if (index1 == length1) {
                    return nums2[index2 + mid - 1];
                }
                // 如果数组2 已经没有数了，直接去数组1 的数据即可
                if (index2 == length2) {
                    return nums1[index1 + mid - 1];
                }
                if (mid == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }
                int half = mid / 2;
                int newIndex1 = Math.min(index1 + half, length1) - 1;
                int newIndex2 = Math.min(index2 + half, length2) - 1;
                // 如果数组1 中的数值大于数组2 中的值，那么直接舍弃数组2 的 newIndex2 前面的数字
                if (nums1[newIndex1] > nums2[newIndex2]) {
                    mid = mid - (newIndex2 - index2 + 1);
                    index2 = newIndex2 + 1;
                } else {
                    mid = mid - (newIndex1 - index1 + 1);
                    index1 = newIndex1 + 1;
                }

            }
        }
    }

}
