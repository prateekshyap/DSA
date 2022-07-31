/*https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/*/

class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int result = 0;
        int i = 0, range = 1;
        
        while (i < n)
        {
            ++result;
            i += (range++);
        }
        
        if (i > n) --result;
        
        return result;
    }
}