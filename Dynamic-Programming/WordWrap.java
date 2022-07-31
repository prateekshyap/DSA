/*https://practice.geeksforgeeks.org/problems/word-wrap1646/1*/

//tle
class Solution
{
    int minCost,n;
    int[] dp;
    public int solveWordWrap (int[] nums, int k)
    {
        // Code here
        n = nums.length;
        minCost = Integer.MAX_VALUE;
        dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        wordWrapSolver(nums, k, 0, 0);
        return minCost;
    }
    public void wordWrapSolver(int[] nums, int k, int index, int currCost)
    {
        if (index >= n)
        {
            if (currCost < minCost) minCost = currCost;
            return;
        }
        int charCount = 0, cost;
        boolean startWord = true;
        while (index < n && ((startWord && charCount+nums[index] <= k) || (!startWord && charCount+nums[index]+1 <= k)))
        {
            charCount += nums[index];
            if (!startWord) ++charCount;
            startWord = false;
            ++index;
            if (index < n) cost = (k-charCount)*(k-charCount); else cost = 0;
            if (currCost+cost < minCost && currCost+cost <= dp[index])
            {
                dp[index] = currCost+cost;
                wordWrapSolver(nums, k, index, currCost+cost);
            }
        }
    }
}

//efficient
class Solution
{
    int n;
    int[] dp;
    public int solveWordWrap (int[] nums, int k)
    {
        // Code here
        n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return wordWrapSolver(nums, k, 0);
    }
    public int wordWrapSolver(int[] nums, int k, int index)
    {
        if (index >= n) return 0;
        if (dp[index] != -1) return dp[index];
        int charCount = 0, cost = Integer.MAX_VALUE, i;
        for (i = index; i < n; ++i)
        {
            if (i > index) ++charCount;
            charCount += nums[i];
            if (charCount > k) break;
            if (i < n-1) cost = Math.min(cost,(k-charCount)*(k-charCount)+wordWrapSolver(nums, k, i+1)); else cost = 0;
        }
        dp[index] = cost;
        return cost;
    }
}