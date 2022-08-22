/*https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/*/

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int N = cardPoints.length, window = N-k, i, curr = 0, min = Integer.MAX_VALUE, sum = 0;
        // if (window <= 0) return IntStream.of(cardPoints).sum();
        for (i = 0; i < window; ++i)
        {
            sum += cardPoints[i];
            curr += cardPoints[i];
        }
        if (curr < min) min = curr;
        for (; i < N; ++i)
        {
            sum += cardPoints[i];
            curr -= cardPoints[i-window];
            curr += cardPoints[i];
            if (curr < min) min = curr;
        }
        return window <= 0 ? sum : sum-min;
    }
}