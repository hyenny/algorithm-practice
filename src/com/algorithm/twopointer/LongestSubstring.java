package com.algorithm.twopointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        String s = "pwwkea";
        //String s = "";
        //String s = "aaaaa";
        System.out.println(longestSubstring.solve(s));

    }

    public int solve(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, counter = 0, max = 0;

        while(r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1)
                counter++;
            r++;

            while(counter > 0) {
                char c2 = s.charAt(l);
                if (map.get(c2) > 1)
                    counter--;
                map.put(c2, map.get(c2)-1);
                l++;
            }
            max = Math.max(max, r-l);
        }
        return max;
    }
}
