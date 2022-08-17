/*
https://leetcode.com/problems/combination-sum-ii/
40. Combination Sum II

*/

class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        solve(0, target, candidates);
        return ans;
    }
    
    vector<vector<int>> ans;
    vector<int> output;
    void solve(int idx, int sum, vector<int>& cand )
    {
       if(sum==0)
       {   
           ans.push_back(output);
           return;
       }
        
        for(int i=idx; i<cand.size(); i++)
        {
            // check for duplicates from next index
            if(i>idx and cand[i]==cand[i-1]) continue;
            if(sum < cand[i]) return;
            output.push_back(cand[i]);
            solve(i+1, sum-cand[i], cand);
            output.pop_back();
        }
    }  
};