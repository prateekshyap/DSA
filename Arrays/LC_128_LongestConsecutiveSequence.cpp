/*
https://leetcode.com/problems/longest-consecutive-sequence/
128. Longest Consecutive Sequence
https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1/
*/

class Solution {
public:
    // O(nlogn) algorithm
    int longestConsecutive_nlogn(vector<int>& nums) {
        if(nums.empty()) return 0;
        sort(nums.begin(), nums.end());
        
        int ans=1;
        int len=1;
        for(int i=1; i<nums.size(); i++)
        {
            cout<<nums[i]<<" ";
            if(nums[i] == nums[i-1]+1) // sequence find then +1
                len++;
            else if(nums[i] != nums[i-1]) //new sequence reset
                len=1;
            //else skip duplicates
            
            ans = max(ans, len);
        }
        
        return ans;
    }//end
    
    int longestConsecutive(vector<int>& nums) {
        if(nums.empty()) return 0;
        
        int ans=0;
        unordered_set<int> us(nums.begin(), nums.end());
        
        for(int i=0; i<nums.size(); i++)
        {
            if(us.find(nums[i]-1) == us.end()) // first seq in series
            {
                int len = 1;
                while(us.find(nums[i] +  len) != us.end())
                    len++;
                
                ans = max(ans, len);
            }
            /*
            if(us.find(nums[i]-1) != us.end())
                continue;
            else
            {
                int cnt=0, x = nums[i];
                while(us.find(x) != us.end())
                {
                    cnt++;
                    x++;
                }
                ans = max(ans, cnt);
            }
            */
        }
        
        return ans;
    }//end
};