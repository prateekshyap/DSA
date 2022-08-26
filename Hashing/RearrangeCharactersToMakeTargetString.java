/*https://leetcode.com/problems/rearrange-characters-to-make-target-string/*/

class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] hash = new int[26];
        for (char ch : s.toCharArray())
            ++hash[ch-'a'];
        int[] req = new int[26];
        for (char ch : target.toCharArray())
            ++req[ch-'a'];
        int min = Integer.MAX_VALUE;
        for (char ch : target.toCharArray())
        {
            min = Math.min(min,hash[ch-'a']/req[ch-'a']);
        }
        return min;
    }
}