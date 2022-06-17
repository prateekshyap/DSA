/*
https://leetcode.com/problems/game-of-life/
289. Game of Life
https://binarysearch.com/problems/Conway's-Game-of-Life/solutions
*/

class Solution {
public:
    void gameOfLife_ExtraSpace(vector<vector<int>>& board) {
        
        int m = board.size();
        int n = board[0].size();
        
        int dirs[8][2] = {
            {-1,-1}, {-1,0}, {-1,+1}, {0,+1}, {+1,+1}, {+1,0}, {+1,-1}, {0,-1}  
        };
        
        vector<vector<int>> ans(m, vector<int>(n,0));
        
        int liveCount = 0, x=0, y=0;
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                liveCount=0;
                for(auto d: dirs)
                {
                    x=i+d[0];
                    y=j+d[1];
                    
                    if(x<0 || y<0 || x>=m || y>=n || board[x][y]==0)
                        continue;
                    else
                        liveCount++;
                }
                
                if((board[i][j] && (liveCount==2 || liveCount==3)) || (!board[i][j]) && liveCount ==3)
                    ans[i][j]=1;
                else
                    ans[i][j]=0;
            }
        }
        
        board = ans;
    }//end
    
    void gameOfLife(vector<vector<int>>& board) {
        
        int m = board.size();
        int n = board[0].size();
        
        int dirs[8][2] = {
            {-1,-1}, {-1,0}, {-1,+1}, {0,+1}, {+1,+1}, {+1,0}, {+1,-1}, {0,-1}  
        };
        
        int x=0, y=0;
        int diff = 0;
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j]>0) //if it is a live cell 
                    diff = +1;
                else
                    diff = -1;
                
                for(auto d: dirs) // for each cell. look into its 8 neighbours
                {
                    x = i+d[0]; y = j+d[1];

                    if(x<0 || y<0 || x>=m || y>=n)
                        continue;
                    else if(board[x][y]>0) // if it is neighbours are live
                            board[i][j] += diff; 
                }
                
            }
        }
        
         for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                    if((board[i][j] >= 3 && board[i][j] <= 4) || board[i][j] == -3) // 1 + 2 or 3 live neighbours // 0 + -3 
                        board[i][j] = 1;
                    else
                        board[i][j] = 0;
            }
         }
    }//end
};