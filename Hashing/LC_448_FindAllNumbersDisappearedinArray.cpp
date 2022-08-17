/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
448. Find All Numbers Disappeared in an Array

*/

class Solution {
public:
    vector<int> findDisappearedNumbers_(vector<int>& nums) {
        int n = nums.size();
        vector<int> count(n+1,0);
        // int count[n]={0};
        vector<int> ans;
        
        for(int i=0; i<n; i++)
        {
            count[nums[i]]++;
        }
        
        for(int i=1; i<=n; i++)
        {
            if(count[i] == 0)
                ans.push_back(i);
        }
        return ans;
    }//
    
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans;
        
        
        // for(int i=0; i<n; i++)
        // {
        //     int val = abs(nums[i]);
        //     int ele = nums[val-1];
        //     if(ele>0)
        //         nums[val-1] = -ele;  
        // }
        for (const int x : nums) {
          const int ind = abs(x) - 1;
            if(nums[ind]>0)
                nums[ind] = -nums[ind]; 
        }
        
        for(int i=0; i<n; i++)
        {
            if(nums[i]>0)
                ans.push_back(i+1);
        }
        return ans;
    }//
};