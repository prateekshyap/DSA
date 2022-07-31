/*https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string/*/

class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long p1 = 0, p2 = 0, max = 0;
        char[] pat = pattern.toCharArray();

        if (pat[0] == pat[1])
        {
            p1 = 1;
            for (char ch : text.toCharArray())
            {
                if (ch == pat[0])
                {
                    max += p1;
                    p1++;
                }
            }
            return max;
        }
        for (char ch : text.toCharArray())
        {
            if (ch == pat[0]) ++p1;
            else if (ch == pat[1])
            {
                max += p1;
                ++p2;
            }
        }
        return max+Math.max(p1,p2);
    }
}