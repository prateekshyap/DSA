/*https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/*/

//TLE
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        return score(nums,multipliers,0,nums.length-1,0);
    }
    private int score(int[] nums, int[] muls, int start, int end, int index)
    {
        if (index == muls.length) return 0;
        int left = muls[index]*nums[start]+score(nums,muls,start+1,end,index+1);
        int right = muls[index]*nums[end]+score(nums,muls,start,end-1,index+1);
        return Math.max(left,right);
    }
}

//MLE
class Solution {
    Integer[][][] table;
    public int maximumScore(int[] nums, int[] multipliers) {
        table = new Integer[nums.length][nums.length][multipliers.length];
        table[0][nums.length-1][0] = score(nums,multipliers,0,nums.length-1,0);
        return table[0][nums.length-1][0];
    }
    private int score(int[] nums, int[] muls, int start, int end, int index)
    {
        if (index == muls.length) return 0;
        if (table[start][end][index] != null) return table[start][end][index];
        int left = muls[index]*nums[start]+score(nums,muls,start+1,end,index+1);
        int right = muls[index]*nums[end]+score(nums,muls,start,end-1,index+1);
        return table[start][end][index] = Math.max(left,right);
    }
}

//Again MLE
class Solution {
    Integer[][] table;
    public int maximumScore(int[] nums, int[] multipliers) {
        table = new Integer[nums.length][multipliers.length];
        table[0][0] = score(nums,multipliers,0,0);
        return table[0][0];
    }
    private int score(int[] nums, int[] muls, int start, int index)
    {
        if (index == muls.length) return 0;
        if (table[start][index] != null) return table[start][index];
        int left = muls[index]*nums[start]+score(nums,muls,start+1,index+1);
        int right = muls[index]*nums[nums.length-1-(index-start)]+score(nums,muls,start,index+1);
        return table[start][index] = Math.max(left,right);
    }
}

//Accepted
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        int[] dp = new int[m+1];
        for (int index = m-1; index >= 0; --index)
        {
            int[] nextRow = dp.clone();
            for (int left = index; left >= 0; --left)
            {
                dp[left] = Math.max(multipliers[index]*nums[left]+nextRow[left+1],multipliers[index]*nums[n-1-(index-left)]+nextRow[left]);
            }
            // for (int i = 0; i < dp.length; ++i)
            //     System.out.print(dp[i]+" ");
            // System.out.println();
        }
        return dp[0];
    }
}