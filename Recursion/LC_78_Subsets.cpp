/*
https://leetcode.com/problems/subsets/
78. Subsets

*/

class Solution {
public:
    vector<vector<int>> ans;
    int n;
    
    vector<vector<int>> subsets(vector<int>& nums) {
        n = nums.size();
        vector<int> subset;
        backtrackHelper(nums, subset, 0);
        
        return ans;
    }//end
    
    void backtrackHelper11(vector<int>& input, vector<int> output, int idx)
    {
        // Recursive
        if(idx == input.size())
        {    
            ans.push_back(output);
            return ;
        }
        
        output.push_back(input[idx]);
            backtrackHelper11(input, output, idx+1);
        output.pop_back();
            backtrackHelper11(input, output, idx+1);
    }
    
    void backtrackHelper(vector<int>& input, vector<int>& subset, int idx)
    {
        ans.push_back(subset);
             
        for(int i=idx; i<input.size(); i++)
        {
            subset.push_back(input[i]);
                backtrackHelper(input, subset, i+1);
            subset.pop_back();
        }
    }
};