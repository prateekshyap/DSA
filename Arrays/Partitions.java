/*https://www.interviewbit.com/problems/partitions/*/

public class Solution {
    int[][] dp;
    public int solve(int n, int[] B) {
        int ways = 0; int sum = 0, i, j, firstSum = 0, leftSum = 0, rightSum = 0;
        
        for (int num : B) sum += num;
        if (sum%3 != 0) return 0;
        sum /= 3;
        for (i = 0; i < n-2; ++i)
        {
            firstSum += B[i];
            if (firstSum == sum) //first bucket found
            {
                leftSum = B[i+1];
                rightSum = 0;
                for (j = i+2; j < n; ++j) rightSum += B[j];
                if (leftSum == sum && rightSum == sum) ++ways;
                for (j = i+2; j < n-1; ++j)
                {
                    leftSum += B[j];
                    rightSum -= B[j];
                    if (leftSum == sum && rightSum == sum) ++ways;
                }
            }
        }
        return ways;
    }
}
