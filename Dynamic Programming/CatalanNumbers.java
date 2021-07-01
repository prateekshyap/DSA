/*https://practice.geeksforgeeks.org/problems/nth-catalan-number0817/1/*/

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