/*https://leetcode.com/problems/check-distances-between-same-letters/*/

class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] hash = new int[26];
        Arrays.fill(hash,-1);
        for (int i = 0; i < s.length(); ++i)
        {
            char ch = s.charAt(i);
            if (hash[ch-'a'] == -1)
                hash[ch-'a'] = i;
            else if (i-hash[ch-'a']-1 != distance[ch-'a'])
                return false;
        }
        return true;
    }
}