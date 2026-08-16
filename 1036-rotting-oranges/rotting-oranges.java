class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        //add all 2 to queue with row and col and time =0

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j,0});
                }
            }
        }

        int time =0;

        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};

        // check for all for direction

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r=current[0];
            int c=current[1];
            int t=current[2];

            time=Math.max(time,t);

            for(int i=0;i<4;i++){
                int newRow = r+row[i];
                int newCol= c+col[i];

                if(newRow>=0 && newCol>=0 && newRow<n && newCol<m && grid[newRow][newCol]==1){

                    grid[newRow][newCol]=2;
                    queue.offer(new int[]{newRow,newCol,t+1});
                }
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }
}