package com.yczuoxin.algorithm.test.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 网站域名 "discuss.leetcode.com" 由多个子域名组成。顶级域名为 "com" ，二级域名为 "leetcode.com" ，最低一级为 "discuss.leetcode.com" 。当访问域名 "discuss.leetcode.com" 时，同时也会隐式访问其父域名 "leetcode.com" 以及 "com" 。
 *
 * 计数配对域名 是遵循 "rep d1.d2.d3" 或 "rep d1.d2" 格式的一个域名表示，其中 rep 表示访问域名的次数，d1.d2.d3 为域名本身。
 *
 * 例如，"9001 discuss.leetcode.com" 就是一个 计数配对域名 ，表示 discuss.leetcode.com 被访问了 9001 次。
 * 给你一个 计数配对域名 组成的数组 cpdomains ，解析得到输入中每个子域名对应的 计数配对域名 ，并以数组形式返回。可以按 任意顺序 返回答案。
 */
public class SubdomainVisits {

    public static void main(String[] args) {
        String[] question = new String[]{ "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(Solution.subdomainVisits(question));
    }

    static class Solution {
        public static List<String> subdomainVisits(String[] cpdomains) {
            List<String> result = new ArrayList<>();
            Map<String, Integer> mapping = new HashMap<>();
            for (String cpdomain : cpdomains) {
                String[] str = cpdomain.split(" ");
                int count = Integer.parseInt(str[0]);
                String path = str[1];
                int index = 0;
                while ((index = path.indexOf(".")) != -1) {
                    if (mapping.containsKey(path)) {
                        mapping.put(path, mapping.get(path) + count);
                    } else {
                        mapping.put(path, count);
                    }
                    path = path.substring(index + 1);
                }
                if (mapping.containsKey(path)) {
                    mapping.put(path, mapping.get(path) + count);
                } else {
                    mapping.put(path, count);
                }
            }
            for (Map.Entry<String, Integer> entry : mapping.entrySet()) {
                result.add(entry.getValue() + " " + entry.getKey());
            }
            return result;
        }
    }

}
