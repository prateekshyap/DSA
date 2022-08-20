/*https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/*/

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length(), result = Integer.MAX_VALUE;
        char[] b = blocks.toCharArray();
        int i = 0, bCount = 0;
        for (; i < k; ++i)
            if (b[i] == 'B')
                ++bCount;
        result = Math.min(result,k-bCount);
        for (; i < n; ++i)
        {
            bCount -= b[i-k] == 'B' ? 1 : 0;
            bCount += b[i] == 'B' ? 1 : 0;
            result = Math.min(result,k-bCount);
        }
        return result;
    }
}