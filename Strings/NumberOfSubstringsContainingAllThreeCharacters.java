/*https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/*/

class Solution {
    public int numberOfSubstrings(String s) {
        int start = 0, end = -1, n = s.length(), uniqueCount = 0, result = 0, ch;
        int[] hash = new int[3];
        while (end < n-1)
        {
            ++end;
            ch = s.charAt(end)-'a';
            ++hash[ch];
            if (hash[ch] == 1) ++uniqueCount;
            while (uniqueCount == 3)
            {
                result += n-end;
                ch = s.charAt(start)-'a';
                --hash[ch];
                if (hash[ch] == 0) --uniqueCount;
                ++start;
            }
        }
        return result;
    }
}