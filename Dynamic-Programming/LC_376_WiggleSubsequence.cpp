/*
https://leetcode.com/problems/wiggle-subsequence/
376. Wiggle Subsequence

https://practice.geeksforgeeks.org/problems/longest-alternating-subsequence5951/1/#

https://binarysearch.com/problems/Longest-Sign-Alternating-Subsequence
*/
class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        
        
        
        vector<int> up(nums.size(),1);
        vector<int> down(nums.size(),1);
        
        for(int i=1; i<nums.size(); i++)
        {
            if(nums[i-1] < nums[i])
            {
                up[i] = down[i-1] + 1;
                down[i]= down[i-1];
            }
            else if(nums[i-1] > nums[i])
            {
                down[i] = up[i-1] + 1;
                up[i]= up[i-1];
            }
            else
            {
                down[i]= down[i-1];
                up[i]= up[i-1];
            }
        }
        
        return max(up[nums.size()-1], down[nums.size()-1]);
        
        
        // O(n)
        
//         int up=1;
//         int down=1;
//         for(int i=1; i<nums.size(); i++)
//         {
//             if(nums[i-1] < nums[i]) // current num is greater than previous
//                 up = down+1;  
//             else if(nums[i-1] > nums[i]) // current num is lesser than previous
//                 down = up+1;
//         }
        
//         return max(up, down);
    }// end
};