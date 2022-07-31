/*
730. Count Different Palindromic Subsequences
https://leetcode.com/problems/count-different-palindromic-subsequences/
*/

// Explanation:

// string s = c1mc2
// For e.g: s = abcde, let bcd = m, s = ame;

// sq(s) = sq(c1mc2)
//     if c1 != c2
//     sq(s) = sq(c1m) + sq(mc2) - sq(m)
        
//     if c1 == c2 == any letter(consider a)
//         if m doesn't contain any a:(a------a)
//             sq(s) = 2*sq(m) + 2 //add a, aa
//         if m contains one a: (a---a----a)
//             sq(s) = 2*sq(m) + 1 // add aa only as 'a' is in middle
//         if m contains more than one a: (a----a---a----a) = a----m'----a  
//             sq(s) = 2*sq(m) - sq(m') // 

// Two arrays prev and next are maintained to check if m/m' contains a or not, it stores the index of // previous and next a respectively

class Solution {
public:
    const int mod = 1e9+7;
    string str;
    vector<vector<int>> memo;
    
    int countPalindromicSubsequences(string s) {
        int n = s.length();
        str = s;
        // memo.resize(n, vector<int>(n, -1));
        // return solve(0, n-1); // memoization
        // return solvedp(0, n-1); // tabulation
        // return solvedpPrevNext(0, n-1); // tabulation with prev and next
        return solve3dp(0, n-1);
        
        //Approach 1
        // bruteforce("", 0);
        // return seen.size()-1;
    }//
    
    int solve3dp(int i, int j)
    {
        int n = j+1;
        long long dp[n][n][4];
        memset(dp, 0, sizeof(dp));
        
        for(int i=0; i<n; i++)
        {
            for(int ch=0; ch<4; ch++)
            { 
                if(str[i] == ch+'a')
                    dp[i][i][ch] = 1;
            }
        }
        
        for(int k=1; k<n; k++)
        {
            for(int i=0; i<n-k; ++i)
            {
                int j = i+k;
                for(int ch=0; ch<4; ch++)
                {
                    if(str[i]==str[j] and str[i] == ch+'a')
                    {
                        dp[i][j][ch] = 2;
                        for(int x=0; x<4; x++)
                            dp[i][j][ch] += (i+1>j-1 ? 0 : dp[i+1][j-1][x]);  
                    }
                    else
                    {
                         dp[i][j][ch] = (dp[i+1][j][ch] + dp[i][j-1][ch] - (i+1>j-1 ? 0 : dp[i+1][j-1][ch]));
                    }
                     if(dp[i][j][ch]<0) 
                        dp[i][j][ch] += mod;
                    else
                        dp[i][j][ch] %= mod;
                }
                
               
            }
        }
        long long ans=0;
        for(int ch=0; ch<4; ch++)
            ans+=dp[0][n-1][ch];
       return ans%mod;
    }
    
    int solvedpPrevNext(int i, int j)
    {
        int n = j+1;
        vector<int> prev(n, -1), next(n, -1);
        unordered_map<char, int> um;
        
        for(int i=0; i<n; i++)
        {
            if(um.count(str[i]))
                prev[i] = um[str[i]];
            um[str[i]] = i;
            
        }
        um.clear();
        for(int i=n-1; i>=0; i--)
        {
            if(um.count(str[i]))
                next[i] = um[str[i]];
            um[str[i]] = i;
        }
        
        vector<vector<int>> dp(n, vector<int>(n, 0));
        
        for(int i=0; i<n; i++)
            dp[i][i] = 1;
        
        for(int k=2; k<=n; k++)
        {
            for(int i=0; i<n-k+1; ++i)
            {
                int j = i+k-1;
                if(str[i]!=str[j])
                    dp[i][j] = (dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]);
                else
                {
                    dp[i][j] = 2*dp[i+1][j-1]; // add two ends to every inner palindrome
                    int left = next[i], right = prev[j];
                    if(left < right) //a...a...a...a
                        dp[i][j] -= dp[left+1][right-1];
                    else if(left == right)//a...a...a,
                        dp[i][j] += 1;
                    else  //a...a,
                        dp[i][j] += 2; //
                }
                if(dp[i][j]<0) 
                    dp[i][j] += mod;
                else
                    dp[i][j] %= mod;
            }
        }
       return dp[0][n-1];
    }
    
    int solvedp(int i, int j)
    {
        int n = j+1;
        vector<vector<int>> dp(n, vector<int>(n, 0));
        
        for(int i=0; i<n; i++)
            dp[i][i] = 1;
        
        for(int k=2; k<=n; k++)
        {
            for(int i=0; i<n-k+1; ++i)
            {
                int j = i+k-1;
                if(str[i]!=str[j])
                    dp[i][j] = (dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]);
                else
                {
                    dp[i][j] = 2*dp[i+1][j-1]; // add two ends to every inner palindrome
                    int left = i+1, right = j-1;
                    while(left<=right and str[left] != str[i]) left++;
                    while(left<=right and str[right] != str[j]) right--;
                    if(left < right) //a...a...a...a
                        dp[i][j] -= dp[left+1][right-1];
                    else if(left == right)//a...a...a,
                        dp[i][j] += 1;
                    else  //a...a,
                        dp[i][j] += 2; //
                }
                if(dp[i][j]<0) 
                    dp[i][j] += mod;
                else
                    dp[i][j] %= mod;
            }
        }
       return dp[0][n-1];
    }
    
    int solve(int i, int j)
    {
        if(i>j)  return 0;
        if(i==j)  return 1;
        if(memo[i][j] != -1) return memo[i][j];
        int cnt=0;
        if(str[i] != str[j]){
            cnt = solve(i+1, j) + solve(i, j-1) - solve(i+1, j-1);
        }
        else
        {
            cnt=2*solve(i+1, j-1); // add two ends to every inner palindrome
            int left = i+1, right = j-1;
            while(left<=right and str[left] != str[i]) left++;
            while(left<=right and str[right] != str[j]) right--;
            if(left < right) //a...a...a...a
                cnt -= solve(left+1, right-1);
            else if(left == right)//a...a...a,
                cnt += 1;
            else  //a...a,
                cnt += 2; //
        }
        if(cnt<0)
            cnt += mod;
        else 
            cnt = cnt%mod;
        return  memo[i][j] = cnt;
    }
    
    /*
    unordered_set<string> seen;
    void bruteforce(string cur, int idx)
    {   
        // cout<<cur<<". ";
        if(idx == str.length())
        {
            if(ispalindrome(cur, 0, cur.size()-1)) seen.insert(cur);
            return ;
        }
        bruteforce(cur, idx+1);
        bruteforce(cur+str[idx], idx+1);
    }
    
    bool ispalindrome(string &s, int i, int j) {
        while(i<j and s[i] == s[j]){
            i++;
            j--;
        }
        return i>=j;
    }
    */
};