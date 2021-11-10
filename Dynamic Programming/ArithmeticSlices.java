/*https://leetcode.com/problems/arithmetic-slices/*/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        int i = 0, j = 1;
        while (j < nums.length)
        {
            int currGap = nums[j]-nums[i];
            int start = i;
            while (j < nums.length && nums[j]-nums[i] == currGap)
            {
                ++i; ++j;
            }
            int len = i-start;
            result += len*(len-1)/2; //it is just sum of n numbers
        }
        return result;
    }
}