package com.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    public static void main(String[] args) {
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };

        int[] start = {0,4};
        int[] destination = {4,4};

        Maze mazaBfs = new Maze();
        mazaBfs.hasPath(maze, start, destination);

    }

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int m, n;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0)
            return false;

        m = maze.length;
        n = maze[0].length;

        if (start[0] == destination[0] && start[1] == destination[1])
            return true;

        boolean visited[][] = new boolean[m][n];
        visited[start[0]][start[1]] = true; // start point
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : DIRS) {
                int x = cur[0];
                int y = cur[1];

                while(x >= 0 && y >= 0 && x < m && y <n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }

                x -= dir[0];
                y -= dir[1];

                if (visited[x][y]) continue;
                visited[x][y] = true;
                if (x == destination[0] && y == destination[1]) return true;

                queue.offer(new int[]{x,y});
            }
        }
        return false;
    }

}
