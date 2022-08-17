/*https://leetcode.com/problems/node-with-highest-edge-score/*/

class Solution {
    public int edgeScore(int[] edges) {
        int i, n = edges.length, answer = -1;
        long max = 0;
        long[] scores = new long[n];
        for (i = 0; i < n; ++i)
            scores[edges[i]] += i;
        for (i = 0; i < n; ++i)
        {
            if (scores[i] > max)
            {
                max = scores[i];
                answer = i;
            }
        }
        return answer;
    }
}