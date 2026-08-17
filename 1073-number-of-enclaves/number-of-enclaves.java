class Solution {
    int cnt = 0;

    public void bfs(int rows, int cols, int[][] grid, boolean[][] visited) {

        Queue<int[]> queue = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        int fntCnt = 0;
        boolean touchesBoundary = false;

        queue.offer(new int[]{rows, cols});
        visited[rows][cols] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            fntCnt++;

            if (row == 0 || row == n - 1 ||
                col == 0 || col == m - 1) {

                touchesBoundary = true;
            }

            // down
            if (row + 1 < n &&
                !visited[row + 1][col] &&
                grid[row + 1][col] == 1) {

                visited[row + 1][col] = true;
                queue.offer(new int[]{row + 1, col});
            }

            // up
            if (row - 1 >= 0 &&
                !visited[row - 1][col] &&
                grid[row - 1][col] == 1) {

                visited[row - 1][col] = true;
                queue.offer(new int[]{row - 1, col});
            }

            // right
            if (col + 1 < m &&
                !visited[row][col + 1] &&
                grid[row][col + 1] == 1) {

                visited[row][col + 1] = true;
                queue.offer(new int[]{row, col + 1});
            }

            // left
            if (col - 1 >= 0 &&
                !visited[row][col - 1] &&
                grid[row][col - 1] == 1) {

                visited[row][col - 1] = true;
                queue.offer(new int[]{row, col - 1});
            }
        }

        if (!touchesBoundary) {
            cnt += fntCnt;
        }
    }

    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!visited[i][j] && grid[i][j] == 1) {
                    bfs(i, j, grid, visited);
                }
            }
        }

        return cnt;
    }
}