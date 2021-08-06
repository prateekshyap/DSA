/*https://leetcode.com/problems/move-zeroes/*/

class Solution
{
    public void moveZeroes(int[] nums)
    {
        int store = 0, pick = 0, n = nums.length;
        
        //move both the pointers to the first 0 encountered
        while (pick < n && nums[pick] != 0)
        {
            ++pick;
            ++store;
        }
        
        //move pick to the next non-zero element
        while (pick < n && nums[pick] == 0)
        {
            ++pick;
        }
        
        //till the array is exhausted
        while (pick < n)
        {
            //shift
            nums[store] = nums[pick];
            
            //store 0
            nums[pick] = 0;
            
            //move pick to the next non-zero element
            while (pick < n && nums[pick] == 0) ++pick;
            
            //move store to the next zero element
            while (store < n && nums[store] != 0) ++store;
        }
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        for (int l = 0, i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t = nums[l];
                nums[l] = nums[i];
                nums[i] = t;
                l++;
            }
        }
    }
}