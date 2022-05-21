/*https://leetcode.com/problems/rotate-function/*/

class Solution {
    public int maxRotateFunction(int[] nums) {
        int i = 0, sum = 0, f = 0, max = Integer.MIN_VALUE, n = nums.length;
        
        for (i = 0; i < n; ++i)
        {
            sum += nums[i];
            f += i*nums[i];
        }
        
        max = f;
        
        for (i = n-1; i > 0; --i)
        {
            f += (sum - nums[i]*n);
            if (f > max) max = f;
        }
        
        return max;
    }
}