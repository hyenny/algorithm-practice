package com.algorithm.sortandsearch;

import java.util.Arrays;

/**
 * [leetcode] 128. Longest Consecutive Sequence
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {1,2,0,1};
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        longestConsecutive.solve(nums);
    }

    public int solve(int[] nums) {
        // []일 경우
        if (nums.length == 0) return 0;

        // 1. 숫자 배열을 오름차순 정렬한다.
        Arrays.sort(nums);

        // 2. 값이 연속되는 최대값을 구한다.
        int count = 1;
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i]) { // 동일 숫자가 연속될 경우 카운트하지 않는다.
                if (nums[i + 1] == nums[i] + 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }
        return max;
    }

}
