# 数组（Leet Code）

## 66 加一

[链接](https://leetcode-cn.com/problems/plus-one/)

### 描述

给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

 

### 示例 1：

输入：`digits = [1,2,3]`
输出：`[1,2,4]`
解释：输入数组表示数字 `123`。

### 示例 2：

输入：`digits = [4,3,2,1]`
输出：`[4,3,2,2]`
解释：输入数组表示数字 `4321`。

### 示例 3：

输入：`digits = [0]`
输出：`[1]`

### 提示：

`1 <= digits.length <= 100`
`0 <= digits[i] <= 9`



## 21 合并两个有序链表

[链接](https://leetcode-cn.com/problems/merge-two-sorted-lists)

### 描述

将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 

### 示例 1：

输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]

### 示例 2：

输入：l1 = [], l2 = []
输出：[]

### 示例 3：

输入：l1 = [], l2 = [0]
输出：[0]

### 提示：

两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列



## 641 设计循环双端队列

[链接](https://leetcode-cn.com/problems/design-circular-deque)

### 描述

设计实现双端队列。
你的实现需要支持以下操作：

MyCircularDeque(k)：构造函数,双端队列的大小为k。
insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
isEmpty()：检查双端队列是否为空。
isFull()：检查双端队列是否满了。



### 示例：

MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
circularDeque.insertLast(1);			        // 返回 true
circularDeque.insertLast(2);			        // 返回 true
circularDeque.insertFront(3);			        // 返回 true
circularDeque.insertFront(4);			        // 已经满了，返回 false
circularDeque.getRear();  				// 返回 2
circularDeque.isFull();				        // 返回 true
circularDeque.deleteLast();			        // 返回 true
circularDeque.insertFront(4);			        // 返回 true
circularDeque.getFront();				// 返回 4

 

### 提示：

所有值的范围为 [1, 1000]
操作次数的范围为 [1, 1000]
请不要使用内置的双端队列库。