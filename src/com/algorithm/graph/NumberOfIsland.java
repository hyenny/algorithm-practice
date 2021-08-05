package com.algorithm.graph;

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

}
