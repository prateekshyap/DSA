/*https://leetcode.com/problems/distinct-subsequences/*/

class Solution {
    int sLen, tLen;
    Integer[][] storage;
    public int numDistinct(String s, String t) {
        sLen = s.length();
        tLen = t.length();
        storage = new Integer[sLen+1][tLen+1];
        storage[0][0] = solve(s, t, 0, 0);
        return storage[0][0];
    }
    public int solve(String s, String t, int sIndex, int tIndex)
    {
        if (tIndex == tLen) { storage[sIndex][tIndex] = 1; return 1; }
        if (sIndex == sLen) { storage[sIndex][tIndex] = 0; return 0; }
              
        if (storage[sIndex][tIndex] != null) return storage[sIndex][tIndex];
        
        int moveSIndex, result = 0;
        for (moveSIndex = sIndex; moveSIndex <= sLen-(tLen-tIndex); ++moveSIndex)
            if (s.charAt(moveSIndex) == t.charAt(tIndex))
                result += solve(s, t, moveSIndex+1, tIndex+1);
        
        storage[sIndex][tIndex] = result;
        return result;
    }
}