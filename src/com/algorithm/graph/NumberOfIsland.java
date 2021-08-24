package com.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        /**
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
         **/

        NumberOfIsland numberOfIsland = new NumberOfIsland();
        System.out.println(numberOfIsland.solve_dfs(grid));
    }

    private int m,n;
    private int cnt = 0;
    private static final int[][] DIRS = {{-1,0}, {1,0}, {0,1}, {0, -1}};

    public int solve_dfs(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                    System.out.println("=================");
                    dfs(grid, i, j);
                    System.out.println("=================");
                }
            }
        }
        return cnt;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = -1; // 방문한 곳은 -1
        System.out.println("i : " + i + ", j : " + j);
        for (int[] dir : DIRS) {
            //System.out.println(Arrays.toString(dir));
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }

    public int solve_bfs(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    bfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private void bfs(int[][] grid, int i, int j) {
        grid[i][j] = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int[] dir : DIRS) {
                int x1 = cur[0] + dir[0];
                int y1 = cur[1] + dir[1];

                if (x1 >=0 && y1 >= 0 && x1 < m && y1 < n && grid[x1][y1] == 1) {
                    grid[x1][y1] = -1;
                    queue.offer(new int[]{x1,y1});
                }
            }
        }
    }

}
