class Solution { 
    public int dfs(int r, int c, int[][] grid) { 
        
        int cnt = 0; 
        int n = grid.length; 
        int m = grid[0].length; 

        boolean[][] visited = new boolean[n][m]; 

        Stack<int[]> st = new Stack<>();   
        st.push(new int[]{r, c}); 
        visited[r][c] = true; 

        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while (!st.isEmpty()) {

            int[] curr = st.pop();
            int row = curr[0];
            int col = curr[1];

            for (int[] d : dir) {

                int nr = row + d[0];
                int nc = col + d[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    cnt++;
                }

                else if (grid[nr][nc] == 0) {
                    cnt++;
                }

                else if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    st.push(new int[]{nr, nc});
                }
            }
        }

        return cnt;
    }

    public int islandPerimeter(int[][] grid) { 
        int n = grid.length; 
        int m = grid[0].length; 

        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) { 
                if (grid[i][j] == 1) { 
                    return dfs(i, j, grid); 
                } 
            } 
        } 

        return 0; 
    } 
}