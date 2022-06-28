/*https://binarysearch.com/problems/Longest-Consecutive-Run-of-1s-in-Binary*/

import java.util.*;

class Solution {
    public int solve(int n) {
        int curr, count = 0, max = 0;
        while (n > 0)
        {
            curr = n&1;
            if (curr == 1) ++count;
            else
            {
                if (count > max) max = count;
                count = 0;
            }
            n >>= 1;
        }
        if (count > max) max = count;
        return max;
    }
}