/*https://leetcode.com/problems/find-missing-observations/*/

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int total = (rolls.length+n)*mean;
        int avail = 0;
        for (int i = 0; i < rolls.length; ++i)
            avail += rolls[i];
        total -= avail;
        if (total <= 0) return new int[0];
        double avg = (double)total/(double)n;
        int[] result = new int[n];
        if (avg > 6 || avg < 1) return new int[0];
        if (n == 1) result[0] = total;
        else
        {
            for (int i = 0; i < result.length; ++i)
            {
                result[i] = (int)avg;
                total -= result[i];
            }
            int i = 0;
            while (total-- > 0)
                ++result[i++];
        }
        return result;
    }
}