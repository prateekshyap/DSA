/*
https://leetcode.com/problems/rotate-array/
*/

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        k = nums.length-k;
        for (int i = 0, j = k-1; i < j; ++i, --j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        for (int i = k, j = nums.length-1; i < j; ++i, --j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        for (int i = 0, j = nums.length-1; i < j; ++i, --j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}