/*https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/*/

class Solution {
    public boolean checkZeroOnes(String s) {
        int longestOnes = 0, longestZeros = 0, curr = 0, prev = s.charAt(0)-'0';
        for (char ch : s.toCharArray())
        {
            if (ch-'0' == prev)
                ++curr;
            else
            {
                if (prev == 0) longestZeros = Math.max(longestZeros,curr);
                else longestOnes = Math.max(longestOnes,curr);
                curr = 1;
                prev = ch-'0';
            }
        }
        if (prev == 0) longestZeros = Math.max(longestZeros,curr);
        else longestOnes = Math.max(longestOnes,curr);
        return longestOnes > longestZeros;
    }
}