/*
https://practice.geeksforgeeks.org/problems/word-break1352/1
Word Break
*/

class Solution
{
public:
    unordered_set<string> dict;
    vector<int> memo;
    int wordBreak(string A, vector<string> &B) {
        copy(B.begin(), B.end(), inserter(dict, dict.end()));
        // for(string &b: B) dict.insert(b);
        memo.assign(A.length()+1, -1);
        return solve(0, A);
    }
    
    bool solve(int idx, string& s)
    {
        // cout<<"\n"<<idx<<"= ";
        if(idx == s.length())
            return true;
        if(memo[idx] != -1) return memo[idx];
        for(int i=idx; i<s.length(); i++)
        {
            string temp = s.substr(idx, i-idx+1);
            if(dict.find(temp) != dict.end())
            {   
                // cout<<idx<<"-"<<temp<<"-"<<i<<" \t";
                if(solve(i+1, s)) return memo[idx] =true;
            }
            
        }
        return memo[idx] =false;
    }
};