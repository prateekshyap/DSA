/*https://leetcode.com/problems/consecutive-characters/*/

class Solution {
    public int maxPower(String s) {
        int consecutiveCount = 0, maxCount = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            if (i == 0)
                ++consecutiveCount;
            else if (s.charAt(i-1) == s.charAt(i))
                ++consecutiveCount;
            else
            {
                maxCount = Math.max(maxCount,consecutiveCount);
                consecutiveCount = 1;
            }
        }
        maxCount = Math.max(maxCount,consecutiveCount);
        return maxCount;
    }
}