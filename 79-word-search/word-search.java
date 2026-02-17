class Solution {

    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public boolean exist(char[][] board, String word) {

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)) {

                    boolean[][] visited = new boolean[m][n];

                    if (dfs(i, j, 0, board, word, visited))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, int idx,
                        char[][] grid,
                        String word,
                        boolean[][] visited) {

        if (grid[r][c] != word.charAt(idx))
            return false;

        if (idx == word.length() - 1)
            return true;

        visited[r][c] = true;

        for (int[] d : dirs) {
            int x = r + d[0];
            int y = c + d[1];

            if (x >= 0 && y >= 0 &&
                x < grid.length && y < grid[0].length &&
                !visited[x][y]) {

                if (dfs(x, y, idx + 1, grid, word, visited))
                    return true;
            }
        }

        visited[r][c] = false;

        return false;
    }
}