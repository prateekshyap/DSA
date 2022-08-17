/*
https://leetcode.com/problems/combination-sum-iii/
216. Combination Sum III

*/

class Solution {
public:
    vector<vector<int>> ans;
    vector<int> output;
    int K;
    vector<vector<int>> combinationSum3(int k, int n) {
        K=k;
        solve(1, n);
        return ans;
    }//
    
    void solve(int x, int sum)
    {
        if(K==output.size())
        {
            if(sum==0) ans.push_back(output);
            return;
        }
        
        for(int digit=x; digit<=9; digit++)
        {
            if(digit>sum) return;
            output.push_back(digit);
            solve(digit+1, sum-digit);
            output.pop_back();
        }
    }
    
};