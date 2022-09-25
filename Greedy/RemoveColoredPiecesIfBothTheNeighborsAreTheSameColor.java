/*https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/*/

class Solution {
    public boolean winnerOfGame(String colors) {
        if (colors.length() <= 2) return false;
        int prev = colors.charAt(0)-'A', n = colors.length(), count = 0, alice = 0, bob = 0;
        for (char ch: colors.toCharArray())
        {
            if (prev == ch-'A')
                ++count;
            else
            {
                if (prev == 0)
                    alice += Math.max(0,count-2);
                else
                    bob += Math.max(0,count-2);
                prev = ch-'A';
                count = 1;
            }
        }
        if (prev == 0)
            alice += Math.max(0,count-2);
        else
            bob += Math.max(0,count-2);
        return alice > bob && alice > 0;
    }
}