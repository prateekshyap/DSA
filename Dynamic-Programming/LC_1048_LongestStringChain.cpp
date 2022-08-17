/*
1048. Longest String Chain

https://leetcode.com/problems/longest-string-chain/
*/

class Solution {
public:
    static bool mycomp(string& a, string& b){
        return a.size()<b.size();
    }
    
    int n;
    int longestStrChain(vector<string>& words) {
        n = words.size();
        sort(words.begin(), words.end(), mycomp);
        // vector<int> dp(n, 1);
        // for(int i=1; i<n; i++)
        // {
        //     int len = dp[i];
        //     for(int j=0; j<i; j++)
        //     {
        //         if(words[i].size()-words[j].size() != 1) continue;
        //         if(isPredecessor(words[j], words[i]))
        //             len = max(len, dp[j]+1);
        //     }
        //     dp[i] = len;
        // }
        // // for(int i=0; i<n; i++) cout<<dp[i]<<" ";cout<<endl;
        // return *max_element(dp.begin(),dp.end());
        
        unordered_map<string,int> counter;
        int ans=0;
        for(auto &w: words)
        {
            counter[w] = 1;
            for(int i=0; i<w.size(); i++)
            {
                auto d = w.substr(0, i) + w.substr(i+1);
                if(counter.count(d))
                    counter[w] = max(counter[w], counter[d]+1);
            }
            ans = max(ans, counter[w]);
        }
        return ans;
    }//
    
    bool isPredecessor(string& wj, string& wi)
    {
        int i=0, j=0;
        int cnt=0;
        while(i<wi.size())
        {
            if(wi[i]==wj[j])
            {
                i++;
                j++;
            }
            else
            {
                cnt++;
                i++;
            }
        }
        if(cnt==1) return true;
        else return false;
    }
};