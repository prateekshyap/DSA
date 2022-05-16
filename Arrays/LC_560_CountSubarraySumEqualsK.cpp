/*
https://leetcode.com/problems/subarray-sum-equals-k/
560. Subarray Sum Equals K

*/
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        
          unordered_map<int,int> prefix;
          int sum = 0, fnd=0;
          prefix[sum] = 1; // if sum ==0
         
          int count=0;

          for(int x : nums)
          {
              sum += x; // sum till current i_th element, calculating the prefix 
              
              fnd = sum - k;
              
              if(prefix.find(fnd)!=prefix.end()) count += prefix[fnd];

              prefix[sum]++;

          }
          return count;
        
    }//end
};