/*
https://leetcode.com/problems/valid-sudoku/
36. Valid Sudoku

*/

class Solution {
public:
    void setZeroes_bool(vector<vector<int>>& matrix) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        
        vector<bool> row(m,false), col(n, false);
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i]=true;
                    col[j]=true;
                }
            }
        
         for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
            {
                if(row[i] || col[j])
                {
                    matrix[i][j]=0;
                }
            }
        
        
    }//end
    
    void setZeroes_int(vector<vector<int>>& matrix) {
        
        // int m = matrix.size();
        // int n = matrix[0].size();
        
        vector<int> row, col;
        
        for(int i=0; i<matrix.size(); i++)
            for(int j=0; j<matrix[0].size(); j++)
            {
                if(matrix[i][j]==0)
                {
                    row.push_back(i);
                    col.push_back(j);
                }
            }
        
         for(int r=0; r<row.size(); r++)
            for(int j=0; j<matrix[0].size(); j++)
                matrix[row[r]][j]=0;
        
        for(int c=0; c<row.size(); c++)
            for(int i=0; i<matrix.size(); i++)
                matrix[i][col[c]]=0;
        
        
    }//end
    
    void setZeroes(vector<vector<int>>& matrix) {
        
        const int m = matrix.size();
        const int n = matrix[0].size();
        
        bool fillFirstRow = false;
        bool fillFirstCol = false;
        
        // first col is zero or not
        for(int r=0; r<m; r++)
            if(matrix[r][0]==0)
            {    
                fillFirstCol = true;
                break;
            }
        
        // first row is zero or not
        for(int c=0; c<n; c++)
            if(matrix[0][c]==0)
            {    
                fillFirstRow = true;
                break;
            }
        
         for(int r=1; r<m; r++)
             for(int c=1; c<n; c++)
                 if(matrix[r][c] == 0)
                 {
                     matrix[r][0]=0;
                     matrix[0][c]=0;
                 }
        
        for(int r=1; r<m; r++)
             for(int c=1; c<n; c++)
                 if(matrix[r][0] == 0 || matrix[0][c]==0)
                     matrix[r][c]=0;
        
        if(fillFirstRow)
        for(int c=0; c<n; c++)
             matrix[0][c]=0;
        
        if(fillFirstCol)
        for(int r=0; r<m; r++)
             matrix[r][0]=0;
        
    }//end
};