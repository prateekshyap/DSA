/*
https://leetcode.com/problems/pascals-triangle/
118. Pascal's Triangle

*/
class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        
        vector<vector<int>> ans(numRows);
        int row=0;
        
        for(int i=1; i<=numRows; i++)
        {
           row = i-1;
           // ans[row].resize(i); // resize row to its lenght
           // ans[row][0]=1; //  one in beginning, i-1 th row (0th indexing)
           // ans[row][row]=1;  //  one in end
           ans[row].push_back(1);
            if(row==0) continue;
           
           for(int col=1; col<row; col++ )
               // ans[row][col] = ans[row-1][col-1]+ ans[row-1][col];
                ans[row].push_back(ans[row-1][col-1]+ ans[row-1][col]);
          
            ans[row].push_back(1);
            
        }
        
        return ans;
    }//end
    
    vector<vector<int>> generate1(int numRows) {
        
        vector<vector<int>> ans{};
        ans.push_back({1});
        
        vector<int> temp1 = {1};
        vector<int> temp2;
        
        for(int i=2; i<=numRows; i++)
        {
          temp2 = {1}; //first one in the row
          
          for(int col=0; col<temp1.size()-1; col++)
              temp2.push_back(temp1[col] + temp1[col+1]); // middle values in the row
          
          temp2.push_back(1); //last one in the row
            
          ans.push_back(temp2);
          temp1=temp2;
            
        }
        
        return ans;
    }//end
    
};