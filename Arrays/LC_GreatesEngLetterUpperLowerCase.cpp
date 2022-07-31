/*
https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/
2309. Greatest English Letter in Upper and Lower Case

*/

class Solution {
public:
    string greatestLetter_1(string s) {
        
        vector<bool> chkLower(26,0), chkUpper(26,0);
        
        for(int i=0; i<s.size(); i++)
        {
            if(islower(s[i]))
                chkLower[s[i]-'a'] = true;
            if(isupper(s[i]))
                chkUpper[s[i]-'A'] = true;
        }
        
        for(int i=26-1; i>=0; i--)
        {
            if(chkLower[i] && chkUpper[i])
            {
                char ch = i+'A';
                string s(1,ch);
                return s;
            }
        }
        
        return "";
        
    }//end
    
    string greatestLetter(string s) {
        
        for(char ch='Z'; ch>='A'; ch--)
        {
            if(find(s.begin(), s.end(), ch) != s.end() && find(s.begin(), s.end(), tolower(ch))!= s.end())
                return string(1,ch);
        }
        
        return "";
        
    }//end
};