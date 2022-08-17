/*
https://leetcode.com/problems/word-break-ii/
https://practice.geeksforgeeks.org/problems/word-break-part-23249/1
Word Break - Part 2
*/

class Solution {
public:
    string srch;
    vector<string> ans;
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        srch = s;
        solve(0, "", wordDict);
        return ans;
    }
    
    bool solve(int sindx, string temp, vector<string>& dict)
    {
        if(sindx == srch.length())
        {
            temp.pop_back(); // remove last space
            ans.push_back(temp);
            return true;
        }
        
        for(string &d: dict)
        {
            size_t found = srch.find(d,sindx); //s.find(d, 0);
            if(found != string::npos and found == sindx) //found==0
                solve(sindx+d.size(), temp+d+' ', dict);
            
        }
        return false;
    }
};

class Solution{
public:
    int nd;
    string srch;
    vector<string> ans;
    vector<string> wordBreak(int n, vector<string>& dict, string s)
    {
        nd = n;
        srch = s;
        solve(0, "", dict);
        return ans;
    }
    
    void solve(int sindx, string temp, vector<string>& dict)
    {
        if(sindx == srch.length())
        {
            ans.push_back(temp); // insert into our ans
            return;
        }
        
        if(sindx!=0)
            temp+=" "; // extra space for each word except the beginning 
        
        string s = srch.substr(sindx); //construct string from main string to find next word
        for(string d: dict)
        {
            size_t found = s.find(d);
            if(found != string::npos and found==0) // if dict word found at beginning 
            {
                // cout<<sindx<<"="<<d<<") ";
                solve(sindx+d.size(), temp+d, dict);
            }
        }
    }
    
};