/*https://leetcode.com/problems/remove-letter-to-equalize-frequency/description/*/

class Solution {
    public boolean equalFrequency(String word) {
        if (word.length() == 2&& word.charAt(0) == word.charAt(1)) return true;
        int[] hash = new int[26];
        for (char ch : word.toCharArray())
            ++hash[ch-'a'];
        for (char ch : word.toCharArray())
        {
            --hash[ch-'a'];
            if (equal(hash)) return true;
            ++hash[ch-'a'];
        }
        return false;
    }
    private boolean equal(int[] hash)
    {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 26; ++i)
            if (hash[i] != 0)
                set.add(hash[i]);
        return set.size() == 1;
    }
}