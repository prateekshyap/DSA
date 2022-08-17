/*https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1*/
/*https://leetcode.com/problems/longest-happy-prefix/*/

class Solution {
    int lps(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int i = 0, j = 1;
        while (j < n)
        {
            if (s.charAt(i) == s.charAt(j))
            {
                dp[j] = i+1;
                ++j; ++i;
            }
            else
            {
                if (i == 0) ++j;
                else if (i == 1)
                {
                    i = 0;
                    dp[j] = 0;
                }
                else
                {
                    dp[j] = 0;
                    j = j-i+1;
                    i = 0;
                }
            }
        }
        return dp[n-1];
    }
}

class Solution {
    public String longestPrefix(String s) {
        int i = 1, lpsLen = 0, pLen = s.length();
        int[] lps = new int[pLen];
        char[] p = s.toCharArray();
        while (i < pLen)
        {
            if (p[i] == p[lpsLen])
                lps[i++] = ++lpsLen;
            else if (lpsLen != 0)
                lpsLen = lps[lpsLen-1];
            else lps[i++] = lpsLen;
        }
        return s.substring(0,lps[pLen-1]);
    }
}