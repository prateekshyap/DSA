/*https://practice.geeksforgeeks.org/problems/min-number-of-flips3210/1*/

class Solution {
    public int minFlips(String s) {
        // Code here
        boolean turn = true;
        int i, n = s.length(), uCount = 0, nCount = 0;
        for (i = 0; i < n; ++i)
        {
            if ((turn && s.charAt(i) == '0') || (!turn && s.charAt(i) == '1')) ++uCount;
            turn = !turn;
        }
        turn = false;
        for (i = 0; i < n; ++i)
        {
            if ((turn && s.charAt(i) == '0') || (!turn && s.charAt(i) == '1')) ++nCount;
            turn = !turn;
        }
        return Math.min(uCount,nCount);
    }
}