/*
https://leetcode.com/problems/spiral-matrix-ii/
59. Spiral Matrix II
*/
class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        
        vector<vector<int>> ans(n, vector<int>(n));
        
        int left = 0, right = n-1;
        int top = 0, bottom = n-1;
        int itr = 1, r=0, c=0;
        int direction = 0;
        
        while(left <= right && top <= bottom)
        {
            if(direction == 0)
            {
                for(c=left; c<=right; c++ )
                    ans[top][c] = itr++;
                top++;
            }
            else if(direction == 1)
            {
                for(r=top; r<=bottom; r++)
                    ans[r][right] = itr++;
                right--;
            }
            else if(direction == 2)
            {
                for(c=right; c>=left; c-- )
                    ans[bottom][c] = itr++;
                bottom--;
            }
            else if(direction == 3)
            {
                for(r=bottom; r>=top; r--)
                    ans[r][left] = itr++;
                left++;
            }
            
            direction = (direction+1)%4;
        }
        
        
        return ans;
    }//end
};