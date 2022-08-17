/*
https://binarysearch.com/problems/Longest-Palindromic-Substring
*/
int solve_DP(string s) {

    int n = s.length();
    if(n<=0) return 0;
    int longest=1; //all substring of length one are palindrome

    bool tab[n][n];
    memset(tab, 0, sizeof(tab));

    for(int i=0; i<n; i++)
        tab[i][i]=true; // substring of length one
    
    for(int i=0; i<n-1; i++)
        if(s[i]==s[i+1]) // substring of length two
        {
            tab[i][i+1]=true;
            longest=2;
        }
                      
    for(int k=3; k<=n; k++) //substring of length >=3
    {
        for(int i=0; i<n-k+1; i++)
        {
            int j=i+k-1;
            if(s[i]==s[j] && tab[i+1][j-1] )
            {
                tab[i][j]=1;
                if(k>longest)
                    longest=k;
            }
        }
    }

// cout<<"  ";
// for(int i=0; i<n; i++)
//     {
//         cout<<s[i]<<" ";
//     }
//     cout<<endl;
// for(int i=0; i<n; i++)
//     {
//         cout<<s[i]<<" ";
//         for(int j=0; j<n; j++)
//         {
//             cout<<tab[i][j]<<" ";
//         }
//         cout<<endl;
//     }
    return longest;
}

vector<vector<int>> memo;

int recur(string &s, int i, int j)
{
    if(i>j) return 0; //lower triangle matrix zero, length 0
    if(i==j) return 1; //palindorm of string 1 , length 1
    if(memo[i][j] != -1) return memo[i][j];

    if(s[i] == s[j] && recur(s, i+1, j-1)==j-1-i)
        return memo[i][j] = j-i+1;

    //current substring not palindrome then two possibilities.
    return memo[i][j] = max(recur(s, i+1, j), recur(s,i,j-1));
}

int palindrome(int i, int j, string &s)
{
    if(i<0 || j>=s.size()) return 0;
    int cnt=0;
    while(i>=0 && j<s.size() && s[i]==s[j])
    {
        i--;
        j++;
        cnt+=2;
    }
    return cnt;
}
int solve(string s) {
    /*
    memo.clear();
    memo.resize(s.size(), vector<int>(s.size(), -1));
    return recur(s, 0, s.size()-1);
    */

    int n = s.size();
    if(n<2) return n;

    int longest = 1;
    for(int x=0; x<n; x++)
    {
        longest = max(longest, palindrome(x-1, x+1,s)+1); //odd length
        if(x-1>=0 && s[x] == s[x-1])
            longest = max(longest, palindrome(x-2, x+1,s)+2); //even length
        
    }

    return longest;
}