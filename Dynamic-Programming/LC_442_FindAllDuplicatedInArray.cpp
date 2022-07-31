/*
https://leetcode.com/problems/find-all-duplicates-in-an-array/
442. Find All Duplicates in an Array

*/

class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        
        int n = nums.size(), val, ele;
        vector<int> ans;
        
        for(int i=0; i<n; i++)
        {
             val = abs(nums[i]);
             ele = nums[val-1];
            if(ele>0)
                nums[val-1] = -1*ele;
            else
                ans.push_back(val);
            // if(nums[abs(nums[i])-1] < 0)
            //     ans.push_back(abs(nums[i]));
            // else
            //     nums[abs(nums[i])-1] *=-1;
                
        }
        
        return ans;
    }//end
};