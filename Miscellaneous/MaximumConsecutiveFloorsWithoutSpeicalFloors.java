/*https://leetcode.com/problems/maximum-consecutive-floors-without-special-floors/*/

class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int result = 0;
        int i, n = special.length;
        int prev = bottom, next = special[0];
        result = next-prev;
        for (i = 1; i < n; ++i)
        {
            prev = next+1;
            next = special[i];
            if (next-prev > result)
                result = next-prev;
        }
        result = Math.max(result,top-next);
        return result;
    }
}