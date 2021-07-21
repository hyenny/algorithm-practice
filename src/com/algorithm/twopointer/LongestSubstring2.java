package com.algorithm.twopointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring2 {
    public static void main(String[] args) {
        LongestSubstring2 longestSubstring2 = new LongestSubstring2();
        //String s = "aceba";
        String s = "ccaabbb";
        System.out.println(longestSubstring2.solve(s));
    }

    public int solve(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int r = 0, l = 0, counter = 0, max = 0;

        while(r < s.length())  {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                counter++;
            }
            r++;

            while(counter > 2) {
                char c2 = s.charAt(l);
                map.put(c2, map.getOrDefault(c2, 0) - 1);
                if (map.get(c2) == 0) {
                    counter--;
                }
                l++;
            }
            max = Math.max(max, r-l);
        }

        return max;
    }

}


