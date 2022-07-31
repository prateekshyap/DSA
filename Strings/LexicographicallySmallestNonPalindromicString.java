/*https://binarysearch.com/problems/Lexicographically-Smallest-Non-Palindromic-String*/
/*https://leetcode.com/problems/break-a-palindrome/*/

import java.util.*;

class Solution {
    public String solve(String s) {
        StringBuilder newS = new StringBuilder(s);
        int n = s.length();
        // if (n == 1) return ""; //for leetcode
        int last = n%2 == 1 ? ((n-1)/2)-1 : (n-1)/2;
        for (int i = 0; i <= last; ++i)
        {
            if (newS.charAt(i) != 'a')
            {
                newS.setCharAt(i,'a');
                return newS.toString();
            }
        }
        newS.setCharAt(n-1,'b');
        return newS.toString();
    }
}