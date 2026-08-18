class Solution {
    public void bfs(int row,int col,char[][] board){
        Queue<int []> queue = new LinkedList<>();
        int n = board.length;
        int m= board[0].length;

        queue.offer(new int[]{row,col});

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            int curRow=current[0];
            int curCol=current[1];

            if(curRow+1 <n && board[curRow+1][curCol]=='X'){
                queue.offer(new int[]{curRow+1,col});
                board[curRow+1][col]='.';
            }

            if(curRow-1 >=0 && board[curRow-1][curCol]=='X'){
                queue.offer(new int[]{curRow-1,curCol});
                board[curRow-1][curCol]='.';
            }

            if(curCol-1 >=0  && board[curRow][curCol-1]=='X'){
                queue.offer(new int[]{curRow,curCol-1});
                board[curRow][curCol-1]='.';
            }
            if(curCol+1 <m && board[curRow][curCol+1]=='X'){
                queue.offer(new int[]{curRow,curCol+1});
                board[curRow][curCol+1]='.';
            }
        }
        return;
    }
    public int countBattleships(char[][] board) {
        int cnt=0;

        int n=board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){
                if(board[i][j]=='X'){
                    cnt++;
                    bfs(i,j,board);
                }
            }
        }

        return cnt;
    }
}