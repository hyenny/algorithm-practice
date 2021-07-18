package com.algorithm.array;

public class MaximumSubArray {
    public static void main(String[] args) {
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = {5,4,-1,7,8};
        System.out.println(maximumSubArray.solve(nums));
    }

    public int solve(int[] nums) {
        int curMax = nums[0];
        int allMax = nums[0];

        // O(n)
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], nums[i] + curMax);
            allMax = Math.max(curMax, allMax);
        }
        return allMax;
    }
}
