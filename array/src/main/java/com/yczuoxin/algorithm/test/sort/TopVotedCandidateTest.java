package com.yczuoxin.algorithm.test.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你两个整数数组 persons 和 times 。在选举中，第i张票是在时刻为times[i]时投给候选人 persons[i]的。
 *
 * 对于发生在时刻 t 的每个查询，需要找出在t 时刻在选举中领先的候选人的编号。
 *
 * 在t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 *
 * 实现 TopVotedCandidate 类：
 *
 * TopVotedCandidate(int[] persons, int[] times) 使用persons 和 times 数组初始化对象。
 * int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号
 */
public class TopVotedCandidateTest {

    public static void main(String[] args) {
        int[] persons = new int[]{0, 1, 1, 0, 0, 1, 0};
        int[] times = new int[]{0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons, times);
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(15));
        System.out.println(topVotedCandidate.q(24));
    }

    static class TopVotedCandidate {
        // 被投票人及其票数信息维护
        Map<Integer, Integer> mapping = new HashMap<>();
        // 存放对应 times 的下标的时间段，第一名的名单
        List<Integer> tops = new ArrayList<>();
        // 投票时间
        int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            mapping.put(-1, -1);
            int top = -1;
            for (int person : persons) {
                int count = mapping.getOrDefault(person, 0) + 1;
                mapping.put(person, count);
                // 如果票数相同，最近一个是第一名
                if (mapping.get(top) <= mapping.get(person)) {
                    top = person;
                }
                tops.add(top);
            }
            this.times = times;
        }

        public int q(int t) {
            int left = 0;
            int right = times.length - 1;
            while (left < right) {
                // 可能 int 越界，此处需要 +1，不然会进入死循环
                int mid = left + (right - left + 1) / 2;
                // 要求满足条件的最大值，所以小于的值可能是答案
                if (times[mid] <= t) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return tops.get(left);
        }
    }
}
