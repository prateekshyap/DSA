/*https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/*/

class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int result = 0, n = energy.length, temp;
        for (int i = 0; i < n; ++i)
        {
            if (experience[i] >= initialExperience)
            {
                temp = experience[i]+1-initialExperience;
                result += temp;
                initialExperience += temp;
            }
            if (energy[i] >= initialEnergy)
            {
                temp = energy[i]+1-initialEnergy;
                result += temp;
                initialEnergy += temp;
            }
            initialExperience += experience[i];
            initialEnergy -= energy[i];
        }
        return result;
    }
}