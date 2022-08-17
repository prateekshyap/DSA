/*
https://leetcode.com/problems/substring-with-concatenation-of-all-words/
*/

class Solution {
public:
    int n, m, wlen, wsize;
    vector<int> findSubstring(string s, vector<string>& words) {
        n = s.length();
        m = words.size();
        wsize = words[0].size();
        wlen = m*wsize;
        vector<int> ans;
        if(wlen > n) return ans;
         
        unordered_map<string, int> hash;
        for(string &w: words)
            hash[w]++;
        
        int l = 0; 
        for(int r = wlen; r<=n; l++, r++ )
        {
           if(hash.count(s.substr(l,wsize)) and checkSubstring(l, r, hash, s))
           {
               ans.push_back(l); 
           }   
        }
        return ans;
    }
    
    bool checkSubstring(int l, int r, unordered_map<string, int> hash, string& s)
    {
        // cout<<endl;
        for(int i=l; i<r; i += wsize)
        {
            string w = s.substr(i, wsize);
           
            if(hash.find(w) != hash.end())
            { 
                // cout<<w<<" "<<i<<") ";
                if(--hash[w] == -1)
                    return false;
            }
            else
                return false;
        }
        return true;
    }
};