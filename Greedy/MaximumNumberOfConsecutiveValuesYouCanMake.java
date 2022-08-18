/*https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/*/

class Solution {
    public int getMaximumConsecutive(int[] coins) {
        int result = 0;
        Arrays.sort(coins);
        for (int i = 0; i < coins.length; ++i)
        {
            if (coins[i] == 1)
                ++result;
            else if (result >= coins[i]-1)
                result += coins[i];
        }
        return result+1;
    }
}