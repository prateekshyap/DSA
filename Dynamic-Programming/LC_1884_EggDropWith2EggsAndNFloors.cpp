/*
1884. Egg Drop With 2 Eggs and N Floors
https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/


*/
//https://brilliant.org/wiki/egg-dropping/
class Solution {
public:
    int twoEggDrop(int k) {
        // memo.resize(2+1, vector<int>(k+1, -1));
        // return solve(2, k);
        return ceil(-0.5+ (sqrt(1+8*k)/2));
    }
    
    vector<vector<int>> memo;
    
    int solve(int e, int f)
    {
        if(f==0 || f==1)
            return memo[e][f]=f;
        
        if(e == 1)
            return memo[e][f]=f;
        
        if(memo[e][f] != -1)
            return memo[e][f];
            
        int mn = INT_MAX;
        for(int x=1; x<=f; x++)
        {
            // int ifbreaks = solve(e-1, x-1);
            // int ifnotbreaks = solve(e, f-x);
            // int ops = 1 + max(ifbreaks, ifnotbreaks);
            int ops = 1 + max(solve(e-1, x-1), solve(e, f-x));
            // cout<<e<<" "<<x<<" "<<ops<<") ";
            if(ops < mn)
                mn = ops;
        }
       
        // cout<<e<<" "<<f<<" "<<mn<<") "; 
        // cout<<endl;
        
        return memo[e][f]=mn;
    }
};