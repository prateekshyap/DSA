/*
https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
2357. Make Array Zero by Subtracting Equal Amounts
*/

class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        /*
        int n = nums.size();
        int ops=0;
        sort(nums.begin(), nums.end());
        for(int i=0; i<n; i++)
        {
            if(nums[i] != 0)
            {
                int pick = nums[i];
                ops++;
                for(int j=i; j<n; j++)
                {
                    if(nums[j])
                        nums[j] -= pick;
                }
            }
        }
        return ops;
        */
        unordered_set<int> s;
        for(int x: nums)
        {
            if(x != 0)
                s.insert(x);
        }
        return s.size();
    }
};