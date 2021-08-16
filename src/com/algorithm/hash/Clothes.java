package com.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * [프로그래머스] 위장
 */
public class Clothes {

    // (a + 1) * (b + 1) ... (n + 1) - 1
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] s : clothes) {
            if (!map.containsKey(s[1])) {
                map.put(s[1], 1);
            } else {
                map.put(s[1], map.get(s[1]) + 1);
            }
        }
        for (String key : map.keySet()) {
            answer = answer * (map.get(key) + 1);
        }
        return answer - 1;
    }
}
