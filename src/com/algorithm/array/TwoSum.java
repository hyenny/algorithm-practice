package com.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2,8,11,14};
        int target = 10;
        System.out.println(Arrays.toString(twoSum.solve(nums,target)));
    }

    public int[] solve(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i+1;
                return result;
            } else {
                map.put(target - nums[i], i+1);
            }
        }
        return result;
    }
}
