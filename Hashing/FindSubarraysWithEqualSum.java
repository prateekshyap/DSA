/*https://leetcode.com/problems/find-subarrays-with-equal-sum/*/

class Solution {
    public boolean findSubarrays(int[] nums) {
        int currSum = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length-1; ++i)
        {
            currSum = nums[i]+nums[i+1];
            if (set.contains(currSum)) return true;
            set.add(currSum);
        }
        return false;
    }
}

class Solution {
    public boolean findSubarrays(int[] nums) {
        int currSum = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length-1; ++i)
        {
            currSum = nums[i]+nums[i+1];
            if (!set.add(currSum)) return true;
        }
        return false;
    }
}