/*
https://leetcode.com/problems/super-egg-drop/
887. Super Egg Drop

*/

class Solution {
public:
    vector<vector<int>> memo;
    int superEggDrop(int k, int n) {
        return superEggDropMaths(k,n);
        
        // memo.resize(k+1, vector<int>(n+1, -1));
        // return solveopti(k,n);
    }
    
    int solveopti(int e, int f)
    {
        if(f==0 || f==1)
            return memo[e][f]=f;
        
        if(e == 1)
            return memo[e][f]=f;
        
        if(memo[e][f] != -1)
            return memo[e][f];
            
        int mn = INT_MAX;
        // for(int x=1; x<=f; x++)
        // {
        //     int ops = 1 + max(solve(e-1, x-1), solve(e, f-x));
        //     if(ops < mn) mn = ops;
        // }
        int x, t1, t2;
        int lo = 1, hi = f;
        while(lo<=hi)
        {
            x = (lo+hi)>>1;
            if(memo[e-1][x-1]!=-1) t1 = memo[e-1][x-1];
            else t1 = memo[e-1][x-1]= solveopti(e-1, x-1);
            
            if(memo[e][f-x]!=-1) t2 = memo[e][f-x];
            else t2 = memo[e][f-x]= solveopti(e, f-x);
            
            if(t1<t2)
                lo=x+1;
            else //if(t1>t2)
                hi=x-1;
            // else
            //     lo=hi=x;
        }
        
        int ops1 = 1 + max(memo[e-1][lo-1], memo[e][f-lo]);
        int ops2 = 1 + max(memo[e-1][hi-1], memo[e][f-hi]);
        mn = min({mn, ops1, ops2});
       
        
        return memo[e][f]=mn;
    }
    
    // f(drops (d),Eggs(K)) >= Floors (N)
    // f(drops,Eggs) is the number of floors we can cover with K eggs, N Floors and no more than d drops in the worst case;
    int superEggDropMaths(int E, int F) {
        //K->E eggs, N->F floors
        int lo = 1;
        int hi = F;
        while(lo<hi)
        {
            int drops = (lo+hi)/2;
            if(binomial(drops,E,F) < F)
                lo = drops+1;
            else
                hi = drops;
        }
        return lo;
    }

    //evaluates C(n,k->E) and verifies if it is greater than or equal to n
    int binomial(int n, int E, int F)
    {
        int ans=0;
        int aux=1;
        
        for(int i=1; i<=E; i++)
        {
            aux *= (n-i+1);
            aux /= i;
            ans += aux;
            if(ans>=F) break;
        }
        
        return ans;
    }
    /*
    // TLE
    int superEggDrop(int k, int n) {
        memo.resize(k+1, vector<int>(n+1, -1));
        return solve(k, n);
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
    */
};