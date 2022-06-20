/*https://leetcode.com/problems/minimum-time-to-make-rope-colorful/*/

class Solution {
    public int minCost(String colorsStr, int[] neededTime) {
        int start = 0, i = 0, end = 0, result = 0, max = 0;
        char[] colors = colorsStr.toCharArray();
        while (end < colors.length)
        {
            while (end < colors.length && colors[start] == colors[end]) ++end;
            --end;
            if (start != end)
            {
                max = 0;
                for (i = start; i <= end; ++i)
                {
                    result += neededTime[i];
                    if (neededTime[i] > max) max = neededTime[i];
                }
                result -= max;
            }
            ++end;
            start = end;
        }
        return result;
    }
}