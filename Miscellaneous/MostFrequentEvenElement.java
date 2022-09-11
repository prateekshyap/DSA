/*https://leetcode.com/problems/most-frequent-even-element/*/

class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] map = new int[(int)1e5+1];
        int maxFreq = 0, maxNum = -1;
        for (int val : nums)
            ++map[val];
        for (int i = 0; i < 1e5+1; i += 2)
            if (map[i] > maxFreq)
            {
                maxFreq = map[i];
                maxNum = i;
            }
        return maxNum;
    }
}