package com.algorithm.sortandsearch;

/**
 * [leetcode] 704. Binary Search
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int result = new BinarySearch().solve(nums, 9);
        System.out.println(result); // 4
    }

    public int solve(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }

        return -1;
    }

}
