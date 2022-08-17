/*
Longest K unique characters substring 
https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1/
*/

// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++

class Solution{
  public:
    int longestKSubstr(string s, int k) {
        unordered_map<char, int> umap;
        
        int n = s.length();    
        int i = 0, j = 0;
        int longest=-1;
        
        while(j<n)
        {
            umap[s[j]]++;
            
            if(umap.size() == k) // num of unique char is == k;
                longest = max(longest, j-i+1);
            else if(umap.size() > k)
            {
                while(umap.size()>k)
                {
                    umap[s[i]]--;
                    if(umap[s[i]] == 0)umap.erase(s[i]);
                    i++;
                }
            }
            
            j++;
        }
    
        return longest;
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        int k;
        cin >> k;
        Solution ob;
        cout << ob.longestKSubstr(s, k) << endl;
    }
}
  // } Driver Code Ends