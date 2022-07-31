/*
131. Palindrome Partitioning
https://leetcode.com/problems/palindrome-partitioning/

https://binarysearch.com/problems/Palindrome-Splitting
*/

class Solution {
public:
    
bool isPalindrome(string &str, int start, int end)
{
    while(start<=end)
    {
        if(str[start]!=str[end])
            return false;
        start++;
        end--;
    }
    return true;
}

void doSplit(string &s, int idx, vector<string> part)
{
    if(s.length()==idx) // if you reach at the end index of string, means one partition is done.
    {
        ans.push_back(part);
        return;
    }
    
    
    for(int e=idx; e<s.length(); e++) 
    {
        // cout<<"(idx:"<<idx<<" e"<<e<<") "<<s.substr(idx, e - idx + 1)<<" "<<endl;
        if(isPalindrome(s, idx, e))
        {
            part.push_back(s.substr(idx, e - idx + 1));
            doSplit(s, e+1, part);
            part.pop_back();
            // cout<<endl;
        }
            
    }
}
    
    vector<vector<string>> ans;
    
    vector<vector<string>> partition(string s) {
        int n = s.length();
        
        vector<string> part;

        doSplit(s, 0, part);
        
        return  ans;
    }
};


// Binary Search ---------------------------------------------------

bool isPalindrome(string str)
{
    string rev = string(str.rbegin(), str.rend());
    return rev==str;
}

int doSplit(string &s, int idx, vector<int>& memo)
{
    if(s.length()-1==idx) // if you reach at the end index of string, means one partition is done.
        return 1;
    
    if(memo[idx+1] != -1)
        return memo[idx+1];

    int cnt=0;
    for(int len=1; len<=s.length()-idx-1; len++) 
    {
        // cout<<"(idx:"<<idx+1<<" L"<<len<<") "<<s.substr(idx+1, len)<<" "<<endl;
        if(isPalindrome(s.substr(idx+1, len)))
        {
            cnt+=doSplit(s, idx+len, memo);
            // cout<<endl;
        }
            
    }
    memo[idx+1] = cnt;
    return memo[idx+1];
}

int solve(string s) {
    int n = s.length();
    if(n==1)
        return n;

    vector<int> memo(n, -1);

    int ans = doSplit(s,-1, memo);
    // cout<<endl;
    //     for(int x: memo)
    //     cout<<x<<" ";
    return  ans;// -1 if the entire string is palindrome
}