/*
https://leetcode.com/problems/combination-sum/
39. Combination Sum
https://practice.geeksforgeeks.org/problems/combination-sum-1587115620/1
*/

class Solution {
public:
    // int tg;
    vector<vector<int>> ans;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        // int n = candidates.size();
        //sort(candidates.begin(), candidates.end());
        //candidates.erase(unique(candidates.begin(), candidates.end()), candidates.end());
        // tg = target;
        // solve(0,0,{}, candidates);
        solve2(0, target, candidates);
        return ans;
    }
    
    vector<int> output;
    void solve2(int idx, int sum, vector<int>& cand )
    {
        if(idx >= cand.size())
        {
            if(sum==0) ans.push_back(output);
            return;
        }
        
        if(cand[idx]<= sum)
        {
            output.push_back(cand[idx]);
            solve2(idx, sum-cand[idx], cand);
            output.pop_back();
        }
        solve2(idx+1, sum, cand);
    }  
    
//     void solve(int idx, int sum, vector<int> temp, vector<int>& cand)
//     {
//         if(sum==tg)
//         {
//             ans.push_back(temp);
//             return;
//         }
        
//         for(int i=idx; i<cand.size(); i++)
//         {
//             if(cand[i]+sum <= tg)
//             {
//                 temp.push_back(cand[i]);
//                 solve(i, sum+cand[i], temp, cand);
//                 temp.pop_back();
//             }
//         }//for i
//     }//
};