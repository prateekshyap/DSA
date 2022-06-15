/*https://leetcode.com/problems/two-furthest-houses-with-different-colors/*/

class Solution {
    public int maxDistance(int[] colors) {
        int diff = 1, n = colors.length, i, j, maxDiff = 1;
        for (i = 0; i < n; ++i)
        {
            for (j = i+diff; j < n; ++j)
                if (colors[j] != colors[i] && j-i > maxDiff)
                    maxDiff = j-i;
            diff = maxDiff;
        }
        return maxDiff;
    }
}