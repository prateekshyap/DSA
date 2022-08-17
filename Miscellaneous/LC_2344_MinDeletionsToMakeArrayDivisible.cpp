/*
https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/
2344. Minimum Deletions to Make Array Divisible
*/

class Solution {
public:
    int minOperations(vector<int>& nums, vector<int>& numsDivide) {
        int n = nums.size();
        int nd = numsDivide.size();
        // int gcdn = numsDivide[0];
        // for(int i =1; i<nd; i++)
        //     gcdn = __gcd(gcdn, numsDivide[i]);
        
        int gcdn = reduce(numsDivide.begin(), numsDivide.end(), numsDivide[0], [](int a, int b) {return gcd(a,b);});
        
        sort(nums.begin(), nums.end());
        for(int i=0; i<n; i++)
        {    
            if(gcdn % nums[i] == 0)
                return i;
            if(nums[i] > gcdn)
                break;
        }
        return -1;
    }
};