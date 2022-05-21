/*https://leetcode.com/problems/slowest-key/*/

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDur = releaseTimes[0]-0, n = releaseTimes.length, currDur;
        char ch = keysPressed.charAt(0);
        for (int i = 1; i < n; ++i)
        {
            currDur = releaseTimes[i]-releaseTimes[i-1];
            if (currDur > maxDur)
            {
                maxDur = currDur;
                ch = keysPressed.charAt(i);
            }
            else if (currDur == maxDur && keysPressed.charAt(i) > ch)
                ch = keysPressed.charAt(i);
        }
        return ch;
    }
}