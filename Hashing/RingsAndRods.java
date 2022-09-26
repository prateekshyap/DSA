/*https://leetcode.com/problems/rings-and-rods/*/

class Solution {
    public int countPoints(String rings) {
        Set<Integer>[] hash = new Set[10];
        for (int i = 0; i < 10; ++i)
            hash[i] = new HashSet<Integer>();
        int color = -1;
        for (char ch : rings.toCharArray())
        {
            if (color == -1)
                color = ch-'A';
            else
            {
                hash[ch-'0'].add(color);
                color = -1;
            }
        }
        int count = 0;
        for (int i = 0; i < 10; ++i)
            if (hash[i].size() == 3)
                ++count;
        return count;
    }
}