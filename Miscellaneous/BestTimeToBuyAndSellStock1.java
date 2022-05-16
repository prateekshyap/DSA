/*https://leetcode.com/problems/best-time-to-buy-and-sell-stock/*/

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        int currProfit = 0;
        
        for(int i = 0; i < prices.length; ++i)
        {
            if(prices[i] < min) min = prices[i]; //get the minimum price
            currProfit = prices[i] - min; //get the current possible profit
            if(result < currProfit) result = currProfit; //update the final profit
        }
        return result;
    }
}