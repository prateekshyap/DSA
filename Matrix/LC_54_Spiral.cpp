/*
 	https://leetcode.com/problems/spiral-matrix/
	
*/

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int r = matrix.size();
        int c = matrix[0].size();
        
        vector<int> ans(r*c);
        int i=0;
        int j=0;
        int ind=0;
        
        int top=0; 
        int bottom=r-1;
        
        int left=0;
        int right=c-1;
        
        while(top<=bottom && left<=right)
        {
            for(j=left; j<=right; j++ )
                ans[ind++] = (matrix[top][j]);
              if(++top>bottom)break; //delete top row and check
              
            for(i=top; i<=bottom; i++)
                ans[ind++] = (matrix[i][right]);
              if(--right<left)break; // delete right col and check
            
            for(j=right; j>=left; j--)
                ans[ind++] = (matrix[bottom][j]);
              if(--bottom<top)break; // delete bottom row and check
            
            for(i=bottom; i>=top; i--)
                ans[ind++] = (matrix[i][left]);
             if(++left>right)break; // delete left col and check
            
        }
        return ans;
    }//end
};