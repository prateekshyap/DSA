/*https://practice.geeksforgeeks.org/problems/largest-number-with-given-sum-1587115620/1*/

class Solution
{
    static String largestNumber(int n, int sum)
    {
        if (sum > n*9) return "-1";
        StringBuilder result = new StringBuilder("");
        while (sum >= 9)
        {
            result.append(9);
            sum -= 9;
        }
        if(result.length() == n) return new String(result);
        result.append(sum);
        int curLen = result.length();
        for (int i = curLen+1; i <= n; ++i)
            result.append(0);
        return new String(result);
    }
}