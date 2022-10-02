/*https://leetcode.com/problems/number-of-common-factors/*/

class Solution {
    public int commonFactors(int a, int b) {
        int count = 0, target = Math.min(a,b);
        for (int i = 1; i <= target; ++i)
            if (a%i == 0 && b%i == 0)
                ++count;
        return count;
    }
}