/*https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/*/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0], max = prices[n-1];
        int[] leftMax = new int[n], rightMax = new int[n];
        for (int i = 1; i < n; ++i)
        {
            if (prices[i] < min) min = prices[i];
            leftMax[i] = Math.max(leftMax[i-1],prices[i]-min);
        }
        for (int i = n-2; i >= 0; --i)
        {
            if (prices[i] > max) max = prices[i];
            rightMax[i] = Math.max(rightMax[i+1],max-prices[i]);
        }
        int finalPrice = 0;
        for (int i = 0; i < n; ++i)
            if (leftMax[i]+rightMax[i] > finalPrice)
                finalPrice = leftMax[i]+rightMax[i];
        return finalPrice;
    }
}