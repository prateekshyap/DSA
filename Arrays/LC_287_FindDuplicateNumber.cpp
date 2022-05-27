/*
https://leetcode.com/problems/find-the-duplicate-number/
287. Find the Duplicate Number

*/

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        /*
        sort(nums.begin(), nums.end());
        
        for(int i=1; i<nums.size(); i++)
        {
            if(nums[i-1]==nums[i])
                return nums[i];
        }
        
        return -1;
        */
        /*
        set<int> s;
        
        for(int i=0; i<nums.size(); i++)
        {
            if(s.find(nums[i]) == s.end())
                s.insert(nums[i]);
            else
                return nums[i];
        }
        
        return -1;
        */
        // /Floyd's Tortoise and Hare
        
//         int slow = nums[0];
//         int fast = nums[0];
        
//         do
//         {
//             slow = nums[slow];
//             fast = nums[nums[fast]];
//         }while(slow!=fast);
        
//         // find the exact location
//         slow = nums[0];
//         while(slow!=fast)
//         {
//             slow = nums[slow];
//             fast = nums[fast];
//         }
//         return fast;
        
        for(int i=0; i<nums.size(); i++)
        {
            int ind = abs(nums[i]);
            
            if(nums[ind] < 0)
                return ind;
            
            nums[ind]*=-1;
        }
        
        return -1;
    }// end
};