/*
https://leetcode.com/problems/4sum/
18. 4Sum
https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1
*/
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        
        int l,r, sum, T, n = nums.size();
        vector<vector<int>> ans;
        if(n<4 || nums.empty()) return ans;
        sort(nums.begin(), nums.end());
        
        for(int i=0; i<n-3; i++)
        {
            if(i>0 && nums[i]==nums[i-1])continue;
            
            for(int j=i+1; j<n-2; j++)
            {
                if(j>i+1 && nums[j]==nums[j-1])continue;
                                                      
                T = target-nums[i]-nums[j];
                
                if(nums[j+1]+nums[j+2] > T) break;
                if(nums[n-1]+nums[n-2] < T) continue;
                
                l = j+1;
                r = n-1;
                while(l<r)
                {
                    // cout<<i<<" "<<j<<" "<<l<<" "<<r<<" "<<nums[i]+nums[j]+nums[l]+nums[r]<<endl;
                    sum = nums[l]+nums[r];
                    
                    if(sum > T) r--;
                    else if(sum < T) l++;
                    else{
                        ans.push_back(vector<int>{nums[i], nums[j], nums[l], nums[r]});
                        int curr_left = nums[l];
                        int curr_rgt = nums[r];
                        while(l<r && nums[l]==curr_left)l++;
                        while(l<r && nums[r]==curr_rgt)r--;
                    }
                        
                        
                }
            }
        }
        
        return ans;
    }
};