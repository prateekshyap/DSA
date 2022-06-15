/*https://leetcode.com/problems/count-numbers-with-unique-digits/*/

//formula
class Solution {
    public int factorial(int n)
    {
        int i, p = 1;
        for (i = 1; i <= n; ++i)
            p*=i;
        return p;
    }
    public int countNumbersWithUniqueDigits(int n) {
        int i, ans=0;
        for (i = 1; i <= n; ++i)
            ans += (9*factorial(9)/(factorial(10-i)));
        return ans+1;
    }
}

//dp solution
class Solution
{
    public int countNumbersWithUniqueDigits(int n)
    {
        int i, j;
        int[] dp = new int[9];
        dp[0] = 1;
        for (j = 1; j < 9; ++j)
        {
            int ans = 9;
            int y = 9;
            for(i = 1; i < j; ++i)
            {
                ans *= y;
                y--;
            }
            dp[j] = ans+dp[j-1];
        }
        return dp[n];
    }
}