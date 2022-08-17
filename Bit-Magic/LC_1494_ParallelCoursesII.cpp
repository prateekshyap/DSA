/*
https://leetcode.com/problems/parallel-courses-ii/
1494. Parallel Courses II

*/


/*
NP Class Problem : DAG Scheduling Problem
BitMasking: Using 1 and 0 carefully to represt a state of the system. 2^n states (take or not)
Using integer called bitmask -> ith bit of mask is 1 indicates that ith course is taken.

At any semester state --> the courses you can take --> indegree of the course is 0 excluding the edges from the courses already taken

More than k option --> we compute all the submasks of the current mask
https://cp-algorithms.com/algebra/all-submasks.html
1 0 1 0 0 1 --> 1 0 1 0 0 0, 1 0 0 0 0 0, 0 0 0 0 0 0, 0 0 1 0 0 1
Overlapping SubProblems

Less than k option --> Greedly take all the option
*/
class Solution {
public:
    int N, K; // max n is 15
    vector<vector<int>> adj;
    int finalBitMask;
    vector<int> dp;
    
    int minNumberOfSemesters(int n, vector<vector<int>>& relations, int k) {
        
        if(relations.size()==0) // no precedence constraint given
            return n/k + bool(n%k); // n%k==0 -> n/k else n/k + 1;
        
        N=n; K=k;
        adj.resize(n);
        dp.assign((1<<n), -1);
        finalBitMask = ((1<<n)-1);// means all the courses have been taken // 2^n -1 all ones of length n bits
        
        //creating graph
        for(const auto& c: relations){
            adj[c[0]-1].push_back(c[1]-1); // numbered 1 to N
        }
        
        return solve(0); // currently no courses have been taken
    }
    
    int solve(int bitmask)
    {
        if(bitmask == finalBitMask) return 0; // all courses have been taken, no semesters required.
        
        if(dp[bitmask] != -1) return dp[bitmask];
        vector<int> ind(N, 0); // ind[i] : number of prerequisites for ith course excluding the ones already taken
        for(int i=0; i<N; i++)
        {
            if((bitmask & (1<<i)) == 0) // if course has not been taken then take now
            {
                for(int e: adj[i])
                    ind[e]++;
            } //else if ith bit mask is set that is ith course is already taken we won't care
           
        }
        
        int availmask=0; // the mask of courses that are available to take
        for(int i=0; i<N; i++)
        {
            if(((bitmask & (1<<i)) == 0) and ind[i] == 0)
                availmask |= (1<<i);
        }
        
        // cout<<"bitmask-> "<<bitmask<<" "<<bitset<5>(bitmask)<<" ->\t";
        // for(int i=0; i<N; i++)
        //     cout<<i+1<<"="<<ind[i]<<" \t";
        // cout<<"availmask-> "<<bitset<5>(availmask)<<" ->\t";
        // cout<<endl;
        
        int cnt = N+1;
        
        if(__builtin_popcount(availmask) <= K)
            cnt = min(cnt, 1 + solve(bitmask|availmask));
        else
        {
            // generating the submask of a given mask
            for(int submask = availmask; submask>0; submask = (submask-1) & availmask)
            {
                if(__builtin_popcount(submask) == K)
                    cnt = min(cnt, 1 + solve(bitmask|submask));
            }
        }
        return dp[bitmask] = cnt;
    }
    
};