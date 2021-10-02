package com.algorithm.search;

import java.util.*;

/**
 * [leetcode] 347.Top K Frequent Elements
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = {1,2,2,1,1,2,2,3,3,3,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        // 1. 요소의 빈도를 체크한다.
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 2. 빈도가 높은 요소 순으로 정렬한다.
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        // 3. Top K를 넣는다.
        for (int i = 0; i < result.length; i++) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }

}
