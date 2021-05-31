/*https://leetcode.com/problems/number-of-1-bits/*/

public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        long lon = 0;
        if (n < 0)
        {
            lon = Integer.toUnsignedLong(n);
            while (lon > 0)
            {
                if ((lon&1) > 0) ++count;
                lon >>= 1;
            }
        }
        else
        {
            while (n > 0)
            {
                if ((n&1) > 0) ++count;
                n >>= 1;
            }
        }
        return count;
    }
}