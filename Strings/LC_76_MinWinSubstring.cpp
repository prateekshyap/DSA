/*
https://leetcode.com/problems/minimum-window-substring/
76. Minimum Window Substring
https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
*/

class Solution {
public:
    /*
    string minWindow(string s, string t) {
        int m = s.length();
        int n = t.length();
        if(m < n)
            return "";
        
        unordered_map<char,int> umt;
        int l=0, r=0, count=0;
        int minwd=INT_MAX;
        string ans;
        
        for(char ch: t)
            umt[ch]++;
        count = umt.size(); // un map size, or unique char
        
        while(r<m)
        {
            if(umt.find(s[r])!=umt.end())
            {
                // cout<<r<<" "<<s[r]<<umt[s[r]]<<"    ";
                umt[s[r]]--;
                if(umt[s[r]]==0)
                    count--;
            }// 
            
            if(count==0)
            {
                if(minwd > r-l+1)
                {
                    minwd = r-l+1;
                    ans = s.substr(l, minwd);
                }
                
                while(l<=r && count==0)
                {
                    if(umt.find(s[l]) != umt.end())
                    {
                        // cout<<l<<" "<<s[l]<<" "<<umt[s[l]]<<endl;
                        umt[s[l]]++;
                        if(umt[s[l]] == 1)
                        {
                            if(minwd > r-l+1)
                            {
                                minwd = r-l+1;
                                ans = s.substr(l, minwd);
                            }
                            count++;
                        }
                    }
                    l++;
                }
            }//if cnt==0
            r++;
        }//while r<m
        
        if(minwd == INT_MAX)
            return "";
        return ans;
        
    }
    */
    
    string minWindow(string s, string t) {
        if(s.length() < t.length())
            return "";
        
        string ans; // ans to return
        int l=0; //sliding window left boundary
        int start = 0; //start of substring;
        int count=0; // count of char to match
        int minwd = s.length()+1;  // min window which contains string t;
        
        vector<int> freq(128, 0); // to store mapping;
        for(char &ch: t)
            freq[ch]++;
        
        for(int r=0; r<s.length(); r++)
        {
            if(--freq[s[r]] >= 0) // if duplicates then also count if we found a char, otherwise non t char will be negative
                count++;
            
            
            while(count == t.size())
            {
                if(r-l+1 < minwd)
                {
                    minwd = r-l+1;
                    start = l;
                }
                
                if(++freq[s[l]] > 0)
                    count--; //deletion of left char 
                l++;
            }
            
        }//for r->s.len
        
        if(minwd == s.length()+1)
            return "";
        else
            return s.substr(start, minwd);
    }
};