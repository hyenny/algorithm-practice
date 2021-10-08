package com.algorithm.sortandsearch;

public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = {0,3,2,0,8,5,9,0};
        for (int result : moveZeros.solve(nums)) {
            System.out.println(result);
        }
    }

    public int[] solve(int[] nums) {
        int index = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < length; i++) {
            nums[i] = 0;
        }

        return nums;
    }
}
