class Solution {
    public int[][] highestPeak(int[][] isWater) {

        int n = isWater.length;
        int m = isWater[0].length;

        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];

        int[][] height = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (isWater[i][j] == 1) {

                    queue.offer(new int[]{i, j, 0});

                    visited[i][j] = true;

                    height[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int cost = current[2];

            if (row + 1 < n && !visited[row + 1][col]) {

                queue.offer(new int[]{
                    row + 1,
                    col,
                    cost + 1
                });

                visited[row + 1][col] = true;

                height[row + 1][col] = cost + 1;
            }

            if (row - 1 >= 0 && !visited[row - 1][col]) {

                queue.offer(new int[]{
                    row - 1,
                    col,
                    cost + 1
                });

                visited[row - 1][col] = true;

                height[row - 1][col] = cost + 1;
            }

            if (col + 1 < m && !visited[row][col + 1]) {

                queue.offer(new int[]{
                    row,
                    col + 1,
                    cost + 1
                });

                visited[row][col + 1] = true;

                height[row][col + 1] = cost + 1;
            }

            if (col - 1 >= 0 && !visited[row][col - 1]) {

                queue.offer(new int[]{
                    row,
                    col - 1,
                    cost + 1
                });

                visited[row][col - 1] = true;

                height[row][col - 1] = cost + 1;
            }
        }

        return height;
    }
}