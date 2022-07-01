/*https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/*/
/*https://practice.geeksforgeeks.org/problems/buy-and-sell-a-share-at-most-twice/1/*/

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

class Solution {
    public int maxProfit(int[] price) {        
        int i, n = price.length, firstBuy = Integer.MIN_VALUE, firstSell = 0, secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (i = 0; i < n; ++i)
        {
            firstBuy = Math.max(firstBuy,-price[i]);
            firstSell = Math.max(firstSell,firstBuy+price[i]);
            secondBuy = Math.max(secondBuy,firstSell-price[i]);
            secondSell = Math.max(secondSell,secondBuy+price[i]);
        }
        return secondSell;
    }
}