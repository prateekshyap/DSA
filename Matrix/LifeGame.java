class Solution {
    public void gameOfLife(int[][] board) 
    {
        if(board==null || board.length==0 || board[0].length==0)return;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                
                int count = 0;
                if(isAlive(board,i-1,j))count++;
                if(isAlive(board,i,j-1))count++;
                if(isAlive(board,i-1,j-1))count++;
                if(isAlive(board,i-1,j+1))count++;
                if(isAlive(board,i+1,j))count++;
                if(isAlive(board,i+1,j-1))count++;
                if(isAlive(board,i+1,j+1))count++;
                if(isAlive(board,i,j+1))count++;
                if(board[i][j]==1)
                {
                    if(count>3 || count<2)
                    {
                        board[i][j] = 3;
                    }
                    else if(count==2 || count==3)
                    {
                        board[i][j] = 1;
                    }
                }
                else 
                {
                    if(count==3)
                    {
                        if(board[i][j]==0)board[i][j] = 2;
                    }
                }
            }
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==3)board[i][j] = 0;
                else if(board[i][j]==2)board[i][j] = 1;
            }
        }
    }
    public boolean isAlive(int[][] board,int i,int j)
    {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length)
        {
            return false;
        }
        if(board[i][j]==1|| board[i][j]==3)return true;
        return false;
    }
}