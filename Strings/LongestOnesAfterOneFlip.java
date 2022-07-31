/*https://binarysearch.com/problems/Longest-1s-After-One-Flip*/

import java.util.*;

class Solution {
    public int solve(String s) {
        int zeroCount = 0, n = s.length(), maxOnes = 0, start = 0, end = 0;

        while (end < n)
        {
            if (s.charAt(end) == '0') ++zeroCount;
            while (zeroCount > 1)
            {
                if (s.charAt(start) == '0') --zeroCount;
                ++start;
            }
            maxOnes = Math.max(maxOnes,end-start+1);
            ++end;
        }

        return maxOnes;
    }
}