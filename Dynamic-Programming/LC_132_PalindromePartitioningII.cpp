/*
https://leetcode.com/problems/palindrome-partitioning-ii/
132. Palindrome Partitioning II

https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1/#
*/

class Solution {
public:
    int minCut(string s) 
    {
        return minCut1(s);
        
        int n = s.length();
        vector<int> memo(n+1, -1); // memo[i] ye bta rha he ki ith index pe minimum cuts kitne he right side me i ko include krke. parition matalb kitne palindrome group he.
        solve(0, 0, s, memo);
        
        // for(int x: memo)
        //     cout<<x<<" ";
        return memo[0]-1;
        
    }
    
    // curCuts left side me kitne partition he wo bta rhe he
    int solve(int idx, int curCuts, string &s, vector<int>& memo)
    {
        if(idx == s.length())
            return memo[idx] = 0;
        
        if(memo[idx] != -1)
            return memo[idx];
        
        int cnt=INT_MAX;
        for(int i=idx; i<s.length(); i++)
        {
            if(isPalindrome(idx, i, s))
            {
                cnt = min(cnt, 1 + solve(i+1, curCuts+1, s, memo)); // 1+ to current partition bta rha hai
            }
        }
        // if(curCuts + cnt < minCuts)
            // minCuts = curCuts + cnt;
        return memo[idx] = cnt;;
    }//solve
    
    bool isPalindrome(int start, int end, string& s)
    {
        while(start<=end)
        {
            if(s[start] != s[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
    
    
    
    
    
    
    // Approach 2
    void expandAround(int i, int j, string &s, vector<int>& dp)
    {
        while(i>=0 && j<s.length() && s[i] == s[j])
        {
            dp[j+1] = min(dp[j+1], dp[i]+1);
            i--;
            j++;
        }
    }
    int minCut1(string s) 
    {
        int n = s.length();
        vector<int> tab(n+1, INT_MAX); // dp[i] ye bta rha hai ki i-1 pe kitne palindrome ke group hai. 
        tab[0] = 0;
        
        int i=0;
        while(i<=n)
        {
            expandAround(i, i, s, tab);
            expandAround(i, i+1, s, tab);
            i++;
        }
        
        // for(int x: tab)
        //     cout<<x<<" ";
        return tab[n]-1;
        
    }
   
};