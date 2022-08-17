/*
https://practice.geeksforgeeks.org/problems/word-break1352/1
https://leetcode.com/problems/word-break/
*/
class Solution {
public:
    vector<int> memo;
    unordered_set<string> dict;
    bool wordBreak(string s, vector<string>& wordDict) {
        copy(wordDict.begin(), wordDict.end(), inserter(dict, dict.end()));
        memo.assign(s.length()+1, -1);
        // return solve(0, s);
        return solve2(0, s, wordDict);
    }
    
    bool solve(int idx, string &s)
    {
        if(idx == s.length()) return memo[idx]=true;
        if(memo[idx] != -1) return memo[idx];
        
        for(int i=idx; i<s.length(); i++)
        {
            string temp = s.substr(idx, i-idx+1);
            if(dict.find(temp) != dict.end())
            {
                if(solve(i+1, s)) return memo[idx] = true;
            }
        }
        return memo[idx] = false;
    }
    
    bool solve2(int sindx, string &srch, vector<string>& dict)
    {
        if(sindx == srch.length())
            return memo[sindx]=true;
        if(memo[sindx] != -1) return memo[sindx];
        
        for(string &d: dict)
        {
            size_t found = srch.find(d,sindx);
            if(found != string::npos and found == sindx)
            {
                if(solve2(sindx+d.size(), srch, dict))
                    return memo[sindx]=true;
            }
        }
        return memo[sindx]=false;
    }
};