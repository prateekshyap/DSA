/*https://leetcode.com/problems/koko-eating-bananas/*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = (int)1e9;
        while (low < high)
        {
            int mid = low+(high-low)/2;
            if (possible(mid,piles,h))
                high = mid;
            else low = mid+1;
        }
        return high;
    }
    private boolean possible(int k, int[] piles, int timeLimit)
    {
        int time = 0;
        for (int pile : piles)
        {
            time += ((pile-1)/k)+1;
            if (time > timeLimit) return false;
        }
        return true;
    }
}