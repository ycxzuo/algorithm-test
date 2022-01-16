package com.yczuoxin.algorithm.test.recursion;

import com.yczuoxin.algorithm.test.node.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKLists {

    public static void main(String[] args) {
        ListNode list1_6 = new ListNode(6);
        ListNode list1_5 = new ListNode(5, list1_6);
        ListNode list1_3 = new ListNode(3, list1_5);
        ListNode list1_1 = new ListNode(1, list1_3);

        ListNode list2_4 = new ListNode(4);
        ListNode list2_2 = new ListNode(2, list2_4);
        ListNode list2_1 = new ListNode(1, list2_2);

        ListNode[] listNode = new ListNode[] {list1_1, list2_1};

        ListNode result = Solution.mergeKLists(listNode);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    static class Solution {

        public static ListNode mergeKLists(ListNode[] lists) {
            // 空集合的时候会有问题，所以要判断一下，放前面校验只需要判断一次
            if (lists.length == 0) {
                return null;
            }
            return merge(lists, 0, lists.length - 1);
        }

        // 分治
        private static ListNode merge(ListNode[] lists, int left, int right) {
            // 边界
            // 空集合的时候会有问题，所以要判断一下
//            if (left > right) {
//                return null;
//            }
            if (left == right) {
                return lists[left];
            }
            int mid = (left + right) / 2;
            return mergeTwoList(merge(lists, left, mid), merge(lists, mid + 1, right));
        }

        // 合并两个链表方法抽离
        private static ListNode mergeTwoList(ListNode list1, ListNode secondList) {
            ListNode head = new ListNode(-1);
            ListNode pre = head;
            while (list1 != null && secondList != null) {
                if (list1.val <= secondList.val) {
                    pre.next = list1;
                    list1 = list1.next;
                } else {
                    pre.next = secondList;
                    secondList = secondList.next;
                }
                pre = pre.next;
            }
            pre.next = list1 == null ? secondList : list1;
            return head.next;
        }
    }

}
