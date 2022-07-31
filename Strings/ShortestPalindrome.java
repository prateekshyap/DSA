/*https://leetcode.com/problems/shortest-palindrome/*/

class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        StringBuilder build = new StringBuilder(s);
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        build.append("#");
        build.append(rev);
        int len = build.length();
        int[] lps = new int[len];
        int i, temp;
        for (i = 1; i < len; ++i)
        {
            temp = lps[i-1];
            while (temp > 0 && build.charAt(i) != build.charAt(temp))
                temp = lps[temp-1];
            if (build.charAt(i) == build.charAt(temp)) ++temp;
            lps[i] = temp;
        }
        return (new StringBuilder(rev.substring(0,n-lps[len-1])).append(s)).toString();
    }
}