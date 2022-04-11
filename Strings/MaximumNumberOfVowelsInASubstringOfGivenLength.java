/*https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/*/

class Solution {
    public int maxVowels(String s, int k) {
        int[] hash = new int[26];
        int maxCount = 0, currCount = 0;
        for (int i = 0; i < k; ++i)
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                ++currCount;
        maxCount = Math.max(maxCount, currCount);
        for (int i = k; i < s.length(); ++i)
        {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                ++currCount;
            if (s.charAt(i-k) == 'a' || s.charAt(i-k) == 'e' || s.charAt(i-k) == 'i' || s.charAt(i-k) == 'o' || s.charAt(i-k) == 'u')
                --currCount;
            maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }
}