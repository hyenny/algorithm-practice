package com.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * [leetcode] 1. TwoSum
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum2 {

    public int[] twoSum(int[] nums, int target) {
        // num와 num의 index를 key value로 갖는 맵
        int[] answers = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        // map에 값을 넣는다
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // target - 현재 num = 남은 num 을 만족하는 인덱스를 answers에 넣는다
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key) && map.get(key) != i) {
                answers[0] = i;
                answers[1] = map.get(key);
            }
        }
        return answers;
    }
}
