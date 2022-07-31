/*
https://leetcode.com/problems/maximum-subarray/
53. Maximum Subarray
https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1/

https://binarysearch.com/problems/Largest-Sublist-Sum
*/
class Solution {
public:
    int maxSubArray1(vector<int>& nums) {
       
       if(nums.size() == 1) return nums[0];
        
       int curr_max = nums[0];
       int max_sum = nums[0];
       
       for(int i=1; i<nums.size(); i++)
       {
           if(curr_max + nums[i] > nums[i])
               curr_max =  curr_max + nums[i]; // if inculding current nums_i it is greater than include
           else
               curr_max = nums[i]; // reset value of curr_max if not greater than current nums_i
           
           if(max_sum < curr_max)
               max_sum = curr_max;
       }
        
        return max_sum;
        
    }//end
    
     int maxSubArray(vector<int>& nums) {
       
       if(nums.size() == 1) return nums[0];
        
       int curr_max = 0;
       int max_sum = INT_MIN;
       
       for(int i=0; i<nums.size(); i++)
       {
           curr_max =  curr_max + nums[i]; // if inculding current nums_i it is greater than include
          
           
           if(max_sum < curr_max)
               max_sum = curr_max;
           
           if(curr_max < 0)
               curr_max = 0;
       }
        
        return max_sum;
        
    }//end
};