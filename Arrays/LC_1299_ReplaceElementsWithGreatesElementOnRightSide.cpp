/*
https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
1299. Replace Elements with Greatest Element on Right Side

*/

class Solution {
public:
    vector<int> replaceElements(vector<int>& arr) {
        int n = arr.size();
        vector<int> ans(n, -1);
        
        int max_sofar=arr[n-1];
        
        for(int i=n-2; i>=0; i--)
        {
           ans[i] = max_sofar;
           if(arr[i]>max_sofar)
               max_sofar = arr[i];
        }
        
        
        return ans;
    }
};