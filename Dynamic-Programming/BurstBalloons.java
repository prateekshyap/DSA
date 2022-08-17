/*https://leetcode.com/problems/burst-balloons/*/

class Solution {
    Integer[][] table;
    public int maxCoins(int[] nums) {
        int n = nums.length+2;
        int[] arr = new int[n];
        for (int i = 0; i < n-2; ++i)
            arr[i+1] = nums[i];
        arr[0] = arr[n-1] = 1;
        table = new Integer[n][n];
        table[1][n-2] = solve(arr,1,n-2);
        return table[1][n-2];
    }
    private int solve(int[] nums, int i, int j)
    {
        if (i > j) return 0;
        if (table[i][j] != null) return table[i][j];
        int result = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k)
            result = Math.max(result,solve(nums,i,k-1)+solve(nums,k+1,j)+nums[i-1]*nums[j+1]*nums[k]);
        return table[i][j] = result;
    }
}