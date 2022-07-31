/*
https://leetcode.com/problems/find-common-characters/
1002. Find Common Characters

*/

class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        vector<string> ans;
        // unordered_map<int, int> freq;
        // vector<int> freq(26,0);
        // int freq[26] = {0};
        // int newf[26] = {0};
        vector<int> freq(26,0);
        vector<int> newf(26,0);
        
        for(char c: words[0])
        {
            freq[c-'a']++;
        }
        
        for(int w=1; w<words.size(); w++)
        {
            // vector<int> newf(26,0);
            
            for(char c: words[w])
            {
                newf[c-'a']++;
            }
            for(int i=0; i<26; i++)
            {
                // if(newf[i] != freq[i])
                    freq[i]=min(newf[i], freq[i]);
                    newf[i]=0;
            }
        }
        
        for(int i=0; i<26; i++)
        {
            while(freq[i]--)
            {
                string s(1, i+'a');
                ans.push_back(s);
            }
        }
        
        return ans;
    }//
};