/*https://leetcode.com/problems/total-appeal-of-a-string/*/

class Solution
{
    public long appealSum(String s)
    {
        int last[] = new int[26];
        long res = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            last[s.charAt(i) - 'a'] = i + 1;
            for (int j: last)
                res += j;
        }
        return res;
    }
}