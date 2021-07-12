package com.algorithm.search;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        //int[] nums = {2,3,1,5,6,4,8,10,4};
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 2;
        //System.out.println(kthLargestElement.solve(nums, k));
        System.out.println(kthLargestElement.solvePriorityQueue(nums, k));
    }

    public int solve(int[] nums, int k) {
        Arrays.sort(nums); // 오름차순
        return nums[nums.length - k];
    }

    public int solvePriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순, min heap
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
