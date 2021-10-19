/* 
 https://leetcode.com/problems/find-pivot-index/
*/


class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int tsum = 0, lsum=0; // total sum, left sum;
        int n = nums.size();
         //total sum of array
         for (int i = 0; i < n; ++i)
            tsum += nums[i];
            
         for (int i = 0; i < n; ++i) {
               // tsum is now right sum for index i
                if ((2*lsum) == (tsum-nums[i]) ) //x+LSum+RSum=Tsum
                    return i;
               // if ( (2*lsum) > (tsum-nums[i]) )
                 //   return -1;
                    
                lsum += nums[i];
         }
        return -1;
    }
};
