/*
https://leetcode.com/problems/3sum/
15. 3Sum

*/
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        
        vector<vector<int>> ans;
        int n = nums.size();
        if(n<3) return ans;
        
        
        sort(nums.begin(), nums.end());
    
        int l=0, r=0, sum=0;
        for(int i=0; i<n-2; i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue; //do not consider same element which is already taken previously;
            l = i+1;
            r = n-1;
            while(l<r)
            {
                sum=nums[i] + nums[l] + nums[r];
                if(sum == 0)
                {
                    ans.push_back({nums[i] , nums[l] , nums[r]});
                    // l++;
                    int curr_left = nums[l];
                    int curr_right = nums[r];
                    while(l<r && nums[l]==curr_left) l++;
                    while(l<r && nums[r]==curr_right) r--;
                    
                }    
                else if(sum<0)
                    l++;
                else
                    r--;
            }
        }
    
        return ans;
    }
};