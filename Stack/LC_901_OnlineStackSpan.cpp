/*
https://leetcode.com/problems/online-stock-span/
901. Online Stock Span

*/

class StockSpanner {
public:
    
    vector<int> prices;
    stack<int> st;
    int i=0;
    
    StockSpanner() {
        ios::sync_with_stdio(0); cin.tie(0);cout.tie(0);
    }
    
    int next(int price)
    {
        
        if(prices.empty())
        {
            prices.push_back(price);
            st.push(prices.size()-1);
            return 1;
        }
        
        i = prices.size(); // earlier 0, now 1
        
        while(!st.empty() && prices[st.top()] <= price)
            st.pop();
        
        int newval = (st.empty()) ? i+1 : i - st.top();
        
        prices.push_back(price);
        
        st.push(i);
        
        return newval;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */