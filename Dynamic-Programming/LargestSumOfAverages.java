/*https://leetcode.com/problems/largest-sum-of-averages/*/

class Solution {
    Double[][] memory;
    public double largestSumOfAverages(int[] nums, int k) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        memory = new Double[nums.length][k+1];
        return getMaximumPartition(nums,0,k,(double)sum);
    }
    private double getMaximumPartition(int[] nums, int index, int k, double sum)
    {
        if (index == nums.length) return 0;
        if (memory[index][k] != null) return memory[index][k];
        if (k == 1)
        {
            double currAvg = 0;
            for (int i = index; i < nums.length; ++i)
                currAvg += nums[i];
            return memory[index][k] = currAvg/(nums.length-index);
        }
        double result = 0;
        double currAvg = 0;
        for (int i = index; i <= nums.length-k; ++i)
        {
            currAvg += nums[i];
            result = Math.max(currAvg/(i-index+1)+getMaximumPartition(nums,i+1,k-1,sum),result);
        }
        return memory[index][k] = result;
    }
}

class Solution {
    double[][] memory;
    public double largestSumOfAverages(int[] nums, int k) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        memory = new double[nums.length+1][k+1];
        for (int i = 0; i <= k; ++i)
            memory[nums.length][i] = 0;
        for (int i = 0; i < nums.length; ++i)
        {
            for (int j = i; j < nums.length; ++j)
                memory[i][1] += nums[j];
            memory[i][1] /= nums.length-i; 
        }
        for (int n = nums.length-1; n >= 0; --n)
        {
            for (int j = 2; j <= k; ++j)
            {
                double currAvg = 0.0;
                for (int i = n; i <= nums.length-j; ++i)
                {
                    currAvg += nums[i];
                    memory[n][j] = Math.max(memory[n][j],currAvg/(i-n+1)+memory[i+1][j-1]);
                }
            }
        }
        return memory[0][k];
    }
}