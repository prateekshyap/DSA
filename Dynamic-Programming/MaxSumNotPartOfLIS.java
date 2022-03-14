/*https://practice.geeksforgeeks.org/problems/maximum-sum-of-elements-not-part-of-lis/1*/

class Solution
{
    static int maxSumLis(int arr[], int n)
    {
        int totalSum = 0;
 
	    // Find total sum of array
	    for(int i = 0; i < n; i++)
	    {
	       totalSum += arr[i];
	    }
	 
	    // Maintain a 2D array
	    int [][]dp = new int[2][n];
	    for(int i = 0; i < n; i++)
	    {
	       dp[0][i] = 1;
	       dp[1][i] = arr[i];
	    }
	 
	    // Update the dp array along
	    // with sum in the second row
	    for(int i = 1; i < n; i++)
	    {
	       for(int j = 0; j < i; j++)
	       {
	          if (arr[i] > arr[j])
	          {
	               
	              // In case of greater length
	              // Update the length along
	              // with sum
	              if (dp[0][i] < dp[0][j] + 1)
	              {
	                  dp[0][i] = dp[0][j] + 1;
	                  dp[1][i] = dp[1][j] + arr[i];
	              }
	               
	              // In case of equal length
	              // find length update length
	              // with minimum sum
	              else if (dp[0][i] == dp[0][j] + 1)
	              {
	                  dp[1][i] = Math.min(dp[1][i],
	                                      dp[1][j] + arr[i]);
	              }
	          }
	       }
	    }
	    int maxm = 0;
	    int subtractSum = 0;
	 
	    // Find the sum that need to
	    // be subtracted from total sum
	    for(int i = 0; i < n; i++)
	    {
	       if (dp[0][i] > maxm)
	       {
	           maxm = dp[0][i];
	           subtractSum = dp[1][i];
	       }
	       else if (dp[0][i] == maxm)
	       {
	           subtractSum = Math.min(subtractSum, dp[1][i]);
	       }
	    }
	 
	    // Return the sum
	    return totalSum - subtractSum;
    }
}