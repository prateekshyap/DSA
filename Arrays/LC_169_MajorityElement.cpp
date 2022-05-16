/*
169. Majority Element

https://leetcode.com/problems/majority-element/
https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1/
*/

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        
        int n = nums.size();
        unordered_map<int,int> umap;
        
 // APPROACH 1.5
        // for(int i: nums)
        // { 
        //     umap[i]++;
        //     if(umap[i] > nums.size()/2)
        //         return i;
        // }
        
// APPROACH 1
        
        // for(int i: nums)
        //     umap[i]++;
        
//         int max=0;
        // for(auto x : umap)
        // {
        //     if(x.second > max && x.second > nums.size()/2)
        //         max = x.first;
        // }
        
        // unordered_map<int,int>::iterator it;
        // for(it = umap.begin(); it!=umap.end(); it++)
        // {
        //     if(it->second > max && it->second > nums.size()/2)
        //         max = it->first;
        // }
        
        
        //Approach 2, no extra space
        // sort(nums.begin(), nums.end());
        // for(auto x : nums)
        // {
        //     cout<<x<<" ";
        // }
        // cout<<" "<<ceil(n/4.0);
        // if(nums[0]==nums[n/2] || nums[n-1]==nums[n/2])
        //     max = nums[n/2];
        // else if(nums[ceil(n/4.0)-1]==nums[n/2] || nums[n/2 + ceil(n/4.0) -1]==nums[n/2])
        //     max = nums[n/2];
        
        // return max;
        
        
        //Approach 3: Moore's Voting Algorithm
        
        int maj_count=1;
        int maj_ind = 0;
        for(int i=1; i<nums.size(); i++)
        {
            if(nums[i] == nums[maj_ind])
                maj_count++;
            else
                maj_count--;
            
            if(maj_count==0)
            {
                maj_count=1;
                maj_ind = i;
            }
        }
        
        maj_count=0;
        for(int i=0; i<nums.size(); i++)
        {
            if(nums[i]==nums[maj_ind])
                maj_count++;
            if(maj_count > nums.size()/2)
                return nums[maj_ind];
        }
        
        return -1;
        
    }//end
};