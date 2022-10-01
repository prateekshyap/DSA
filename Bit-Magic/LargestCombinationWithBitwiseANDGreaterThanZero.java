/*https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/*/

class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitPositions = new int[32];
        for (int candidate : candidates)
        {
            int index = 0;
            while (candidate > 0)
            {
                bitPositions[index] += (candidate&1);
                ++index;
                candidate >>= 1;
            }
        }
        return max(bitPositions);
    }
    private int max(int[] arr)
    {
        int max = 0;
        for (int val : arr)
            if (val > max)
                max = val;
        return max;
    }
}