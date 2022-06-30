/*https://leetcode.com/problems/subarrays-with-k-different-integers/*/

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
    
    public int solve(int[] nums, int k){
        int[] frequency = new int[nums.length+1];
        int l = 0, h = 0, ans = 0, uniqueCount = 0;
        while (h < nums.length)
        {
            ++frequency[nums[h]];
            if (frequency[nums[h]] == 1) ++uniqueCount;

            while (uniqueCount > k)
            {
                --frequency[nums[l]];
                if (frequency[nums[l]] == 0) --uniqueCount;
                ++l;
            }

            ans += h-l+1;
            ++h;
        }
        return ans;
    }
}

