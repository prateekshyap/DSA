/*
338. Counting Bits
https://leetcode.com/problems/counting-bits/
*/

class Solution {
public:
    vector<int> countBits(int n) {
        
        if(n==0) return {0};
        if(n==1) return {0,1};
        
        
        vector<int> ans(n+1,0);
        ans[0]=0;
        ans[1]=1;
        int m=2;
        
        for(int i=2; i<=n; i++)
        {
        //   if(i == m*2) m =i;
        //     ans[i] = 1 + ans[i%m]; // divided into sections 0-1, 2-3, 4-7, 8-15. previous sections + 1
            ans[i] = ans[i & (i - 1)] + 1; // same logic as above but using AND operator
        }
        
        // Using BuiltIn PopCount
//         for(int i=2; i<=n; i++)
//             ans[i] = __builtin_popcount(i);
        
        
        
        return ans;
    }//end
};