class Solution {
    public int bfs(int r, int c, int[][] grid){
        int cnt=0;
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{r,c});
        grid[r][c]=0;
        cnt++;

        // now bfs kar

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            int row=current[0];
            int col=current[1];

            if(row+1<n && grid[row+1][col]==1){
                queue.offer(new int[]{row+1,col});
                grid[row+1][col]=0;
                cnt++;
            }

            if(row-1>=0 && grid[row-1][col]==1){
                queue.offer(new int[]{row-1,col});
                grid[row-1][col]=0;
                cnt++;
            }

            if(col+1<m && grid[row][col+1]==1){
                queue.offer(new int[]{row,col+1});
                grid[row][col+1]=0;
                cnt++;
            }

            if(col-1>=0 && grid[row][col-1]==1){
                queue.offer(new int[]{row,col-1});
                grid[row][col-1]=0;
                cnt++;
            }
        }

        return cnt;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max=0;

        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int currentMax=bfs(i,j,grid);
                    max=Math.max(max,currentMax);
                }
            }
        }

        return max;
    }
}