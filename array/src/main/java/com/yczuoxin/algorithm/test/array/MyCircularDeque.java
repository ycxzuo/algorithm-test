package com.yczuoxin.algorithm.test.array;

/**
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了
 */
public class MyCircularDeque {

    public static void main(String[] args) {
        CircularDeque deque = new CircularDeque(4);
        System.out.println(deque.insertLast(1));
        System.out.println(deque.insertFront(3));
        System.out.println(deque.insertFront(2));
        System.out.println(deque.insertFront(5));
        System.out.println(deque.insertFront(6));
        System.out.println(deque.isEmpty());
        System.out.println(deque.getFront());
        System.out.println(deque.getRear());
        System.out.println(deque.deleteFront());
        System.out.println(deque.getFront());
        System.out.println(deque.deleteFront());
        System.out.println(deque.getFront());
        System.out.println(deque.deleteFront());
        System.out.println(deque.getFront());
        System.out.println(deque.deleteFront());
        System.out.println(deque.getFront());
        System.out.println(deque.deleteFront());
    }

    /**
     * Your CircularDeque object will be instantiated and called as such:
     * CircularDeque obj = new CircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */
    static class CircularDeque {
        int size;
        LinkNode first;
        LinkNode tail;
        int threshold;
        public CircularDeque(int k) {
            threshold = k;
        }

        public boolean insertFront(int value) {
            if (size >= threshold) {
                return false;
            }
            LinkNode node = new LinkNode(value, first, null);
            if (first != null) {
                first.pre = node;
            } else {
                tail = node;
            }
            first = node;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (size >= threshold) {
                return false;
            }
            LinkNode node = new LinkNode(value, null, tail);
            if (tail != null) {
                tail.next = node;
            } else {
                first = node;
            }
            tail = node;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (size == 0) {
                return false;
            }
            // 只有一个元素
            if (first == tail) {
                first = null;
                tail = null;
                // 只有两个元素
            } else {
                first = first.next;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (size == 0) {
                return false;
            }
            if (first == tail) {
                first = null;
                tail = null;
            } else {
                tail = tail.pre;
            }
            size--;
            return true;
        }

        public int getFront() {
            if (size == 0) {
                return -1;
            }
            return first.value;
        }

        public int getRear() {
            if (size == 0) {
                return -1;
            }
            return tail.value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size >= threshold;
        }

        private class LinkNode {
            int value;
            LinkNode next;
            LinkNode pre;

            public LinkNode(int value) {
                this.value = value;
            }

            public LinkNode(int value, LinkNode next, LinkNode pre) {
                this(value);
                this.next = next;
                this.pre = pre;
            }
        }
    }

}
