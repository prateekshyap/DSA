/*
https://practice.geeksforgeeks.org/problems/trailing-zeroes-in-factorial5134/1
Trailing zeroes in factorial 
*/

// { Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
//User function Template for C++
class Solution
{
public:
    int trailingZeroes(int N)
    {
       int m =5;
       int count = 0;
       int fac = N/m;
       while(fac > 0)
       {
           count += fac;
           m*=5;
           fac = N/m;
           
       }
       return count;
    }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N;
        cin >> N;
        Solution ob;
        int ans  = ob.trailingZeroes(N);
        cout<<ans<<endl;
    }
    return 0;
}  // } Driver Code Ends