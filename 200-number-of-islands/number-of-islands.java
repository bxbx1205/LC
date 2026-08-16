class Solution {
    public void bfs(char[][] grid, int i,int j){
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col= current[1];

            if(row+1<n && col<m && grid[row+1][col]=='1'){
                queue.offer(new int[]{row+1,col});
                grid[row+1][col]='0';
            }

            if(row-1>=0 && col<m && grid[row-1][col]=='1'){
                queue.offer(new int[]{row-1,col});
                grid[row-1][col]='0';
            }

            if(row<n && col+1<m && grid[row][col+1]=='1'){
                queue.offer(new int[]{row,col+1});
                grid[row][col+1]='0';
            }

            if(row<n && col-1>=0 && grid[row][col-1]=='1'){
                queue.offer(new int[]{row,col-1});
                grid[row][col-1]='0';
            }


        }
        return;
    }
    public int numIslands(char[][] grid) {
        int n =grid.length;
        int m = grid[0].length;
        int cnt=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    bfs(grid,i,j);
                }
            }
        }

        return cnt;
    }
}