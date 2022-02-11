/*
https://leetcode.com/problems/two-sum/
1. Two Sum
*/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        
        int n = nums.size();
        
        // BRUTE FORCE APPROACH
//         for(int i=0; i< n; i++ )
//         {
//             for(int j=i+1; j<n ; j++)
//             {
//                 if(nums[i]+nums[j] == target)
//                     return {i,j};
//             }
//         }
    
        
        // SORT and TWO pointer approach (NOT Applicable as we have to return index of element)
//         sort(nums.begin(),nums.end());
        
//         int l=0;
//         int r=n-1;
//         while(l<r)
//         {
//           if(nums[l]+nums[r] == target)
//             return {l,r};  
//           else if(nums[l]+nums[r] < target)
//               l++;
//           else 
//               r--;
//         }
        
        
        // Using Hashmap
        
        unordered_map<int,int> um;
        for(int i=0; i<n; i++)
        {
            int rem_sum = target-nums[i];
            if(um.find(rem_sum) != um.end())
            {
                return {i,um[rem_sum]};
            }
            um.insert({nums[i],i});
        }
        
        
        return {-1};
    }//end
};