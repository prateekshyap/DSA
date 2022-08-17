/*
https://practice.geeksforgeeks.org/problems/count-of-ap-subsequences0016/1
*/

class Solution{
public:
typedef long long LL ;
    long long ans;
    int n; 
    long long int count(int N, int A[])
    {
        n = N;
        ans=0;
        vector<LL> cur;
        dfs(0, A, cur); // brute force approach to find all subsequence
        ans+=N+1; // count of empty and singleton set
        return ans;
    }
        
    void dfs(int dep, int nums[], vector<LL> cur)
    {
        if(dep == n){
            int cs = cur.size();
            if(cs < 2) return;
            // check if subsequence of >=2 length is AP or not
            int diff = cur[1] - cur[0];
            for(int i=2; i<cs; i++)
            {
                if(cur[i] - cur[i-1] != diff)
                    return;
            }
            // for(auto &x: cur) cout<<x<<" "; cout<<endl;
            ans++;
            return;
        }
        
        dfs(dep+1, nums, cur); // without char
        cur.push_back(nums[dep]);
        dfs(dep+1, nums, cur); // with char
    }
};