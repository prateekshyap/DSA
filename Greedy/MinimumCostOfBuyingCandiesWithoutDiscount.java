/*https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/*/

class Solution {
    public int minimumCost(int[] cost) {
        int buyPrice = 0;
        Arrays.sort(cost);
        for (int i = cost.length-1; i >= 0; )
        {
            buyPrice += cost[i];
            if (i-1 >= 0) buyPrice += cost[i-1];
            i -= 3;
        }
        return buyPrice;
    }
}