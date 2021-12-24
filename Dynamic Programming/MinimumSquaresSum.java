/*https://practice.geeksforgeeks.org/problems/get-minimum-squares0538/1*/

class Solution
{
    public int MinSquares(int n)
    {
    	//base cases
        if (n <= 3) return n;

        //fill base cases
        int dp[] = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++)
        {
            dp[i] = i; //(1*1+1*1+...i times)

            //for each square till i update the count
            for (int x = 1; x*x <= i; x++)
                dp[i] = Math.min(dp[i], 1+dp[i-(x*x)]);
        }
        return dp[n];
    }
}