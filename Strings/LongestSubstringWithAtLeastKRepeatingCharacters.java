/*https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/submissions/*/

class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.isEmpty() || k > s.length())
            return 0;
        int[] countMap = new int[26];
        int n = s.length();
        int result = 0;
        for (int start = 0; start < n; start++)
        {
            Arrays.fill(countMap, 0);
            for (int end = start; end < n; end++)
            {
                countMap[s.charAt(end) - 'a']++;
                if (isValid(countMap, k))
                    result = Math.max(result, end-start+1);
            }
        }
        return result;
    }

    private boolean isValid(int[] countMap, int k)
    {
        int countLetters = 0, countAtLeastK = 0;
        for (int freq : countMap)
        {
            if (freq > 0) countLetters++;
            if (freq >= k) countAtLeastK++;
        }
        return countAtLeastK == countLetters;
    }
}
