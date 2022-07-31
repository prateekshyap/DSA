/*https://practice.geeksforgeeks.org/problems/count-digit-groupings-of-a-number1520/1/*/

class Solution
{
    Integer[][] table;
    public int TotalCount(String str)
    {
        table = new Integer[str.length()+1][901];
        return solve(str, 0, str.length(), 0);
    }
    public int solve(String s, int index, int n, int prevSum)
    {
        if (index == n) return 1;
        if (table[index][prevSum] != null) return table[index][prevSum];
        int result = 0, currSum = 0, i;
        for (i = index; i < n; ++i)
        {
            currSum += s.charAt(i)-'0';
            if (prevSum <= currSum)
                result += solve(s, i+1, n, currSum);
        }
        table[index][prevSum] = result;
        return result;
    }
}