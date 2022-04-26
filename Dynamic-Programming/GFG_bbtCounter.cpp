/*
	BBT Counter
	https://practice.geeksforgeeks.org/problems/bbt-counter4914/1
*/

// { Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

/*
For height h, there are three combinations possible
1 - tree of height h-1 as left subtree and tree of height h-2 as right subtree
2 - tree of height h-2 as left subtree and tree of height h-1 as right subtree
3 - tree of height h-1 as both left and right subtree
All other combinations violate the condition of balanced binary trees
So - table[i-1]*table[i-2]*2+table[i-1]*table[i-1]
*/

class Solution {
  public:
     int mod = 1e9+7;
    long long int countBT(int h) {
        
        vector<long long int> tab(h+1);
        
        tab[0]=tab[1]=1;
        
        for(int i=2; i<=h; i++)
        {
            tab[i] = ((tab[i-1]*tab[i-1])%mod + 2*(tab[i-1]*tab[i-2])%mod)%mod;
        }
        
        return tab[h];
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int h;
        cin >> h;
        Solution ob;
        cout<<ob.countBT(h)<<endl;  
    }
    return 0;
}
  // } Driver Code Ends