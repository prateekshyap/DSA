/*
https://leetcode.com/problems/valid-palindrome/
125. Valid Palindrome

*/

class Solution {
public:
    /*
    bool isPalindrome(string s) {
        if(s.size()==0) return true;
        
        string modified;
        for(char ch: s)
        {
            if(isalnum(ch))
            {
                ch = ch|32;
                modified +=ch;
            }
        }
        // cout<<modified;
        int hlen = modified.length()/2;
        for(int i=0; i<hlen; i++)
        {
            if(modified[i] != modified[modified.length()-1-i])
                return false;
        }
        return true;
    }
    */
    
    bool isPalindrome_(string s) {
        if(s.size()==0) return true;
        
        int i=0;
        int j=s.size()-1;
        
        while(i<j)
        {
            if(!isalnum(s[i])){
                i++; continue;
            }
            if(!isalnum(s[j])){
                j--; continue;
            }
            if(tolower(s[i]) != tolower(s[j]))
                return false;
            else
            {
                i++;
                j--;
            }
        }
        
        return true;
    }
    
    bool isPalindrome(string s) {
        if(s.size()==0) return true;
        
        int i=0;
        int j=s.size()-1;
        
        while(i<j)
        {
            if(!isalnum(s[i])){
                i++; continue;
            }
            if(!isalnum(s[j])){
                j--; continue;
            }
            if(tolower(s[i]) != tolower(s[j]))
                return false;
            else
            {
                i++;
                j--;
            }
        }
        
        return true;
    }
};