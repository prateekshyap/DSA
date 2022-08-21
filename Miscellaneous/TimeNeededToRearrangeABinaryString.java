/*https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/*/

class Solution {
    public int secondsToRemoveOccurrences(String s) {
        char c[] = s.toCharArray();
        int k = 0, n = c.length;
        boolean flag = true;
        while (flag)
        {
            flag = false;
            for (int i = 0; i < n-1; ++i)
                if (c[i] == '0' && c[i+1] == '1')
                {
                    flag = true;
                    c[i] = '1';
                    c[i+1] = '0';
                    ++i;
                }
            if (flag) ++k;
        }
        return k;
    }
}