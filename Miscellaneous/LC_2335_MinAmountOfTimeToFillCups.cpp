/*
https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/
2335. Minimum Amount of Time to Fill Cups

*/

class Solution {
public:
    int fillCups_1(vector<int>& amount) {
        priority_queue<int> pq(amount.begin(), amount.end());
        int minutes=0;
        
        while(!pq.empty())
        {
            int t = pq.top(); pq.pop();
            
            if(t>0)
            {
                minutes++;
                t--;
                if(!pq.empty())
                {
                    int t2 = pq.top(); pq.pop();
                    t2--;
                    pq.push(t2);
                }
                pq.push(t);
            }
        }
        
        
        return minutes;
    }
    
    int fillCups(vector<int>& amount) {
        
        sort(amount.begin(), amount.end());
        
        if(amount[2] <= amount[0]+amount[1])
            return (amount[0] + amount[1] + amount[2] +1)/2;
        
        
        
        return amount[2];
    }
};