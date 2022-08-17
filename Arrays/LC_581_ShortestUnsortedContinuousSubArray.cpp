/*
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
581. Shortest Unsorted Continuous Subarray

*/

class Solution {
public:
    
     int findUnsortedSubarray(vector<int>& nums) {
        int n = nums.size();
        int l = 0, r=-1;
        
        int mn = nums.back(), mx=nums.front();
         
        for(int i=0; i<n; i++)
        {
            mx = max(nums[i], mx);
            mn = min(nums[n-1-i], mn);
            
            if(mx > nums[i])
                r = i;
            if(mn < nums[n-1-i])
                l = n-1-i;
        }
         
        return r-l+1;
    }//end
    
    int findUnsortedSubarray_2(vector<int>& nums) {
        int n = nums.size();
        int l = 0, r=n-1;
        
        int mn = INT_MAX, mx=INT_MIN;
        while(l<n-1 and nums[l] <= nums[l+1])
            l++;
        
        if(l == n-1) // already sorted in aescending order
            return 0;
        
        while(r>0 and nums[r-1]<=nums[r])
            r--;
        
        if(r==0) // sorted in descending order
            return n;
        
        for(int i=l; i<=r; i++)
        {
            mx = max(nums[i], mx);
            mn = min(nums[i], mn);
        }
        
        while(l>0 and nums[l-1] > mn)
            l--;
        while(r<n-1 and mx > nums[r+1])
            r++;
        
        return r-l+1;
    }//end
    
     int findUnsortedSubarray_1(vector<int>& nums) {
         int n = nums.size();
         int l = -1, r=-1;
        
         vector<int> sorted(nums);
         sort(sorted.begin(), sorted.end());
         
         for(int i=0; i<n; i++)
         {
           if(l == -1 and nums[i] != sorted[i])
           {
               l = i;
               r = i;
           }
            else if(l != -1 and nums[i] != sorted[i])
           {
               r = i;
           }
         }
         // for(int x: nums)
         //     cout<<x<<" ";
         // cout<<endl;
         // for(int x: sorted)
         //     cout<<x<<" ";
         // cout<<endl;
         // cout<<l<<" "<<r<<endl;
        
        return l == -1 ? 0 : r-l+1;
    }//end
};