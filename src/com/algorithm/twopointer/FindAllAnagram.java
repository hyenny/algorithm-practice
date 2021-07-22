package com.algorithm.twopointer;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagram {
    public static void main(String[] args) {
        FindAllAnagram findAllAnagram = new FindAllAnagram();
        String s = "bacdgabcda", p = "abcd";
        System.out.println(findAllAnagram.solve(s, p));

    }

    public List<Integer> solve(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return result;

        int[] pArr = new int[26];
        for (int i=0; i < p.length(); i++) {
            pArr[p.charAt(i)-'a']++;
        }

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int[] sArr = new int[26];
            for (int j=0; j < p.length(); j++) {
                sArr[s.charAt(i+j)-'a']++;
            }

            if (check(pArr, sArr))
                result.add(i);
        }

        return result;
    }

    private boolean check(int[] pArr, int[] sArr) {
        for (int i = 0; i < pArr.length; i++) {
            if (pArr[i] != sArr[i]) {
                return false;
            }
        }
        return true;
    }
}
