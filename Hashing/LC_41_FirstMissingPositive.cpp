/*
https://leetcode.com/problems/first-missing-positive/
41. First Missing Positive

*/

class Solution {
public:
    int firstMissingPositive_2(vector<int>& nums) {
        int n=nums.size();
        vector<bool> vis(n+1);
        
        for(int x: nums)
            if(x>0 and x<=n)
                vis[x]=true;
        
        for(int i=1; i<=n; i++)
            if(!vis[i])
                return i;
        
        return n+1;
    }
    
    int firstMissingPositive_1(vector<int>& nums) {
        int ans=1;
        priority_queue<int, vector<int>, greater<int>> pq(nums.begin(), nums.end());
        
        while(!pq.empty())
        {
            int ele = pq.top();
            if(ele > 0)
            {
                if(pq.top() == ans)
                    ans++;
                // else
                //     return ans;
            }
            pq.pop();
        }
        
        return ans;
    }
    
    int firstMissingPositive_3(vector<int>& nums) {
        int n = nums.size();
        int max_pos_num = n+1;
        
        //modifying the input array
        for(int i=0; i<n; i++)
        {
            if(nums[i] <=0 || nums[i] > max_pos_num)
                nums[i] = max_pos_num;
        }
        
        for(int i=0; i<n; i++)
        {
            int val = abs(nums[i]);
            if(val <= n && nums[val-1]>0) //val should be <=n and +ve to negative kr do
                nums[val-1] *=-1;
        }
        
        for(int i=0; i<n; i++)
            if(nums[i] > 0)
                return i+1;
        
        return max_pos_num;
    }
    
    int firstMissingPositive(vector<int>& nums) {
        int n = nums.size();
        bool isFirstPresent=false;
        //modifying the input array
        for(int i=0; i<n; i++)
        {
            if(nums[i]==1) isFirstPresent=true;
            if(nums[i] <=0 || nums[i] > n)
                nums[i]=1;
        }
        
        if(!isFirstPresent) return 1;
        // cout<<endl;
        // for(int x: nums)
        //     cout<<x<<" ";
        
        for(int i=0; i<n; i++)
        {
            int val = abs(nums[i]);
            // int ele = nums[val-1];
            if(nums[val-1]>0)
                nums[val-1] *= -1;
        }
        // cout<<endl;
        // for(int x: nums)
        //     cout<<x<<" ";
        
        for(int i=0; i<n; i++)
            if(nums[i] > 0)
                return i+1;
        
        return n+1;
    }
};