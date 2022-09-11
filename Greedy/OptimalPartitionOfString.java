/*https://leetcode.com/problems/optimal-partition-of-string/*/

class Solution {
    public int partitionString(String s) {
        int[] hash = new int[26];
        int partitionCount = 1;
        for (char ch : s.toCharArray())
        {
            if (hash[ch-'a'] > 0)
            {
                ++partitionCount;
                hash = new int[26];
            }
            ++hash[ch-'a'];
        }
        return partitionCount;
    }
}