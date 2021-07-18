package com.algorithm.array;

import java.util.Arrays;

public class DailyTemperature {
    public static void main(String[] args) {
        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        //int[] temperatures = {30,40,50,60};
        Arrays.toString(dailyTemperature.solve(temperatures));

    }

    public int[] solve(int[] nums) {
        int[] wait = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    wait[i] = cnt;
                    break;
                }
                cnt++;
            }
        }
        return wait;
    }
}
