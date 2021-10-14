package com.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [프로그래머스] 네트워크
 */
public class Network {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            bfs(i, computers, visited);
            answer++;
        }

        return answer;
    }

    private void bfs(int i, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[i] = true;
        queue.offer(i);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int j = 0; j < computers.length; j++) {
                if (num != j && computers[num][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }

}
