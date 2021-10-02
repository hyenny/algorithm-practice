package com.algorithm.backtacking;

import java.util.ArrayList;
import java.util.List;

/**
 * [leetcode] 39.Combination Sum
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum.combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();

        findCombinations(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public void findCombinations(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                findCombinations(candidates, i, target-candidates[i], current, result);
                current.remove(new Integer(candidates[i]));
            }
        }
    }
}
