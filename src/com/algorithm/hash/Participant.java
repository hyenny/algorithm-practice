package com.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * [프로그래머스] 완주하지 못한 선수
 */
public class Participant {
    public static void main(String[] args) {
        //String[] p = {"leo", "leo","kiki", "eden", "kiki"};
        //String[] c = {"eden", "kiki", "kiki", "leo"};
        String[] p = {"mislav", "stanko", "mislav", "ana"};
        String[] c = {"stanko", "ana", "mislav"};
        System.out.println(solution(p, c));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        // 선수(key), 명(value)
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 완주한 선수는 -1
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        // 완주하지 못한 선수는 value가 0이 아님
        for (String key : map.keySet()) {
            if (map.get(key) != 0)
                answer = key;
        }

        return answer;
    }

}
