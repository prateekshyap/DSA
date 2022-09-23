/*https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/*/

class Solution {
    public int minTimeToType(String word) {
        int seconds = 0, prev = 0;
        for (char ch : word.toCharArray())
        {
            int distance = Math.abs(prev-(ch-'a'));
            prev = ch-'a';
            if (distance < 13)
                seconds += distance+1;
            else seconds += 26-distance+1;
        }
        return seconds;
    }
}