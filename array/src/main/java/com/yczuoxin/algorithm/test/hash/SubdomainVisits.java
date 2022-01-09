package com.yczuoxin.algorithm.test.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
