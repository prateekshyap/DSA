/*https://leetcode.com/problems/rabbits-in-forest/*/

class Solution {
    public int numRabbits(int[] answers) {
        int[] freqs = new int[1000];
        for (int val : answers)
            ++freqs[val];
        int minRabbits = 0;
        for (int i = 0; i < 1000; ++i)
        {
            if (freqs[i] != 0)
                minRabbits += (i+1)*(((freqs[i]-1)/(i+1))+1);
        }
        return minRabbits;
    }
}