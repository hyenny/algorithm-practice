package com.algorithm.graph;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        //String word = "ABCCED";
        String word = "SEE";
        //String word = "ABCB";

        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.solve(board, word));

    }

    private int m, n;
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean solve(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, int index, String word) {
        if (index == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        for(int[] dir : DIRS) {
            if (dfs(board, visited, i + dir[0], j+dir[1], index + 1, word)) {
                return true;
            };
        }
        visited[i][j] = false;
        return false;
    }


}
