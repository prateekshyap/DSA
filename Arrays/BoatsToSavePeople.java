/*https://leetcode.com/problems/boats-to-save-people/*/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0, n = people.length, i = 0, j = n-1;
        Arrays.sort(people);
        while (i <= j)
        {
            ++boatCount;
            if (people[i]+people[j] <= limit)
            {
                ++i;
                --j;
            }
            else --j;
        }
        
        return boatCount;
    }
}