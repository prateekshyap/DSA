/*
983. Minimum Cost For Tickets

https://leetcode.com/problems/minimum-cost-for-tickets/
*/

class Solution {
public: 
     vector<int> costs; 
    int n;
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        this->costs = costs;
        n = days.size(); 
        
        // s = unordered_set<int>(days.begin(), days.end());
        // int ans = solve(1);
        // for(int i=0; i<30; i++) cout<<i+1<<"="<<memo[i]<<") "; cout<<endl;
        // return ans;
        
        memo1.resize(n, -1);
        // solve1(0, days); for(int x: memo1) cout<<x<<" "; cout<<endl;
        return solve1(0, days);
    }
    
    vector<int> memo1;
    vector<int> pass = {0, 6, 29};
    int solve1(int i, vector<int>& days)
    {
        if(i == n)
            return 0; 
        
        if(memo1[i]!= -1) return memo1[i];
        int it, cost = INT_MAX;
        for(int p=0; p<3; p++)
        {
            it = upper_bound(days.begin(), days.end(), days[i]+pass[p]) - days.begin();
            cost = min(cost, solve1(it, days) + costs[p]); 
        }
        return memo1[i] = cost;
    } 
    
    unordered_set<int> s;
    vector<int> memo = vector<int>(366, -1);
    int solve(int day)
    {
        if(day>=366) return 0;
        if(memo[day] != -1) return memo[day];
        int cost=0;
        if(s.count(day))
        {
            cost = min({solve(day+1)+costs[0], solve(day+7)+costs[1], solve(day+30)+costs[2]});
        }
        else
            cost = solve(day+1);
        
        return memo[day]=cost;
    }
     
};