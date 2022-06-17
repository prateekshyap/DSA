/*
https://leetcode.com/problems/pascals-triangle-ii/
119. Pascal's Triangle II

*/
class Solution {
public:
    /*
    vector<int> getRow(int rowIndex) {
        
        vector<int> temp1 = {1};
        vector<int> temp2;
        
        for(int i=1; i<=rowIndex; i++)
        {
          temp2 = {1}; //first one in the row
          
          for(int col=0; col<temp1.size()-1; col++)
              temp2.push_back(temp1[col] + temp1[col+1]); // middle values in the row
          temp2.push_back(1); //last one in the row
          temp1=temp2;
        }
        return temp1;
    }//end
    */
    //without extra space
     vector<int> getRow(int rowIndex) {
        
        vector<int> ans;
        
         long int coeff=1;
         for(int c=0; c<=rowIndex; c++)
         {
             ans.push_back(coeff);
             coeff = coeff * (rowIndex - c)/(c+1);
         }
         
        return ans;
    }//end
};