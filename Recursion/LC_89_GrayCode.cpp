/*
https://leetcode.com/problems/gray-code/
89. Gray Code

*/
class Solution {
public:
    /*
    vector<int> grayCode(int n) {
        
        // Using mirroring concept.
        vector<int> ans{0,1};
        if(n==1) return ans;
        // if(n==2) return {0,1,3,2};
        
        int k=2; // from where we have to mirror
        for(int i=2; i<=n; i++) // number of iterations i=1-2-3-4 to n
        {
            for(int j=k-1; j>=0; j--)
            {
                ans.push_back(k + ans[j]);
            }
            k = 2*k; 
            
        }
        
        return ans;
    }//end
    */
    
    vector<int> grayCode(int n) {
        int totRange = 1<<n;
        vector<int> ans(totRange); //if n=3 then 8 values (0 to 7)
        ans[0] = 0; 
        ans[1] = 1;
        
        // for(int k = 2; k < totRange; k<<=1)  
        //     for(int j = 0; j < k; j++) 
        //         ans[j+k] = k + ans[k - 1 - j];
        
        for (int i = 0; i < totRange; i++)
           ans[i] = (i ^ (i >> 1));
        
        return ans;
    }
};