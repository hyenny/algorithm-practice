package com.algorithm.array;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater.solve(height));
    }

    public int solve(int[] height) {
        int result = 0;
        if (height == null || height.length <= 2)
            return result;

        // 1. leftMax[] => [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int leftMax = height[0];
        left[0] = leftMax;
        for (int i = 1; i < len; i++) {
            leftMax = Math.max(leftMax, height[i]);
            left[i] = leftMax;
        }

        // 2. rightMax[] => [3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]
        int rightMax = height[len-1];
        right[len-1] = rightMax;
        for (int i = len-2; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            right[i] = rightMax;
        }

        // 3. min(left,right) - height
        for (int i = 0; i < len; i++) {
            result = result + (Math.min(left[i], right[i]) - height[i]);
        }
        return result;
    }
}
