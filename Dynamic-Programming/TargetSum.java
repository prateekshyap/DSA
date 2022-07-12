/*https://leetcode.com/problems/target-sum/*/
/*https://practice.geeksforgeeks.org/problems/target-sum-1626326450/1*/

class Solution
{
    static int findTargetSumWays(int[] A , int N, int target)
    {
        int sum=0;
        for (int i = 0; i < A.length; ++i)
            sum = sum+A[i];
            
        if (target < -1*sum || target > sum) 
            return 0;
            

        int[][] dp = new int[A.length+1][sum*2+1];
        dp[0][sum] = 1;
        for (int i = 1; i <= A.length; ++i)
        {
            for (int j = 0; j < sum*2+1 ; ++j)
            {
                if (j+A[i-1] < sum*2+1)
                    dp[i][j] = dp[i][j]+dp[i-1][j+A[i-1]];
                if (j-A[i-1] >= 0)
                    dp[i][j] = dp[i][j]+dp[i-1][j-A[i-1]];
            }
        }
        return dp[A.length][sum+target];
    }
}

class Solution {
    int n, offset;
    Integer[][] counts;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        counts = new Integer[n+1][(2*sum)+1];
        offset = sum;
        counts[0][0+offset] = calculate(nums, 0, 0, target);
        return counts[0][0+offset];
    }
    private int calculate(int[] nums, int index, int currSum, int target)
    {
        if (index == n)
        {
            if (currSum == target) counts[index][currSum+offset] = 1;
            else counts[index][currSum+offset] = 0;
            return counts[index][currSum+offset];
        }
        if (counts[index][currSum+offset] != null) return counts[index][currSum+offset];
        int result = 0;
        result += calculate(nums, index+1, currSum+nums[index], target);
        result += calculate(nums, index+1, currSum-nums[index], target);
        counts[index][currSum+offset] = result;
        return result;
    }
}