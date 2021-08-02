package com.algorithm.queuestack;

import java.util.*;

/**
 * [프로그래머스] 기능개발
 */
public class FeatureDevelopment {
    public static void main(String[] args) {
        FeatureDevelopment featureDevelopment = new FeatureDevelopment();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        //int[] progresses = {95, 90, 99, 99, 80, 99};
        //int[] speeds = {1, 1, 1, 1, 1, 1};

        //int[] progresses = {90, 10, 70};
        //int[] speeds = {10, 50, 30};

        System.out.println(Arrays.toString(featureDevelopment.solution(progresses, speeds)));

    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int deployDate = (int) Math.ceil(remain);

            if (!queue.isEmpty() && queue.peek() < deployDate) {
                list.add(queue.size());
                queue.clear();
            }
            queue.offer(deployDate);
        }
        list.add(queue.size());

        return list.stream().mapToInt(i -> i).toArray();
    }
}
