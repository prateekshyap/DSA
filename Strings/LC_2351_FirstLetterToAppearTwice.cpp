/*
https://leetcode.com/problems/first-letter-to-appear-twice/
2351. First Letter to Appear Twice

*/

class Solution {
public:
    char repeatedCharacter(string s) {
        // unordered_set<char> repeat;
        // for(char &ch : s)
        // {
        //     if(repeat.find(ch) != repeat.end())
        //         return ch;
        //     else
        //         repeat.insert(ch);
        // }
        // return *repeat.begin();
        int freq[26] = {0};
        for(char &ch: s)
        {
            if(freq[ch-'a'])
                return ch;
            freq[ch-'a']++;
        }
        return s[0];
    }
};