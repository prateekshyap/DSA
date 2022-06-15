/*
https://leetcode.com/problems/k-diff-pairs-in-an-array/
532. K-diff Pairs in an Array

*/

class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        
        unordered_map<int,int> um;
        int count=0;
    
        for(int x: nums)
        {
            if(um.find(x) != um.end() ) 
            {
                if(k>0)
                    continue; // skip the repeated elements
                else if(um[x]==1) // if 1,1,1,1,1
                    count++;
            }
            else
            {
                if(um.find(x+k) != um.end()) count++;
                if(um.find(x-k) != um.end()) count++;
            }
            um[x]++;
        }
        
        /*
        for(int x: nums)
            um[x]++;
        
        if(k==0)
        {
            for(auto f: um)
            {
                if(f.second>1)
                    count++;
            }
        }
        else {
                for(auto f: um)
                    if(um.find(f.first+k) != um.end()) //every ele is present in map
                        count++;
        }
        */

        return count;
        
    }
    
    int findPairs__(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
    
        int i=0, j=1, diff=0; //there is monotonicity that we are moving in only one direction in order to determine the answer.
        int count=0, n = nums.size();
        
        while(i<n && j<n)
        {
            diff = abs(nums[i]-nums[j]);

            if(diff > k) {
                i++; //decrease the diff
                if(i==j) j++;
            }
            else if(diff < k) j++;
            else
            {
                i++; j++;
                // while(i<n && nums[i]==nums[i-1])i++;
                while(j<n && nums[j]==nums[j-1])j++;
                
                count++;
            }
        }

        return count;
    }
};