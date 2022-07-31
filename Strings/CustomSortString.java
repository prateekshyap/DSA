/*https://leetcode.com/problems/custom-sort-string/*/

class Solution {
    public String customSortString(String order, String s) {
        int[] hash = new int[26];
        for (char ch : s.toCharArray())
            ++hash[ch-'a'];
        StringBuilder result = new StringBuilder("");
        
        for (char ch : order.toCharArray())
        {
            while (hash[ch-'a'] > 0)
            {
                result.append((char)(ch));
                --hash[ch-'a'];
            }
        }
        
        for (int i = 0; i < 26; ++i)
        {
            while (hash[i] > 0)
            {
                result.append((char)(i+'a'));
                --hash[i];
            }
        }
        
        return result.toString();
    }
}