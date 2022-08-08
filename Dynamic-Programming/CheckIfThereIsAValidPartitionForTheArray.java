/*https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/*/

class Solution {
    Boolean[] table;
    public boolean validPartition(int[] nums) {
        table = new Boolean[nums.length];
        return checkValidity(nums,0);
    }
    private boolean checkValidity(int[] nums, int index)
    {
        if (index == nums.length)
            return true;
        if (table[index] != null) return table[index];
        boolean result = false;
        
        if (index+1 < nums.length && nums[index] == nums[index+1])
            result |= checkValidity(nums,index+2);
        if (index+2 < nums.length)
        {
            if (nums[index] == nums[index+1] && nums[index+1] == nums[index+2])
                result |= checkValidity(nums,index+3);
            if (nums[index] == nums[index+1]-1 && nums[index+1] == nums[index+2]-1)
                result |= checkValidity(nums,index+3);
        }
        table[index] = result;
        
        return result;
    }
}



class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        if (n == 1) return false;
        // if (n == 2) return nums[0] == nums[1];
        boolean[] dp = new boolean[n];
        if (nums[0] == nums[1]) dp[1] = true;
        if ((nums[0] == nums[1] && nums[1] == nums[2]) || 
            (nums[0] + 1 == nums[1] && nums[1] + 1 == nums[2])) dp[2] = true;
        for (int i = 3; i < n; i++) {
            if (nums[i] == nums[i-1] && dp[i-2]) dp[i] = true;
            else if (((nums[i] == nums[i-1] && nums[i-1] == nums[i-2]) || 
                      (nums[i] - 1 == nums[i-1] && nums[i-1] - 1 == nums[i-2])) && dp[i-3]) dp[i] = true;
        }
        return dp[n-1];
    }
}

