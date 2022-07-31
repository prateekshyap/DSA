/*https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/*/

class Solution {
    public int minimumLength(String str) {
        int start = 0, end = str.length()-1;
        char[] s = str.toCharArray();
        while (start < end)
        {
            if (s[start] != s[end]) return end-start+1;
            char currChar = s[start];
            while (start < s.length && s[start] == currChar) ++start;
            while (end >= 0 && s[end] == currChar) --end;
        }
        return Math.max(end-start+1,0);
    }
}