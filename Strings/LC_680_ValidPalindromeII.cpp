/*
https://leetcode.com/problems/valid-palindrome-ii/
680. Valid Palindrome II

*/

class Solution {
public:
    /*
    bool validPalindrome(string s) {
        
        if(s.size()==0) return true;
        
        int i=0;
        int j=s.size()-1;
        while(i<j)
        {
            if(s[i] != s[j])
                return chkPalindrome(s, i+1, j) || chkPalindrome(s, i, j-1);
            i++; j--;
        }
      
        return true;
        
    }//end
    
    bool chkPalindrome(string &s, int i, int j)
    {
        while(i<j)
        {
            if(s[i]!=s[j])
                return false;
            i++; j--;
        }
        return true;
    }
    */
    
     bool validPalindrome(string s) {
        
        if(s.size()==0) return true;
        
        int i=0;
        int j=s.size()-1;
        while(i<j)
        {
            if(s[i] != s[j]) // if one character  is mismatched
            {
                int i1 = i+1, j1 = j;
                int i2 = i, j2 = j-1;
                while(i1 < j1 && s[i1] == s[j1])
                {
                    i1++;
                    j1--;
                }
                while(i2 < j2 && s[i2] == s[j2])
                {
                    i2++;
                    j2--;
                }
                return i1>=j1 || i2>=j2;
            }
            i++; 
            j--;
        }
      
        return true;
        
    }//end
    
};