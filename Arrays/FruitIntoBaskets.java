/*https://leetcode.com/problems/fruit-into-baskets/*/

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length, start = 0, end = 0, uniqueCount = 0, maxLen = 0;
        int[] freq = new int[n];
        while (end < n)
        {
            ++freq[fruits[end]];
            if (freq[fruits[end]] == 1) ++uniqueCount;
            while (uniqueCount > 2)
            {
                --freq[fruits[start]];
                if (freq[fruits[start]] == 0) --uniqueCount;
                ++start;
            }
            if (uniqueCount <= 2) if (end-start+1 > maxLen) maxLen = end-start+1;
            ++end;
        }
        return maxLen;
    }
}