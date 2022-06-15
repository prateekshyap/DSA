/*
https://leetcode.com/problems/contiguous-array/
525. Contiguous Array
https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1/
*/class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        
        int sum = 0;
        int max_len = 0;
        
        // BruteForce
        /*
        for(int i=0; i<nums.size(); i++)
        {
            sum = (nums[i]==0)? -1: 1;
            
            for(int j=i+1; j<nums.size(); j++)
            {
                sum += (nums[j]==0)?-1 : 1;
                
                if(sum == 0 && max_len < j-i+1)
                {
                    max_len = j-i+1;
                    
                }
            }
        }
        */
        
        //using hashmap
        unordered_map<int,int> prefix;
        prefix[0]=-1;
        for(int i=0; i<nums.size(); i++)
        {
            sum += (nums[i]==0)? -1: 1;
            
            if(prefix.find(sum) != prefix.end())
            {
                if(max_len < i - prefix[sum])
                    max_len = i-prefix[sum];
            }
            else
                prefix[sum] = i;
        }
        
        return max_len;
        
    }//end
};