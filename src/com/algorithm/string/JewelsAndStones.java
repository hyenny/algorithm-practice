package com.algorithm.string;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        String jewels = "aAA", stones = "aAAAbbbb";
        System.out.println(jewelsAndStones.solve(jewels, stones));
    }

    public int solve(String jew, String stones) {
        Set<Character> uniqueJew = new HashSet<>();
        for (int i = 0; i < jew.length(); i++) {
            uniqueJew.add(jew.charAt(i));
        }

        int result = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (uniqueJew.contains(stones.charAt(i)))
                result++;
        }

        return result;
    }
}
