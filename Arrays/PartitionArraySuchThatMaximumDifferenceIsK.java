/*https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/*/

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, start = 0, end = 0, n = nums.length;
        while (end < n)
        {
            if (end+1 < n && nums[end+1]-nums[start] <= k) ++end;
            else
            {
                ++count;
                start = end+1;
                end = start;
            }
        }
        return count;
    }
}