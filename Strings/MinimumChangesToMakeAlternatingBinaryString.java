/*https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/*/

class Solution {
    public int minOperations(String s) {
        int uCount = 0, nCount = 0, i, n = s.length();
        boolean turn = true;
        for (i = 0; i < n; ++i)
        {
            if (turn && s.charAt(i) != '1') ++uCount;
            else if (!turn && s.charAt(i) != '0') ++uCount;
            turn = !turn;
        }
        turn = true;
        for (i = 0; i < n; ++i)
        {
            if (turn && s.charAt(i) != '0') ++nCount;
            else if (!turn && s.charAt(i) != '1') ++nCount;
            turn = !turn;
        }
        return Math.min(uCount,nCount);
    }
}