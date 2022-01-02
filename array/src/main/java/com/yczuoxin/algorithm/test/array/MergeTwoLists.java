package com.yczuoxin.algorithm.test.array;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode list1_6 = new ListNode(6);
        ListNode list1_5 = new ListNode(5, list1_6);
        ListNode list1_3 = new ListNode(3, list1_5);
        ListNode list1_1 = new ListNode(1, list1_3);

        ListNode list2_4 = new ListNode(4);
//        ListNode list2_2 = new ListNode(2, list2_4);
//        ListNode list2_1 = new ListNode(1, list2_2);

        ListNode listNode = Solution.mergeTwoLists(list1_1, list2_4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    static class Solution {
        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            // 设置一个哨兵
            ListNode first =  new ListNode(-1);
            // 当前的末节点
            ListNode pre = first;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    pre.next = list1;
                    list1 = list1.next;
                } else {
                    pre.next = list2;
                    list2 = list2.next;
                }
                pre = pre.next;
            }
            // 如果一个先遍历完，后面的就是另一个链表
            pre.next = list1 == null ? list2 : list1;
            return first.next;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
