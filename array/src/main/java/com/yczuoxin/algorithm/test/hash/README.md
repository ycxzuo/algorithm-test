# Hash 和前缀和

## 子域名访问计数

[链接](https://leetcode-cn.com/problems/subdomain-visit-count/)

### 描述

网站域名 "discuss.leetcode.com" 由多个子域名组成。顶级域名为 "com" ，二级域名为 "leetcode.com" ，最低一级为 "discuss.leetcode.com" 。当访问域名 "discuss.leetcode.com" 时，同时也会隐式访问其父域名 "leetcode.com" 以及 "com" 。

计数配对域名 是遵循 "rep d1.d2.d3" 或 "rep d1.d2" 格式的一个域名表示，其中 rep 表示访问域名的次数，d1.d2.d3 为域名本身。

例如，"9001 discuss.leetcode.com" 就是一个 计数配对域名 ，表示 discuss.leetcode.com 被访问了 9001 次。
给你一个 计数配对域名 组成的数组 cpdomains ，解析得到输入中每个子域名对应的 计数配对域名 ，并以数组形式返回。可以按 任意顺序 返回答案。



### 示例 1：

输入：`cpdomains = ["9001 discuss.leetcode.com"]`
输出：`["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]`
解释：例子中仅包含一个网站域名："discuss.leetcode.com"。
按照前文描述，子域名 "leetcode.com" 和 "com" 都会被访问，所以它们都被访问了 9001 次。

### 示例 2：

输入：`cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]`
输出：`["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]`
解释：按照前文描述，会访问 "google.mail.com" 900 次，"yahoo.com" 50 次，"intel.mail.com" 1 次，"wiki.org" 5 次。
而对于父域名，会访问 "mail.com" 900 + 1 = 901 次，"com" 900 + 50 + 1 = 951 次，和 "org" 5 次。



### 提示：

`1 <= cpdomain.length <= 100`
`1 <= cpdomain[i].length <= 100`
cpdomain[i] 会遵循 "repi d1i.d2i.d3i" 或 "repi d1i.d2i" 格式
repi 是范围 [1, 104] 内的一个整数
d1i、d2i 和 d3i 由小写英文字母组成



## 数组的度

[链接](https://leetcode-cn.com/problems/degree-of-an-array/)

### 描述

给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。

你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。



### 示例 1：

输入：`nums = [1,2,2,3,1]`
输出：`2`
解释：
输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
连续子数组里面拥有相同度的有如下所示：
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。

### 示例 2：

输入：`nums = [1,2,2,3,1,4,2]`
输出：`6`
解释：
数组的度是 3 ，因为元素 2 重复出现 3 次。
所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。



### 提示：

- `nums.length` 在 `1` 到 `50,000` 范围内。
- `nums[i]` 是一个在 `0` 到 `49,999` 范围内的整数。



## 和为 K 的子数组

[链接](https://leetcode-cn.com/problems/subarray-sum-equals-k/)

### 描述

给你一个整数数组 `nums` 和一个整数 `k` ，请你统计并返回该数组中和为 `k` 的连续子数组的个数。



### 示例 1：

```
输入：nums = [1,1,1], k = 2
输出：2
```

### 示例 2：

```
输入：nums = [1,2,3], k = 3
输出：2
```



### 提示：

- `1 <= nums.length <= 2 * 104`
- `-1000 <= nums[i] <= 1000`
- `-107 <= k <= 107`