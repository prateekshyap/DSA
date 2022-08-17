/*
https://leetcode.com/problems/daily-temperatures/
739. Daily Temperatures

https://binarysearch.com/problems/Wallstreet-Bets
*/

class Solution {
public:
    // a variation of method used in next greater lement and online stack problem
    vector<int> dailyTemperatures_(vector<int>& temperatures) {
        
        vector<int> ans(temperatures.size());
        stack<int> st;
        // st.push(0);
        
        for(int i=temperatures.size()-1; i>=0; i--)
        {
            while(!st.empty() && temperatures[st.top()] <= temperatures[i])
                st.pop();
            
            ans[i] = st.empty()? 0: st.top()-i;
            
            st.push(i);
        }
        return ans;
    }
    
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        if(n==1) return {0};
        
        vector<int> ans(n, 0);
        int hottest=temperatures[n-1], i=0, cur=0;
        
        for(int j=n-2; j>=0; j--)
        {
            cur = temperatures[j];
            if(cur>=hottest)
            {
                hottest = cur;
                continue;
            }
            i=j+1;
            while(cur >= temperatures[i])
                i = i + ans[i];
            ans[j] = i-j;
        }
        return ans;
    }
};