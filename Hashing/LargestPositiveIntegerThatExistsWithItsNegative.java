/*https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/*/

class Solution {
    public int findMaxK(int[] nums) {
        int[] negHash = new int[1001];
        int[] posHash = new int[1001];
        Arrays.fill(negHash,-1);
        Arrays.fill(posHash,-1);
        int max = -1;
        for (int i = 0; i < nums.length; ++i)
        {
            if (nums[i] > 0)
            {
                if (negHash[nums[i]] != -1)
                    max = Math.max(max,nums[i]);
                posHash[nums[i]] = i;
            }
            else if (nums[i] < 0)
            {
                if (posHash[Math.abs(nums[i])] != -1)
                    max = Math.max(max,Math.abs(nums[i]));
                negHash[Math.abs(nums[i])] = i;
            }
            else if (nums[i] == 0)
                max = Math.max(max,nums[i]);
        }
        return max;
    }
}

