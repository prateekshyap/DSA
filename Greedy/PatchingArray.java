/*https://leetcode.com/problems/patching-array/*/

class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0, i = 0, N = nums.length;
        long result = 0, curr = nums[0];
        while (result < n)
        {
            curr = i <= N-1 ? Math.min(nums[i],(long)n+1) : n;
            while (result < curr-1)
            {
                result += result+1;
                ++patches;
            }
            result += curr;
            ++i;
        }
        return patches;
    }
}