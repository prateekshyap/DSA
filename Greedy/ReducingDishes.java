/*https://leetcode.com/problems/reducing-dishes/*/

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length, i, j, max = 0;
        Arrays.sort(satisfaction);
        if (satisfaction[n-1] < 0) return 0;
        int[] prefix = new int[n];
        prefix[0] = satisfaction[n-1];
        for (i = 1, j = n-2; i < n && j >= 0; ++i, --j)
            prefix[i] = prefix[i-1]+satisfaction[j];
        satisfaction = prefix;
        prefix = new int[n];
        prefix[0] = max = satisfaction[0];
        for (i = 1; i < n; ++i)
        {
            prefix[i] = prefix[i-1]+satisfaction[i];
            if (prefix[i] > max) max = prefix[i];
        }
        return max;
    }
}