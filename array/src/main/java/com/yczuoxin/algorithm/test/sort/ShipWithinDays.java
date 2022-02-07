package com.yczuoxin.algorithm.test.sort;

/**
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 */
public class ShipWithinDays {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(Solution.shipWithinDays(arr, days));
    }

    static class Solution {
        public static int shipWithinDays(int[] weights, int days) {
            // 利用二分验证法解决问题
            // 首先确定二分的边界
            int right = 0;
            int left = 0;
            for (int weight : weights) {
                right += weight;
                left = Math.max(left, weight);
            }
            while (left < right) {
                // 猜测的载重（二分中点）
                int mid = (left + right) / 2;
                int time = 1;
                int carry = 0;
                for (int weight : weights) {
                    // 如果大于猜测值，就需要增加一天，并将载重归 0
                    if (weight + carry > mid) {
                        carry = 0;
                        time++;
                    }
                    // 载重累加，并进行下一轮
                    carry += weight;
                }
                // 如果载重所需的时间小于等于题目所需要的，答案就在中值及中值的右边
                if (time <= days) {
                    right = mid;
                    // 如果载重所需的时间大于题目所需要的，答案就在中值的的左边
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

}
