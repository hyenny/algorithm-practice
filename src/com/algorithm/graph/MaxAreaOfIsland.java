package com.algorithm.graph;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1}
        };

        MaxAreaOfIsland maxAreaOfIslands = new MaxAreaOfIsland();
        System.out.println(maxAreaOfIslands.solve(grid));

    }

    private int m, n;
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int solve(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    System.out.println("=================");
                    int area = dfs(grid, i, j, 0);
                    max = Math.max(area, max);
                    System.out.println("=================");
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int area) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return area;
        }
        grid[i][j] = -1;
        area++;
        System.out.println("i : " + i + ", j : " + j + ",size : " + area);

        for (int[] dir : DIRS) {
            area = dfs(grid, i + dir[0], j + dir[1], area);
        }
        return area;
    }
}
