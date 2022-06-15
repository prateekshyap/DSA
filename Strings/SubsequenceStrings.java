/*https://binarysearch.com/problems/Subsequence-Strings*/

import java.util.*;

class Solution {
    public boolean solve(String s1, String s2) {
        if (s1.length() == 0) return true;
        int index = 0;

        for (int i = 0; i < s2.length() && index < s1.length(); ++i)
            if (s2.charAt(i) == s1.charAt(index)) ++index;

        if (index == s1.length()) return true;
        return false;
    }
}