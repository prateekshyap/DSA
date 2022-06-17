/*
https://leetcode.com/problems/combinations/
77. Combinations

*/

class Solution {
public:
    vector<vector<int>> ans;
    
    int N=0, K=0;
    
    vector<vector<int>> combine(int n, int k) {
        
        N=n;
        K=k;
        
        // for(int i=1; i<=N; i++)
        // { 
        //     backtrackHelper(i, {i});
        // }
        vector<int> cur;
        combineHelper(k, cur, 1);
        
        return ans;    
    }//end
    
    
    void backtrackHelper(int idx, vector<int> temp)
    {
        if(temp.size() == K)
        {
            ans.push_back(temp);
        }
        
        // temp.push_back(idx);
        
        for(int i=idx+1; i<=N; i++)
        {
            temp.push_back(i);
            backtrackHelper(i, temp);
            temp.pop_back();
        }
        // temp.pop_back();
    }
    
    void combineHelper(int k, vector<int> &cur, int i)
    {
        if(k==0)
        {
            ans.push_back(cur);
            return;
        }
        for(int j=i; j <= N-k+1; j++)
        {
            cur.push_back(j);
            combineHelper(k-1, cur, j+1);
            cur.pop_back();
        }
    }//
    
};