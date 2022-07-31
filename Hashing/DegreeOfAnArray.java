/*https://leetcode.com/problems/degree-of-an-array/*/

class Solution {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length, i, maxSize = 0, maxFreq = 0;
        int[] freq = new int[50000], start = new int[50000];
        Arrays.fill(start,-1);
        for (i = 0; i < n; ++i)
        {
            ++freq[nums[i]];
            if (start[nums[i]] == -1) start[nums[i]] = i;
            if (freq[nums[i]] > maxFreq)
            {
                maxFreq = freq[nums[i]];
                maxSize = i-start[nums[i]]+1;
            }
            else if (freq[nums[i]] == maxFreq && i-start[nums[i]]+1 < maxSize)
                maxSize = i-start[nums[i]]+1;
        }
        return maxSize;
    }
}

