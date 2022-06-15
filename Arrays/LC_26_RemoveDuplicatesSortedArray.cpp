/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
26. Remove Duplicates from Sorted Array

*/

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        if(nums.size()==1) return 1;
        
        int i=0, j=1;
        
        while(j<nums.size())
        {
            while(nums[i]==nums[j])
            {
                j++;
                if(j==nums.size())return i+1;
            }
            i++;
            swap(nums[i], nums[j]);
            j++;
        }
        
        return i+1;
    }//end
};