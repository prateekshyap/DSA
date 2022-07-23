/*https://leetcode.com/problems/best-poker-hand/*/

class Solution {
    public String bestHand(int[] ranks, char[] suits) {
    	//all cards equal suite
        if (suits[0] == suits[1] && suits[0] == suits[2] && suits[0] == suits[3] && suits[0] == suits[4]) return "Flush";
        int[] freq = new int[14];
        for (int card : ranks)
            ++freq[card];
        
        //3 cards of same rank
        for (int f : freq)
            if (f >= 3)
                return "Three of a Kind";

        //2 cards of same rank
        for (int f : freq)
            if (f >= 2)
                return "Pair";

        //default case
        return "High Card";
    }
}