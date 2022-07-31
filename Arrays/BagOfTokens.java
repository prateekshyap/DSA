/*https://leetcode.com/problems/bag-of-tokens/*/

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int low = 0, high = tokens.length-1, score = 0, maxScore = 0;
        Arrays.sort(tokens);
        if (tokens.length == 0 || tokens[0] > power) return 0;
        while (low <= high)
        {
            if (tokens[low] <= power)
            {
                power -= tokens[low++];
                ++score;
            }
            else if (score > 0)
            {
                power += tokens[high--];
                --score;
            }
            if (score > maxScore) maxScore = score;
        }
        return maxScore;
    }
}