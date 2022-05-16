/*
121. Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
                
        int max=0; int diff;
        
        if(prices.size()==1) return max;

         //TLE 
        // for(int i=0; i<prices.size()-1; i++)
        // {
        //     for(int j=i+1; j<prices.size(); j++)
        //     {
        //          diff = prices[j]-prices[i];
        //         if(prices[i]<prices[j] && max < diff)
        //             max = diff;
        //     }
        // }
        
        // Sliding window
        // int i=0, j=1;
        
        // while(j < prices.size())
        // {
        //   if(prices[i] < prices[j])
        //   {
        //       diff = prices[j]-prices[i];
        //       if( max < diff)
        //             max = diff;
        //   }
        //   else
        //       i=j;
        //   j++;
        // }
        // return max;
        
        //
        int min_buy=0; // assume to buy on 0th day
        
        for(int i=1; i<prices.size(); i++)
        {
            diff = prices[i]-prices[min_buy]; // if you sell the stock at ith day then profit is
            if(diff > max) 
                max = diff;
            
            if(prices[i] < prices[min_buy])  // if you buy the stock at ith day
                min_buy = i;
        }
        
        
        
        
        return max;
    }
};