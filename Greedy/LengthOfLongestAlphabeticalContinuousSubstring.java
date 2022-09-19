/*https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/*/

class Solution {
    public int longestContinuousSubstring(String s) {
        int n = s.length(), curr = 1, max = 1;
        for (int i = 1; i < n; ++i)
        {
            if (s.charAt(i) == s.charAt(i-1)+1)
                ++curr;
            else curr = 1;
            max = Math.max(curr,max);
        }
        return max;
    }
}

class Solution {
    public int longestContinuousSubstring(String s) {
        int curr = 1, max = 1, prev = 'A';
        for (char ch : s.toCharArray())
        {
            if (ch == prev+1)
                ++curr;
            else curr = 1;
            prev = ch;
            max = Math.max(curr,max);
        }
        return max;
    }
}