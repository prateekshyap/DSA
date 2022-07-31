/*
https://leetcode.com/problems/min-cost-climbing-stairs/
746. Min Cost Climbing Stairs

*/

class Solution {
public:
    vector<int> memo;
    
    int minCostClimbingStairs(vector<int>& cost) {
        
        memo.resize(cost.size()+1, -1);
        return recur(cost.size(), cost);
    }
    
    int recur(int ind, vector<int>& cost)
    {
        if(ind==0 || ind==1)
            return 0;
        
        if(memo[ind] != -1)
            return memo[ind];
        
        return memo[ind] = min(recur(ind-1, cost)+cost[ind-1], recur(ind-2, cost)+cost[ind-2]);
    }
};