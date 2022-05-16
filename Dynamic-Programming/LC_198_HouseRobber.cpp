/*
https://leetcode.com/problems/house-robber/
198. House Robber

*/

class Solution {
public:
    int rob(vector<int>& nums) {
        
        int n = nums.size();
        
        if(n==0) return 0; // no house to take
        if(n==1) return nums[0]; // only one house to take
        
        
        int prev1 = 0; // i-1
        int prev2 = 0; // i-2
        int curr = 0;
        
        for(int i=0; i<n; i++)
        {
           curr = max(prev1, prev2 + nums[i]);
           prev2 = prev1;
           prev1 = curr;
        }
        return curr;
        
//         vector<int> tab(n, 0); // max money that can be robbed from 0th indexed house to n-1th indexed house
//         tab[0] = nums[0];
//         tab[1] = max(nums[0],nums[1]);
        
//         for(int i=2; i<n; i++)
//             tab[i] = max(tab[i-1], nums[i] + tab[i-2]);
        
//         return tab[n-1];
    }//
};