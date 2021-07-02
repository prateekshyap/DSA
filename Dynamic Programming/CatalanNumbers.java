/*https://practice.geeksforgeeks.org/problems/nth-catalan-number0817/1/*/
/*Prateekshya's Solution*/
class Solution
{
    public static BigInteger findCatalan(int n)
    {
        BigInteger[] table = new BigInteger[n+1];
        table[0] = new BigInteger("1");
        for (int i = 1; i <= n; ++i)
        {
            BigInteger sum = new BigInteger("0");
            for (int j = 0, k = i-1; j < i && i > -1; ++j, --k)
                sum = sum.add(table[j].multiply(table[k]));
            table[i] = sum;
        }
        return table[n];
    }
}
/*Pratik's Solution*/
class Solution
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        //Your code here
        BigInteger dp[] = new BigInteger[n+1];
        dp[0] = new BigInteger("1");
        for(int i=1;i<=n;i++)
        {
            BigInteger res = new BigInteger("0");
            for(int j=0;j<i;j++)
            {
                res = res.add(dp[j].multiply(dp[i-j-1]));
            }
            dp[i] = res;
        }
        return dp[n];
    }
}

/* O(N) solution */
class Solution
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        //Your code here
        BigInteger ans = new BigInteger("1");
        for(int i=n;i>=1;i--)
        {
            ans = ans.multiply(new BigInteger(Integer.toString(n+i)));
            ans = ans.divide(new BigInteger(Integer.toString(n-i+1)));
        }
        ans = ans.divide(new BigInteger(Integer.toString(n+1)));
        return ans;
    }
}