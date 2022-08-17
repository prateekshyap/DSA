/*
https://leetcode.com/problems/find-missing-observations/
2028. Find Missing Observations

*/

class Solution {
public:
    vector<int> missingRolls(vector<int>& rolls, int mean, int n) {
        int m = rolls.size();
        int sum_m = accumulate(rolls.begin(), rolls.end(), 0);
        vector<int> ans;
        
        int sum_n = mean*(n+m) - sum_m;
        
        if(sum_n > (n*6) || sum_n < n)
            return ans;
        // if( q <= 0 || q+bool(rem)>6)
        //     return ans; // not possible to make n array
        
        int q = sum_n / n;
        int rem = sum_n % n;
        ans.resize(n, q);
        
        // for(int i=0; i<n; i++)
        //     ans.push_back(q);
        for(int i=0; i<rem; i++)
            ans[i] += 1;
        
        // cout<<sum_m<<" "<<sum_n<<" "<<q<<" "<<rem<<endl;
        
        return ans;
    }
    
    vector<int> missingRolls_(vector<int>& rolls, int mean, int n) {
        int m = rolls.size();
        int sum_m = accumulate(rolls.begin(), rolls.end(), 0);
        vector<int> ans;
        
        int sum_n = mean*(n+m) - sum_m;
        
        if(sum_n > (n*6) || sum_n < n)
            return ans;
        // if( q <= 0 || q+bool(rem)>6)
        //     return ans; // not possible to make n array
        
        ans.resize(n, 1);
        
        int i=0;
        sum_n -= n;
        while(sum_n)
        {
            if(sum_n >= 5)
            {
                ans[i] += 5;
                sum_n -= 5;
            }
            else
            {
                ans[i] += sum_n;
                sum_n=0;
            }
            i++;
        }
        
        // cout<<sum_m<<" "<<sum_n<<" "<<q<<" "<<rem<<endl;
        
        return ans;
    }
};