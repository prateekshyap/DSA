/*
https://leetcode.com/problems/arithmetic-slices/
413. Arithmetic Slices

*/

class Solution {
public:
    int numberOfArithmeticSlices1(vector<int>& nums) {
        
        int n = nums.size();
        
        if(n>=0 && n<=2) return 0;
        
        vector<int> dp(n,0); // dp[i] arithmetic slices of length 3 ending at index i 
        int total =0;
        
        for(int i=2; i<nums.size(); i++)
        {
            if((nums[i]-nums[i-1])==(nums[i-1]-nums[i-2]))
            {
                dp[i] = dp[i-1]+1;
                total+=dp[i];
            }
        }
        
        
       return total; 
        
    }//end
    
    int numberOfArithmeticSlices(vector<int>& nums) {
        
        int n = nums.size();
        
        if(n>=0 && n<=2) return 0;
        
        int slow=0, fast= 1;
        int diff=0;
        int total =0;
        
        diff = nums[fast]-nums[slow];
        fast++ ; // fast ==>2
        
        for( ;fast < nums.size(); fast++)
        {
          
           if(nums[fast]-nums[fast-1] == diff)
           {
               if(fast-slow+1>=3)
               {
                   total+=fast-slow+1-2;
               }
               continue;
           }
            else
            {
                slow = fast-1;
                diff = nums[fast]-nums[slow];
            }
           
           
        }
    
       return total; 
        
    }//end
};