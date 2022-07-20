/*https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/*/

class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = (int)1e9 +7;
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        int ans = 0;

        int[] power = new int[nums.length];
        power[0] = 1;
        for (int idx = 1; idx < nums.length; ++idx)
            power[idx] = (power[idx-1]*2)%mod; 
        while (l <= r)
        {
            if (nums[l]+nums[r] <= target)
            {
                ans = (ans+power[r-l])%mod;
                l++;
            }
            else
                r--;
        }
        return ans;
    }
}