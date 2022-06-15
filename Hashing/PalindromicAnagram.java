/*https://binarysearch.com/problems/Palindromic-Anagram*/

import java.util.*;

class Solution {
    public boolean solve(String s) {
        int[] hash = new int[26];
        int oddCount = 0;
        for (char ch : s.toCharArray()) ++hash[ch-'a'];
        for (int i = 0; i < 26; ++i) if (hash[i]%2 != 0) ++oddCount;
        if (oddCount <= 1) return true;
        return false;
    }
}