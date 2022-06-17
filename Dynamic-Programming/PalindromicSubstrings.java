/*https://leetcode.com/problems/palindromic-substrings/*/

class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 0) return 0;
        int n = s.length(), start, end, count = 0, i;
        for (i = 0; i < n; ++i)
        {
            //odd length
            start = i; end = i;
            while (start >= 0 && end < n && s.charAt(start) == s.charAt(end))
            {
                --start; ++end;
                ++count;
            }

            //even length
            if (i < n-1 && s.charAt(i) == s.charAt(i+1))
            {
                start = i; end = i+1;
                while (start >= 0 && end < n && s.charAt(start) == s.charAt(end))
                {
                    --start; ++end;
                    ++count;
                }
            }
        }
        return count;
    }
}