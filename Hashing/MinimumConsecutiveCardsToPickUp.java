/*https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/*/

class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> pastCardPosition = new HashMap<Integer,Integer>();
        int n = cards.length, i, len = Integer.MAX_VALUE;
        for (i = 0; i < n; ++i)
        {
            if (pastCardPosition.containsKey(cards[i])) len = Math.min(len,i-(Integer)pastCardPosition.get(cards[i])+1);
            pastCardPosition.put(cards[i],i);
        }
        return len == Integer.MAX_VALUE ? -1 : len;
    }
}