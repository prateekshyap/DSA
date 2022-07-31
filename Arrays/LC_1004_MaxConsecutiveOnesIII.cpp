/*
https://leetcode.com/problems/max-consecutive-ones-iii/
1004. Max Consecutive Ones III

https://practice.geeksforgeeks.org/problems/maximize-number-of-1s0905/1
*/

class Solution {
public:
    int longestOnes_1(vector<int>& nums, int k) {
        int n = nums.size();

        int i=0, j=0, cntz=0, ones=0;
        int ans=0;
       
        while(j<nums.size())
        {
            if(nums[j]==0)
                cntz++;
            else
                ones++;
            
            while(i<j and cntz>k)
            {
                if(nums[i]==0)
                    cntz--;
                i++;
            }
            // cout<<i<<" "<<j<<endl;
            
            if(ones!=0 or k!=0)
                ans = max(ans, j-i+1);
            else
                ans = max(ans, j-i);
            j++;
        }
       return ans;
    }
    
     int longestOnes(vector<int>& nums, int k) {
        int n = nums.size();

        int ans=0;
         int l=0, r=0, cntz=0;
         
         while(l<n && r<n)
         {
            if(nums[r] == 0)
                cntz++;
             
             if(cntz>k)
             {
                if(nums[l] == 0)
                    cntz--;
                ++l;    
             }
             cout<<l<<" "<<r<<endl;
             ++r;
         }
         
       return r-l;
    }

};

