/*
https://leetcode.com/problems/longest-palindromic-substring/
5. Longest Palindromic Substring

https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string1956/1/
https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1/
*/

class Solution {
public:
    /* 
    string longestPalindrome(string s) {
        int n = s.length();
        if(n<=0) return "0";
        bool tab[n][n];
        memset(tab, 0, sizeof(tab));
        int start=0, length=1;
        
        for(int i=0; i<n; i++) // all palindrome of length one
            tab[i][i] = 1;
        
        for(int i=0; i<n-1; i++) // all palindrome of length two
            if(s[i] == s[i+1])
            {
                tab[i][i+1] = 1;
                start=i;
                length = 2;
            }
        
        for(int k=3; k<=n; k++) // substring of length >=3
        {
            for(int i=0; i<n-k+1; i++)
            {
                int j = i+k-1;
                if(s[i] == s[j] && tab[i+1][j-1])
                {
                    tab[i][j] = 1;
                    if(k>length)
                    {
                        start=i;
                        length = k;
                    }
                }
            }
        }
        
        return s.substr(start, length);
    }
    */
    /*
    vector<vector<int>> memo;
    int st=0;
    int len=1;
    int recur(string &s, int i, int j)
    {
        if(i>j) return 0; //lower triangle matrix zero, length 0
        if(i==j) return 1; //palindorm of string 1 , length 1
        if(memo[i][j] != -1) return memo[i][j];
        if(s[i] == s[j] && recur(s, i+1, j-1) == j-1-i)
        {
            if(j-i+1>len)
            {
                st=i;
                len = j-i+1;
            }
            return memo[i][j]=j-i+1;
        }
        //current substring not palindrome then two possibilities.
        return memo[i][j] = max(recur(s, i+1, j), recur(s, i, j-1));
    }
    
    string longestPalindrome(string s) {
           memo.resize(s.size(), vector<int>(s.size(), -1));
           recur(s, 0, s.length()-1);
           return s.substr(st, len);
    }
    */
    
   
    int palindrome(int i, int j, string &s)
    {
        // if(i<0 || j>=s.size()) return 0;
        // int cnt=0;
        int l=i;
        int r=j;
        while(l>=0 && r<s.size() && s[l] == s[r])
        {
            l--;
            r++;
        }
        return r-l-1;
        // return cnt;
    }
    string longestPalindrome(string s) {
        int n = s.length();
        if(n<=0) return "0";
        int ind=0;
        int longest = 1, oddLen, evenLen, len;
        
        for(int x=0; x<n; x++)
        {
            oddLen = palindrome(x, x , s);
            evenLen = palindrome(x, x+1 , s);
            len = max(oddLen, evenLen);
            if( len > longest)
            {
                ind = x - (len-1)/2;
                longest = len;
            }
            // cout<<ind<<" "<<longest<<endl;
        }
        
        return s.substr(ind, longest);
    }
    
        
    
};